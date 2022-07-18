 
/**
 * Name : Rohit Kumar Yadav
 * Group: N3;
 */

public class AcademicCourse extends Course  //creating class having e
{
    private String lecturerName; 
    private String level;
    private String credit;
    private String startingDate;
    private String completionDate;
    private int numberOfAssessments;
    private boolean isRegistered;
    
    public AcademicCourse(String courseId, String courseName, int duration, String level, String credit, int numberOfAssessments)
    {
        super(courseId, courseName, duration);

        this.level = level;
        this.credit = credit;
        this.numberOfAssessments = numberOfAssessments;
        this.lecturerName = "";
        this.startingDate = "";
        this.completionDate = "";
        this.isRegistered = false;
    }
    
    //Accessors Method
    public String getLecturerName() //Allow user access to lecturerName's confidential information.
    {
        return lecturerName;
    }

    public String getLevel()    //Allow user to access private level
    {
        return level;
    }

    public String getCredit()   //Allow user to access private credit
    {
        return credit;
    }

    public String getStartingDate() //Allow user to access private startingDate
    {
        return startingDate;
    }

    public String getCompletionDate()   //Allow user to access private completionDate
    {
        return completionDate;
    }

    public int getNumberOfAssessments() //Allow user to access private numberOfAssessments
    {
        return numberOfAssessments;
    }
        
    public boolean getIsRegistered()    //Allow user to access private isRegistered
    {
        return isRegistered;
    }

    //Mutators Method
    public void setLecturerName(String lecturerName)
    {
        this.lecturerName = lecturerName;
    }

    public void setNumberOfAssessments(int numberOfAssessments)
    {
        this.numberOfAssessments = numberOfAssessments;
    }
    
    public void registerCourse(String courseLeader, String lecturerName, String startingDate, String completionDate)
    {
        if(isRegistered == false) {
            super.setLeader(courseLeader);
            this.lecturerName = lecturerName;
            this.startingDate = startingDate;
            this.completionDate = completionDate;
            isRegistered = true;
            
        }

        else {
            System.out.println("This course is being registerd to " +lecturerName + " to complete within " + startingDate + " to " + completionDate);
        }
    }

    public String display()
    {
        String str = "";
        if(isRegistered == true) {
            str = str + super.display();
            str = str + "\nLecturer Name is " + lecturerName+"\nLevel is " + level+"\ncredit is " + credit+"\nStarting Date is " + startingDate+"\nCompletion Date is " + completionDate;
            System.out.println("Lecturer Name is " + lecturerName);
            System.out.println("Level is " + level);
            System.out.println("Credit is " + credit);
            System.out.println("Starting Date is " + startingDate);
            System.out.println("Completion Date is" + completionDate);
        }

        else {
            str = str + super.display();
        }
        return str;
    }

}
