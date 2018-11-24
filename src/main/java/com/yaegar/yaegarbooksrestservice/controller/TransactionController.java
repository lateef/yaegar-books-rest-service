package com.yaegar.yaegarbooksrestservice.controller;

import com.yaegar.yaegarbooksrestservice.model.Ledger;
import com.yaegar.yaegarbooksrestservice.model.Transaction;
import com.yaegar.yaegarbooksrestservice.model.User;
import com.yaegar.yaegarbooksrestservice.service.LedgerService;
import com.yaegar.yaegarbooksrestservice.service.TransactionService;
import com.yaegar.yaegarbooksrestservice.util.AuthenticationUtils;
import com.yaegar.yaegarbooksrestservice.model.enums.TransactionSide;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
public class TransactionController {
    private LedgerService ledgerService;
    private TransactionService transactionService;

    public TransactionController(LedgerService ledgerService, TransactionService transactionService) {
        this.ledgerService = ledgerService;
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

            final Ledger ledger = ledgerService.findByUuid(transaction.getLedger().getUuid())
                    .orElseThrow(NullPointerException::new);
            final Ledger counterLedger = ledgerService.findByUuid(transaction.getCounterLedgerUuid())
                    .orElseThrow(NullPointerException::new);


            if (transaction1 == null) {
                transaction1 = new Transaction();
                transaction1.setUuid(transaction.getUuid());
                transaction1.setLedger(ledger);
                transaction1.setAmount(transaction.getAmount());
                transaction1.setCounterLedgerUuid(transaction.getCounterLedgerUuid());
                transaction1.setDescription(transaction.getDescription());
                transaction1.setCreatedBy(user);
                transaction1.setUpdatedBy(user);
                transaction1.setTransactionSide(computeTransactionSide(transaction1));
                final Transaction savedTransaction1 = transactionService.addTransaction(transaction1);

                Transaction counterTransaction = new Transaction();
                counterTransaction.setUuid(UUID.randomUUID().toString());
                counterTransaction.setLedger(counterLedger);
                counterTransaction.setAmount(transaction.getAmount());
                counterTransaction.setDescription(transaction.getDescription());
                counterTransaction.setTransactionLink(savedTransaction1);
                counterTransaction.setTransactionSide(computeTransactionSide(counterTransaction));
                transactionService.addTransaction(counterTransaction);
            } else {
                transaction.setUpdatedBy(user);
            }
        }
        return ResponseEntity.ok().headers(headers).body(transaction1);
    }

    private TransactionSide computeTransactionSide(Transaction transaction) {
        return TransactionSide.CREDIT;
    }
}
