package dk.projectsbygroup7.testproject.dataaccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IPreparer {
    PreparedStatement prepare(PreparedStatement stmt) throws SQLException;
}
