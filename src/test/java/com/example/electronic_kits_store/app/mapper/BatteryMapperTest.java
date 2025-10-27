package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BatteryMapperTest {

    private final BatteryMapper batteryMapper = new BatteryMapperImpl();
    @Test
    void shouldProperlyMapEntityToDto() {
        //given
        Battery battery = new Battery();
        battery.setId(45L);
        battery.setName("The BestBattery 12V!");
        battery.setCost(BigDecimal.valueOf(111200));
        battery.setManufacturer("China");
        battery.setDescription("high performance lion battery 12 V");
        battery.setRating((byte) 3);
        battery.setPictureUrl("/111200.jpg");
        battery.setCategory(Product.Category.BATTERY);
        battery.setNominalVoltage(12);
        battery.setCapacity(3000);
        battery.setForm(Battery.FormFactor.PRISMATIC);
        battery.setBatteryTerminalDiameter(12);
        //when
        BatteryDTO batteryDTO = batteryMapper.toDto(battery);

        //then
        Assertions.assertNotNull(batteryDTO);
        Assertions.assertEquals(battery.getId(), batteryDTO.id());
        Assertions.assertEquals(battery.getName(), batteryDTO.name());
        Assertions.assertEquals(battery.getCost(), batteryDTO.cost());
        Assertions.assertEquals(battery.getManufacturer(), batteryDTO.manufacturer());
        Assertions.assertEquals(battery.getDescription(), batteryDTO.description());
        Assertions.assertEquals(battery.getRating(), batteryDTO.rating());
        Assertions.assertEquals(battery.getPictureUrl(), batteryDTO.pictureUrl());
        Assertions.assertEquals(battery.getCategory(), batteryDTO.category());
        Assertions.assertEquals(battery.getNominalVoltage(), batteryDTO.nominalVoltage());
        Assertions.assertEquals(battery.getCapacity(), batteryDTO.capacity());
        Assertions.assertEquals(battery.getForm(), batteryDTO.form());
        Assertions.assertEquals(battery.getBatteryTerminalDiameter(), batteryDTO.batteryTerminalDiameter());





    }
    @Test
    void shouldProperlyMapCreateBatteryRequestToEntity() {
        //given
        CreateBatteryRequest createBatteryRequest = new CreateBatteryRequest(
                "The BestBattery 12V!",
                BigDecimal.valueOf(111200),
                "China",
                "high performance lion battery 12 V",
                (byte) 3,
                Product.Category.BATTERY,
                12,
                3000,
                Battery.FormFactor.PRISMATIC,
                12
        );
        //when
        Battery battery = batteryMapper.toEntity(createBatteryRequest);

        //then
        Assertions.assertNotNull(battery);
        Assertions.assertNull(battery.getId());
        Assertions.assertNull(battery.getPictureUrl());
        Assertions.assertEquals(battery.getName(), createBatteryRequest.name());
        Assertions.assertEquals(battery.getCost(), createBatteryRequest.cost());
        Assertions.assertEquals(battery.getManufacturer(), createBatteryRequest.manufacturer());
        Assertions.assertEquals(battery.getDescription(), createBatteryRequest.description());
        Assertions.assertEquals(battery.getRating(), createBatteryRequest.rating());
        Assertions.assertEquals(battery.getCategory(), createBatteryRequest.category());
        Assertions.assertEquals(battery.getNominalVoltage(), createBatteryRequest.nominalVoltage());
        Assertions.assertEquals(battery.getCapacity(), createBatteryRequest.capacity());
        Assertions.assertEquals(battery.getForm(), createBatteryRequest.form());
        Assertions.assertEquals(battery.getBatteryTerminalDiameter(), createBatteryRequest.batteryTerminalDiameter());





    }
}
