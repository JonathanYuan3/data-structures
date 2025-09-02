import java.util.LinkedList;
import java.util.ListIterator;

public class Business
{
    /**
      * Removes every nth element from the linked list
      *
      * @param employeeNames the linked list to remove from
      * @param n                 the parameter to determine "nth"
     */
    public static void downsize(LinkedList<String> employeeNames, int n){
        if(n <= 0){
            System.out.println("n cannot be less than 1.");
        }
        
        ListIterator<String> iterator = employeeNames.listIterator();
        int position = 0;
        
        while(iterator.hasNext()){
            iterator.next();
            position++;
            
            if(position % n == 0){
                iterator.remove();
            }
        }  
    }
}
