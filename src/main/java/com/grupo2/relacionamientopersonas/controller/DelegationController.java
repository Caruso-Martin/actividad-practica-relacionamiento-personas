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
    public Delegation getDelegationById(@PathVariable("delegationId") Long delegationId) {
        return delegationService.getDelegationById(delegationId);
    }

    @PostMapping(path = "authorization") // Item: 4
    public void delegationAuthorization(@RequestParam Long delegativeDni, @RequestParam Long delegateDni) {
        delegationService.delegationAuthorization(delegativeDni, delegateDni);
    }

    @PutMapping(path = "acceptance") // Item: 5 y 7
    public void delegationAcceptance(@RequestParam Long delegationId, @RequestParam Boolean delegationAcceptance) {
        delegationService.delegationAcceptance(delegationId, delegationAcceptance);
    }

    @DeleteMapping(path = "revoke-authorization/{delegationId}") // Item: 6
    public void delegationAuthorizationRevoke(@PathVariable Long delegationId) {
        delegationService.delegationAuthorizationRevoke(delegationId);
    }
}
