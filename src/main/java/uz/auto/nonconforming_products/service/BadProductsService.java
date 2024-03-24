package uz.auto.nonconforming_products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.auto.nonconforming_products.entity.BadProducts;
import uz.auto.nonconforming_products.mapper.BadProductsMapper;
import uz.auto.nonconforming_products.model.BadProductModel;
import uz.auto.nonconforming_products.repository.BadProductsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadProductsService {
    private final BadProductsRepository repository;

    public List<BadProductModel> getAllBadProducts() {
        return repository.findAll().stream()
                .map(BadProductsMapper::mapToModel)
                .toList();
    }

    public List<BadProductModel> getBadProductsByDefectType(String defectType) {
        List<BadProducts> badProductsList = repository.findByDefectType(defectType);
        return badProductsList.stream()
                .map(BadProductsMapper::mapToModel)
                .toList();
    }
}
