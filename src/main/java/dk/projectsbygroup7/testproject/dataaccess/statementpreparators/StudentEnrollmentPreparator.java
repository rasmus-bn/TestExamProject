package dk.projectsbygroup7.testproject.dataaccess.statementpreparators;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentEnrollmentPreparator implements IStatementPreparator {

    private int studentId;
    private int courseId;

    public StudentEnrollmentPreparator(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public PreparedStatement prepare(PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, studentId);
        stmt.setInt(2, courseId);
        return stmt;
    }
}
