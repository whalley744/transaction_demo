package whalley.dao.impl;

import whalley.dao.BankDao;
import whalley.ds.ConnectionHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Whalley on 2018/7/30.
 */
public class BankDaoImpl implements BankDao {

    private DataSource dataSource;

    public BankDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update(int accountId, Double amount) throws SQLException {
        Connection connection = ConnectionHolder.getConnectionHolder().getConnection(dataSource);
        //todo execute update sql
    }

    @Override
    public Double select(int accountId) throws SQLException {
        Connection connection = ConnectionHolder.getConnectionHolder().getConnection(dataSource);
        //todo execute select sql
        return null;
    }
}
