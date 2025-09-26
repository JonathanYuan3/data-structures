/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.addFirst("One");
        list.addFirst("Two");
        list.addFirst("Three");
        list.addFirst("Four");
        System.out.println(list);
    }
}
