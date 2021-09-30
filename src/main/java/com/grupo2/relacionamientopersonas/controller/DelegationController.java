package com.grupo2.relacionamientopersonas.controller;

import com.grupo2.relacionamientopersonas.domain.delegation.Delegation;
import com.grupo2.relacionamientopersonas.service.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "delegation")
public class DelegationController {
    private final DelegationService delegationService;

    @Autowired
    public DelegationController(DelegationService delegationService) {
        this.delegationService = delegationService;
    }

    @GetMapping(path = "{delegationId}")
    public Delegation getDelegationById(@PathVariable("delegationId") Long idDelegation) {
        return delegationService.getDelegationById(idDelegation);
    }

    @PostMapping(path = "authorization") // Item: 4
    public void delegationAuthorization(@RequestBody Delegation delegation) {
        delegationService.delegationAuthorization(delegation);
    }

    @PutMapping(path = "acceptance") // Item: 5 y 7
    public void delegationAcceptance(@RequestBody Long idDelegation, @RequestBody Boolean delegationAcceptance) {
        delegationService.delegationAcceptance(idDelegation, delegationAcceptance);
    }

    @DeleteMapping(path = "revoke-authorization") // Item: 6
    public void delegationAuthorizationRevoke(@RequestBody Long idDelegation) {
        delegationService.delegationAuthorizationRevoke(idDelegation);
    }
}
