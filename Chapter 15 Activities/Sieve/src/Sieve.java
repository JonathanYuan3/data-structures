import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        
        // Compile a list of all the terms
        Set<Integer> terms = new HashSet<>(); 
        for(int i = 2; i <= n; i++) {
            terms.add(i);
        }
        
        // Perform Eratosthenes' sieve
        for (int i = 2; i * i <= n; i++) {
            if (terms.contains(i)) { //Check for a number that hasn't been removed (a prime number)
                // Remove all multiples of i, excluding i itself
                for (int j = 2 * i; j <= n; j += i) { //Checks for every multiple of the number. Originally was going to use modulus (%) to figure out but realized this would be more efficient.
                    terms.remove(j);
                }
            }
        }
        
        System.out.println(terms);







    }
}
