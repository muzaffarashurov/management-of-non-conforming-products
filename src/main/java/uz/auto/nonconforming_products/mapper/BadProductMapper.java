package uz.auto.nonconforming_products.mapper;

import uz.auto.nonconforming_products.entity.BadProduct;
import uz.auto.nonconforming_products.model.BadProductModel;
import uz.auto.nonconforming_products.rest.dto.BadProductRequest;
import uz.auto.nonconforming_products.rest.dto.BadProductResponse;

public class BadProductMapper {
    public static BadProductResponse mapToDto(BadProductModel model) {
        return BadProductResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .defectType(model.getDefectType())
                .quantity(model.getQuantity())
                .dateField(model.getDateField())
                .build();
    }

    public static BadProductModel mapToModel(BadProduct entity) {
        return BadProductModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .defectType(entity.getDefectType())
                .quantity(entity.getQuantity())
                .dateField(entity.getDateField())
                .build();
    }

    public static BadProduct mapToEntity(BadProductRequest request) {
        return BadProduct.builder()
                .name(request.getName())
                .defectType(request.getDefectType())
                .quantity(request.getQuantity())
                .dateField(request.getDateField())
                .build();
    }
}
