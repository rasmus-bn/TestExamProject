package dk.projectsbygroup7.testproject.dataaccess;

import dk.projectsbygroup7.testproject.dataaccess.statementpreparators.CourseInsertPreparator;
import dk.projectsbygroup7.testproject.dataaccess.resultreaders.CourseResultReader;
import dk.projectsbygroup7.testproject.pojos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseDAO {

    @Autowired
    DBConnection dbConn;

    public int createNew(Course newCourse) {

        String sql = "" +
                "insert into course (subject, hours, startDate, endDate)\n" +
                "values (?,?,?,?); " +
                "select last_insert_id() as id;";

        return dbConn.doInsert(sql, new CourseInsertPreparator(newCourse));
    }

    public ArrayList<Course> getAll() {
        String sql = "" +
                "select id, subject, hours, startDate, endDate from course;";

        return dbConn.doSelectAll(sql, new CourseResultReader());
    }

    public Course getById(int id) {
        String sql = "" +
                "select id, subject, hours, startDate, endDate from course where id = ?;";

        return dbConn.doSelectById(sql, id, new CourseResultReader());
    }
}
