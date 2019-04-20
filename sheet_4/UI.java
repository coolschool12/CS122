package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import java.utils.*;

public class UI
{
    public static void main(String[] args)
    {
        int ch = UI.choice();

        Scanner sc = new Scanner(System.in);
        if (ch == 1)
        {
            System.out.println("Insert the variable name: A, B or C");
            sc = sc.next().charAt(0);
            System.out.println("Insert polynomial terms: ");
            
        }
        else if (ch == 2)
        {

        }
        else if (ch == 3)
        {

        }
        else if (ch == 4)
        {

        }
        else if (ch == 5)
        {

        }
        else if (ch == 6)
        {

        }
        else if (ch == 7)
        {

        }
    }

    public static int choice()
    {
        System.out.println("Please choose an action\n-----------------------");
        System.out.println("-----------------------\n1- Set a polynomial variable\n2- Print the value of a polynomial variable");
        System.out.println("3- Add two polynomials\n4- Subtract two polynomials");
        System.out.println("5- Multiply two polynomials\n6- Evaluate a polynomial at some point\n7- Clear a polynomial variable");

        do{
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice < 1 || choice > 7)
                System.out.print("Invalid input.\nRe-enter: ");
        }while(choice < 1 || choice > 7);

        return choice;
    }


}
