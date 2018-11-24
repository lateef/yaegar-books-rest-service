package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.Ledger;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.service.LedgerService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LedgerController {
    private LedgerService ledgerService;

    public LedgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    @RequestMapping(value = "/add-ledger", method = RequestMethod.POST)
    public ResponseEntity<Ledger> addLedger(@RequestBody final Ledger ledger, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        Ledger ledger1 = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);
            ledger1 = ledgerService.addLedger(ledger, user);
        }
        return ResponseEntity.ok().headers(headers).body(ledger1);
    }
}
