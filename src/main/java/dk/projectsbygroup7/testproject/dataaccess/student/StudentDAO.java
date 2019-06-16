package dk.projectsbygroup7.testproject.dataaccess.student;

import dk.projectsbygroup7.testproject.dataaccess.DBConnection;
import dk.projectsbygroup7.testproject.dataaccess.course.CourseResultReader;
import dk.projectsbygroup7.testproject.dataaccess.course.InsertCoursePreparator;
import dk.projectsbygroup7.testproject.pojos.Course;
import dk.projectsbygroup7.testproject.pojos.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class StudentDAO {

    @Autowired
    DBConnection dbConn;

    public int createNew (Student newStudent) {

        String sql = "" +
                "insert into student (name, email, birthday)\n" +
                "values (?,?,?); " +
                "select last_insert_id() as id;";

        return dbConn.doInsert(sql, new InsertStudentPreparator(newStudent));
    }

    public ArrayList<Student> getAll () {
        String sql = "" +
                "select id, name, email, birthday from student;";

        return dbConn.doSelectAll(sql, new StudentResultReader());
    }

    public Student getById (int id) {
        String sql = "" +
                "select id, name, email, birthday from student where id = ?;";

        return dbConn.doSelectById(sql, id, new StudentResultReader());
    }
}
