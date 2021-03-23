package part2;

public class HeapSort {
    public static void sort(int[] arr) {
        constructHeap(arr);
        sortHeap(arr);

    }
    public static void sortHeap(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapifyDown(arr, 0, i);
        }
    }
    public static void constructHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapifyDown(array, i, array.length);
    }
    public static void heapifyDown(int[] arr, int i, int n) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyDown(arr, largest, n);
        }
    }

    public static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }
    public static void main(String[] args) {
        int[] array = {-2,0,8,-6,4};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
