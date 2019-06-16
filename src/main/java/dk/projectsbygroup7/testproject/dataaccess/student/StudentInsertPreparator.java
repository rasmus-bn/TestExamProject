package dk.projectsbygroup7.testproject.dataaccess.student;

import dk.projectsbygroup7.testproject.dataaccess.IPreparator;
import dk.projectsbygroup7.testproject.pojos.Student;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentInsertPreparator implements IPreparator {

    private Student student;

    public StudentInsertPreparator(Student student) {
        this.student = student;
    }

    @Override
    public PreparedStatement prepare(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getEmail());
        Date birthDay = Date.valueOf(student.getBirthday());
        stmt.setDate(3, birthDay);
        return stmt;
    }
}
