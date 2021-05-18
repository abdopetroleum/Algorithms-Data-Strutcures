package DataStructures.Trees.PriorityQueuesPackage;

import java.util.Comparator;

public class Example {
    Comparator<Integer> Ascending=new Comparator<Integer>() {
        @Override
        public int compare(Integer x1, Integer x2) {
            if(x1<x2){
                return -1;
            }else {
                return 1;
            }
        }
    };
    Comparator<Integer> descending=new Comparator<Integer>() {
        @Override
        public int compare(Integer x1, Integer x2) {
            if(x1>x2){
                return -1;
            }else {
                return 1;
            }
        }
    };
}
