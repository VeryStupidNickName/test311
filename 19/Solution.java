import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


 	/*
	* Всякий раз, когда Гоша просит Лизу потусоваться, она занята домашним заданием. 
	* Гоша хочет помочь ей закончить это быстрее. Можете ли вы помочь Гоше понять домашнее 
	* задание Лизы, чтобы она могла погулять с ним? 
	* Рассмотрим массив различных целых чисел. Можно менять местами любые два элемента массива 
	* любое количество раз. Массив "красив", если сумма разностей двух соседних элементов минимальна.
	* sum(|qrr[i] - arr[i - 1]|) -> min
	* Определите минимальное количество перестановок, которые должны быть выполнены 
	* для того, чтобы сделать массив "красивым".
	*
	* 1 <= n <= 10e5
	* 1 <= qrr[i] <= 2*10e9
	*
	* Пример: 4
	*         2 5 3 1
	* Ответ: 2
	*        1 <=> 2, 2 <=> 5
	*
	* Пример: 3
	*         2 3 1
	* Ответ: 1
	*	 1 <=> 2
	*/


    static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int takeThat = arr[i];
            int key = i - 1;
            while(key >= 0 && arr[key] > takeThat) {
                arr[key + 1] = arr[key--];
            }
            arr[key + 1] = takeThat;
        }
    }

    static int IntArrIndexOf(int[] arr, int needle) {
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == needle) {
                index = i;
                break;
            }
        }
        return index;
    }

    static int calcMoves(int[] source, int[] sorted) {
        int moves = 0;

        for(int i = 0; i < source.length; i++) {
            if(source[i] == sorted[i]) continue;
            else {
                int index = IntArrIndexOf(source, sorted[i]);
                int temp = source[i];
                source[i] = source[index];
                source[index] = temp;
                moves++;
            }
        }
        return moves;
    }

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        int[] sourceArr = arr.clone();
        insertionSort(arr);
        return calcMoves(sourceArr, arr);




    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}