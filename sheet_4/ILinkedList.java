package eg.edu.alexu.csd.datastructure.linkedList.cs31;

public interface ILinkedList
{
    //Inserts a specified element at the specified position in the list.
    public void add(int index, Object element);

    //Inserts the specified element at the end of the list.
    public void add(Object element);

    //Return the element at the specified position in this list.
    public Object get(int index);

    //Replaces the element at the specified position in this list with the specified element.
    public void set(int index, Object element);

    //Removes all of the elements from this list.
    public void clear();

    //Return true if this list contains no elements.
    public boolean isEmpty();

    //Removes the element at the specified position in this list.
    public void remove(int index);

    //Return the number of elements in this list.
    public int size();

    //Return a view of the portion of this list between the specified
    public ILinkedList sublist(int fromIndex, int toIndex);

    //Return true if this list contains an element with the same value as the
    public boolean contains(Object o);
}
