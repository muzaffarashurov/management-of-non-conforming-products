package uz.auto.nonconforming_products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.auto.nonconforming_products.entity.BadProducts;

import java.util.List;

@Repository
public interface BadProductsRepository extends JpaRepository<BadProducts, Long> {
    List<BadProducts>findByDefectType(String defectType);
}
