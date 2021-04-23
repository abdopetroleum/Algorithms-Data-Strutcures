package Algorithms.SortingAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BubbleSort {
    public static <K> void bubbleSort(K arr[], Comparator<K> comparator) {
        int n = arr.length;
        while (n > 0) {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++) {
                // if the item at the previous index is greater than the item at the `currentIndex`, swap them
                if (comparator.compare(arr[currentIndex - 1], arr[currentIndex]) > 0) {
                    // swap
                    K temp = arr[currentIndex - 1];
                    arr[currentIndex - 1] = arr[currentIndex];
                    arr[currentIndex] = temp;
                    // save the index that was modified
                    lastModifiedIndex = currentIndex;
                }
            }
            // save the last modified index so we know not to iterate past it since all proceeding values are sorted
            n = lastModifiedIndex;
        }
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[30];
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
        bubbleSort(integers, comparator);
        System.out.println(Arrays.asList(integers));
    }


}
