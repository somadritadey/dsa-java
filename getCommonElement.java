// find all the common elements between a1 & a2 arrays

import java.util.HashMap;
import java.util.Scanner;

public class getCommonElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements 1: ");
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }
        System.out.print("Enter number of elements 2: ");
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int val: a1) {
            if(hm.containsKey(val)) {
                hm.put(val, hm.get(val) + 1);
            }
            else {
                hm.put(val, 1);
            }
        }
        System.out.println("Common Elements: ");
        for(int val: a2) {
            if(hm.containsKey(val) && hm.get(val) > 0) {
                System.out.println(val);
                hm.put(val, hm.get(val) - 1);
            }
        }
    }
}
