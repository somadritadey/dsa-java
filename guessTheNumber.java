// guess the number game

import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int myNumber = (int)(Math.random()*100);
        int userNumber;

        do {
            System.out.println("Guess my number (1-100): ");
            userNumber = sc.nextInt();

            if(userNumber == myNumber) {
                System.out.println("CORRECT!");
                break;
            }
            else if(userNumber > myNumber) {
                System.out.println("Too large");
            }
            else {
                System.out.println("Too small");
            }
        } while(userNumber >= 0);

        System.out.println("My number was: ");
        System.out.println(myNumber);
    }
}
