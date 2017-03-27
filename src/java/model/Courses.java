
package model;

public class Courses {
    
    private int courseID;
    private String courseName;
    private String courseSession;
    private String courseNo;
    
     public Courses() {
        this.courseID = 0;
        this.courseName = "";
        this.courseSession = "";
        this.courseNo = "";
        }
    
    public Courses(int courseID, String courseName, String courseSession, String courseNo) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseSession = courseSession;
        this.courseNo = courseNo;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(String courseSession) {
        this.courseSession = courseSession;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    @Override
    public String toString() {
        return "Courses{" + "courseID=" + courseID + ", courseName=" + courseName + ", courseSession=" + courseSession + ", courseNo=" + courseNo + '}';
    }
    
    
    
    
}
