package Modules.DB;

import java.sql.Connection;

public interface IDBDriver {
    Connection getConnection();

    void commit();

    void close();
}
