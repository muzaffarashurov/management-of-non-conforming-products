package uz.auto.nonconforming_products.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.auto.nonconforming_products.user.entity.Role;
import uz.auto.nonconforming_products.user.entity.RoleName;
import uz.auto.nonconforming_products.user.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(RoleName roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("No role found by name " + roleName.name()));
    }
}
