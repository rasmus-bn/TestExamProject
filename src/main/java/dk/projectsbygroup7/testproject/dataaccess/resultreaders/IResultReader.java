package dk.projectsbygroup7.testproject.dataaccess.resultreaders;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResultReader<T> {
    T readResult(ResultSet result) throws SQLException;
}
