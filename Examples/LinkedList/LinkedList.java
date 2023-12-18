
public class LinkedList implements Container
{
   ListNode head, tail;
   
   public LinkedList()
   {
      makeEmpty();
   }
   public boolean isEmpty()
   {
      return (head == tail);
   }
   public void makeEmpty()
   {
      head = tail = new ListNode();
   }
   private class ListNode
   {
      private Object element;
      private ListNode next;
      
      private ListNode(Object e, ListNode n)
      {
         element = e;
         next = n;
      }
      private ListNode()
      {
         this(null, null);
      }
   }
}
