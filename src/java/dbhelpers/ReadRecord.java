
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Courses;

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Courses course = new Courses();
    private int courseID; 
    
    public ReadRecord (int courseID){
    
    Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.courseID = courseID;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    
    public void doRead(){

    
       
        PreparedStatement ps  = null;
        try {
            String query  = "SELECT * FROM courses WHERE courseID = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1,courseID);
            this.results = ps.executeQuery();
            this.results.next();
            course.setCourseID(this.results.getInt("courseID"));
            course.setCourseName(this.results.getString("courseName"));
            course.setCourseSession(this.results.getString("courseSession"));
            course.setCourseNo(this.results.getString("courseNo"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }
    
    public Courses getCourse(){
    
        return this.course;
    }
        
        

}
    

