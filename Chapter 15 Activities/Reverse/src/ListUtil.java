import java.util.LinkedList;
import java.util.ListIterator;
 
/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        LinkedList<String> temp = new LinkedList<>();
        while (iterator.hasNext()){ 
            temp.addFirst(iterator.next());
        }
        //The method returns the linked list <strings">, so you need to move the objects in <temp> to <strings>.
        strings.clear();
        strings.addAll(temp);
    }
}
