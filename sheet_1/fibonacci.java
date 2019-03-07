class fibonacci
{
    public static long long fibonacci(int index)
    {
        if (index == 1 || index == 2)
            return 1;
        else if (index == 0)
            return 0;
        else
            return fibonacci(index - 1) + fibonacci(index - 2);
    }
}
