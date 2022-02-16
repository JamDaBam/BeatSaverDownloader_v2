package Modules.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDriver implements IDBDriver {
    private Connection ivConnection;

    @Override
    public Connection getConnection() {
        if (ivConnection != null) {
            return ivConnection;
        }

        try {
            ivConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "Beatsaver", "root", "admin123");
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
