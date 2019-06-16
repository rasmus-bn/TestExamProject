package dk.projectsbygroup7.testproject.dataaccess.student;

import dk.projectsbygroup7.testproject.dataaccess.IPreparator;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentGetByEmailPreparator implements IPreparator {

    String email;

    public StudentGetByEmailPreparator(String email) {
        this.email = email;
    }

    @Override
    public PreparedStatement prepare(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, email);
        return stmt;
    }
}
