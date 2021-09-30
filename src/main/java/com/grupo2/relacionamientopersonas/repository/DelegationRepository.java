package com.grupo2.relacionamientopersonas.repository;

import com.grupo2.relacionamientopersonas.domain.delegation.Delegation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {
    Delegation findDelegationById(Long delegationId);
}
