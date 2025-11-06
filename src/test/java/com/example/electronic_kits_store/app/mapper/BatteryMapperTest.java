package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

public class BatteryMapperTest {

    private final BatteryMapper batteryMapper = new BatteryMapperImpl();
//    @BeforeAll
//    static void setup() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }
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
        battery.setNominalVoltage(12);
        battery.setCapacity(3000);
        battery.setForm(Battery.FormFactor.PRISMATIC);
        battery.setBatteryTerminalDiameter(12);
        //when
        BatteryDTO batteryDTO = batteryMapper.toDto(battery);

        //then
        assertNotNull(batteryDTO);
        assertEquals(battery.getId(), batteryDTO.id());
        assertEquals(battery.getName(), batteryDTO.name());
        assertEquals(battery.getCost(), batteryDTO.cost());
        assertEquals(battery.getManufacturer(), batteryDTO.manufacturer());
        assertEquals(battery.getDescription(), batteryDTO.description());
        assertEquals(battery.getRating(), batteryDTO.rating());
        assertEquals(battery.getPictureUrl(), batteryDTO.pictureUrl());
        assertEquals(battery.getCategory().toString(), batteryDTO.category());
        assertEquals(battery.getNominalVoltage(), batteryDTO.nominalVoltage());
        assertEquals(battery.getCapacity(), batteryDTO.capacity());
        assertEquals(battery.getForm().toString(), batteryDTO.form());
        assertEquals(battery.getBatteryTerminalDiameter(), batteryDTO.batteryTerminalDiameter());
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
                12,
                3000,
                "PRISMATIC",
                12
        );
        //when
        Battery battery = batteryMapper.toEntity(createBatteryRequest);

        //then
        assertNotNull(battery);
        assertNull(battery.getId());
        assertNull(battery.getPictureUrl());
        assertEquals(createBatteryRequest.name(), battery.getName());
        assertEquals(createBatteryRequest.cost(),battery.getCost());
        assertEquals(createBatteryRequest.manufacturer(), battery.getManufacturer());
        assertEquals(createBatteryRequest.description(), battery.getDescription());
        assertEquals(createBatteryRequest.rating(), battery.getRating());
        assertEquals(Product.Category.BATTERY, battery.getCategory());
        assertEquals(createBatteryRequest.nominalVoltage(), battery.getNominalVoltage());
        assertEquals(createBatteryRequest.capacity(), battery.getCapacity());
        assertEquals(createBatteryRequest.form(), battery.getForm().toString());
        assertEquals(createBatteryRequest.batteryTerminalDiameter(), battery.getBatteryTerminalDiameter());
    }

//    @Test
//    void shouldProperlyMapStringCategoryToBatteryForm() {
//        //given
//       String form = "PRISMATIC";
//
//        //when
//        Battery.FormFactor formFactor = batteryMapper.stringToFormFactor(form);
//
//        //then
//        assertNotNull(formFactor);
//        assertEquals(Battery.FormFactor.PRISMATIC, formFactor);
//    }

}
