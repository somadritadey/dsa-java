import java.util.HashMap;
import java.util.Scanner;

public class longestConsecutiveSeq {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int val: arr) {
            map.put(val, true);
        }
        for(int val: arr) {
            if(map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int ml = 0; // max length
        int msp = 0; // max start point
        for(int val: arr) {
            if(map.get(val) == true) {
                int tl = 0; // temporary length
                int tsp = val; // temporary start point
                while(map.containsKey(tsp + tl)) {
                    tl++;
                }
                if(tl > ml) {
                    ml = tl;
                    msp = tsp;
                }
            }
        }
        for(int i = 0; i < ml; i++) {
            System.out.println(msp + i);
        }
    }
}
