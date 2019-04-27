package eg.edu.alexu.csd.datastructure.stack.cs31;

//Stack linked list implementation
class node
{
    Object element;
    node next;
}

public class Stack implements IStack
{
    node stack;

    /**
     * Removes the element at the top of stack and returns that element.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object pop()
    {
        //If stack is empty
        if (stack == null)
            return null;

        Object temp = stack.element;
        stack = stack.next;

        return temp;
    }

    /**
     * Get the element at the top of stack without removing it from stack.
     *
     * @return top of stack element, or through exception if empty
     */
    public Object peek()
    {
        //If stack is empty
        if (stack == null)
            return null;

        return stack.element;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param object
     *
    to insert
     */
    public void push(Object element)
    {
        //Making a new node
        node top = new node();
        top.element = element;
        top.next = stack;

        //Setting new stack head
        stack = top;
    }

    /**
     * Tests if this stack is empty
     *
     * @return true if stack empty
     */
    public boolean isEmpty()
    {
        if (stack == null)
            return true;
        else
            return false;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
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
