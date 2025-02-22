package com.mwaisaka.SpringSecuritySample.repository;

import com.mwaisaka.SpringSecuritySample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
}
