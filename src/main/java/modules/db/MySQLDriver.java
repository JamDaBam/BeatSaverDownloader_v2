package modules.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDriver implements IDBDriver {
    private Connection ivConnection;
    private String ivUser;
    private String ivPassword;
    private String ivHost;
    private String ivPort;
    private String ivDatabase;

    private MySQLDriver() {
    }

    public MySQLDriver(String aUser, String aPassword, String aHost, String aPort, String aDatabase) {
        ivUser = aUser;
        ivPassword = aPassword;
        ivHost = aHost;
        ivPort = aPort;
        ivDatabase = aDatabase;
    }

    @Override
    public Connection getConnection() {
        if (ivConnection != null) {
            return ivConnection;
        }

        try {
            ivConnection = DriverManager.getConnection("jdbc:mysql://" + ivHost + ":" + ivPort + "/" + ivDatabase, ivUser, ivPassword);

            ivConnection.setAutoCommit(false);
        } catch (SQLException aE) {
            aE.printStackTrace();
        }

        return ivConnection;
    }

    @Override
    public void commit() {
        if (ivConnection == null) {
            return;
        }

        try {
            ivConnection.commit();
        } catch (SQLException aE) {
            aE.printStackTrace();
        }
    }

    @Override
    public void close() {
        if (ivConnection == null) {
            return;
        }

        try {
            ivConnection.close();
            ivConnection = null;
        } catch (SQLException aE) {
            aE.printStackTrace();
        }
    }
}
