package game;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    public static class Node<T> 
    {
        private T data;
        private Node<T> next;
        public Node(T t)
        {
            data = t;
        }
        public void setNext(Node<T> n)
        {
            next = n;
        }
        public Node<T> next()
        {
            return next;
        }
        public T getData()
        {
            return data;
        }
    }
    private Node<T> head;
    private int size;
    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }
    public int size()
    {
        return size;
    }
    public void add(int index, T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }
        if ((index < 0) || (index > size()))
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> current = head;
        if (isEmpty())
        {
            head = new Node<T>(obj);
        }
        else
        {
            if (index == 0)
            {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else
            {
                int currentIndex = 0;
                while (current != null)
                {
                    if ((currentIndex + 1) == index)
                    {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);
                    }
                    current = current.next();
                }
            }
        }
        size++;
    }
    public void add(T obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }
        Node<T> current = head;
        if (isEmpty())
        {
            head = new Node<T>(obj);
        }
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public boolean remove(T obj)
    {
        boolean found = false;
        Node currentNode = head;
        int i = 0;
        while (!found && (currentNode != null))
        {
            if (obj.equals(currentNode.getData()))
            {
                if (i == 1)
                {
                    head = head.next();
                }
                else
                {
                    Node nodeBefore = getNodeAt(i - 1);
                    Node nodeToRemove = nodeBefore.next();
                    Node nodeAfter = nodeToRemove.next();
                    nodeBefore.setNext(nodeAfter);
                }
                found = true;
                size--;
            }
            else
            {
                currentNode = currentNode.next();
            }
        }
        return found;
    }
    public boolean remove(int index)
    {
        if (index >= 1 && index <= size)
        {
            if (index == 1)
            {
                head = head.next();
            }
            else
            {
                Node nodeBefore = getNodeAt(index - 1);
                Node nodeToRemove = nodeBefore.next();
                Node nodeAfter = nodeToRemove.next();
                nodeBefore.setNext(nodeAfter);
            }
            size--;
            return true;
        }
        else
        {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation");
        }
    }
    public T get(int index)
    {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        if (data == null)
        {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }
    public boolean contains(T obj)
    {
        Node<T> current = head;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void clear()
    {
        if (!isEmpty())
        {
            head = null;
            size = 0;
        }
    }
    public Object[] toArray()
    {
        Object[] array = new Object[size()];
        Node<T> current = head;
        int count = 0;
        while (current != null)
        {
            array[count] = current.getData();
            current = current.next;
            count++;
        }
        return array;
    }
    private Node getNodeAt(int givenPosition)
    {
        Node currentNode = head;
        for (int i = 1; i < givenPosition; i++)
        {
            currentNode = currentNode.next();
        }
        return currentNode;
    }
    private class SinglyLinkedListIterator<T> implements Iterator<T>
    {
        private Node<T> start;
        private boolean wasCalled;
        private SinglyLinkedListIterator()
        {
            start = (Node<T>) head;
            wasCalled = false;
        }
        @Override
        public boolean hasNext() {
            return start.next().getData() != null;
        }

        @Override
        public T next() {
            if (hasNext())
            {
                Node<T> out = start.next();
                start = start.next();
                wasCalled = true;
                return out.getData();
            }
            else
            {
                throw new NoSuchElementException("Element not allowed");
            }
        }
        
    }

}
