package dk.projectsbygroup7.testproject.dataaccess.resultreaders;

import dk.projectsbygroup7.testproject.dataaccess.resultreaders.IResultReader;
import dk.projectsbygroup7.testproject.pojos.Course;
import dk.projectsbygroup7.testproject.pojos.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CourseResultReader implements IResultReader<Course> {
    @Override
    public Course readResult(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        Subject subject = new Subject();
        subject.setName(result.getString("subject"));
        int hours = result.getInt("hours");
        LocalDate startDate = result.getDate("startDate").toLocalDate();
        LocalDate endDate = result.getDate("endDate").toLocalDate();
        return new Course(id, subject, hours, startDate, endDate);
    }
}
