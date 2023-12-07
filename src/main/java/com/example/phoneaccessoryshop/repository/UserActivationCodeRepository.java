package com.example.phoneaccessoryshop.repository;

import com.example.phoneaccessoryshop.model.entity.UserActivationCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationCodeRepository extends JpaRepository<UserActivationCodeEntity, Long> {


    UserActivationCodeEntity findByActivationCode(String activationCode);
}
