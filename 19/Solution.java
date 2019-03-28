import java.io.*;
import java.util.*;

interface Search {
    int go(int index);
}

class FancyArray {

    private int[] arr;
    private int moves;
    private Search search = (int desired)-> {
        for(int iter = 0; iter < this.arr.length; iter++) {
            if(this.arr[iter] == desired) {
                return iter;
            }
        }
        return -1;
    };
    FancyArray(int n) {
        this.arr = new int[n];
        this.moves = 0;
    }

    public void getElements (String[] arrItems) {
        for (int i = 0; i < this.arr.length; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            this.arr[i] = arrItem;
        }
    }

    public int getMoves() {
        return this.moves;
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int takeThat = arr[i];
            int key = i - 1;
            while(key >= 0 && arr[key] > takeThat) {
                arr[key + 1] = arr[key--];
            }
            arr[key + 1] = takeThat;
        }
    }

    /**
     * @param arr - have to be sorted
     * @param desired - desired value
     * @return index
     */
    public static int binarySearch(int[] arr, int desired) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left + right) / 2;
            int guess = arr[mid];

            if(guess == desired) return mid;
            if(guess > desired) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    private void calcMoves(int[] sorted) {
        this.moves = 0;
        for(int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == sorted[i]) continue;
            else {
                try {
                    int index = this.search.go(sorted[i]);
                    int temp = this.arr[i];
                    this.arr[i] = this.arr[index];
                    this.arr[index] = temp;
                    this.moves++;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    this.moves = -1;
                }
            }
        }
    }

    public void init() {
        int[] sortedArr = this.arr.clone();
        insertionSort(sortedArr);
        this.calcMoves(sortedArr);
    }
}

public class Solution {



    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, Exception {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            FancyArray arr = new FancyArray(n);

            Thread thread = new Thread(() -> {
                arr.getElements(arrItems);
                arr.init();
            });

            thread.start();
            thread.join();

            int result = arr.getMoves();

            // System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();

            scanner.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
