 
/**
 * Sub class NonAcademicCourse dervied from class Course.
 * Name: Rohit Kumar ydav
 * Group: N3;
 */

public class NonAcademicCourse extends Course //Creating class having extends
{
    private String instructorName;
    private String startingDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered, isRemoved;

    public NonAcademicCourse(String courseId, String courseName, int duration, String prerequisite)
    {
        super(courseId,courseName,duration); // parent class constructor

        this.prerequisite = prerequisite;
        this.instructorName = "";
        this.startingDate = "";
        this.completionDate = "";
        this.examDate = "";
        this.isRegistered = false;
        this.isRemoved = false;
    }

    //Accessors Method
    public String getInstructorName()   //Creating getter method for instructorName
    {
        return instructorName;
    }

    public String getStartingDate() //Creating getter method for startingDate
    {
        return startingDate;
    }

    public String getCompletionDate()  //Creating getter method for completionDate
    {
        return completionDate;
    }

    public String getExamDate() //Creating getter method for  examDate
    {
        return examDate;
    }

    public String getPrerequisite() //Creating getter method for  prerequisite
    {
        return prerequisite;
    }

    public boolean getIsRegistered()    //Allow user to access private isRegistered
    {
        return isRegistered;
    }

    public boolean getIsRemoved()   //Allow user to access private isRemoved
    {
        return isRemoved;
    }

    //Mutators Method
    public void setInstructorName(String instructorName) //Creating setter method for InstructorName
    {
        if(isRegistered == false) {
            this.instructorName = instructorName;
        }

        else {
            System.out.println("This course is registered therefore Instructor Name can't be updated");
        }
    }

    public void registerCourse(String courseLeader, String instructorName, String startingDate, String completionDate, String examDate)
    {
        if(isRegistered == false) {
            super.setLeader(courseLeader);

            setInstructorName(instructorName);
            this.startingDate = startingDate;
            this.completionDate = completionDate;
            this.examDate = examDate;
            isRegistered = true;
        }

        else {
            System.out.println("This course has been Registered!");
        }
    }

    public void removeCourse()
    {
        if(isRemoved == true) {
            System.out.println("This course has been removed!");
        }

        else {
            super.setLeader("");
            
            instructorName = "";
            startingDate = "";
            completionDate = "";
            examDate = "";
            isRegistered = false;
            isRemoved = true;
        }
    }

    public String display()
    {
        String str = "";
        if(isRegistered == true) {
            str = str + super.display();
            str = str + "\nInstructor Name is " + instructorName+"\nStarting Date is " + startingDate+"\nCompletion Date is " + completionDate+"\nExamination Date is " + examDate;
            System.out.println("Instructor Name is " + instructorName);
            System.out.println("Starting Date is " + startingDate);
            System.out.println("Completion Date is " + completionDate);
            System.out.println("Examination Date is " + examDate);
        }
        
        else {
            str = str + super.display();
        }
        return str;
    }
}
