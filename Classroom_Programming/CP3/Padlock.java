/** The padlock state may be opened or closed. If it is opened, it can be closed, if it is closed it can be opened by using the correct combination.
The combination (key) is an alphanumeric string with a length greater than zero
*/

public class Padlock
{
   // Init public constants
   final public static String INITIAL_KEY = "0000";
   final public static String STATE_OPEN = "open";
   final public static String STATE_CLOSED = "closed";
   final public static String INITIAL_STATE = STATE_OPEN;
   
   // Init private variables
   private String key;
   private String state;
   
   /** Initializes this padlock with the state open and the specified combination
         If the combination is null or is the empty string, it sets the combination to "0000"
   */
   public Padlock(String aKey)
   {
      if (aKey == null || aKey.length() == 0)
      {
         key = INITIAL_KEY;
      }
      else
      {
         key = aKey;
      }
      state = INITIAL_STATE;
   }

   public Padlock()
   {
      this(INITIAL_KEY);
   }
   
   
   /** opens this padlock, if it is closed and the specified combination matches the current padlock combination
   */
   public void open​(String aKey)
   {
      if (aKey.equals(key) && state == STATE_CLOSED)
      {
         state = STATE_OPEN;
      }
   }
   
   /** closes this padlock, if it is open
   */
   public void close()
   {
      if (state == STATE_OPEN)
      {
         state = STATE_CLOSED;
      }
   }
   
   /** sets the specified new combination as combination of this padlock, 
         if the specified old combination matches the padlock's combination and 
         the new combination is not null or the empty string
   */
   public void setCombination​(String oldKey, String newKey)
   {
      if (oldKey.equals(key))
      {
         key = newKey;
      }
   }
   
   /** textual description of this padlock in the format
         "Padlock is state, combination is key" where state and key are
         respectively the current state (either open or closed) and combination of this Padlock
   */
   public String toString()
   {
      return "Padlock is " + state + ", combination is " + key;
   }
}
