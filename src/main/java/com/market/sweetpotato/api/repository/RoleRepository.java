package com.market.sweetpotato.api.repository;

import com.market.sweetpotato.api.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleUser);
}
