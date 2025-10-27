package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class BmsMapperTest {
    private final BmsMapper bmsMapper = new BmsMapperImpl();
    @Test
    void shouldProperlyMapEntityToDto() {
        //given
        Bms bms = new Bms();
        bms.setId(45L);
        bms.setName("The Best BMS 12V!");
        bms.setCost(BigDecimal.valueOf(7200));
        bms.setManufacturer("China");
        bms.setDescription("high performance BMS with active balancer 12 V");
        bms.setRating((byte) 5);
        bms.setPictureUrl("/45.jpg");
        bms.setCategory(Product.Category.BMS);
        bms.setMaxPower(2200);
        bms.setBalancerType(Bms.Balancer.ACTIVE);
        bms.setMinStringSupported(2);
        bms.setMaxStringSupported(12);
        bms.setIsBluetooth(true);


        //when
        BmsDTO bmsDTO = bmsMapper.toDto(bms);

        //then
        Assertions.assertNotNull(bmsDTO);
        Assertions.assertEquals(bms.getId(), bmsDTO.id());
        Assertions.assertEquals(bms.getName(), bmsDTO.name());
        Assertions.assertEquals(bms.getCost(), bmsDTO.cost());
        Assertions.assertEquals(bms.getManufacturer(), bmsDTO.manufacturer());
        Assertions.assertEquals(bms.getDescription(), bmsDTO.description());
        Assertions.assertEquals(bms.getRating(), bmsDTO.rating());
        Assertions.assertEquals(bms.getPictureUrl(), bmsDTO.pictureUrl());
        Assertions.assertEquals(bms.getCategory(), bmsDTO.category());
        Assertions.assertEquals(bms.getMaxPower(), bmsDTO.maxPower());
        Assertions.assertEquals(bms.getBalancerType(), bmsDTO.balancerType());
        Assertions.assertEquals(bms.getMinStringSupported(), bmsDTO.minStringSupported());
        Assertions.assertEquals(bms.getMaxStringSupported(), bmsDTO.maxStringSupported());
        Assertions.assertEquals(bms.getIsBluetooth(), bmsDTO.isBluetooth());
    }
    @Test
    void shouldProperlyMapCreateBmsRequestToEntity() {
        //given
        CreateBmsRequest createBmsRequest = new CreateBmsRequest(
                "The Best BMS 12V!",
                BigDecimal.valueOf(7200),
                "China",
                "high performance BMS with active balancer 12 V",
                (byte) 5,
                Product.Category.BMS,
                2000,
                Bms.Balancer.ACTIVE,
                2,
                12,
                true

        );


        //when
        Bms bms = bmsMapper.toEntity(createBmsRequest);

        //then
        Assertions.assertNotNull(bms);
        Assertions.assertNull(bms.getId());
        Assertions.assertNull(bms.getPictureUrl());
        Assertions.assertEquals(bms.getName(), createBmsRequest.name());
        Assertions.assertEquals(bms.getCost(), createBmsRequest.cost());
        Assertions.assertEquals(bms.getManufacturer(), createBmsRequest.manufacturer());
        Assertions.assertEquals(bms.getDescription(), createBmsRequest.description());
        Assertions.assertEquals(bms.getRating(), createBmsRequest.rating());
        Assertions.assertEquals(bms.getCategory(), createBmsRequest.category());
        Assertions.assertEquals(bms.getMaxPower(), createBmsRequest.maxPower());
        Assertions.assertEquals(bms.getBalancerType(), createBmsRequest.balancerType());
        Assertions.assertEquals(bms.getMinStringSupported(), createBmsRequest.minStringSupported());
        Assertions.assertEquals(bms.getMaxStringSupported(), createBmsRequest.maxStringSupported());
        Assertions.assertEquals(bms.getIsBluetooth(), createBmsRequest.isBluetooth());
    }
}
