package Algorithms.SortingAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MergeSort {
        private static <K>void merge(K arr[],int low, int high,
                                 Class aClass, Comparator<K> comparator){

        int endOfArray1=low+(high-low)/2+1;
        int endOfArraytwo=high+1;
        int iterator1=low;
        int iterator2=low+(high-low)/2+1;
        K[] result=(K[])Array.newInstance(aClass,endOfArraytwo-low);
        for (int i=0;i<result.length;i++){
            if (iterator2>=endOfArraytwo||
                    (iterator1<endOfArray1&&comparator.compare(arr[iterator2],arr[iterator1])>0)){
                result[i]=arr[iterator1++];
            }else {
                result[i]=arr[iterator2++];
            }

        }
        System.arraycopy(result,0,arr,low,endOfArraytwo-low);
    }
    private static <K>void mergeSort(K arr[],int low, int high,
                                  Class aClass, Comparator<K> comparator){
        if (low>=high){
            return;
        }
        int middle=low+(high-low)/2;
        mergeSort(arr,low,middle,aClass,comparator);
        mergeSort(arr,middle+1,high,aClass,comparator);
        merge(arr,low,high,aClass,comparator);
    }
    public static <K>void mergeSort(K arr[],
                                     Class aClass, Comparator<K> comparator){
        mergeSort(arr,0,arr.length-1,aClass,comparator);

    }
    /*private static <K>void mergeSort2(K arr[],
                                     Class aClass, Comparator<K> comparator){
       for (int i=1;i<arr.length;i=i*2){
           for (int j=0;j<arr.length;j=j+2*i){
               merge(arr,j,j+2*i-1,aClass,comparator);
           }
       }

    }*/


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
        mergeSort(integers,Integer.class, comparator);
       System.out.println(Arrays.asList(integers));
    }



}
