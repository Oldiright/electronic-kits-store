package com.example.electronic_kits_store.app.controller;

import com.example.electronic_kits_store.app.dto.Miscellaneous.CreateMiscellaneousRequest;
import com.example.electronic_kits_store.app.dto.Miscellaneous.MiscellaneousDTO;
import com.example.electronic_kits_store.app.dto.battery.BatteryDTO;
import com.example.electronic_kits_store.app.dto.battery.CreateBatteryRequest;
import com.example.electronic_kits_store.app.dto.battery.UpdateBatteryRequest;
import com.example.electronic_kits_store.app.dto.bms.BmsDTO;
import com.example.electronic_kits_store.app.dto.bms.CreateBmsRequest;
import com.example.electronic_kits_store.app.dto.inverter.CreateInverterRequest;
import com.example.electronic_kits_store.app.dto.inverter.InverterDTO;
import com.example.electronic_kits_store.app.dto.powerblock.CreatePowerBlockRequest;
import com.example.electronic_kits_store.app.dto.powerblock.PowerBlockDTO;
import com.example.electronic_kits_store.app.dto.product.ProductDTO;
import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.service.BatteryService;
import com.example.electronic_kits_store.app.service.BmsService;
import com.example.electronic_kits_store.app.service.FileStorageService;
import com.example.electronic_kits_store.app.service.InverterService;
import com.example.electronic_kits_store.app.service.MiscellaneousService;
import com.example.electronic_kits_store.app.service.PowerBlockService;
import com.example.electronic_kits_store.app.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final ProductService productService;
    private final FileStorageService fileStorageService;
    private final BatteryService batteryService;
    private final BmsService bmsService;
    private final InverterService inverterService;
    private final MiscellaneousService miscellaneousService;
    private final PowerBlockService powerBlockService;

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
    @PostMapping("battery/create")
    public ResponseEntity<BatteryDTO> createBattery(@Valid @RequestBody CreateBatteryRequest createBatteryRequest) {
        return ResponseEntity.status(201).body(batteryService.create(createBatteryRequest));
    }
    @PutMapping("battery/update")
    public ResponseEntity<BatteryDTO> updateBattery(@Valid @RequestBody UpdateBatteryRequest updateBatteryRequest) {
        return ResponseEntity.ok(batteryService.updateBattery(updateBatteryRequest));
    }
    @PostMapping("bms/create")
    public ResponseEntity<BmsDTO> createBms(@Valid @RequestBody CreateBmsRequest createBmsRequest) {
        return ResponseEntity.status(201).body(bmsService.create(createBmsRequest));
    }
    @PostMapping("inverter/create")
    public ResponseEntity<InverterDTO> createInverter(@Valid @RequestBody CreateInverterRequest createInverterRequest) {
        return ResponseEntity.status(201).body(inverterService.create(createInverterRequest));
    }
    @PostMapping("miscellaneous/create")
    public ResponseEntity<MiscellaneousDTO> createMiscellaneous(@Valid @RequestBody CreateMiscellaneousRequest createMiscellaneousRequest) {
        return ResponseEntity.status(201).body(miscellaneousService.create(createMiscellaneousRequest));
    }
    @PostMapping("powerblock/create")
    public ResponseEntity<PowerBlockDTO> createPowerBlock(@Valid @RequestBody CreatePowerBlockRequest createPowerBlockRequest) {
        return ResponseEntity.status(201).body(powerBlockService.create(createPowerBlockRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}/images/{category}")
    public ResponseEntity<ProductDTO> uploadImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file, @PathVariable String category) {

        String imagePath = fileStorageService.saveProductImage(id, file, category);
        var product = productService.addImage(id, imagePath);
        return ResponseEntity.ok(product);
    }
}
