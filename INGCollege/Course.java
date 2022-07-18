 

/**
 * Course class is the Base class from which other classes has been Derived.
 * Name:  Rohit Kumar Yadav
 * Group: N3;
 */

public class Course //Creating class 
{
    private String courseId;
    private String courseName;
    private String courseLeader;
    private int duration;

    public Course(String courseId, String courseName, int duration)
    {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        courseLeader = "";
    }

    //Accessors Method
    public String getCourseId() //Creating a CourseID getter method
    {
        return courseId;
    }

    public String getCourseName()   //
    {
        return courseName;
    }

    public int getduration()    //Creating a duration getter method
    {
        return duration;
    }

    public String getLeader()  //Creating a course getter method Leader
    {
        return courseLeader;
    }

    //Mutators Method
    public void setLeader(String courseLeader) 
    {
        this.courseLeader = courseLeader;
    }
    
    public String display()
    {
        String str = "";
        str = str + "\t##Course Details##:-\nCourseID is " + courseId+"\nCourseName is " + courseName;
        System.out.println("\t##Course Details##:-");
        System.out.println("CourseID is " + courseId);
        System.out.println("CourseName is " + courseName);

        if(!courseLeader.isEmpty()) {
            str = str + "\nCourseLeader is " + courseLeader;
            System.out.println("\nCourseLeader is " + courseLeader);
        }
        str = str + "\nDuration is " + duration;
        System.out.println("Duration is " + duration);
        return str;
    }

}