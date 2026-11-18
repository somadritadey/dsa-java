import java.util.Scanner;

public class patternQuestions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // 1
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println(" ");
        }
        */

        // 2
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println(" ");
        }
        */

        // 3
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i - 1; j++) {
                System.out.print("\t");
            }
            for(int j = i; j <= n; j++) {
                System.out.print("*\t");
            }
            System.out.println(" ");
        }
        */

        // 4
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i - 1; j++) {
                System.out.print("\t");
            }
            for(int j = i; j <= n; j++) {
                System.out.print("*\t");
            }
            System.out.println(" ");
        }
        */

        // 5
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = 1; i <= n ; i++) {
            for(int sp = 1; sp <= (n - i); sp++) {
                System.out.print("\t");
            }
            for(int st = 1; st <= (2 * i - 1); st++) {
                System.out.print("*\t");
            } 
            System.out.println();
        }
        for(int i = n - 1; i >= 1; i--) {
            for(int sp = 1; sp <= (n - i); sp++) {
                System.out.print("\t");
            }
            for(int st = 1; st <= (2 * i - 1); st++) {
                System.out.print("*\t");
            } 
            System.out.println();
        }
        */

        // 6
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = 1; i <= n ; i++) {
            for(int st = 1; st <= (n - i + 1); st++) {
                System.out.print("*\t");
            }
            for(int sp = 1; sp <= (2 * i - 1); sp++) {
                System.out.print("\t");
            }
            for(int st = 1; st <= (n - i + 1); st++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
        for(int i = n - 1; i >= 1; i--) {
            for(int st = 1; st <= (n - i + 1); st++) {
                System.out.print("*\t");
            }
            for(int sp = 1; sp <= (2 * i - 1); sp++) {
                System.out.print("\t");
            }
            for(int st = 1; st <= (n - i + 1); st++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
        */

        // 7
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i - 1; j++) {
                System.out.print("\t");
            }
            System.out.println("*");
        }
        */

        // 8
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i - 1; j++) {
                System.out.print("\t");
            }
            System.out.println("*");
        }
        */

        // 9
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j || i + j == n + 1) {
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println(" ");
        }
        */

        // 10
        /*
        System.out.println("Enter the number: ");
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int os = 1; os <= n - i; os++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for(int is = 1; is <= 2 * i - 3; is++) {
                if(i == 1) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("\t");
                }
            }
            if(i == 1) {
                System.out.println(" ");
            }
            else {
                System.out.println("*\t");
            }
        }
        for(int i = n - 1; i >= 1; i--) {
            for(int os = 1; os <= n - i; os++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for(int is = 1; is <= 2 * i - 3; is++) {
                if(i == 1) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("\t");
                }
            }
            if(i == 1) {
                System.out.println(" ");
            }
            else {
                System.out.println("*\t");
            }
        }
        */

        // check rest of the questions from pepcoding playlist too!
    }
}
