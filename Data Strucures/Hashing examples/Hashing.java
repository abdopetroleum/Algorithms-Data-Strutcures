package MyHashing;

import java.util.Scanner;

public class Hashing {

    public static void main(String[] args) {
        // array to act like hash table the index of each element is corresponding to its AscII Code
        // ascii table is lenghth is 256, but the first 128 is more commonly used. So, we assume that all input
        // characters are from the first 128 characters
        int[] repetitions = new int[128];
        Scanner scanner = new Scanner(System.in);
        String s = "";

        System.out.println("Enter The String");
        s = scanner.nextLine();


        // loop to calculate repetitions of each char in the repetitionss array
        for (int i = 0; i < s.length(); i++) {
            repetitions[hashChar(s.charAt(i))]++;
        }
        // vars to be ssigned to the indexof maxium repeated char and how much this char is repeated
        int indexOfMaximumRepeatedChar = 0;
        int repettionsOfMaximumRepeatedChar = 0;
        // loop to capture the indexof maxium repeated char and how much this char is repeated
        for (int i = 0; i < 128; i++) {
            if (repetitions[i] > repettionsOfMaximumRepeatedChar) {
                indexOfMaximumRepeatedChar = i;
                repettionsOfMaximumRepeatedChar = repetitions[i];
            }
        }
        // condtion to determine if the char is space or not and print the output
        if (indexOfMaximumRepeatedChar == 32) {
            System.out.println("Space " + repettionsOfMaximumRepeatedChar);
        } else {
            System.out.println((char) indexOfMaximumRepeatedChar + " " + repettionsOfMaximumRepeatedChar);
        }
    }

    // function to hash each char to its Ascii code
    public static int hashChar(char c) {
        return (int) c;
    }

}
