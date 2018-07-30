package whalley.tm;

import whalley.ds.ConnectionHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Whalley on 2018/7/30.
 */
public class TransactionManager {

    private DataSource                    dataSource;

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return ConnectionHolder.getConnectionHolder().getConnection(dataSource);
    }

    public void open() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        Connection connection = getConnection();
        connection.commit();
    }

    public void rollback() throws SQLException {
        Connection connection = getConnection();
        connection.rollback();
    }

    public final void close() {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(true);
            connection.setReadOnly(false);
            connection.close();
            ConnectionHolder.getConnectionHolder().removeConnection(dataSource);
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't close connection[" + connection + "].", e);
        }
    }

}
