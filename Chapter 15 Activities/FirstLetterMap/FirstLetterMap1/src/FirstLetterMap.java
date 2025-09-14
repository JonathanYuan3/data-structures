import java.util.*;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class FirstLetterMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "src/test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map <Character, String> firstletters = new TreeMap();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Character c = word.charAt(0);

                // Update the map here
                // Modify Worked Example 15.1
                if (firstletters.get(c) == null) {
                    firstletters.put(c, word);
                }
                else {
                    firstletters.put(c, word + ", " + firstletters.get(c));
                }

                


            }

            // Print the map here in this form
            for(Character key : firstletters.keySet()){
                System.out.println(key + ": [" + firstletters.get(key) + "]");
            }
            // a: [a, able, aardvark]
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
