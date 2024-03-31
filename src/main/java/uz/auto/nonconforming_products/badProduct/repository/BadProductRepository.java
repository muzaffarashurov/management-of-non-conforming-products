package uz.auto.nonconforming_products.badProduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.auto.nonconforming_products.badProduct.entity.BadProduct;

import java.util.List;

@Repository
public interface BadProductRepository extends JpaRepository<BadProduct, Long> {
    List<BadProduct>findByDefectType(String defectType);
}
