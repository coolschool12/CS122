//Testing stack implementation
import java.util.Scanner;

public class testClass
{
    public static void main(String[] args)
    {
        Stack trial = new Stack();
        int choice;

        do {
            choice = testClass.UI();

            //Processing input
            if (choice == 1)
            {
                Object input;
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter element to be pushed: ");
                input = sc.next();

                trial.push(input);
            }
            else if (choice == 2)
            {
                System.out.println("Element popped: "+ trial.peek());
                trial.pop();
            }
            else if (choice == 3)
            {
                System.out.println("Element on top is: " + trial.peek());
            }
            else if (choice == 4)
            {
                System.out.println("Size is: " + trial.size());
            }
            else if (choice == 5)
            {
                if (trial.isEmpty())
                    System.out.println("Stack is empty.");
                else
                    System.out.println("Stack is not empty.");
            }
            else if (choice == 6)
            {
                printStack(trial);
            }
        }while (choice != 7);
    }

    //Prints stack contents
    public static void printStack(Stack stk)
    {
        node temp = stk.stack;

        System.out.print("Stack contents: ");
        while (temp != null)
        {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //User interface
    public static int UI()
    {
        System.out.println("\nPlease choose an option: ");
        System.out.println("\t\t1: Push.\n\t\t2: Pop.\n\t\t3: Peek.\n\t\t4: Get size.\n\t\t5: Check if empty.\n\t\t6: Print contents.\n\t\t7: Exit.");

        //Taking input
        int choice;
        do {
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            if (choice < 1 || choice > 7)
                System.out.print("Invalid input.\nRe-enter: ");
        }while (choice < 1 || choice > 7);

        return choice;
    }
}
