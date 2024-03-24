package uz.auto.nonconforming_products.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.auto.nonconforming_products.mapper.BadProductsMapper;
import uz.auto.nonconforming_products.rest.dto.BadProductsResponse;
import uz.auto.nonconforming_products.service.BadProductsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class BadProductsController {

    private final BadProductsService service;

    @Operation(summary = "Get all Bad Products")
    @GetMapping("/")
    public List<BadProductsResponse> getAllBadProducts() {
        return service.getAllBadProducts().stream()
                .map(BadProductsMapper::mapToDto)
                .toList();
    }
    @Operation(summary = "Get all Bad Products By Defect Type")
    @GetMapping("/{defectType}")
    public List<BadProductsResponse> getBadProductsByDefectType(@PathVariable("defectType") String defectType ) {
        return service.getBadProductsByDefectType(defectType).stream()
                .map(BadProductsMapper::mapToDto)
                .toList();
    }
}
