package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.wirelug.CreateWireLugRequest;
import com.example.electronic_kits_store.app.dto.wirelug.WireLugDTO;
import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.model.WireLug;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WireLugMapperTest {
    private final WireLugMapper wireLugMapper = new WireLugMapperImpl();

//    @BeforeAll
//    static void setup() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }

    @Test
    void shouldProperlyMapEntityToDto() {
        //given
        WireLug wireLug = new WireLug();
        wireLug.setId(42L);
        wireLug.setName("aluminum wire lug M6");
        wireLug.setCost(BigDecimal.valueOf(256));
        wireLug.setManufacturer("China");
        wireLug.setDescription("aluminum wire lug M6, designed for high performance batteries");
        wireLug.setRating((byte) 5);
        wireLug.setPictureUrl("/42.jpg");
        wireLug.setWireCrossSectionArea(12);
        wireLug.setTerminalDiameter(6);
        wireLug.setMaterial("ALUMINUM");

        //when
        WireLugDTO wireLugDTO = wireLugMapper.toDto(wireLug);

        //then
        assertNotNull(wireLugDTO);
        assertEquals(wireLug.getId(), wireLugDTO.id());
        assertEquals(wireLug.getName(), wireLugDTO.name());
        assertEquals(wireLug.getCost(), wireLugDTO.cost());
        assertEquals(wireLug.getManufacturer(), wireLugDTO.manufacturer());
        assertEquals(wireLug.getDescription(), wireLugDTO.description());
        assertEquals(wireLug.getRating(), wireLugDTO.rating());
        assertEquals(wireLug.getPictureUrl(), wireLugDTO.pictureUrl());
        assertEquals(wireLug.getCategory().toString(), wireLugDTO.category());
        assertEquals(wireLug.getWireCrossSectionArea(), wireLugDTO.wireCrossSectionArea());
        assertEquals(wireLug.getTerminalDiameter(), wireLugDTO.terminalDiameter());
        assertEquals(wireLug.getMaterial(), wireLugDTO.material());

    }
    @Test
    void shouldProperlyMapCreateWireLugRequestToEntity() {
        //given
        CreateWireLugRequest createWireLugRequest = new CreateWireLugRequest(
                "Wire 4AWG",
                BigDecimal.valueOf(256),
                "China",
                "Wire 4AWG, black, with PVC isolation",
                (byte) 5,
                12,
                6,
                "ALUMINUM"

        );
        //when
        WireLug wireLug = wireLugMapper.toEntity(createWireLugRequest);

        //then
        assertNotNull(wireLug);
        assertNull(wireLug.getId());
        assertNull(wireLug.getPictureUrl());
        assertEquals(createWireLugRequest.name(), wireLug.getName());
        assertEquals(createWireLugRequest.cost(), wireLug.getCost());
        assertEquals(createWireLugRequest.manufacturer(), wireLug.getManufacturer());
        assertEquals(createWireLugRequest.description(), wireLug.getDescription());
        assertEquals(createWireLugRequest.rating(), wireLug.getRating());
        assertEquals(Product.Category.WIRE_LUG, wireLug.getCategory());
        assertEquals(createWireLugRequest.wireCrossSectionArea(), wireLug.getWireCrossSectionArea());
        assertEquals(createWireLugRequest.terminalDiameter(), wireLug.getTerminalDiameter());
        assertEquals(createWireLugRequest.material(), wireLug.getMaterial());
    }
}
