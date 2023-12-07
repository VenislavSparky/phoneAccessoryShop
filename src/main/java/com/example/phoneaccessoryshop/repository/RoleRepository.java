package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.RoleEntity;
import com.example.phoneaccessoryshop.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findRoleByRole(UserRoleEnum userRoleEnum);
}
