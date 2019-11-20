package com.mypicknpay.webApi.repository;







import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypicknpay.webApi.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
	Optional<AppUser> findByEmailAddress(String emailAddress);
	Boolean existsByEmailAddress(String emailAddress);
}
