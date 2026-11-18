// in a 2D array, 0s represent land and 1s represent water, find number of islands

import java.util.Scanner;

public class numberOfIslands {
    public static void drawTree(int[][] arr, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        drawTree(arr, i - 1, j, visited);
        drawTree(arr, i, j + 1, visited);
        drawTree(arr, i, j - 1, visited);
        drawTree(arr, i + 1, j, visited);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int m = scn.nextInt();
        System.out.print("Enter number of columns: ");
        int n = scn.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0 && visited[i][j] == false) {
                    drawTree(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println("Number of islands: " + count);
    }
}
