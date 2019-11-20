package com.mypicknpay.webApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	Optional<Role> findByRoleName(String roleName);
}

