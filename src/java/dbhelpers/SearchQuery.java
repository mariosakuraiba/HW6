
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

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
    
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSearch(String courseName){
    
        try {
            String query = "SELECT * FROM courses WHERE UPPER(courseName) LIKE ? ORDER BY courseID ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + courseName.toUpperCase() +"%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    
    
    public String getHTMLtable(){
            String table = "";
            table += "<table>";
            
            table += "<tr>";
                
                table +="<th>";
                table += "ID";
                table +="</th>";

                table +="<th>";
                table += "Name";
                table +="</th>";
                
                table +="<th>";
                table += "Session";
                table +="</th>";
                
                table +="<th>";
                table += "Number";
                table +="</th>";
                
                table +="<th>";
                table += "";
                table +="</th>";
                        
                table += "</tr>";
                
        try {
            while (this.results.next()){
            
                Courses course = new Courses();
                course.setCourseID(this.results.getInt("courseID"));
                course.setCourseName(this.results.getString("courseName"));
                course.setCourseSession(this.results.getString("courseSession"));
                course.setCourseNo(this.results.getString("courseNo"));
                
                
                table += "<tr>";
                
                table += "<td>";
                table += course.getCourseID();
                table += "</td>";
                
                table += "<td>";
                table += course.getCourseName();
                table += "</td>";
                
                table += "<td>";
                table += course.getCourseSession();
                table += "</td>";
                
                table += "<td>";
                table += course.getCourseNo();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?courseID=" + course.getCourseID() +">Update </a>" + "<a href = delete?courseID=" + course.getCourseID() +"> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            table +="</table>";
            return table;
                   
        
        }
    
    }
    
    

