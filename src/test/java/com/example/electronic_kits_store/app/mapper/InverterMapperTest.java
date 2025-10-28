package com.example.electronic_kits_store.app.mapper;
import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class InverterMapperTest {
    private final InverterMapper inverterMapper= new InverterMapperImpl();

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
        Assertions.assertNotNull(inverterDTO);
        Assertions.assertEquals(inverter.getId(), inverterDTO.id());
        Assertions.assertEquals(inverter.getName(), inverterDTO.name());
        Assertions.assertEquals(inverter.getCost(), inverterDTO.cost());
        Assertions.assertEquals(inverter.getManufacturer(), inverterDTO.manufacturer());
        Assertions.assertEquals(inverter.getDescription(), inverterDTO.description());
        Assertions.assertEquals(inverter.getRating(), inverterDTO.rating());
        Assertions.assertEquals(inverter.getPictureUrl(), inverterDTO.pictureUrl());
        Assertions.assertEquals(inverter.getCategory().toString(), inverterDTO.category());
        Assertions.assertEquals(inverter.getPower(), inverterDTO.power());
        System.out.println(inverter.getInputVoltage().toString());
        Assertions.assertEquals(inverter.getInputVoltage().toString(), inverterDTO.inputVoltage());




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
        Assertions.assertNotNull(inverter);
        Assertions.assertNull(inverter.getId());
        Assertions.assertNull(inverter.getPictureUrl());
        Assertions.assertEquals(inverter.getName(), createInverterRequest.name());
        Assertions.assertEquals(inverter.getCost(), createInverterRequest.cost());
        Assertions.assertEquals(inverter.getManufacturer(), createInverterRequest.manufacturer());
        Assertions.assertEquals(inverter.getDescription(), createInverterRequest.description());
        Assertions.assertEquals(inverter.getRating(), createInverterRequest.rating());
        Assertions.assertEquals(inverter.getCategory(), Product.Category.INVERTER);
        Assertions.assertEquals(inverter.getPower(), createInverterRequest.power());
        Assertions.assertEquals(inverter.getInputVoltage().toString(), createInverterRequest.inputVoltage());
    }
}
