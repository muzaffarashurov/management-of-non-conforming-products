package uz.auto.nonconforming_products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.auto.nonconforming_products.entity.BadProduct;
import uz.auto.nonconforming_products.mapper.BadProductMapper;
import uz.auto.nonconforming_products.model.BadProductModel;
import uz.auto.nonconforming_products.repository.BadProductRepository;
import uz.auto.nonconforming_products.rest.dto.BadProductRequest;
import uz.auto.nonconforming_products.rest.dto.BadProductResponse;

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
            entity.setName(request.getName());
            entity.setDefectType(request.getDefectType());
            entity.setQuantity(request.getQuantity());
            entity.setDateField(request.getDateField());
            repository.save(entity);
        }
        return BadProductMapper.mapToDto(BadProductMapper.mapToModel(entity));
    }

    public void deleteBadProduct(Long id) {
        repository.deleteById(id);
    }
}
