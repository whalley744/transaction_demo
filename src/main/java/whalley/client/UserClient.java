package whalley.client;

import whalley.service.BankService;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Whalley on 2018/7/30.
 */
public class UserClient extends BaseClient {
    private BankService bankService;

    public UserClient() {
        super();
        bankService = (BankService) transactionProxyManager.proxyFor(proxied);
    }

    public void transfer(int fromId, int toId, BigDecimal amount) throws SQLException {
        bankService.transfer(fromId, toId, amount);
    }
}
