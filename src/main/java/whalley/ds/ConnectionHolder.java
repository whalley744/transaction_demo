package whalley.ds;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Whalley on 2018/7/30.
 */
public class ConnectionHolder {

    private static ThreadLocal<ConnectionHolder> localConnectionHolder = new ThreadLocal<>();

    public static ConnectionHolder getConnectionHolder() {
        ConnectionHolder connectionHolder = localConnectionHolder.get();
        if (connectionHolder == null) {
            connectionHolder = new ConnectionHolder();
            localConnectionHolder.set(connectionHolder);
        }
        return connectionHolder;
    }

    private static Map<DataSource, Connection> connectionMap = new HashMap<>();

    public Connection getConnection(DataSource dataSource) throws SQLException {
        Connection connection = connectionMap.get(dataSource);
        if (connection == null || connection.isClosed()) {
            connection = dataSource.getConnection();
            connectionMap.put(dataSource, connection);
        }
        return connection;
    }

    public void removeConnection(DataSource dataSource) {
        connectionMap.remove(dataSource);
    }

}
