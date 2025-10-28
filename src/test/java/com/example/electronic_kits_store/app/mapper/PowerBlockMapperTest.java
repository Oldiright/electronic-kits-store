package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.powerblock.CreatePowerBlockRequest;
import com.example.electronic_kits_store.app.dto.powerblock.PowerBlockDTO;
import com.example.electronic_kits_store.app.model.PowerBlock;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerBlockMapperTest {
    private final PowerBlockMapper powerBlockMapper = new PowerBlockMapperImpl();

    @Test
    void shouldProperlyMapEntityToDto() {
        //given
        PowerBlock powerBlock = new PowerBlock();
        powerBlock.setId(45L);
        powerBlock.setName("Power block 45A");
        powerBlock.setCost(BigDecimal.valueOf(10000));
        powerBlock.setManufacturer("China");
        powerBlock.setDescription("Power block 45A, 1-14.5V");
        powerBlock.setRating((byte) 5);
        powerBlock.setPictureUrl("/45.jpg");
        powerBlock.setMinVoltage(1);
        powerBlock.setMaxVoltage(15);
        powerBlock.setPower(45);

        //when
        PowerBlockDTO powerBlockDTO = powerBlockMapper.toDto(powerBlock);

        //then
        assertNotNull(powerBlockDTO);
        assertEquals(powerBlock.getId(), powerBlockDTO.id());
        assertEquals(powerBlock.getName(), powerBlockDTO.name());
        assertEquals(powerBlock.getCost(), powerBlockDTO.cost());
        assertEquals(powerBlock.getManufacturer(), powerBlockDTO.manufacturer());
        assertEquals(powerBlock.getDescription(), powerBlockDTO.description());
        assertEquals(powerBlock.getRating(), powerBlockDTO.rating());
        assertEquals(powerBlock.getPictureUrl(), powerBlockDTO.pictureUrl());
        assertEquals(powerBlock.getCategory().toString(), powerBlockDTO.category());
        assertEquals(powerBlock.getMinVoltage(), powerBlockDTO.minVoltage());
        assertEquals(powerBlock.getMaxVoltage(), powerBlockDTO.maxVoltage());
        assertEquals(powerBlock.getPower(), powerBlockDTO.power());

    }
    @Test
    void shouldProperlyMapCreatePowerBlockRequestToEntity() {
        //given
        CreatePowerBlockRequest createPowerBlockRequest = new CreatePowerBlockRequest(
                "Power block 45A",
                BigDecimal.valueOf(12000),
                "China",
                "Power block 45A, 1-14.5V",
                (byte) 5,
                1,
                15,
                45
        );
        //when
        PowerBlock powerBlock = powerBlockMapper.toEntity(createPowerBlockRequest);

        //then
        assertNotNull(powerBlock);
        assertNull(powerBlock.getId());
        assertNull(powerBlock.getPictureUrl());
        assertEquals(createPowerBlockRequest.name(), powerBlock.getName());
        assertEquals(createPowerBlockRequest.cost(), powerBlock.getCost());
        assertEquals(createPowerBlockRequest.manufacturer(), powerBlock.getManufacturer());
        assertEquals(createPowerBlockRequest.description(), powerBlock.getDescription());
        assertEquals(createPowerBlockRequest.rating(), powerBlock.getRating());
        assertEquals(Product.Category.POWER_BLOCK, powerBlock.getCategory());
        assertEquals(createPowerBlockRequest.minVoltage(), powerBlock.getMinVoltage());
        assertEquals(createPowerBlockRequest.maxVoltage(), powerBlock.getMaxVoltage());
        assertEquals(createPowerBlockRequest.power(), powerBlock.getPower());
    }
}
