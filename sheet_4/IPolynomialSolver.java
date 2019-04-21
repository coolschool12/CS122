package eg.edu.alexu.csd.datastructure.linkedList.cs31;

public interface IPolynomialSolver
{
    //Set polynomial terms (coefficients & exponents)
    void setPolynomial(char poly, int[][] terms);

    //Print the polynomial in ordered human readable representation
    String print(char poly);

    //Clear the polynomial
    void clearPolynomial(char poly);

    //Evaluate the polynomial
    float evaluatePolynomial(char poly, float value);

    //Add two polynomials
    int[][] add(char poly1, char poly2);

    //Subtract two polynomials
    int[][] substract(char poly1, char poly2);

    //Multiply two polynomials
    int[][] multiply(char poly1, char poly2);
}
