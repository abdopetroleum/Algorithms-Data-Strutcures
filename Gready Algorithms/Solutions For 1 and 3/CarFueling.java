package GreedyAlgorithms;

import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int stops[], int n, int tank) {
        int numberOfRefills = 0;
        int currentRefill = 0;
        while (currentRefill <= n) {
            int lastRefill = currentRefill;
            while (currentRefill <= n && stops[currentRefill + 1] - stops[lastRefill] <= tank) {
                currentRefill = currentRefill + 1;
            }
            if (currentRefill == lastRefill) {
                return -1;
            }
            if (currentRefill <= n) {
                numberOfRefills = numberOfRefills + 1;
            }
        }
        return numberOfRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        stops[0] = 0;
        for (int i = 1; i <= n; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[n+1]=dist;
        System.out.println(computeMinRefills(stops, n, tank));
    }
}