package eg.edu.alexu.csd.datastructure.stack.cs31;

//Expression evaluator class
public class ExpEvaluator implements IExpressionEvaluator
{
    /**
     * Checks if a character is an operator
     *
     * @param ch
     *          character to be checked
     * @return true or false.
     */
    public static boolean isOperator(char ch)
    {
        char[] ops = {'+', '-', '/', '*', '('};
        for (int i = 0; i < 5; i++)
        {
            if (ch == ops[i])
                return true;
        }

        return false;
    }

    /**
     * Returns true if ch1 has higher precedence than ch2
     *
     * @param ch1
     *          first character
     * @param ch2
     *          second character
     * @return true or false based on precedence
     */
    public static boolean doesPrecede(char ch1, char ch2)
    {
        if (ch2 == '(')
            return true;
        else if (ch1 == '*' || ch1 == '/')
        {
            if (ch2 == '+' || ch2 == '-')
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression
     *          infix expression
     * @return postfix expression
     */
    public String infixToPostfix(String expression)
    {
        char[] exp = expression.toCharArray();

        //Creating postfix expression
        String postfix = "";
        Stack operators = new Stack();
        for (int i = 0; i < exp.length; i++)
        {
            //If character is an operator
            if (ExpEvaluator.isOperator(exp[i]))
            {
                if (exp[i] == '(')
                    operators.push(exp[i]);
                else if (operators.peek() == null || ExpEvaluator.doesPrecede(exp[i], (char) operators.peek()))
                    operators.push(exp[i]);
                else
                {
                    postfix += " " + (char) operators.pop();
                    i--;
                }
            }
            //If character is a closing parentheses
            else if (exp[i] == ')')
            {
                while (operators.peek() != null && (char) operators.peek() != '(')
                    postfix += " " + (char) operators.pop();

                if (operators.peek() != null && (char) operators.peek() == '(')
                    operators.pop();
            }
            //Variable
            else
            {
                postfix += exp[i];
            }
        }

        //Including remaining operators
        for (int i = 0, j = operators.size(); i < j; i++)
            postfix += " "+ (char) operators.pop();

        return postfix;
    }

    /**
     * Evaluate a postfix numeric expression, with a single space separator
     *
     * @param expression
     *          postfix expression
     * @return the expression evaluated value
     */
    public int evaluate(String expression)
    {
        char[] exp = expression.toCharArray();

        //Evaluating expression
        Stack result = new Stack();
        for (int i = 0, j = exp.length; i < j; i++)
        {
            //If character is a digit
            if (Character.isDigit(exp[i]))
            {
                //Counting digits of a number
                int counter = i;
                while (counter < j && Character.isDigit(exp[counter]))
                    counter++;

                String sub = expression.substring(i, counter);
                int num = Integer.parseInt(sub);

                //Pushing to stack
                result.push(num);

                i = counter - 1;
            }
            else if (ExpEvaluator.isOperator(exp[i]))
            {
                int num1 = (int) result.pop();
                int num2 = (int) result.pop();

                int res = 0;
                switch (exp[i])
                {
                    case '+':
                        res = (int) (num2 + num1);
                        break;
                    case '-':
                        res = (int) (num2 - num1);
                        break;
                    case '*':
                        res = (int) (num2 * num1);
                        break;
                    case '/':
                        res = (int) (num2 / num1);
                        break;
                    default:
                        break;
                }

                //Pushing result to the stack
                result.push(res);
            }
            else if (Character.isLetter(exp[i]))
            {
                System.out.println("Character " + exp[i] + "without a value.");
                return 0;
            }
        }

        if (result.size() != 1)
        {
            System.out.println("Given input was invalid.");
            return 0;

        }

        return (int) result.pop();
    }
}
