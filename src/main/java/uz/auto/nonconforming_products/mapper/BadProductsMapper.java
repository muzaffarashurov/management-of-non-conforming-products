package uz.auto.nonconforming_products.mapper;

import uz.auto.nonconforming_products.entity.BadProducts;
import uz.auto.nonconforming_products.model.BadProductModel;
import uz.auto.nonconforming_products.rest.dto.BadProductsResponse;

public class BadProductsMapper {
    public static BadProductsResponse mapToDto(BadProductModel model) {
        return BadProductsResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .defectType(model.getDefectType())
                .quantity(model.getQuantity())
                .dateField(model.getDateField())
                .build();
    }

    public static BadProductModel mapToModel(BadProducts entity) {
        return BadProductModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .defectType(entity.getDefectType())
                .quantity(entity.getQuantity())
                .dateField(entity.getDateField())
                .build();
    }
}
