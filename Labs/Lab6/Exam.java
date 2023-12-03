
/**
 * Write a description of class Exam here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exam
{
    // instance variables - replace the example below with your own
    private String name;
    private int grade;
    
    /**
     * Constructor for objects of class Exam
     */
    public Exam(String aName, int aGrade)
    {
        if (aName == null)
        {
            throw new IllegalArgumentException("Please provide exam\'s name and grade!");
        }
        // initialise instance variables
        name = aName;
        grade = aGrade;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getGrade()
    {
        // put your code here
        return grade;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        // put your code here
        return name + ": " + grade;
    }
}
