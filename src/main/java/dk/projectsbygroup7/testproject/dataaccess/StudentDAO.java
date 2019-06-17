package dk.projectsbygroup7.testproject.dataaccess;

import dk.projectsbygroup7.testproject.dataaccess.resultreaders.StudentResultReader;
import dk.projectsbygroup7.testproject.dataaccess.statementpreparators.StudentEnrollmentPreparator;
import dk.projectsbygroup7.testproject.dataaccess.statementpreparators.StudentGetByEmailPreparator;
import dk.projectsbygroup7.testproject.dataaccess.statementpreparators.StudentInsertPreparator;
import dk.projectsbygroup7.testproject.dataaccess.statementpreparators.StudentUpdatePreparator;
import dk.projectsbygroup7.testproject.pojos.Enrollment;
import dk.projectsbygroup7.testproject.pojos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentDAO {

    @Autowired
    DBConnection dbConn;

    public int createNew (Student newStudent) {

        String sql = "" +
                "insert into student (name, email, birthday)\n" +
                "values (?,?,?); " +
                "select last_insert_id() as id;";

        return dbConn.doInsert(sql, new StudentInsertPreparator(newStudent));
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

    public boolean update (Student newStudent) {

        String sql = "" +
                "update student " +
                "set name = ?, email = ?, birthday = ? " +
                "where id = ?; ";

        return dbConn.doUpdate(sql, new StudentUpdatePreparator(newStudent));
    }

    public ArrayList<Student> getByEmail (String email) {
        String sql = "" +
                "select id, name, email, birthday from student where email = ?;";

        return dbConn.doSelectByValue(
                sql,
                new StudentGetByEmailPreparator(email),
                new StudentResultReader()
        );
    }

    public int enrollToCourse (Enrollment enrollment) {

        String sql = "" +
                "insert into enrollment (student_id, course_id, payed) " +
                "values (?,?, true); " +
                "select last_insert_id() as id;";

        return dbConn.doInsert(sql, new StudentEnrollmentPreparator(
                enrollment.getStudent().getId(),
                enrollment.getCourse().getId())
        );
    }
}
