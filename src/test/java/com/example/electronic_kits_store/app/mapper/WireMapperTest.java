package com.example.electronic_kits_store.app.mapper;

import com.example.electronic_kits_store.app.dto.wire.CreateWireRequest;
import com.example.electronic_kits_store.app.dto.wire.WireDTO;
import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.model.Wire;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WireMapperTest {
    private final WireMapper wireMapper= new WireMapperImpl();


//    @BeforeAll
//    static void setup() {
//        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//    }
    @Test
    void shouldProperlyMapEntityToDto() {
        //given
        Wire wire = new Wire();
        wire.setId(445L);
        wire.setName("Wire 4AWG");
        wire.setCost(BigDecimal.valueOf(256));
        wire.setManufacturer("China");
        wire.setDescription("Wire 4AWG, black, with PVC isolation");
        wire.setRating((byte) 5);
        wire.setPictureUrl("/445.jpg");
        wire.setColor("Black");
        wire.setCrossSectionArea(2);
        wire.setInsulationMaterial("PVC");


        //when
        WireDTO wireDTO = wireMapper.toDto(wire);

        //then
        assertNotNull(wireDTO);
        assertEquals(wire.getId(), wireDTO.id());
        assertEquals(wire.getName(), wireDTO.name());
        assertEquals(wire.getCost(), wireDTO.cost());
        assertEquals(wire.getManufacturer(), wireDTO.manufacturer());
        assertEquals(wire.getDescription(), wireDTO.description());
        assertEquals(wire.getRating(), wireDTO.rating());
        assertEquals(wire.getPictureUrl(), wireDTO.pictureUrl());
        assertEquals(wire.getCategory().toString(), wireDTO.category());
        assertEquals(wire.getColor(), wireDTO.color());
        assertEquals(wire.getCrossSectionArea(), wireDTO.crossSectionArea());
        assertEquals(wire.getInsulationMaterial(), wireDTO.insulationMaterial());

    }
    @Test
    void shouldProperlyMapCreateWireRequestToEntity() {
        //given
        CreateWireRequest createWireRequest = new CreateWireRequest(
                "Wire 4AWG",
                BigDecimal.valueOf(256),
                "China",
                "Wire 4AWG, black, with PVC isolation",
                (byte) 5,
                "Black",
                2,
                "PVC"

        );
        //when
        Wire wire = wireMapper.toEntity(createWireRequest);

        //then
        assertNotNull(wire);
        assertNull(wire.getId());
        assertNull(wire.getPictureUrl());
        assertEquals(createWireRequest.name(), wire.getName());
        assertEquals(createWireRequest.cost(), wire.getCost());
        assertEquals(createWireRequest.manufacturer(), wire.getManufacturer());
        assertEquals(createWireRequest.description(), wire.getDescription());
        assertEquals(createWireRequest.rating(), wire.getRating());
        assertEquals(Product.Category.WIRE, wire.getCategory());
        assertEquals(createWireRequest.color(), wire.getColor());
        assertEquals(createWireRequest.crossSectionArea(), wire.getCrossSectionArea());
        assertEquals(createWireRequest.insulationMaterial(), wire.getInsulationMaterial());
    }
}
