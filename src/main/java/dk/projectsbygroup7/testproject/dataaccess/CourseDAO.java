package dk.projectsbygroup7.testproject.dataaccess;

import dk.projectsbygroup7.testproject.pojos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class CourseDAO {

    @Autowired
    DBConnHandler connHandler;

    public int createCourse (Course newCourse) {

        String sql = "" +
                "insert into course (subject, hours, startDate, endDate)\n" +
                "values (?,?,?,?); " +
                "select last_insert_id() as id;";

        class Preparer implements IPreparer {

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

        return connHandler.doInsert(sql, new Preparer());
    }
}
