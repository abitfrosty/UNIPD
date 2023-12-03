import java.util.Scanner;

/**
 * The test class StudentArchiveTester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentArchiveTester
{
    /**
     * Default constructor for test class StudentArchiveTester
     */
    public StudentArchiveTester()
    {
        
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        StudentArchive facebook = new StudentArchive();
        while (in.hasNextLine())
        {
            String line = in.nextLine();
            if (line.equals('\n'))
            {
                break;
            }
            else if (line.charAt(0) == '*')
            {
                continue;
            }
            Scanner inLine = new Scanner(line);
            inLine.useDelimiter(" */ *");
            String studentName = "";
            int studentRollNo = 0;
            Student student = null;
            for (int i = 0; inLine.hasNext(); i++)
            {
                String token = inLine.next();
                if (i == 0)
                {
                    studentName = token;
                    System.out.println("Now parsing studentName: " + studentName);
                }
                else if (i == 1)
                {
                    studentRollNo = Integer.parseInt(token);
                    System.out.println("Now parsing studentRollNo: " + studentRollNo);
                }
                else
                {
                    if (student == null)
                    {
                        student = new Student(studentName, studentRollNo);
                        System.out.println("Student created.");
                    }
                    String examName = token.substring(0, token.length() - 2);
                    int examGrade = Integer.parseInt(token.substring(token.length() - 2, token.length()));
                    student.addExam(examName, examGrade);
                    System.out.println("Now parsing examName: " + examName);
                    System.out.println("Now parsing examGrade: " + examGrade);
                    System.out.println("Exam added.");
                }
            }
            if (student != null)
            {
                facebook.add(student);
                System.out.println("Student added to archive.");
            }
            inLine.close();
        }
        in.close();
        System.out.println(facebook.toString());
    }
}


