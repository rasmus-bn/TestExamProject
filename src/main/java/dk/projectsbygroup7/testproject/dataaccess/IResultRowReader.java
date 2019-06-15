package dk.projectsbygroup7.testproject.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IResultRowReader<T> {
    T readResult(ResultSet row) throws SQLException;
}
