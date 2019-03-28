


import java.io.IOException;

import java.util.Scanner;

public class Solution {

    /* Учитель рисования просит класс открыть книги по номеру страницы.
     * Иван можете начать перелистывать страницы книги сначала или с конца.
     * Всегда переворачивает страницы по одной.  Когда открывает книгу, то 1 страница всегда находится справа.
     * Последняя страница может быть напечатана на одной странице,
     * зависит от количества страниц в книге.
     * Сколько раз минимум нужно Ивану перевернуть страницы, чтобы найти нужную.
     * Листать можно как сначала, так и с конца.*/

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите количество страниц в книге");
        int n = scanner.nextInt();
        System.out.println("\nНужная страница?");
        int p = scanner.nextInt();
        Test Qwerty = new Test();
        Qwerty.displayInfo(n, p);




    static int pageCount(int n, int p) {
        if (n%2 ==0)
            n++;
        int k = 0;
        if (n != 0 && p != 0) {
            if ((n / p) > 1) {
                k = p / 2;
            } else {
                k = Math.abs((n - p) / 2);
            }
        }
        return (k);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        System.out.println("Введите количество страниц в книге");
        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        System.out.println("\nНужная страница?");
        int p = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        int result = pageCount(n, p);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();
        System.out.println("\nМинимальное количество перевернутых страниц: "+result);

        scanner.close();

    }
}
// Применить объетно-ориентированный подход в решении задачи. Должен создаваться новй объект, назначаться ему свойства и вызываться метод, формирующий решение.
// НЕ уверен, что понял суть задания!
class Test{

    void displayInfo(int n, int p) {
        int k = 1;
        if (n % 2 == 0)
            n++;
        if (n != 0 && p != 0) {
            if ((n / p) > 1) {
                k = p / 2;
            } else {
                k = Math.abs((n - p) / 2);
            }
            System.out.println("\nМинимальное количество перевернутых страниц: " + k);
        }
    }
}