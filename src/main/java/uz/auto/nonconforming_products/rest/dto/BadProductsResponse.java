package uz.auto.nonconforming_products.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class BadProductsResponse {
    private Long id;
    private String name;
    private String defectType;
    private Integer quantity;
    private LocalDate dateField;

}
