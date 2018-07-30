package whalley.service.impl;

import whalley.dao.BankDao;
import whalley.service.BankService;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Whalley on 2018/7/30.
 */
public class BankServiceImpl implements BankService {

    private BankDao bankDao;

    public BankServiceImpl(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Override
    public void withDraw(int accountId, BigDecimal amount) throws SQLException {
        BigDecimal balance = balance(accountId);
        BigDecimal newBalance = balance.subtract(amount);
        update(accountId, newBalance);
    }

    @Override
    public void topUp(int accountId, BigDecimal amount) throws SQLException {
        BigDecimal balance = balance(accountId);
        BigDecimal newBalance = balance.add(amount);
        update(accountId, newBalance);
    }

    @Override
    public void transfer(int formId, int toId, BigDecimal amount) throws SQLException {
        withDraw(formId, amount);
        topUp(toId, amount);
    }

    @Override
    public BigDecimal balance(int accountId) throws SQLException {
        Double balance = bankDao.select(accountId);
        return new BigDecimal(balance);
    }

    private void update(int accountId, BigDecimal balance) throws SQLException {
        bankDao.update(accountId, balance.doubleValue());
    }

}
