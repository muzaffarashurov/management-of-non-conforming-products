package uz.auto.nonconforming_products.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class BadProductModel {
    private Long id;
    private String name;
    private String defectType;
    private Integer quantity;
    private LocalDate dateField;
}
