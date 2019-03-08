class MySpecialArrayUtils
{
    //Reverses the elements of a single dimensional array in place.
    public static void reverse(int[] arr)
    {
        int arrayLen = arr.length;
        for (int i = 0; i < (arrayLen / 2); i++)
        {
            arr[i] = arr[i] ^ arr[arrayLen - i - 1];
            arr[arrayLen - i - 1] = arr[i] ^ arr[arrayLen - i - 1];
            arr[i] = arr[i] ^ arr[arrayLen - i - 1];
        }
    }

    //Finds sum of the even and the odd elements in an array
    public static int[] sumEvenOdd(int[] arr)
    {
        int[] sums = {0,0};
        int arrayLen = arr.length;

        for (int i = 0; i < arrayLen; i++)
        {
            //Even number
            if (arr[i] % 2 == 0)
                sums[0] += arr[i];
            //Odd number
            else
                sums[1] += arr[i];
        }

        return sums;
    }

    //Finds average of elements in an array
    public static double average(int[] arr)
    {
        double average = 0;
        int arrayLen = arr.length;

        for (int i = 0; i < arrayLen; i++)
        {
            average += (double)arr[i] / arrayLen;
        }

        return average;
    }

    //Moves elements equal to value to the end of an array - in place
    public static void moveValue(int[] arr, int val)
    {
        int arrayLen = arr.length;

        for (int i = 0; i < arrayLen; i++)
        {
            if (arr[i] == val)
            {
                //Moving element to the end of the array
                for (int j = i; j < arrayLen - 1; j++)
                {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }

                //If val occurs twice in a row
                if (arr[i] == val)
                	for (int j = i; j < arrayLen; j++)
                		if (arr[j] != val)
                		{
                			i--;
                			break;
                		}
            }
        }
    }

    //Transpose an array
    public static int[][] transpose(int[][] arr)
    {
        int rowLen = arr.length;
        int columnLen = arr[0].length;
        int[][] temp = new int[columnLen][rowLen];

        for (int i = 0; i < rowLen; i++)
        {
            for (int j = 0; j < columnLen; j++)
            {
                //Transposing array
                temp[j][i] = arr[i][j];
            }
        }

        return temp;
    }
}
