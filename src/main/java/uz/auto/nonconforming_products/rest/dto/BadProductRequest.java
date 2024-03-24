package uz.auto.nonconforming_products.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class BadProductRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Defect type is required")
    private String defectType;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    private LocalDateTime dateField;

    public BadProductRequest() {
        this.dateField = LocalDateTime.now();
    }
}
