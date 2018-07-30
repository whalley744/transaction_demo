package whalley.service;

import whalley.tm.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Whalley on 2018/7/30.
 */
public interface BankService {

    @Transactional
    void withDraw(int accountId, BigDecimal amount) throws SQLException;

    @Transactional
    void topUp(int accountId, BigDecimal amount) throws SQLException;

    @Transactional
    void transfer(int formId, int toId, BigDecimal amount) throws SQLException;

    @Transactional
    BigDecimal balance(int accountId) throws SQLException;
}
