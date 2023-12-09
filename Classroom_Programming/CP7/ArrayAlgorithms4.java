import java.util.Comparator;
/**
  * Collects sorting and search algorithms applicable to arrays of Object
  *
  * @version 8-Nov-2021
  * @author Horstmann
  *
*/
public class ArrayAlgorithms4
{
   /**
      Selection sort - sorts the specified array - asymptotic time complexity O(n*n).
      @param a the specified array
   */
   public static void selectionSort(Comparable[] a)
   {  
      for (int i = 0; i < a.length - 1; i++)
      {
         int minPos = findMinPos(a, i);
         if (minPos != i) swap(a, minPos, i);
      }
   }

   /*
      Swaps the elements with the specified indexes in the specified array
      param a the specified array
      param i the first specified index
      param j the second specified index
   */
   private static void swap(Object[] a, int i, int j)
   {
      Object tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
   }

   /*
      Returns the index of the minimum element in the specified sub-array
      starting from the specified index from to the end of the array
      param a the specified array
      param from the specified index
      return index of the minimum element
   */
   private static int findMinPos(Comparable[] a, int from)
   {
      int pos = from;
      Comparable min = a[from];
      
      for (int i = from + 1; i < a.length; i++)
      {    
         if (a[i].compareTo(min) < 0)  
         {
            pos = i;                  
            min = a[i];               
         }
      }

      return pos;
   }
   
   /**
      mergesort - sorts the specified array of Comparables - asymptotic time
      complexity O(n*log n)
      @param v the specified array
   */
   public static void mergeSort(Comparable[] v)
   {
      // base case
      if (v.length < 2) return;

      // copying the full array into arrays of approximately half size
      int mid = v.length / 2;               // approximately half size
      Comparable[] left = new Comparable[mid];
      Comparable[] right = new Comparable[v.length - mid];
      System.arraycopy(v, 0, left, 0, left.length);
      System.arraycopy(v, mid, right, 0, right.length);

      // recursive steps
      mergeSort(left);
      mergeSort(right);

      // merging
      merge(v, left, right);
   }

   /*
      merging the two specified sorted sub-arrays into the specified array
      param a the specified array
      param b the specified first sub-array
      param c the specified second sub-array
   */
   private static void merge(Comparable[] a, Comparable[] b, Comparable[] c)
   {
      // indexes to scan the array
      int ia = 0, ib = 0, ic = 0;

      // until both half size arrays b and c have elements
      while (ib < b.length && ic < c.length)
      {
         if (b[ib].compareTo(c[ic]) < 0)
         {
            a[ia++] = b[ib++];
         }
         else
         {
            a[ia++] = c[ic++];
         }
      }
      
      // add any remaining elements from array b
      while (ib < b.length)
      {
         a[ia++] = b[ib++];
      }
      
      // add any remaining elements from array c
      while (ic < c.length)
      {
         a[ia++] = c[ic++];
      }      
   }


   /**
      insertion sort - sorts the specified array of Comparables asymptotic time
      complexity O(n) in the best case, O(n*n) in the average and worst cases
      @param a the specified array
   */
   public static void insertionSort(Comparable[] a)
   {
      // the loop starts at the index 1 because the first element requires no
      // attention
      for (int i = 1; i < a.length; i++)
      {
        // current element to insert
         Comparable cur = a[i];

         // loop to move elements
         int j = i - 1;
         while (j >= 0 && cur.compareTo(a[j]) < 0)
         {
            a[j + 1] = a[j];
            j--;
         }
         
         // inserting into the sorted array
         a[j + 1] = cur;
      }
   }
   
   /**
      linear search for the specified Comparable in the specified array - O(n).
      @param a the specified array
      @param target the specified Comparable
      @return the index in the array of the first occurrence of the specified
              Comparable or - 1 if the specified Comparable is not in the array
   */
   public static int linearSearch(Comparable[] a, Comparable target)
   {
      for (int i = 0; i < a.length; i++)
         if (a[i].compareTo(target) == 0)
            return i; // FOUND

      return -1;      // NOT FOUND
   }
   
   /**
      sentinel linear search for the specified Comparable in the specified array
      - O(n).
      @param a the specified array
      @param size the number of elements in the array
      @param target the specified Comparable
      @return the index in the array of the first occurrence of the specified
              Comparable or - 1 if the specified Comparable is not in the array
   */
   public static int guardedLinearSearch(Comparable[] a, int size, Comparable target)
   {
      a[size] = target;
      int i = 0;
      while (a[i].compareTo(target) != 0)
         i++;
         
      if (i != size)
         return i;     // FOUND

      return -1;       // NOT FOUND
   }
   

