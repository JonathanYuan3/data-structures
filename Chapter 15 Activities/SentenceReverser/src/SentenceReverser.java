import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
    	
        // Complete this method. Use a Stack.
        Stack<String> stack = new Stack<>();
        String reversed = "";
        while (scanner.hasNext()) {
        	stack.push(scanner.next());
            if(stack.peek().contains(".")){
                int size = stack.size();
                for(int i = 0; i < size; i++){
                    String word = stack.pop().replace(".", "");
                    if(i == 0){
                        word = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
                    }
                    else if (i == size - 1) {
                        word = word + ".";
                    }
                    else {
                        word = word.toLowerCase();
                    }
                    reversed += word + " ";
                }
            }
        }
        return reversed;
    }
}
