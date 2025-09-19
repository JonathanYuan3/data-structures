import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Implement a to do list. Tasks have a priority between
 * 1 and 9 (with 1 being most urgent), and a description.
 * When the user enters the command 'add priority description',
 * the program adds a new task. When the user enters next,
 * the program removes and prints the most urgent task.
 * The quit command quits the program.
 * Use a priority queue in your solution.
 */
public class ToDoList {
    // Instance variable(s)
    PriorityQueue<Task> tasklist = new PriorityQueue<>();

    /**
     * Constructor
     */
    public ToDoList() {
        // Initialize instance variable(s)

    }

    /**
     * Display a menu and accepts commands.
     */
    public void run() {
        String option = "";
        System.out.println("To Do List - Please enter an option");
        System.out.println("     add priority description (add a new task)");
        System.out.println("     next (remove and print most urgent task)");
        System.out.println("     quit (exit this program)");
        System.out.println();

        Scanner in = new Scanner(System.in);

        do {
            System.out.print("> ");
            option = in.nextLine();
            if (option.startsWith("add")) {
                addTask(option);
            } else if (option.equals("next")) {
                nextTask();
            }
        } while (!option.equals("quit"));
    }

    /**
     * Parse the add option line.
     *
     * @param optionStr the option line
     */
    public void addTask(String optionStr) {
        // Complete this method
        try {
            int priority = Integer.parseInt(optionStr.substring(4, 5));
            String description = optionStr.substring(6);
            tasklist.add(new Task(priority, description));
        } catch (Exception e) {
            System.out.println("The priority must be an integer between 1 and 9.");
            return;
        }

    }

    /**
     * Get the next highest priority task and
     * display the description to the user.
     */
    public void nextTask() {
        Task next = null;

        next = tasklist.peek();
        tasklist.remove(next);
        if (next == null) {
            System.out.println("There are no tasks in the list.");
        } else {
            System.out.println(next.getDescription());
        }
    }
}