   /**
      binary search for the specified element in the specified array
      @param a the specified array
      @param target the specified element
      @return the index in the array of the first occurrence of the specified
              Comparable or - 1 if the specified Comparable is not in the array      
   */
   public static int recursiveBinarySearch(Comparable[] a, Comparable target)
   {
      return binSearch(a, 0, a.length - 1, target);
   }

   /*
   
      param a the specified array
      param from the specified start index
      param to the specified end index
      param t the specified element
      return the index in the array of the first occurrence of the specified
              Comparable or - 1 if the specified Comparable is not in the array        
   */
   private static int binSearch(Comparable[] a, int from, int to, Comparable t)
   {
      if (from > to)
         return -1;                 // NOT FOUND

      int mid = (from + to) / 2;    // ABOUT IN THE MIDDLE
      Comparable middle = a[mid];

      if (middle.compareTo(t) == 0)
         return mid;                // FOUND
         
      else if (middle.compareTo(t) < 0)
         return binSearch(a, mid + 1, to, t);   // SEARCH ON THE RIGHT
      else
         return binSearch(a, from, mid - 1, t); // SEARCH ON THE LEFT
   }
   
   /**
      binary search for the specified element in the specified array
      @param a the specified array
      @param target the specified element
      @return the index in the array of the first occurrence of the specified
              Comparable or - 1 if the specified Comparable is not in the array      
   */
   public static int iterativeBinarySearch(Comparable[] a, int target)
   {
      int from = 0;                   // Start index
      int to = a.length - 1;          // End index

      // as long as the sub-array has at least one element
      while(from <= to)
      {
         int mid = (from + to)/2;     // ABOUT IN THE MIDDLE
         Comparable middle = a[mid];

         if (middle.compareTo(target) == 0)
            return mid;               // FOUND
         else if (middle.compareTo(target) < 0)
            from = mid + 1;           // SEARCH ON THE RIGHT
         else
            to = mid - 1;             // SEARCH ON THE LEFT
      }

      return -1; // NOT FOUND
   }  
   /***************************************************************************/

   /*** Algorithm version using Object instead of Comparable  ***/
   
   /**
      selection sort - sorts the specified array - asymptotic time complexity O(n*n).
      @param a the specified array
   */
   public static void selectionSort(Object[] a)
   {  
      for (int i = 0; i < a.length - 1; i++)
      {
         int minPos = findMinPos(a, i);
         if (minPos != i) swap(a, minPos, i);
      }
   }

   /*
      provides the index of the minimum element in the specified array sub-array
      starting from the specified index from to the end of the array
      param a the specified array
      param from the specified index
      return index of the minimum element
   */
   private static int findMinPos(Object[] a, int from)
   {
      int pos = from;
      Object min = a[from];
      
      for (int i = from + 1; i < a.length; i++)
      {    
         if (((Comparable)a[i]).compareTo(min) < 0)  
         {
            pos = i;                  
            min = a[i];               
         }
      }

      return pos;
   }
   
   /**
      mergesort - sorts the specified array of Objects - asymptotic time
      complexity O(n*log n)
      @param v the specified array
   */
   public static void mergeSort(Object[] v)
   {
      // base case
      if (v.length < 2) return;

      // copying the array into sub-arrays of about equal size
      int mid = v.length / 2;
      Object[] left = new Object[mid];
      Object[] right = new Object[v.length - mid];
      System.arraycopy(v, 0, left, 0, left.length);
      System.arraycopy(v, mid, right, 0, right.length);

      // recursive steps
      mergeSort(left);
      mergeSort(right);

      // merging
      merge(v, left, right);
   }

   /*
      merging the two specified sorted sub-arrays into the specified array
      param a the specified array
      param b the specified first sub-array
      param c the specified second sub-array
   */
   private static void merge(Object[] a, Object[] b, Object[] c)
   {
      // indexes to scan the array
      int ia = 0, ib = 0, ic = 0;

      // as long as both sub-arrays b and c have elements
      while (ib < b.length && ic < c.length)
      {
         if (((Comparable)b[ib]).compareTo(c[ic]) < 0)
         {
            a[ia++] = b[ib++];
         }
         else
         {
            a[ia++] = c[ic++];
         }
      }
      
      // add any remaining elements from array b
      while (ib < b.length)
      {
         a[ia++] = b[ib++];
      }
      
      // add any remaining elements from array c
      while (ic < c.length)
      {
         a[ia++] = c[ic++];
      }       
   }

