package uz.auto.nonconforming_products.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.auto.nonconforming_products.mapper.BadProductMapper;
import uz.auto.nonconforming_products.rest.dto.BadProductRequest;
import uz.auto.nonconforming_products.rest.dto.BadProductResponse;
import uz.auto.nonconforming_products.service.BadProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class BadProductController {

    private final BadProductService service;

    @Operation(summary = "Get all Bad Product")
    @GetMapping("/")
    public List<BadProductResponse> getAllBadProduct() {
        return service.getAllBadProduct().stream()
                .map(BadProductMapper::mapToDto)
                .toList();
    }

    @Operation(summary = "Get all Bad Product By Defect Type")
    @GetMapping("/{defectType}")
    public List<BadProductResponse> getBadProductByDefectType(@PathVariable("defectType") String defectType) {
        return service.getBadProductByDefectType(defectType).stream()
                .map(BadProductMapper::mapToDto)
                .toList();
    }

    @PostMapping("/add")
    public ResponseEntity<BadProductResponse> addBadProduct(@RequestBody BadProductRequest request) {
        BadProductResponse response = service.addBadProduct(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Edit Bad Product")
    @PutMapping("/edit/{id}")
    public ResponseEntity<BadProductResponse> editBadProduct(@PathVariable("id") Long id,
                                                             @RequestBody BadProductRequest request) {
        BadProductResponse response = service.editBadProduct(id, request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete Bad Product")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBadProduct(@PathVariable("id") Long id) {
        service.deleteBadProduct(id);
        return new ResponseEntity<>("Bad Product deleted", HttpStatus.OK);
    }

}
