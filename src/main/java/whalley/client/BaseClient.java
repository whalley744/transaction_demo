package whalley.client;

import whalley.dao.impl.BankDaoImpl;
import whalley.ds.DataSourceFactory;
import whalley.service.BankService;
import whalley.service.impl.BankServiceImpl;
import whalley.tm.TransactionManager;
import whalley.tm.proxy.TransactionProxyManager;

import javax.sql.DataSource;

/**
 * Created by Whalley on 2018/7/30.
 */
public class BaseClient {
    protected TransactionProxyManager transactionProxyManager;
    protected BankService             proxied;

    public BaseClient() {
        DataSource dataSource = DataSourceFactory.createDataSource();
        TransactionManager transactionManager = new TransactionManager(dataSource);
        transactionProxyManager = new TransactionProxyManager(transactionManager);
        proxied = new BankServiceImpl(new BankDaoImpl(dataSource));
    }
}
