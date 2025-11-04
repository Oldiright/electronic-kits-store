package com.example.electronic_kits_store.app.mapper;
import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

public class InverterMapperTest {
    private final InverterMapper inverterMapper= new InverterMapperImpl();

//    @BeforeAll
//    static void setup() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }

    @Test
    void shouldProperlyMapEntityToDto() {
        //given
        Inverter inverter = new Inverter();
        inverter.setId(45L);
        inverter.setName("The Inverter 12VDC/200VAC 1200W");
        inverter.setCost(BigDecimal.valueOf(10000));
        inverter.setManufacturer("China");
        inverter.setDescription("high performance (1200W) Inverter 12 V. best of the best");
        inverter.setRating((byte) 5);
        inverter.setPictureUrl("/45.jpg");
        inverter.setPower(1200);
        inverter.setInputVoltage(Inverter.InputVoltage.LOW);
        //when
        InverterDTO inverterDTO = inverterMapper.toDto(inverter);

        //then
        assertNotNull(inverterDTO);
        assertEquals(inverter.getId(), inverterDTO.id());
        assertEquals(inverter.getName(), inverterDTO.name());
        assertEquals(inverter.getCost(), inverterDTO.cost());
        assertEquals(inverter.getManufacturer(), inverterDTO.manufacturer());
        assertEquals(inverter.getDescription(), inverterDTO.description());
        assertEquals(inverter.getRating(), inverterDTO.rating());
        assertEquals(inverter.getPictureUrl(), inverterDTO.pictureUrl());
        assertEquals(inverter.getCategory().toString(), inverterDTO.category());
        assertEquals(inverter.getPower(), inverterDTO.power());
        assertEquals(inverter.getInputVoltage().toString(), inverterDTO.inputVoltage());
    }
    @Test
    void shouldProperlyMapCreateInverterRequestToEntity() {
        //given
        CreateInverterRequest createInverterRequest = new CreateInverterRequest(
                "The Inverter 12VDC/200VAC 1200W",
                BigDecimal.valueOf(12000),
                "China",
                "high performance (1200W) Inverter 12 V. best of the best",
                (byte) 5,
                12000,
                "12"
        );
        //when
        Inverter inverter = inverterMapper.toEntity(createInverterRequest);

        //then
        assertNotNull(inverter);
        assertNull(inverter.getId());
        assertNull(inverter.getPictureUrl());
        assertEquals(createInverterRequest.name(), inverter.getName());
        assertEquals(createInverterRequest.cost(), inverter.getCost());
        assertEquals(createInverterRequest.manufacturer(), inverter.getManufacturer());
        assertEquals(createInverterRequest.description(), inverter.getDescription());
        assertEquals(createInverterRequest.rating(), inverter.getRating());
        assertEquals(Product.Category.INVERTER, inverter.getCategory());
        assertEquals(createInverterRequest.power(), inverter.getPower());
        assertEquals(createInverterRequest.inputVoltage(), inverter.getInputVoltage().toString());
    }
}
