package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

public class BmsMapperTest {
    private final BmsMapper bmsMapper = new BmsMapperImpl();
    @BeforeAll
    static void setup() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
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
        bms.setMaxPower(2200);
        bms.setBalancerType(Bms.Balancer.ACTIVE);
        bms.setMinStringSupported(2);
        bms.setMaxStringSupported(12);
        bms.setIsBluetooth(true);

        //when
        BmsDTO bmsDTO = bmsMapper.toDto(bms);

        //then
        assertNotNull(bmsDTO);
        assertEquals(bms.getId(), bmsDTO.id());
        assertEquals(bms.getName(), bmsDTO.name());
        assertEquals(bms.getCost(), bmsDTO.cost());
        assertEquals(bms.getManufacturer(), bmsDTO.manufacturer());
        assertEquals(bms.getDescription(), bmsDTO.description());
        assertEquals(bms.getRating(), bmsDTO.rating());
        assertEquals(bms.getPictureUrl(), bmsDTO.pictureUrl());
        assertEquals(bms.getCategory().toString(), bmsDTO.category());
        assertEquals(bms.getMaxPower(), bmsDTO.maxPower());
        assertEquals(bms.getBalancerType().toString(), bmsDTO.balancerType());
        assertEquals(bms.getMinStringSupported(), bmsDTO.minStringSupported());
        assertEquals(bms.getMaxStringSupported(), bmsDTO.maxStringSupported());
        assertEquals(bms.getIsBluetooth(), bmsDTO.isBluetooth());
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
                2000,
                "ACTIVE",
                2,
                12,
                true
        );

        //when
        Bms bms = bmsMapper.toEntity(createBmsRequest);

        //then
        assertNotNull(bms);
        assertNull(bms.getId());
        assertNull(bms.getPictureUrl());
        assertEquals(createBmsRequest.name(), bms.getName());
        assertEquals(createBmsRequest.cost(), bms.getCost());
        assertEquals(createBmsRequest.manufacturer(),bms.getManufacturer());
        assertEquals(createBmsRequest.description(), bms.getDescription());
        assertEquals(createBmsRequest.rating(), bms.getRating());
        assertEquals(Product.Category.BMS, bms.getCategory());
        assertEquals(createBmsRequest.maxPower(), bms.getMaxPower());
        assertEquals(createBmsRequest.balancerType(), bms.getBalancerType().toString());
        assertEquals(createBmsRequest.minStringSupported(), bms.getMinStringSupported());
        assertEquals(createBmsRequest.maxStringSupported(), bms.getMaxStringSupported());
        assertEquals(createBmsRequest.isBluetooth(), bms.getIsBluetooth());
    }
}
