// for an element with probable duplicacies, find first and last occurences of its index in array

public class firstAndLastIndexInArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 20, 50, 60, 60, 60, 70, 70, 80};
        int data = 20;
        int low = 0;
        int high = arr.length - 1;
        int fi = -1;
        int li = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(data < arr[mid]) {
                high = mid - 1;
            }
            else if(data > arr[mid]) {
                low = mid + 1;
            }
            /*else {
                fi = mid; // potential answer
                high = mid - 1;
            }*/
            /*else {
                li = mid; // potential answer
                low = mid + 1;
            }*/
        }
        System.out.println("First Index: " + fi);
        System.out.println("Last Index: " + li);
    }
}
