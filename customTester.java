import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class customTester {
    static <E extends Comparable<E>> MyMinHeap<E> initMinHeap(List<E> data) {
        MyMinHeap<E> heap = new MyMinHeap<>();
        heap.data = new ArrayList<>(data);
        return heap;
    }



    @Test
    public void whocares(){
        assertEquals();
    }
}
