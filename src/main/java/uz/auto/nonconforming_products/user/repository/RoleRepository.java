package uz.auto.nonconforming_products.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.auto.nonconforming_products.user.entity.Role;
import uz.auto.nonconforming_products.user.entity.RoleName;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(RoleName roleName);
}
