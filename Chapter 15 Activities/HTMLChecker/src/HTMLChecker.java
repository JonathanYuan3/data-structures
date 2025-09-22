import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "src/TagSample1.html";

        try (Scanner in = new Scanner(new File(filename)))
        {
        	// Your code goes here
            Stack<String> stack = new Stack<>();
            boolean working = true;

            while (in.hasNext()) {
                String tag = in.next();

                if (tag.startsWith("</")) {
                    if (stack.isEmpty()) {
                        working = false;
                        break;
                    }

                    String tag1 = stack.pop();
                    String openTag = tag1.substring(1, tag1.length() - 1);
                    String closeTag = tag.substring(2, tag.length() - 1);

                    if (!openTag.equals(closeTag)) {
                        working = false;
                        break;
                    }
                } else {
                    stack.push(tag);
                }
            }

            if (!stack.isEmpty()) {
                working = false;
            }

            if (working) {
                System.out.println("Tags are properly nested.");
            } else {
                System.out.println("Tags are NOT properly nested.");
            }
            
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }
}
