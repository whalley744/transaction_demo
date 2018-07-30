package whalley.ds;

import javax.sql.DataSource;

/**
 * Created by Whalley on 2018/7/30.
 */
public class DataSourceFactory {

    private static final DataSource dataSource = null;

    //    static {
    //        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
    //        dataSource.setUsername("SA");
    //        dataSource.setPassword("");
    //        dataSource.setUrl("jdbc:hsqldb:mem:bank");
    //    }

    public static DataSource createDataSource() {
        return dataSource;
    }

}
