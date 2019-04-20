package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import java.util.*;

public class UI
{
    public static void main(String[] args)
    {
        int ch;
        polySolver polyn = new polySolver();

        Scanner sc = new Scanner(System.in);

        do {
            ch = UI.choice();

            if (ch == 1)
            {
                System.out.println("Insert the variable name: A, B or C");
                char c = sc.next().charAt(0);
                System.out.println("Insert number of terms: ");
                int a = sc.nextInt();
                int[][] terms = new int[a][2];
                System.out.println("Please enter each term when prompted (e.g. 1 2), integers and spaces only.");
                for (int i = 0; i < a; i++)
                {
                    System.out.print("Term "+i+": ");
                    int aa = sc.nextInt();
                    int bb = sc.nextInt();

                    terms[i][0] = aa;
                    terms[i][1] = bb;
                }

                try{
                    polyn.setPolynomial(c, terms);
                }
                catch (RuntimeException e) {
                    System.out.println("Invalid input.");
                }
            }
            else if (ch == 2)
            {
                System.out.println("Insert the variable name: A, B or C");
                char c = sc.next().charAt(0);
                try {
                    polyn.print(c);
                }
                catch(RuntimeException e){
                    System.out.println("Invalid input.");
                }
            }
            else if (ch == 3)
            {
                System.out.println("Insert variable 1 name: A, B or C");
                char c1 = sc.next().charAt(0);
                System.out.println("Insert variable 2 name: A, B or C");
                char c2 = sc.next().charAt(0);
                int[][] res;
                try{
                    res = polyn.add(c1, c2);
                    UI.printing(res);
                }
                catch(RuntimeException e){
                    System.out.println("Invalid input.");
                }
            }
            else if (ch == 4)
            {
                System.out.println("Insert variable 1 name: A, B or C");
                char c1 = sc.next().charAt(0);
                System.out.println("Insert variable 2 name: A, B or C");
                char c2 = sc.next().charAt(0);
                int[][] res;
                try{
                    res = polyn.substract(c1, c2);
                    UI.printing(res);
                }
                catch(RuntimeException e){
                    System.out.println("Invalid input.");
                }
            }
            else if (ch == 5)
            {
                System.out.println("Insert variable 1 name: A, B or C");
                char c1 = sc.next().charAt(0);
                System.out.println("Insert variable 2 name: A, B or C");
                char c2 = sc.next().charAt(0);
                int[][] res;
                try{
                    res = polyn.multiply(c1, c2);
                    UI.printing(res);
                }
                catch(RuntimeException e){
                    System.out.println("Invalid input.");
                }
            }
            else if (ch == 6)
            {
                System.out.println("Insert the variable name: A, B or C");
                char c = sc.next().charAt(0);
                System.out.println("Insert value: ");
                int d = sc.nextInt();

                try{
                    float f = polyn.evaluatePolynomial(c, d);
                    System.out.println("evaluation: "+f);
                }
                catch(RuntimeException e){
                    System.out.println("Invalid input.");
                }
            }
            else if (ch == 7)
            {
                System.out.println("Insert the variable name: A, B or C");
                char c = sc.next().charAt(0);

                try{
                    polyn.clearPolynomial(c);
                    System.out.println("Cleared");
                }
                catch(RuntimeException e){
                    System.out.println("Invalid input.");
                }
            }
        }while(ch != 8);
    }

    public static int choice()
    {
        System.out.println("\nPlease choose an action\n-----------------------");
        System.out.println("-----------------------\n1- Set a polynomial variable\n2- Print the value of a polynomial variable");
        System.out.println("3- Add two polynomials\n4- Subtract two polynomials");
        System.out.println("5- Multiply two polynomials\n6- Evaluate a polynomial at some point\n7- Clear a polynomial variable\n8- Exit");

        int choice;
        do{
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            if (choice < 1 || choice > 8)
                System.out.print("Invalid input.\nRe-enter: ");
        }while(choice < 1 || choice > 8);

        return choice;
    }

    public static void printing(int[][] terms)
    {
        String printed = "";
        for (int i = 0; i < terms.length; i++)
        {
            printed += String.valueOf(terms[i][0]) + "x^" + String.valueOf(terms[i][1]) + " ";
            if (i != terms.length -1)
                printed += "+ ";

        }
        System.out.println(printed);
    }
}
