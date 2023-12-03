/**
 * Write a description of class StudentArchive here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.IllegalArgumentException;

public class StudentArchive
{
    // instance variables - replace the example below with your own
    private Student[] students = new Student[1];
    private int nextStudentId = 0;
    
    /**
     * Constructor for objects of class StudentArchive
     */
    public StudentArchive()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void add(Student aStudent)
    {
        if (nextStudentId >= students.length)
        {
            Student[] tmp = new Student[students.length * 2];
            System.arraycopy(students, 0, tmp, 0, students.length);
            students = tmp;
        }
        students[nextStudentId++] = aStudent;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isEmpty()
    {
        return nextStudentId == 0;
    }
    
    public StudentArchive getExcellentStudents(int grade)
    {
        StudentArchive excellentStudents = new StudentArchive();
        for (Student eS : students)
        {
            if (eS.getExamAverageGrade() >= grade)
            {
                excellentStudents.add(eS);
            }
        }
        return excellentStudents;
    }
    
    public Student remove()
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("Archive is empty!");
        }
        Student removed = students[0];
        for (int i = 0; i < nextStudentId - 1; i++)
        {
            students[i] = students[i + 1];
        }
        nextStudentId--;
        return removed;
    }
    
    public String toString()
    {
        String strStudents = "";
        for (int i = 0; i < nextStudentId; i++)
        {
            strStudents += students[i].toString() + "\n";
        }
        return strStudents;
    }
}
