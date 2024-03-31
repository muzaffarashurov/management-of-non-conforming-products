package uz.auto.nonconforming_products.badProduct.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BadProductResponse {
    private Long id;
    private String name;
    private String defectType;
    private Integer quantity;
    private LocalDateTime dateField;

}
