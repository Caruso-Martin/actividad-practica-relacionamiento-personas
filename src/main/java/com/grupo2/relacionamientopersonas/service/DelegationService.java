package com.grupo2.relacionamientopersonas.service;

import com.grupo2.relacionamientopersonas.domain.delegation.Delegation;
import com.grupo2.relacionamientopersonas.domain.delegation.DelegationStatus;
import com.grupo2.relacionamientopersonas.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DelegationService {
    private final DelegationRepository delegationRepository;

    @Autowired
    public DelegationService(DelegationRepository delegationRepository) {
        this.delegationRepository = delegationRepository;
    }

    public Delegation getDelegationById(Long idDelegation) {
        return delegationRepository.findDelegationById(idDelegation);
    }

    public void delegationAuthorization(Delegation delegation) {
        delegationRepository.save(delegation);
    }

    @Transactional
    public void delegationAcceptance(Long idDelegation, Boolean delegationAcceptance) {
        if(delegationAcceptance)
            this.getDelegationById(idDelegation).setStatus(DelegationStatus.ACCEPTED);
        else
            this.getDelegationById(idDelegation).setStatus(DelegationStatus.REJECTED);
    }

    public void delegationAuthorizationRevoke(Long idDelegation) {
        delegationRepository.deleteById(idDelegation);
    }
}
