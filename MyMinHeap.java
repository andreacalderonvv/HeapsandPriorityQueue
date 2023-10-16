/*
 * Name: Andrea Calderon
 * Email: a6calderon@ucsd.edu
 * PID: A17303613
 * Sources Used: Comparable Doc, Tutoring, Zybooks
 */

/*Imports Used  */
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class implements Comparable and the MinHeapInterface. 
 * This class implements a min heap.
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface<E> {
    /** instance variable */
    protected ArrayList<E> data;

    /** intializes data as an empty ArrayList */
    public MyMinHeap(){
        this.data = new ArrayList<>();
    }

    /** intializes data as an ArrayList with collection as an agrument in it */
    public MyMinHeap(Collection<? extends E> collection){
        if (collection == null || collection.contains(null)){
            throw new NullPointerException();
        }
        this.data = new ArrayList<>(collection);
        for(int i = data.size()-1 ; i >= 0 ; i--){
            percolateDown(i);
        }
    }
    /* Helper Methods */

    /**
     * swaps elements from an index to a different one
     * @param from the index in which you will switch the element from
     * @param to the index in which you will switch the element to
     */
    protected void swap(int from, int to){
        E temp = (E) data.get(to);

        data.set(to,data.get(from));

        data.set(from, temp);
    }

    /**
     *
     * @param index the index of the node you want to find the parent of
     * @return the index of the parent node of the index
     */
    protected static int getParentIdx(int index){
        return (index-1)/2;
    }

    /**
     * 
     * @param index the index of the node you want to find the left child of
     * @return the index of the left child of the index
     */
    protected static int getLeftChildIdx(int index){
        return 2*index + 1;
    }

    /**
     * 
     * @param index the index of the node you want to find the right child of
     * @return the intex of the right child of the index you want
     */
    protected static int getRightChildIdx(int index){
        return 2*index + 2;
    }

    /**
     * 
     * @param index the index of the parent who you want the min child of
     * @return the min child of the the parent's children
     */
    protected int getMinChildIdx(int index){
        if(getLeftChildIdx(index) > data.size() && getRightChildIdx(index) > data.size()){
            return -1;
        }
        else if(getLeftChildIdx(index) == data.size()-1){
            return getLeftChildIdx(index);
        }
        else if (data.get(getLeftChildIdx(index)).compareTo
        (data.get(getRightChildIdx(index))) == 0){
            return getLeftChildIdx(index);
        }
        else if (data.get(getLeftChildIdx(index)).compareTo
        (data.get(getRightChildIdx(index))) < 0){
            return getLeftChildIdx(index);
        }
        else if(data.get(getLeftChildIdx(index)).compareTo
        (data.get(getRightChildIdx(index))) > 0){
            return getRightChildIdx(index);
        }
        return -1;
    }

    /**
     * moves the node up until all min heap properties are respected
     * @param index the index of the node that moves up
     */
    protected void percolateUp(int index){
        int localIndex = index;
        while(data.get(getParentIdx(localIndex)).compareTo(data.get(localIndex)) > 0){
            if(data.get(getParentIdx(localIndex)).compareTo(data.get(localIndex)) > 0){
                swap(index,getParentIdx(localIndex));
                localIndex = getParentIdx(localIndex);
                percolateDown(localIndex);

            }
        }
    }

    /**
     * moves the node down until all min heap properties are respected
     * @param index the index of the node that moves down
     */
    protected void percolateDown(int index){
        int localIndex = index;
        while (data.get(localIndex).compareTo(data.get(getMinChildIdx(localIndex))) > 0){
            swap(localIndex, getMinChildIdx(localIndex));
        }
    }

    /**
     * 
     * @param index the index of the node that will be deleted and returned
     * @return the node that gets deleted
     */
    protected E deleteIndex(int index){
        E temp = (E) data.get(index);
        if (index == data.size()-1){
            data.remove(index);
        }
        else{
            data.set(index,data.get(data.size()-1));
            data.remove(data.size()-1);
            if(data.get(index).compareTo(data.get(getMinChildIdx(index))) > 0){
                percolateDown(index);
            }
            else if(data.get(getParentIdx(index)).compareTo(data.get(index)) > 0){
                percolateUp(index);
            }
        }
        return temp;
    }

    /**
     * inserts a node at the right most place in the bottom level
     * @param element the element that will be inserted
     */
    public void insert(E element) {
        if (element == null){
            throw new NullPointerException();
        }

        data.add(element);
        percolateUp(data.size()-1);

    }

    /**
     * @return the min element in the heap
     */
    public E getMin() {
        if (data.size() == 0){
            return null;
        }
        else{
            return data.get(0);
        }
    }

    /**
     * removes the root of the heap
     * @return the index that will be removed
     */
    public E remove() {
        if (data.size()== 0){
            return null;
        }

        deleteIndex(0);
        return data.get(0);
    }

    /**
     * @return the size of the heap
     */
    public int size() {
        return data.size();
    }

    /**
     * clears the whole heap
     */
    public void clear() {
        data.clear();
    }

}
