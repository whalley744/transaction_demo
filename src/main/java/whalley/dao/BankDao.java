package whalley.dao;

import java.sql.SQLException;

/**
 * Created by Whalley on 2018/7/30.
 */
public interface BankDao {

    void update(int accountId, Double amount) throws SQLException;

    Double select(int accountId) throws SQLException;
}
