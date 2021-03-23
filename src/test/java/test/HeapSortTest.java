package test;

import org.junit.jupiter.api.*;
import part2.HeapSort;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeapSortTest {
    final int MIN_ELEMENTS = 4;
    final int MAX_ELEMENTS = 100;
    int[] array;
    int n;
//    @BeforeEach
//    void setUp() {
//        array = new int[]{0, -1, 4, 3, -20, -10, 2, 3, 24, 23};
//        n = array.length;
//    }
    @BeforeEach
    void setUp() {
        Random rand = new Random();
        n = MIN_ELEMENTS + rand.nextInt(MAX_ELEMENTS-MIN_ELEMENTS);
        array = new int[n];
        boolean conditions = true;
        while (conditions) {
            for (int i = 0; i < n; i++) {
                array[i] = rand.nextInt();
            }
            boolean heap = checkHeapConditions(0);
            boolean heapN3 = checkHeapConditions(n / 3);
            boolean sorted = checkIfSorted();
            conditions = heap || heapN3 || sorted;
        }
    }
    private boolean checkHeapConditions(int index) { // n >= 4
        boolean left = true,right = true;
        if (index*2+1 < n) {
            left = (array[index]>=array[index*2+1]);
        }
        if (index*2+2 < n) {
            right = (array[index]>=array[index*2+2]);
        }
        if (index*2+1 < n) {
            if (index*2+2 < n) {
                return left && right && checkHeapConditions(index*2+1) && checkHeapConditions(index*2+2);
            }
            return left && right && checkHeapConditions(index*2+1);
        }
        return left && right;
    }
    private boolean checkIfSorted() { // n >= 2
        for (int i = 1; i < n; i++) {
            if (array[i-1] > array[i])
                return false;
        }
        return true;
    }
    @RepeatedTest(100)
    void checkHeapify() {
        int index = n/3;
        HeapSort.heapifyDown(array,index,n);
        checkHeapify(index);
    }
    private void checkHeapify(int index) {
        if (index*2+1 < n) {
            assertTrue(array[index]>=array[index*2+1]);
            checkHeapify(index*2+1);
        }
        if (index*2+2 < n) {
            assertTrue(array[index]>=array[index*2+2]);
            checkHeapify(index*2+2);
        }
    }
    @RepeatedTest(100)
    void checkHeapConstruction() {

        HeapSort.constructHeap(array);
        for (int i = 0; i < n/2; i++) {
            if (i*2+1 < n) {
                assertTrue(array[i]>=array[i*2+1]);
            }
            if (i*2+2 < n) {
                assertTrue(array[i]>=array[i*2+2]);
            }
        }
    }
    @RepeatedTest(100)
    void checkSort() {
        HeapSort.sort(array);
        for (int i = 1; i < n; i++) {
            assertTrue(array[i-1]<=array[i]);
        }
    }
    @AfterAll
    void tearDown() {
        n = 0;
        array = null;
    }
}
