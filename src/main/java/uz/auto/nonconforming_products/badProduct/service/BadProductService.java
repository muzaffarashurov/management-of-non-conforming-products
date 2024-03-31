package uz.auto.nonconforming_products.badProduct.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.auto.nonconforming_products.badProduct.repository.BadProductRepository;
import uz.auto.nonconforming_products.badProduct.entity.BadProduct;
import uz.auto.nonconforming_products.badProduct.mapper.BadProductMapper;
import uz.auto.nonconforming_products.badProduct.model.BadProductModel;
import uz.auto.nonconforming_products.badProduct.rest.dto.BadProductRequest;
import uz.auto.nonconforming_products.badProduct.rest.dto.BadProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadProductService {
    private final BadProductRepository repository;

    public List<BadProductModel> getAllBadProduct() {
        return repository.findAll().stream()
                .map(BadProductMapper::mapToModel)
                .toList();
    }

    public List<BadProductModel> getBadProductByDefectType(String defectType) {
        List<BadProduct> badProductList = repository.findByDefectType(defectType);
        return badProductList.stream()
                .map(BadProductMapper::mapToModel)
                .toList();
    }

    public BadProductResponse addBadProduct(BadProductRequest request) {
        var entity = repository.save(BadProductMapper.mapToEntity(request));
        return BadProductMapper.mapToDto(BadProductMapper.mapToModel(entity));
    }

    public BadProductResponse editBadProduct(Long id, BadProductRequest request) {
        BadProduct entity = repository.findById(id).orElseThrow(() -> new RuntimeException("BadProduct not found"));
        if (entity != null) {
            entity.setName(request.getName() != null ? request.getName() : entity.getName());
            entity.setDefectType(request.getDefectType() != null ? request.getDefectType() : entity.getDefectType());
            entity.setQuantity(request.getQuantity() != null ? request.getQuantity() : entity.getQuantity());
            entity.setDateField(request.getDateField() != null ? request.getDateField() : entity.getDateField());
            repository.save(entity);
        }
        return BadProductMapper.mapToDto(BadProductMapper.mapToModel(entity));
    }

    public void deleteBadProduct(Long id) {
        repository.deleteById(id);
    }
}
