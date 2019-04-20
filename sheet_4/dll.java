package eg.edu.alexu.csd.datastructure.linkedList.cs31;

class dnode
{
    Object element;
    dnode next;
    dnode previous;
}

class dll implements ILinkedList
{
    dnode head;

    public void add(int index, Object element)
    {
        //Index exceeds list size
        if (index >= this.size())
            return;

        dnode temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        //Adding new node
        dnode added = new dnode();
        added.element = element;
        (temp.previous).next = added;
        added.next = temp;
    }

    public void add(Object element)
    {
        //First element in list
        if (head == null)
        {
            head = new dnode();
            head.element = element;
        }
        else
        {
            dnode temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = new dnode();
            temp.next.element = element;
        }
    }

    public Object get(int index)
    {
        //Index exceeds list size
        if (index >= this.size())
            return null;

        dnode temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.element;
    }

    public void set(int index, Object element)
    {
        dnode temp = head;
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

        dnode temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        (temp.previous).next = temp.next;
    }

    public int size()
    {
        int counter = 0;
        dnode temp = head;
        while (temp != null)
        {
            counter++;
            temp = temp.next;
        }

        return counter;
    }

    public dll sublist(int fromIndex, int toIndex)
    {
        dll sublist = new dll();

        sublist.head = new dnode();
        sublist.head.element = this.get(fromIndex);
        dnode temp = sublist.head;
        for (int i = fromIndex + 1; i < toIndex + 1; i++)
        {
            temp.next = new dnode();
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
