// toggle lower to upper case and vice-versa

import java.util.Scanner;

public class toggleTheCase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scn.next();

        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                char uch = (char)('A' + ch - 'a');
                sb.setCharAt(i, uch);
            }
            else {
                char lch = (char)('a' + ch - 'A');
                sb.setCharAt(i, lch);
            }
        }
        System.out.println(sb.toString());
    }
}
