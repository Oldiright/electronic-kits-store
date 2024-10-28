package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.model.Battery;
import com.example.electronic_kits_store.app.model.Bms;
import com.example.electronic_kits_store.app.model.Inverter;
import com.example.electronic_kits_store.app.model.Miscellaneous;
import com.example.electronic_kits_store.app.model.Wire;
import com.example.electronic_kits_store.app.model.WireLug;
import com.example.electronic_kits_store.app.service.BatteryService;
import com.example.electronic_kits_store.app.service.BmsService;
import com.example.electronic_kits_store.app.service.InverterService;
import com.example.electronic_kits_store.app.service.MiscellaneousService;
import com.example.electronic_kits_store.app.service.ProductService;
import com.example.electronic_kits_store.app.service.WireLugService;
import com.example.electronic_kits_store.app.service.WireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class TestController {
    private final ProductService productService;
    private final BatteryService batteryService;
    private final BmsService bmsService;
    private final InverterService inverterService;
    private final MiscellaneousService miscellaneousService;
    private final WireService wireService;
    private final WireLugService wireLugService;

    @GetMapping("/findAll")
    public Object findAllWithDetails(@RequestParam boolean details) {
        if (details) {
            return productService.findAllWithDetails();
        }
        return productService.findAll();
    }

    @GetMapping("/battery/findAll")
    public List<Battery> getAllBatteries() {
        return batteryService.findAll();
    }
    @GetMapping("/bms/findAll")
    public List<Bms> findAllBms() {
        return bmsService.findAll();
    }
    @GetMapping("/inverter/findAll")
    public List<Inverter> findAllInverter() {
        return inverterService.findAll();
    }

    @GetMapping("/wireLug/findAll")
    public List<WireLug> findAllWireLug() {
        return wireLugService.findAll();
    }
    @GetMapping("/wire/findAll")
    public List<Wire> findAllWire() {
        return wireService.findAll();
    }
    @GetMapping("/miscellaneous/findAll")
    public List<Miscellaneous> findAllMiscellaneous() {
        return miscellaneousService.findAll();
    }


}
