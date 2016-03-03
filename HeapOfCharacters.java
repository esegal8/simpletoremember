//Listing 10.7
//********************************************************************
//  HeapOfCharacters.java       Author: Lewis/Loftus/Cocking
//
//  Implements a heap of characters.
//********************************************************************\
//:::::IMPORTANT NOTE:::::
//The bubbleDown() and removeRoot() methods were added by me(Elliot Segal) as assignment //8.2 in my AP Computer Science Class.
//All other methods were given to us. This is the most recent assignment in my class.
//I Believe this program to be complex enough to represent a portion of my computer science abilities.
import java.util.ArrayList;

public class HeapOfCharacters
{
    private ArrayList<Character> heap;

    //-----------------------------------------------------------------
    //  Sets up an empty heap.
    //-----------------------------------------------------------------
    public HeapOfCharacters ()
    {
        heap = new ArrayList<Character>();
        heap.add(0,null); // add a "dummy" element in position 0
    }

    //-----------------------------------------------------------------
    //  Returns a string representing this heap.
    //-----------------------------------------------------------------
    public String toString ()
    {
        return heap.toString();
    }

    //-----------------------------------------------------------------
    //  Adds an element to the heap.
    //-----------------------------------------------------------------
    public void add (Character ch)
    {
        heap.add(ch);
        bubbleUp();
    }

    public void bubbleDown()
    {
        int swapIndex = 1;
        while (heap.size()-1>=(swapIndex*2))
        {
            int leftIndex = swapIndex*2;
            int rightIndex = leftIndex+1;
            Character minChild = heap.get(leftIndex);
            int tracker = leftIndex;
            if ((heap.size()-1>=rightIndex) && ((heap.get(rightIndex)).compareTo(minChild)<0))
            {
                minChild = heap.get(rightIndex);
                tracker = rightIndex;
            }
            if (minChild<(heap.get(swapIndex)))
            {
                Character temp = heap.get(swapIndex);
                heap.set(swapIndex,minChild);
                heap.set(tracker, temp);
            }
            swapIndex = tracker;
        }
    }

    public Character removeRoot()
    {
        if (heap.size()<2)
        {
            return heap.get(1);
        }
        else
        {
            Character temp = heap.get(1);
            heap.set(1,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            bubbleDown();
            return temp;
        }
    }
    //-----------------------------------------------------------------
    //  Bubbles the last element up as necessary to preserve
    //  the ordering of the heap.
    //-----------------------------------------------------------------
    private void bubbleUp ()
    {
        int curIndex = heap.size() - 1;
        int parentIndex = curIndex / 2;
        Character cur = heap.get(curIndex);

        while ((curIndex > 1) &&
        (cur.compareTo(heap.get(parentIndex)) < 0))
        {
            // Swap current element with its parent
            Character parent = heap.get(parentIndex);
            heap.set(parentIndex, cur);
            heap.set(curIndex, parent);

            curIndex = parentIndex;
            parentIndex = curIndex / 2;
        }
    }
} 

