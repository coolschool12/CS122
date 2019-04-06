//Linked list node
class LinkedListNode
{
    private int value;
    private LinkedListNode next;

    public int getValue()
    {
        return value;
    }
    public LinkedListNode getNext()
    {
        return next;
    }

    public void setValue(int val)
    {
        value = val;
    }
    public void setNext(LinkedListNode nextAdd)
    {
        next = nextAdd;
    }
}

//Linked list applications
class MySpecialLinkedListUtils
{
    //Returns sum, average,median, max and min
    public static double[] summary(LinkedListNode head)
    {
        double[] summary_list = new double[5];
        //Find size of the list
        int nOfValues = addUtils.size(head, 0);
        if (nOfValues == 0)
            return summary_list;

        //Copying linked list
        LinkedListNode copy = new LinkedListNode();
        copy = addUtils.createList(nOfValues, copy);
        LinkedListNode temp1 = new LinkedListNode();
        LinkedListNode temp2 = new LinkedListNode();
        temp1 = copy;
        temp2 = head;
        for (int i = 0; i < nOfValues; i++)
        {
            temp1.setValue(temp2.getValue());
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }

        //Sorting
        copy = insertionSort(copy);

        summary_list[0] = addUtils.sum(copy);                        //Sum
        summary_list[1] = summary_list[0] / nOfValues;               //Average
        summary_list[2] = addUtils.median(copy, nOfValues, 0);       //Median
        summary_list[3] = addUtils.last(copy).getValue();            //Max
        summary_list[4] = copy.getValue();                           //Min
        return summary_list;
    }

    //Reverse method
    public static LinkedListNode reverse(LinkedListNode head)
    {
        //Finding array size
        int size = addUtils.size(head, 0);
        if (size == 0)
            return head;

        //Find new array head
        LinkedListNode new_head = addUtils.last(head);
        addUtils.reversing(head, null);
        return new_head;
    }

    //Returns list of even indexed elements
    public static LinkedListNode evenIndexedElements(LinkedListNode head)
    {
        //Finding array size
        int size = addUtils.size(head, 0);
        if (size == 0)
            return head;

        //Creating a new list
        LinkedListNode new_head = addUtils.createList(size/2 + size%2, head);
        new_head = addUtils.even(head, new_head);
        return new_head;
    }

    //Sorts elements using insertion
    public static LinkedListNode insertionSort(LinkedListNode head)
    {
        return addUtils.insertion(head, head, 1);
    }

    //Sorts a list using merge sort
    public static LinkedListNode mergeSort(LinkedListNode head)
    {
        //Find size of list
        int size = addUtils.size(head, 0);

        //Breaking list into 2 halves
        if (size == 1)
            return head;   //can't break it again

        LinkedListNode half = new LinkedListNode();
        half = addUtils.breakList(head);

        //Sorting each half
        head = mergeSort(head);
        half = mergeSort(half);

        //Merging 2 halfs
        LinkedListNode sortedIn = new LinkedListNode();
        sortedIn = addUtils.createList(size, sortedIn);
        addUtils.compareSorted(head, half, sortedIn);

        return sortedIn;
    }

    //Removes central node of a list
    public static LinkedListNode removeCenteralNode(LinkedListNode head)
    {
        //Getting list size
        int size = addUtils.size(head, 0);
        if (size == 0)
            return null;

        int middle = (size%2 == 0) ? size/2 : (size/2) + 1;

        LinkedListNode temp = new LinkedListNode();
        LinkedListNode beforeTemp = new LinkedListNode();
        temp = beforeTemp = head;
        for (int i = 0; i < middle - 1; i++)
        {
            temp = temp.getNext();
            if (i != middle -2)
                beforeTemp = beforeTemp.getNext();
        }

        beforeTemp.setNext(temp.getNext());
        temp.setNext(null);

        return head;
    }

    //Checks if list is a palindrome
    public static boolean palindrome(LinkedListNode head)
    {
        //Getting list size
        int size = addUtils.size(head, 0);
        if (size == 0)
            return false;

        //Copying linked list
        LinkedListNode copy = new LinkedListNode();
        copy = addUtils.createList(size, copy);
        LinkedListNode temp1 = new LinkedListNode();
        LinkedListNode temp2 = new LinkedListNode();
        temp1 = copy;
        temp2 = head;
        for (int i = 0; i < size; i++)
        {
            temp1.setValue(temp2.getValue());
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }

        //Reversing copy
        copy = MySpecialLinkedListUtils.reverse(copy);

        //Comparing original and reversed
        temp1 = copy;
        temp2 = head;
        for (int i = 0; i < size; i++)
        {
            if (temp1.getValue() != temp2.getValue())
                return false;
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }

        return true;
    }
}

