package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper <T> {

    T mapRow(ResultSet result) throws SQLException;
}
