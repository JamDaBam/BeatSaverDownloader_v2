package modules.db;

import java.sql.Connection;

public interface IDBDriver {
    Connection getConnection();

    void commit();

    void close();
}
