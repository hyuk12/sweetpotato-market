package com.market.sweetpotato.api.repository;

import com.market.sweetpotato.api.domain.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
