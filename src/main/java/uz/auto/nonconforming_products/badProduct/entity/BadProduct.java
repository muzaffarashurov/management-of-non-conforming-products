package uz.auto.nonconforming_products.badProduct.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bad_product")
public class BadProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "defect_type", nullable = false)
    private String defectType;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "date_field", nullable = false)
    private LocalDateTime dateField;

    @PrePersist
    protected void onCreate() {
        dateField = LocalDateTime.now();
    }
}
