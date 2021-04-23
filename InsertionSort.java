package Algorithms.SortingAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class InsertionSort {
    public static <K>void insertionSort(K arr[], Comparator<K> comparator){
        // start at the first index and iterate through to the end
        for (int i = 1; i < arr.length; i++)
        {
            int currentIndex = i;
            /*
             * Check:
             *      1. that currentIndex is at least 1
             *      2. that the item directly before the currentIndex is greater than the item at currentIndex
             *
             * If both conditions are met, swap the indexes
             */
            while (currentIndex > 0 && comparator.compare(arr[currentIndex-1],arr[currentIndex]) > 0)
            {
                K temp = arr[currentIndex];
                arr[currentIndex] = arr[currentIndex - 1];
                arr[currentIndex - 1] = temp;
                currentIndex--;
            }

        }
    }

    public static void main(String[] args) {
        Integer[] integers=new Integer[30];
        Random random=new Random();
        for (int i=0;i<integers.length;i++){
            integers[i]=random.nextInt(100);
        }
        Comparator<Integer> comparator= new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        };
        long t1=System.nanoTime();
        insertionSort(integers, comparator);
       System.out.println(Arrays.asList(integers));
    }



}
