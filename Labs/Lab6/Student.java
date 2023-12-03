
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.lang.IllegalArgumentException;

public class Student
{
    // instance variables - replace the example below with your own
    private int rollNo;
    private String name;
    private Exam[] exams = new Exam[1];
    private int nextExamId = 0;

    /**
     * Constructor for objects of class Student
     */
    public Student(String aName, int aRollNo)
    {
        if (aName == null || aRollNo < 1)
        {
            throw new IllegalArgumentException("Please provide student\'s name and roll number!");
        }
        // initialise instance variables
        name = aName;
        rollNo = aRollNo;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void addExam(String aName, int aGrade)
    {
        // put your code here
        if (aName == null)
        {
            throw new IllegalArgumentException("Please provide exam\'s name and grade!");
        }
        if (nextExamId >= exams.length)
        {
            Exam[] tmp = new Exam[exams.length * 2];
            System.arraycopy(exams, 0, tmp, 0, exams.length);
            exams = tmp;
        }
        exams[nextExamId++] = new Exam(aName, aGrade);
    }
    
    public boolean isEmpty()
    {
        return nextExamId == 0;
    }
    
    public double getExamAverageGrade()
    {
        if (isEmpty())
        {
            return 0;
        }
        double sum = 0.0;
        for (int i = 0; i < nextExamId; i++)
        {
            sum += exams[i].getGrade();
        }
        return sum / getExamNumber();
    }
    
    public int getExamNumber()
    {
        return nextExamId;
    }
    
    public String toString()
    {
        String listOfExams = "  ";
        for (int i = 0; i < getExamNumber(); i++)
        {
            listOfExams += i + ") " + exams[i] + "\n  ";
        }
        return "rollNo: " + rollNo + ", name: " + name
        + "\nno. " + getExamNumber() + " taken\n"
        + listOfExams + "average grade: " + getExamAverageGrade();
    }
}
