package dk.projectsbygroup7.testproject.dataaccess;

import dk.projectsbygroup7.testproject.dataaccess.resultreaders.IResultReader;
import dk.projectsbygroup7.testproject.dataaccess.statementpreparators.IStatementPreparator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class DBConnection {
    @Value("${dbconnectionstring}")
    private String dbConString;

    private Connection getConn() {
        Connection conn = null;
        System.out.println(dbConString);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbConString);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void closeConn(ResultSet rs, PreparedStatement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { }

            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { }

            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException sqlEx) {
            }

            conn = null;
        }
    }

    private void printExceptionInfo(SQLException ex){
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }

    public int doInsert(String sql, IStatementPreparator preparator) {
        Connection conn = this.getConn();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt = preparator.prepare(stmt);
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();

            return generatedKeys.getInt(1);
        }
        catch (SQLException ex){
            this.printExceptionInfo(ex);
        }
        finally {
            this.closeConn(null,stmt,conn);
        }

        return 0;
    }

    public <T> ArrayList<T> doSelectAll(String sql, IResultReader<T> reader) {
        ArrayList resultList = new ArrayList();
        Connection conn = this.getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                resultList.add(reader.readResult(rs));
            }
        }
        catch (SQLException ex){
            this.printExceptionInfo(ex);
        }
        finally {
            this.closeConn(rs,stmt,conn);
        }

        return resultList;
    }

    public <T> T doSelectById(String sql, int id, IResultReader<T> reader) {
        Connection conn = this.getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return reader.readResult(rs);
            }
        }
        catch (SQLException ex){
            this.printExceptionInfo(ex);
        }
        finally {
            this.closeConn(rs,stmt,conn);
        }

        return null;
    }

    public <T> ArrayList<T> doSelectByValue(
            String sql,
            IStatementPreparator preparator,
            IResultReader<T> reader
    ) {
        ArrayList resultList = new ArrayList();
        Connection conn = this.getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt = preparator.prepare(stmt);
            rs = stmt.executeQuery();
            while (rs.next()) {
                resultList.add(reader.readResult(rs));
            }
        }
        catch (SQLException ex){
            this.printExceptionInfo(ex);
        }
        finally {
            this.closeConn(rs,stmt,conn);
        }

        return resultList;
    }

    public boolean doUpdate(String sql, IStatementPreparator preparator) {
        Connection conn = this.getConn();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt = preparator.prepare(stmt);
            stmt.executeUpdate();
            return true;
        }
        catch (SQLException ex){
            this.printExceptionInfo(ex);
        }
        finally {
            this.closeConn(null,stmt,conn);
        }
        return false;
    }
}
