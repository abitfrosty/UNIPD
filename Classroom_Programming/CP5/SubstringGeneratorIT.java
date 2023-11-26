
/**
 * This program prints on standard output the substrings of a given string passed as an argument from command line.

    Execution example:
    $java SubstringGeneratorIT givenString
    where givenString is the string to generate the substrings.
    Substrings generation examples:
    The set of substrings of string "abcd" is {a b c d ab bc cd abc bcd abcd}
    
    Notes:
    the string abcd itself is a substring of abcd
    the empty string ""  is a substring of the given string, but it is not printable, so let’s not consider it.
    
    Code in the class the iterative method
    
    public static String[] substringsIT(String s)
    
    that receives as an explicit argument the string on which the substring set is generated and
    then returns an array containing the substrings of s.
    
    Let the array dimension be equal to the number of the substrings (filled array)
 *
 * @author (Igor Semenov)
 * @version (20231125)
 */
import java.lang.IllegalArgumentException;

public class SubstringGeneratorIT
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class SubstringGeneratorIT
     */
    public SubstringGeneratorIT()
    {
        // initialise instance variables
    }
    
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            throw new IllegalArgumentException("Please provide a string as an argument");
        }
        
        String s = args[0];
        String[] sub_ss = substringsIT(s);
        
        for (String e : sub_ss)
        {
            System.out.printf("%s%n", e);
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static String[] substringsIT(String s)
    {
        String[] sub_ss = new String[1];
        
        int idx = 0;
        
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < s.length(); j++)
            {
                if (i >= s.length() - j)
                {
                   continue;
                }
                //System.out.printf("i: %d, j: %d, substring: %s%n", i, j, s.substring(i, s.length() - j));
                
                if (idx > sub_ss.length - 1)
                {
                   String[] tmp = new String[sub_ss.length * 2];
                   System.arraycopy(sub_ss, 0, tmp, 0, idx);
                   sub_ss = tmp;
                }
                sub_ss[idx++] = s.substring(i, s.length() - j);
            }
        }
        idx--; // Index of next element, next element is always null
        if (idx < sub_ss.length - 1)
        {
            String[] tmp = new String[idx];
            System.arraycopy(sub_ss, 0, tmp, 0, idx);
            sub_ss = tmp;
        }
        return sub_ss;
    }
}