   /**
      insertion sort - sorts the specified array of Objects asymptotic time
      complexity O(n) in the best case, O(n*n) in the average and worst cases
      @param a the specified array
   */
   public static void insertionSort(Object[] a)
   {
      // the loop starts at the index 1 because the first element requires no
      // attention
      for (int i = 1; i < a.length; i++)
      {
        // current element to insert
         Comparable cur = (Comparable)a[i];

         // loop to move Objects
         int j = i - 1;
         while (j >= 0 && cur.compareTo(a[j]) < 0)
         {
            a[j + 1] = a[j];
            j--;
         }
         
         // inserting into the sorted array
         a[j + 1] = cur;
      }
   }
   
   /**
      linear search for the specified Object in the specified array - O(n).
      @param a the specified array
      @param target the specified Object
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array
   */
   public static int linearSearch(Object[] a, Object target)
   {
      for (int i = 0; i < a.length; i++)
         if (((Comparable)a[i]).compareTo(target) == 0)
            return i; // FOUND

      return -1;      // NOT FOUND
   }
   
   /**
      sentinel linear search for the specified Object in the specified array
      - O(n).
      @param a the specified array
      @param size the number of elements in the array
      @param target the specified Object
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array
   */
   public static int guardedLinearSearch(Object[] a, int size, Object target)
   {
      a[size] = target;
      int i = 0;
      while (((Comparable)a[i]).compareTo(target) != 0)
         i++;
         
      if (i != size)
         return i;     // FOUND

      return -1;       // NOT FOUND
   }
   

   /**
      binary search for the specified element in the specified array
      @param a the specified array
      @param target the specified element
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array      
   */
   public static int recursiveBinarySearch(Object[] a, Object target)
   {
      return binSearch(a, 0, a.length - 1, target);
   }

   /*  
      param a the specified array
      param from the specified start index
      param to the specified end index
      param t the specified element
      return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array        
   */
   private static int binSearch(Object[] a, int from, int to, Object t)
   {
      if (from > to)
         return -1;                 // NOT FOUND

      int mid = (from + to) / 2;    // ABOUT IN THE MIDDLE
      Comparable middle = (Comparable)a[mid];

      if (middle.compareTo(t) == 0)
         return mid;                // FOUND
         
      else if (middle.compareTo(t) < 0)
         return binSearch(a, mid + 1, to, t);   // SEARCH ON THE RIGHT
      else
         return binSearch(a, from, mid - 1, t); // SEARCH ON THE LEFT
   }
   
   /**
      binary search for the specified element in the specified array
      @param a the specified array
      @param target the specified element
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array      
   */
   public static int iterativeBinarySearch(Object[] a, int target)
   {
      int from = 0;                   // Start index
      int to = a.length - 1;          // End index

      // as long as the sub-array has at least one element
      while(from <= to)
      {
         int mid = (from + to)/2;     // ABOUT IN THE MIDDLE
         Comparable middle = (Comparable)a[mid];

         if (middle.compareTo(target) == 0)
            return mid;               // FOUND
         else if (middle.compareTo(target) < 0)
            from = mid + 1;           // SEARCH ON THE RIGHT
         else
            to = mid - 1;             // SEARCH ON THE LEFT
      }

      return -1; // NOT FOUND
   } 
   
      /***************************************************************************/

   /*** Algorithm version using interface Comparator instead of Comparable  ***/
   
   /**
      selection sort - sorts the specified array using the specified comparator
      - asymptotic time complexity O(n*n).
      @param a the specified array
      @param cmp the specified comparator
   */
   public static void selectionSort(Object[] a, Comparator cmp)
   {  
      for (int i = 0; i < a.length - 1; i++)
      {
         int minPos = findMinPos(a, i, cmp);
         if (minPos != i) swap(a, minPos, i);
      }
   }

   /*
      provides the index of the minimum element in the specified array sub-array
      starting from the specified index from to the end of the array
      param a the specified array
      param from the specified index
      param c the specified comparator
      return index of the minimum element
   */
   private static int findMinPos(Object[] a, int from, Comparator cpr)
   {
      int pos = from;
      Object min = a[from];
      
      for (int i = from + 1; i < a.length; i++)
      {    
         if (cpr.compare(a[i], min) < 0)  
         {
            pos = i;                  
            min = a[i];               
         }
      }

      return pos;
   }
   
   /**
      mergesort - sorts the specified array using the specified comparator
      - asymptotic time complexity O(n*log n)
      @param v the specified array
      @param cmp the specified comparator
   */
   public static void mergeSort(Object[] v, Comparator cmp)
   {
      // base case
      if (v.length < 2) return;

      // copying the array into sub-arrays of about equal size
      int mid = v.length / 2;
      Object[] left = new Object[mid];
      Object[] right = new Object[v.length - mid];
      System.arraycopy(v, 0, left, 0, left.length);
      System.arraycopy(v, mid, right, 0, right.length);

      // recursive steps
      mergeSort(left);
      mergeSort(right);

      // merging
      merge(v, left, right);
   }

