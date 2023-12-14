package mh.springboot.restapi.jdbctransactional.repository;


import mh.springboot.restapi.jdbctransactional.model.Account;
import mh.springboot.restapi.jdbctransactional.repository.mappers.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> findAllAccounts() {
        return jdbcTemplate.query("SELECT * FROM account", new AccountRowMapper());
    }

    public Account findAccountById(int accountId) {
        return jdbcTemplate.queryForObject("SELECT * FROM account WHERE id = ?", new AccountRowMapper(), accountId);
    }

    public void updateAccount(int accountId, BigDecimal amount) {
        jdbcTemplate.update("UPDATE account SET amount = ? WHERE id = ?", amount, accountId);
    }
}
