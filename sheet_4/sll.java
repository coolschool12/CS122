package eg.edu.alexu.csd.datastructure.linkedList.cs31;

class node
{
    Object element;
    node next;
}

class sll implements ILinkedList
{
    node head;

    public void add(int index, Object element)
    {
        //Index exceeds list size
        if (index >= this.size())
            return;

        node temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        //Adding new node
        node added = new node();
        added.element = element;

        added.next = temp.next;
        temp.next = added;
    }

    public void add(Object element)
    {
        //First element in list
        if (head == null)
        {
            head = new node();
            head.element = element;
        }
        else
        {
            node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = new node();
            temp.next.element = element;
        }
    }

    public Object get(int index)
    {
        //Index exceeds list size
        if (index >= this.size())
            return null;

        node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.element;
    }

    public void set(int index, Object element)
    {
        node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        temp.element = element;
    }

    public void clear()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        if (head == null)
            return true;
        else
            return false;
    }

    public void remove(int index)
    {
        //Index exceeds list size
        if (index >= this.size())
            return;

        node temp = head;
        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        temp.next = temp.next.next;
    }

    public int size()
    {
        int counter = 0;
        node temp = head;
        while (temp != null)
        {
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    public sll sublist(int fromIndex, int toIndex)
    {
        sll sublist = new sll();

        sublist.head = new node();
        sublist.head.element = this.get(fromIndex);
        node temp = sublist.head;
        for (int i = fromIndex + 1; i < toIndex + 1; i++)
        {
            temp.next = new node();
            temp.next.element = this.get(i);
            temp = temp.next;
        }

        return sublist;
    }

    public boolean contains(Object o)
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (this.get(i) == o)
                return true;
        }
        return false;
    }
}