   /*
      merging the two specified sorted sub-arrays into the specified array
      param a the specified array
      param b the specified first sub-array
      param c the specified second sub-array
   */
   private static void merge(Object[] a, Object[] b, Object[] c, Comparator cpr)
   {
      // indexes to scan the array
      int ia = 0, ib = 0, ic = 0;

      // as long as both sub-arrays b and c have elements
      while (ib < b.length && ic < c.length)
      {
         if (cpr.compare(b[ib], c[ic]) < 0)
         {
            a[ia++] = b[ib++];
         }
         else
         {
            a[ia++] = c[ic++];
         }
      }
      
      // add any remaining elements from array b
      while (ib < b.length)
      {
         a[ia++] = b[ib++];
      }
      
      // add any remaining elements from array c
      while (ic < c.length)
      {
         a[ia++] = c[ic++];
      }       
   }

   /**
      insertion sort - sorts the specified array using the specified comparator
      asymptotic time
      complexity O(n) in the best case, O(n*n) in the average and worst cases
      @param a the specified array
      @param cmp the specified comparator
   */
   public static void insertionSort(Object[] a, Comparator cmp)
   {
      // the loop starts at the index 1 because the first element requires no
      // attention
      for (int i = 1; i < a.length; i++)
      {
        // current element to insert
         Object cur = a[i];

         // loop to move Objects
         int j = i - 1;
         while (j >= 0 && cmp.compare(cur, a[j]) < 0)
         {
            a[j + 1] = a[j];
            j--;
         }
         
         // inserting into the sorted array
         a[j + 1] = cur;
      }
   }
   
   /**
      linear search for the specified Object in the specified array - O(n).
      @param a the specified array
      @param target the specified Object to search
      @param cmp the specified comparator
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array
   */
   public static int linearSearch(Object[] a, Object target, Comparator cmp)
   {
      for (int i = 0; i < a.length; i++)
         if (cmp.compare(a[i], target) == 0)
            return i; // FOUND

      return -1;      // NOT FOUND
   }
   
   /**
      sentinel linear search for the specified Object in the specified array
      - O(n).
      @param a the specified array
      @param size the number of elements in the array
      @param target the specified Object
      @param cmp the specified comparator
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array
   */
   public static int guardedLinearSearch(Object[] a, int size, Object target, Comparator cmp)
   {
      a[size] = target;
      int i = 0;
      while (cmp.compare(a[i], target) != 0)
         i++;
         
      if (i != size)
         return i;     // FOUND

      return -1;       // NOT FOUND
   }
   

   /**
      binary search for the specified element in the specified array
      @param a the specified array
      @param target the specified element
      @param cmp the specified comparator
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array      
   */
   public static int recursiveBinarySearch(Object[] a, Object target, Comparator cmp)
   {
      return binSearch(a, 0, a.length - 1, target, cmp);
   }

   /*
   
      param a the specified array
      param from the specified start index
      param to the specified end index
      param t the specified element
      @param cpr the specified comparator
      return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array        
   */
   private static int binSearch(Object[] a, int from, int to, Object t, Comparator cpr)
   {
      if (from > to)
         return -1;                 // NOT FOUND

      int mid = (from + to) / 2;    // ABOUT IN THE MIDDLE
      Object middle = a[mid];

      if (cpr.compare(middle, t) == 0)
         return mid;                // FOUND
         
      else if (cpr.compare(middle, t) < 0)
         return binSearch(a, mid + 1, to, t, cpr);   // SEARCH ON THE RIGHT
      else
         return binSearch(a, from, mid - 1, t, cpr); // SEARCH ON THE LEFT
   }
   
   /**
      binary search for the specified element in the specified array
      @param a the specified array
      @param target the specified element
      @param cmp the specified comparator
      @return the index in the array of the first occurrence of the specified
              Object or - 1 if the specified Object is not in the array      
   */
   public static int iterativeBinarySearch(Object[] a, int target, Comparator cmp)
   {
      int from = 0;                   // Start index
      int to = a.length - 1;          // End index

      // as long as the sub-array has at least one element
      while(from <= to)
      {
         int mid = (from + to)/2;     // ABOUT IN THE MIDDLE
         Object middle = a[mid];

         if (cmp.compare(middle, target) == 0)
            return mid;               // FOUND
         else if (cmp.compare(middle, target) < 0)
            from = mid + 1;           // SEARCH ON THE RIGHT
         else
            to = mid - 1;             // SEARCH ON THE LEFT
      }

      return -1; // NOT FOUND
   }  
}

