public class ListNodeTester
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode();
      ListNode ln_a = new ListNode();
      ListNode ln_b = new ListNode();
      
      head.setNext(ln_a);
      ln_a.setNext(ln_b);
      ln_a.setElement("Hello");
      ln_b.setElement("Train");
      
      System.out.println("NodeList head: " + head);
      System.out.println("NodeList ln_a: " + ln_a);
      System.out.println("NodeList ln_b: " + ln_b);
      System.out.println("head.getElement(): " + head.getElement());
      System.out.println("ln_a.getElement(): " + ln_a.getElement());
      System.out.println("ln_b.getElement(): " + ln_b.getElement());
      System.out.println("head.getNext(): " + head.getNext());
      System.out.println("ln_a.getNext(): " + ln_a.getNext());
      System.out.println("ln_b.getNext(): " + ln_b.getNext());
   }
}
