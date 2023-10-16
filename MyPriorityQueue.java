/*
 * Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources Used: Comparable Doc, Tutoring
 */

// imports used
import java.util.ArrayList;
import java.util.Collection;


/**
 * implements a priority queue with a MyMinHeap object
 */
public class MyPriorityQueue<E extends Comparable<E>>{
    /** the instance variable */
    protected MyMinHeap<E> heap;


    /** intializes heap as an empty MyMinHeap */
    public MyPriorityQueue(){
        this.heap = new MyMinHeap<>();
    }

    /**
     * intializes heap with collection in it
     * @param collection
     */
    public MyPriorityQueue(Collection<? extends E> collection){
        if ( collection == null || collection.contains(null)){
            throw new NullPointerException();
        }
        this.heap = new MyMinHeap<>(collection);
    }

    /**
     * adds element to the priority queue
     * @param element the element that will be added
     */
    public void push(E element){
        if (element == null){
            throw new NullPointerException();
        }

        heap.insert(element);
    }

    /**
     * 
     * @return the element at the top of the queue
     */
    public E peek(){
        return heap.getMin();
    }

    /**
     * 
     * @return the element at the top of that queue that is removed
     */
    public E pop(){
        if (heap.size() == 0){
            return null;
        }
        return heap.remove();
    }

    /**
     * 
     * @return the length of the priority queue
     */
    public int getLength(){
        return heap.size();
    }

    /**
     * clears the priority queue
     */
    public void clear(){
        heap.clear();
    }



}