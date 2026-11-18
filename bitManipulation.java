// all basic bit manipulation concept codes

public class bitManipulation {
    public static void main(String[] args) {
        int n = 5;
        int pos = 2;
        // get bit
        /*int bitMask = 1<<pos;
        if((bitMask & n) == 0) {
            System.out.println("bit was 0");
        }
        else {
            System.out.println("bit was 1");
        }*/

        // set bit
        /*int bitMask = 1<<pos;
        int newNum = bitMask | n;
        System.out.println("number is: " + newNum);*/

        // clear bit
        /*int bitMask = 1<<pos;
        int newNum = ((~(bitMask)) & n);
        System.out.println("number is: " + newNum);*/

        // update bit
        /*int up = 1;
        if(up == 1) {
            // set
            int bitMask = 1<<pos;
            int newNum = bitMask | n;
            System.out.println("number is: " + newNum);
        }
        else {
            // clear
            int bitMask = 1<<pos;
            int newNum = ((~(bitMask)) & n);
            System.out.println("number is: " + newNum);
        }*/
    }
}
