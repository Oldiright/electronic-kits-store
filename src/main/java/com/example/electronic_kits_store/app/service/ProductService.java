package com.example.electronic_kits_store.app.service;


import com.example.electronic_kits_store.app.dto.ProductDTO;
import com.example.electronic_kits_store.app.mapper.ProductMapper;
import com.example.electronic_kits_store.app.model.Product;
import com.example.electronic_kits_store.app.projection.ProductProjection;
import com.example.electronic_kits_store.app.repository.BatteryRepository;
import com.example.electronic_kits_store.app.repository.BmsRepository;
import com.example.electronic_kits_store.app.repository.InverterRepository;
import com.example.electronic_kits_store.app.repository.MiscellaneousRepository;
import com.example.electronic_kits_store.app.repository.PowerBlockRepository;
import com.example.electronic_kits_store.app.repository.ProductRepository;
import com.example.electronic_kits_store.app.repository.WireLugRepository;
import com.example.electronic_kits_store.app.repository.WireRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BatteryRepository batteryRepository;
    private final BmsRepository bmsRepository;
    private final InverterRepository inverterRepository;
    private final MiscellaneousRepository miscellaneousRepository;
    private final PowerBlockRepository powerBlockRepository;
    private final WireRepository wireRepository;
    private final WireLugRepository wireLugRepository;
    private final ObjectMapper objectMapper;
    private final ProductMapper productMapper;

    public ProductDTO findById(long id) {
        ProductProjection product = productRepository.findProjectedById(id);
        return productMapper.toDto(product);
    }
    public List<ProductDTO> findAll() {
        return productRepository.findAllProjectedBy().stream().map(productMapper::toDto).toList();
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }


    //    public Product createWithBenefits(Map<String, String> productProperties, String category) throws ClassNotFoundException, JsonProcessingException {
//
//        Product product = objectMapper.readValue(productString, Utils.getProductClassName(category));
//        return productRepository.save(product);
//    }
//    public List<ProductProjection> findByManufacturer(String manufacturer) {
//        return productRepository.findAllProjectedByManufacturer(manufacturer);
//    }
//    public List<ProductProjection> findByCategory(Product.Category category) {
//        return productRepository.findAllProjectedByCategory(category);
//    }
//    public List<Product> findByCategoryWithDetails(String category) {
//        List<Product> productList = new ArrayList<>();
//        switch (category) {
//            case "battery":
//                productList.addAll(batteryRepository.findAll());
//                break;
//            case "bms":
//                productList.addAll(bmsRepository.findAll());
//                break;
//            case "inverter":
//                productList.addAll(inverterRepository.findAll());
//                break;
//            case "miscellaneous":
//                productList.addAll(miscellaneousRepository.findAll());
//                break;
//            case "wire":
//                productList.addAll(wireRepository.findAll());
//                break;
//            case "wireLug":
//                productList.addAll(wireLugRepository.findAll());
//                break;
//            case "powerBlock":
//                productList.addAll(powerBlockRepository.findAll());
//                break;
//        }
//        return productList;
//    }
//
//    public List<Product> findAllWithDetails() {
//        return productRepository.findAll();
//    }

}
