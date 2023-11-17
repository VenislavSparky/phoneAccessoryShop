package com.example.phoneaccessoryshop.model.entity;

import com.example.phoneaccessoryshop.model.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private UserRoleEnum roles;

    public UserRoleEnum getRoles() {
        return roles;
    }

    public void setRoles(UserRoleEnum roles) {
        this.roles = roles;
    }
}
