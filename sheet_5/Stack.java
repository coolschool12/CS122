//Stack linked list implementation
class node
{
    Object element;
    node next;
}

public class Stack implements IStack
{
    node stack;

    public Object pop()
    {
        //If stack is empty
        if (stack == null)
            return null;

        Object temp = stack.element;
        stack = stack.next;

        return temp;
    }

    public Object peek()
    {
        //If stack is empty
        if (stack == null)
            return null;

        return stack.element;
    }

    public void push(Object element)
    {
        //Making a new node
        node top = new node();
        top.element = element;
        top.next = stack;

        //Setting new stack head
        stack = top;
    }

    public boolean isEmpty()
    {
        if (stack == null)
            return true;
        else
            return false;
    }

    public int size()
    {
        int counter = 0;
        node temp = stack;

        //Counting elements in stack
        while (temp != null)
        {
            counter++;
            temp = temp.next;
        }

        return counter;
    }
}
