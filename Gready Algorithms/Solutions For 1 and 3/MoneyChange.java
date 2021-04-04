package GreedyAlgorithms;
import java.util.Scanner;

public class MoneyChange {
    private static int getChange(int money) {
       int result=0;
       while (money>0){
           if (money>=10){
               money-=10;
           }else if (money>=5){
               money-=5;
           }else {
               money--;
           }
           result++;
       }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

