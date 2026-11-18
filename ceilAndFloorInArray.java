// find ceil (larger number) & floor (smaller number) in array

public class ceilAndFloorInArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int data = 52;
        int low = 0;
        int high = arr.length - 1;
        int ceil = 0;
        int floor = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(data < arr[mid]) {
                high = mid - 1;
                ceil = arr[mid];
            }
            else if(data > arr[mid]) {
                low = mid + 1;
                floor = arr[mid];
            }
            else {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }
        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }
}
