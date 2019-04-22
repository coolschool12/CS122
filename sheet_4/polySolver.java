package eg.edu.alexu.csd.datastructure.linkedList.cs31;
import java.lang.Math;
import java.util.*;

public class polySolver implements IPolynomialSolver
{
    sll polynomial;

    public polySolver()
    {
        polynomial = new sll();
        for (int i = 0; i < 3; i++)
            polynomial.add(null);
    }

    int checker(char poly)
    {
        if (poly == 'A' || poly == 'a')
            return 0;
        else if (poly == 'B' || poly == 'b')
            return 1;
        else if (poly == 'C' || poly == 'c')
            return 2;
        else
            throw new RuntimeException("Invalid input.");
    }

    public void setPolynomial(char poly, int[][] terms)
    {
        int where = this.checker(poly);

        //Sorting polynomial and adding it to the list
        Arrays.sort(terms, (int[] o1, int[] o2) -> o2[1] - o1[1]);            ///////////////////////////////
        polynomial.add(where, terms);
        polynomial.remove(where+1);
    }

    public String print(char poly)
    {
        int where = this.checker(poly);

        //Making a string of the polynomial
        int[][] terms = (int[][]) polynomial.get(where);
        String printed = "";
        for (int i = 0; i < terms.length; i++)
        {
            printed += String.valueOf(terms[i][0]) + "x^" + String.valueOf(terms[i][1]) + " ";
            if (i != terms.length -1)
                printed += "+ ";
        }
        System.out.println(printed);
        return printed;
    }

    public void clearPolynomial(char poly)
    {
        int where = this.checker(poly);

        //Removing polynomial
        polynomial.remove(where);
        polynomial.add(where, null);
    }

    public float evaluatePolynomial(char poly, float value)
    {
        int where = this.checker(poly);

        //Evaluating polynomial
        int[][] terms = (int[][]) polynomial.get(where);
        int evaluated = 0;
        for (int i = 0; i < terms.length; i++)
            evaluated += ((float)terms[i][0]) * ((float)Math.pow(value, terms[i][1]));

        return evaluated;
    }

    public int[][] add(char poly1, char poly2)
    {
        int where1 = checker(poly1);
        int where2 = checker(poly2);

        if (where1 == where2)
            throw new RuntimeException("Invalid input.");

        int[][] terms1 = (int[][]) polynomial.get(where1);
        int[][] terms2 = (int[][]) polynomial.get(where2);

        return adding(terms1, terms2);
    }

    //Adds 2 arrays of polynomials
    int[][] adding(int[][] termsa, int[][] termsb)
    {
        int[][] terms1 = new int[termsa.length][2];
        int[][] terms2 = new int[termsb.length][2];
        for (int i = 0; i < terms1.length; i++)
        {
            terms1[i][0] = termsa[i][0];
            terms1[i][1] = termsa[i][1];
        }
        for (int i = 0; i < terms2.length; i++)
        {
            terms2[i][0] = termsb[i][0];
            terms2[i][1] = termsb[i][1];
        }

        //Adding all terms into the list
        ArrayList<int[]> add = new ArrayList<int[]>();
        for (int i = 0; i < terms1.length; i++)
            add.add(terms1[i]);
        for (int i = 0; i < terms2.length; i++)
            add.add(terms2[i]);

        //Adding similiar terms
        for (int i = 0; i < add.size(); i++)
        {
            for (int j = 0; j < add.size(); j++)
            {
                //Similar exponents, not the same element
                if (i != j && add.get(i)[1] == add.get(j)[1])
                {
                    add.get(i)[0] += add.get(j)[0];
                    add.remove(j--);
                }
            }
        }

        int[][] added = new int[add.size()][2];
        for (int i = 0; i < add.size(); i++)
            added[i] = add.get(i);
        Arrays.sort(added, (int[] o1, int[] o2) -> o2[1] - o1[1]);            ///////////////////////////////
        return added;
    }

    public int[][] substract(char poly1, char poly2)
    {
        int where1 = checker(poly1);
        int where2 = checker(poly2);

        if (where1 == where2)
            throw new RuntimeException("Invalid input.");

        int[][] terms1 = (int[][]) polynomial.get(where1);
        int[][] terms2 = (int[][]) polynomial.get(where2);
        for (int i = 0; i < terms2.length; i++)
            terms2[i][0] = -1 * terms2[i][0];

        return adding(terms1, terms2);
    }

    public int[][] multiply(char poly1, char poly2)
    {
        int where1 = checker(poly1);
        int where2 = checker(poly2);

        if (where1 == where2)
            throw new RuntimeException("Invalid input.");

        int[][] terms1 = (int[][]) polynomial.get(where1);
        int[][] terms2 = (int[][]) polynomial.get(where2);

        //Multiplying each term by all others
        int counter = 0;
        int[][] multiplied = new int[(terms1.length) * (terms2.length)][2];
        for (int i = 0; i < terms1.length; i++)
        {
            for (int j = 0; j < terms2.length; j++)
            {
                int[] temp = {terms1[i][0] * terms2[j][0], terms1[i][1] + terms2[j][1]};
                multiplied[counter++] = temp;
            }
        }

        //Adding similar terms and arranging term
        int[][] multi = this.adding(multiplied, multiplied);
        Arrays.sort(multi, (int[] o1, int[] o2) -> o2[1] - o1[1]);            ///////////////////////////////
        return multi;
    }
}
