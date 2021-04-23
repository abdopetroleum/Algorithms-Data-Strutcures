package Algorithms.SortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SelectionSort {
    public static <K> void selectionSort(K arr[], Comparator<K> comparator) {
        // step 1: loop from the beginning of the array to the second to last item
        for (int i = 0; i < arr.length - 1; i++) {
            // step 2: save a copy of the currentIndex
            int minIndex = i;
            // step 3: loop through all indexes that proceed the currentIndex
            for (int j = i + 1; j < arr.length; j++) {
                // step 4:  if the value of the index of the current loop is less
                //          than the value of the item at minIndex, update minIndex
                //          with the new lowest value index */
                if (comparator.compare(arr[minIndex], arr[j]) > 0) {
                    // update minIndex with the new lowest value index
                    minIndex = j;
                }
            }
            // step 5: if minIndex has been updated, swap the values at minIndex and currentIndex
                K temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[120];
        Random random = new Random();
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(100);
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        };
        long t1 = System.nanoTime();
        selectionSort(integers, comparator);
        System.out.println(Arrays.asList(integers));
    }


}
