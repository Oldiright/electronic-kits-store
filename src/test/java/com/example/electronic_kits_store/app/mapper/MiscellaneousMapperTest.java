package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.model.Miscellaneous;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MiscellaneousMapperTest {
    private final MiscellaneousMapper miscellaneousMapper = new MiscellaneousMapperImpl();

//    @BeforeAll
//    static void setup() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }

    @Test
    void shouldProperlyMapEntityToDto() {
        //given
        Miscellaneous miscellaneous = new Miscellaneous();
        HashMap<String, String> otherInfo = new HashMap<>();
        otherInfo.put("material", "ABS Plastic");
        otherInfo.put("weight_grams", "50");
        otherInfo.put("color", "Midnight Black");
        otherInfo.put("isWaterproof", "false");
        otherInfo.put("warranty_months", "12");

        miscellaneous.setId(45L);
        miscellaneous.setName("Black Box");
        miscellaneous.setCost(BigDecimal.valueOf(10000));
        miscellaneous.setManufacturer("China");
        miscellaneous.setDescription("Black Box for different things");
        miscellaneous.setRating((byte) 5);
        miscellaneous.setPictureUrl("/45.jpg");
        miscellaneous.setOtherInfo(otherInfo);

        //when
        MiscellaneousDTO miscellaneousDTO = miscellaneousMapper.toDto(miscellaneous);

        //then
        assertNotNull(miscellaneousDTO);
        assertEquals(miscellaneous.getId(), miscellaneousDTO.id());
        assertEquals(miscellaneous.getName(), miscellaneousDTO.name());
        assertEquals(miscellaneous.getCost(), miscellaneousDTO.cost());
        assertEquals(miscellaneous.getManufacturer(), miscellaneousDTO.manufacturer());
        assertEquals(miscellaneous.getDescription(), miscellaneousDTO.description());
        assertEquals(miscellaneous.getRating(), miscellaneousDTO.rating());
        assertEquals(miscellaneous.getPictureUrl(), miscellaneousDTO.pictureUrl());
        assertEquals(miscellaneous.getCategory().toString(), miscellaneousDTO.category());
        assertEquals(otherInfo, miscellaneousDTO.otherInfo());
    }
    @Test
    void shouldProperlyMapCreateMiscellaneousRequestToEntity() {
        //given
        HashMap<String, String> otherInfo = new HashMap<>();
        otherInfo.put("material", "ABS Plastic");
        otherInfo.put("weight_grams", "50");
        otherInfo.put("color", "Midnight Black");
        otherInfo.put("isWaterproof", "false");
        otherInfo.put("warranty_months", "12");
        CreateMiscellaneousRequest createMiscellaneousRequest = new CreateMiscellaneousRequest(
                "Black Box",
                BigDecimal.valueOf(12000),
                "China",
                "Black Box for different things",
                (byte) 5,
                otherInfo

        );
        //when
        Miscellaneous miscellaneous = miscellaneousMapper.toEntity(createMiscellaneousRequest);

        //then
        assertNotNull(miscellaneous);
        assertNull(miscellaneous.getId());
        assertNull(miscellaneous.getPictureUrl());
        assertEquals(createMiscellaneousRequest.name(), miscellaneous.getName());
        assertEquals(createMiscellaneousRequest.cost(), miscellaneous.getCost());
        assertEquals(createMiscellaneousRequest.manufacturer(), miscellaneous.getManufacturer());
        assertEquals(createMiscellaneousRequest.description(), miscellaneous.getDescription());
        assertEquals(createMiscellaneousRequest.rating(), miscellaneous.getRating());
        assertEquals(Product.Category.OTHER, miscellaneous.getCategory());
        assertEquals(createMiscellaneousRequest.otherInfo(), miscellaneous.getOtherInfo());
    }
}
