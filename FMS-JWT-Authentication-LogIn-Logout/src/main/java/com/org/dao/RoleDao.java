package com.org.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.ERole;
import com.org.model.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
