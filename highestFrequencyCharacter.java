// find character with highest frequency in string

import java.util.HashMap;
import java.util.Scanner;

public class highestFrequencyCharacter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scn.next();

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            }
            else {
                hm.put(ch, 1);
            }
        }

        char maxfc = str.charAt(0);
        for(Character key: hm.keySet()) {
            if(hm.get(key) > hm.get(maxfc)) {
                maxfc = key;
            }
        }
        System.out.println("Max Frequency Character is: " + maxfc);
    }
}
