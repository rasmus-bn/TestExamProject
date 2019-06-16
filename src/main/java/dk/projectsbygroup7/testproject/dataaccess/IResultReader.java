package dk.projectsbygroup7.testproject.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IResultReader<T> {
    T readResult(ResultSet result) throws SQLException;
}
