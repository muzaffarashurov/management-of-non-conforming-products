package uz.auto.nonconforming_products.badProduct.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
