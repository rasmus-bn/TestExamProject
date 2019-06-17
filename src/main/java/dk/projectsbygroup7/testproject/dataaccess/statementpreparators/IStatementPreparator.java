package dk.projectsbygroup7.testproject.dataaccess.statementpreparators;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IStatementPreparator {
    PreparedStatement prepare(PreparedStatement stmt) throws SQLException;
}
