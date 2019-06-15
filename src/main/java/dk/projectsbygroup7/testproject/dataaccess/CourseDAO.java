package dk.projectsbygroup7.testproject.dataaccess;

import dk.projectsbygroup7.testproject.pojos.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class CourseDAO {

    @Autowired
    DBConnHandler connHandler;

    public int createCourse(Course newCourse) {

        Connection conn = connHandler.getConn();

        String sql = "" +
                "insert into course (subject, hours, startDate, endDate)\n" +
                "values (?,?,?,?); " +
                "select last_insert_id() as id;";
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, newCourse.getSubject().getName());
            stmt.setInt(2, newCourse.getHours());
            Date startDate = Date.valueOf(newCourse.getStartDate());
            stmt.setDate(3, startDate);
            Date endDate = Date.valueOf(newCourse.getEndDate());
            stmt.setDate(4, endDate);

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Couldn't retrieve " + Course.class.getSimpleName() + " ID.");
                }
            }
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            connHandler.closeConn(rs,stmt,conn);
        }
        return 0;
    }
}