//Added methods to use in Utils class
class addUtils
{
    //Making nodes
    public static LinkedListNode make_node(int valu, LinkedListNode nex)
    {
        LinkedListNode temp = new LinkedListNode();
        temp.setValue(valu);
        temp.setNext(nex);
        return temp;
    }

    //Create linked list
    public static LinkedListNode createList(int size, LinkedListNode pos)
    {
        if(size == 0)
            return null;
        else
        {
            pos = new LinkedListNode();
            pos.setNext(createList(size - 1, pos.getNext()));
            return pos;
        }
    }

    //Returns size of a list
    public static int size(LinkedListNode head, int counter)
    {
        if (head == null)
            return counter;
        else
            return size(head.getNext(), ++counter);
    }

    //Returns sum of elements in a list
    public static double sum(LinkedListNode head)
    {
        if(head == null)
            return 0;
        else
            return head.getValue() + sum(head.getNext());
    }

    //Returns last element in a list
    public static LinkedListNode last(LinkedListNode head)
    {
        if (head.getNext() == null)
            return head;
        else
            return last(head.getNext());
    }

    //Returns median in a sorted list
    public static double median(LinkedListNode head, int size, int counter)
    {
        if (counter == size/2)
        {
            if (size % 2 == 1)
                return head.getValue();
            else
            {
                LinkedListNode after = head.getNext();
                return (head.getValue() + after.getValue())/2;
            }
        }
        else
            return median(head.getNext(), size, ++counter);
    }

    //Reverses linked list
    public static void reversing(LinkedListNode head, LinkedListNode before)
    {
        if (head.getNext() == null)
            head.setNext(before);
        else
        {
            reversing(head.getNext(), head);
            head.setNext(before);
        }
    }

    //Puts even indexed elements in list
    public static LinkedListNode even(LinkedListNode oldList, LinkedListNode newList)
    {
        newList.setValue(oldList.getValue());

        if (newList.getNext() != null)
            newList.setNext(even((oldList.getNext()).getNext(), newList.getNext()));
        return newList;
    }

    //Return node at a certain position
    public static LinkedListNode node_pos(LinkedListNode head, int pos)
    {
        if (pos == 1)
            return head;
        else
            return node_pos(head.getNext(), pos-1);
    }

    //Compare and insert nodes - returns list head
    public static LinkedListNode insert(LinkedListNode pos, LinkedListNode beforePos, LinkedListNode head)
    {
        if (pos != head)
        {
            if (pos.getValue() < head.getValue())
            {
                //List head
                beforePos.setNext(pos.getNext());
                pos.setNext(head);
                return pos;
            }
            else if ((pos.getValue() >= head.getValue()) && (pos.getValue() <= (head.getNext()).getValue()))
            {
                beforePos.setNext(pos.getNext());
                pos.setNext(head.getNext());
                head.setNext(pos);
            }
            else
            {
                insert(pos, beforePos, head.getNext());
            }
        }
        return head;
    }

    //Sorts elements using insertion
    public static LinkedListNode insertion(LinkedListNode pos, LinkedListNode head, int place)
    {
        if (pos.getNext() == null)
            return head;
        else
        {
            head = insert(pos.getNext(), pos, head);
            LinkedListNode nextPos = node_pos(head, place+1);
            return insertion(nextPos, head, place+1);
        }
    }

    //Merges 2 sorted linked lists into 1
    public static void compareSorted(LinkedListNode list1, LinkedListNode list2, LinkedListNode arrangedIn)
    {
        if (arrangedIn != null)
        {
            if (list1 == null)
            {
                //List 1 ended
                arrangedIn.setValue(list2.getValue());
                compareSorted(list1, list2.getNext(), arrangedIn.getNext());
            }
            else if (list2 == null)
            {
                //List 2 ended
                arrangedIn.setValue(list1.getValue());
                compareSorted(list1.getNext(), list2, arrangedIn.getNext());
            }
            else if (list1.getValue() >= list2.getValue())
            {
                //List 1 has smaller value
                arrangedIn.setValue(list2.getValue());
                compareSorted(list1, list2.getNext(), arrangedIn.getNext());
            }
            else if (list1.getValue() < list2.getValue())
            {
                //List 2 has smaller value
                arrangedIn.setValue(list1.getValue());
                compareSorted(list1.getNext(), list2, arrangedIn.getNext());
            }
        }
    }

    //Breaks a list into 2 lists - returns reference to the second half
    public static LinkedListNode breakList(LinkedListNode head)
    {
        int size = addUtils.size(head, 0);

        int middle = (size/2) + 1;
        LinkedListNode temp = new LinkedListNode();
        LinkedListNode beforeTemp = new LinkedListNode();
        temp = beforeTemp = head;
        for (int i = 0; i < middle - 1; i++)
        {
            temp = temp.getNext();
            if (i != middle -2)
                beforeTemp = beforeTemp.getNext();
        }

        beforeTemp.setNext(null);
        return temp;
    }
}
