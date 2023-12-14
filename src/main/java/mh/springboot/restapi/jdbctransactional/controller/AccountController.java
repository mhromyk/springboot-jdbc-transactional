package mh.springboot.restapi.jdbctransactional.controller;

import mh.springboot.restapi.jdbctransactional.dto.TransferDto;
import mh.springboot.restapi.jdbctransactional.model.Account;
import mh.springboot.restapi.jdbctransactional.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/accounts")
    public List<Account> listAccounts() {
        return transferService.listAllAccounts();
    }

    @PostMapping("/transfer")
    public void makeTransfer(@RequestBody TransferDto transfer) {
        transferService.transferMoney(transfer);
    }
}
