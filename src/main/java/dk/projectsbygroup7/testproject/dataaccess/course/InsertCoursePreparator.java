package dk.projectsbygroup7.testproject.dataaccess.course;

import dk.projectsbygroup7.testproject.dataaccess.IPreparator;
import dk.projectsbygroup7.testproject.pojos.Course;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCoursePreparator implements IPreparator {

    private Course newCourse;

    public InsertCoursePreparator(Course newCourse) {
        this.newCourse = newCourse;
    }

    @Override
    public PreparedStatement prepare(PreparedStatement stmt) throws SQLException {
        stmt.setString(1, newCourse.getSubject().getName());
        stmt.setInt(2, newCourse.getHours());
        Date startDate = Date.valueOf(newCourse.getStartDate());
        stmt.setDate(3, startDate);
        Date endDate = Date.valueOf(newCourse.getEndDate());
        stmt.setDate(4, endDate);
        return stmt;
    }
}

