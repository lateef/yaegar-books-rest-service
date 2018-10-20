package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.Transaction;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.service.TransactionService;
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
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/add-transaction", method = RequestMethod.PUT)
    public ResponseEntity<Transaction> addTransaction(@RequestBody final Transaction transaction, ModelMap model, HttpServletRequest httpServletRequest) {
        final User user = (User) model.get("user");
        HttpHeaders headers = null;
        Transaction transaction1 = null;
        if (user != null) {
            headers = AuthenticationUtils.getAuthenticatedUser(user);

            transaction1 = transactionService.findByUuid(transaction.getUuid())
                    .orElse(null);

            if (transaction1 == null) {
                transaction.setCreatedBy(user);
                transaction.setUpdatedBy(user);
            } else {
                transaction.setUpdatedBy(user);
            }
        }
        return ResponseEntity.ok().headers(headers).body(transaction1);
    }
}
