import java.util.Arrays;

public class HeapSort {

    public static void heapSort(Integer[] values) {
        int length = values.length;
        for(int i = length/2 -1; i >= 0; i--){
            heapify(values, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            swap(values, 0, i);
            heapify(values, i, 0);
        }
    reverseArray(values);
    }

    private static void heapify(Integer[] values, int heapSize, int rootIndex) {
        int maxVal = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && values[leftChild] > values[maxVal]) {
            maxVal = leftChild;
        }

        if (rightChild < heapSize && values[rightChild] > values[maxVal]) {
            maxVal = rightChild;
        }

        if (maxVal != rootIndex) {
            swap(values, rootIndex, maxVal);
            heapify(values, heapSize, maxVal);
        }
    }

    private static void reverseArray(Integer[] values) {
        int left = 0;
        int right = values.length - 1;
        while (left < right) {
            swap(values, left, right);
            left++;
            right--;
        }
    }

    private static void swap(Integer[] values, int i, int j) {
        int curr = values[i];
        values[i] = values[j];
        values[j] = curr;
    }
    public static void main(String[] args) {
        int size = 20;
        Integer[] list = new Integer[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }
        System.out.println("Unsorted List: " + Arrays.toString(list));
        heapSort(list);
        System.out.println("  Sorted List:" + Arrays.toString(list));
    }
}
