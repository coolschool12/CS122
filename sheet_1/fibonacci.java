import java.math.BigInteger;

class fibonacci
{
    public static BigInteger fibonacci(int index)
    {
        BigInteger i = new BigInteger("0");
        BigInteger j = new BigInteger("1");

        //Calculating fibonacci
        for (int k = 0; k < index - 1; k++)
        {
            if (k % 2 == 0)
                i = i.add(j);
            else
                j = j.add(i);
        }

        if (index % 2 == 0)
            return i;
        else
            return j;
    }
}
