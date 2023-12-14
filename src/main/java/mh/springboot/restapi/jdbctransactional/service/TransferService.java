package mh.springboot.restapi.jdbctransactional.service;


import mh.springboot.restapi.jdbctransactional.dto.TransferDto;
import mh.springboot.restapi.jdbctransactional.model.Account;
import mh.springboot.restapi.jdbctransactional.repository.AccountRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class TransferService {

    private final AccountRepository repository;

    public TransferService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> listAllAccounts() {
        return repository.findAllAccounts();
    }

    @Transactional
    public void transferMoney(TransferDto transferDto) {
        Account serderAccount = repository.findAccountById(transferDto.senderAccountId());
        Account receiverAccount = repository.findAccountById(transferDto.receiverAccountId());

        BigDecimal newSenderAccountAmount = serderAccount.amount().subtract(transferDto.amount());
        BigDecimal newReceiverAccountAmount = receiverAccount.amount().add(transferDto.amount());

        repository.updateAccount(serderAccount.id(), newSenderAccountAmount);
        repository.updateAccount(receiverAccount.id(), newReceiverAccountAmount);
        throw new RuntimeException("Oh, no! Something went wrong!");
    }
}
