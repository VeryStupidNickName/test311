

	/*
	 * Реализовать функцию вычисляющую высоту дерева. Дерево растет в два цикла каждый год. Каждую весну его высота удваевается,
	 * каждое лето дерево прибавляет один метр. Дерево высаживается высотой 1 метр.
	 * Вычислить высоту дерева через n - циклов роста.
	 *
	 * Дано: t - количество тестовых примеров
	 *	n - количество циклов роста
	 *  	1 <= t <= 10
	 * 	0 <= t <= 60
	 * Пример:
	 *       2
	 *	0
	 *	4
	 *
	 * Решение:
	 *	1
	 *	7
	 */


	import java.util.Scanner;

	public class Solution {

		static void func1(int n, int cycles[])
		{
			int c;
			for(int k = 0; k < n; k++)
			{
				c = cycles[k];
				int lenWood = 1; // высота дерева
				for (int i = 0; i < c; i++)
				{
					lenWood = i % 2 == 0 ? lenWood * 2 : lenWood + 1;
				}
				System.out.println(lenWood);
			}
		}

		public static void main(String[] args)
		{
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();

			int[] cycles = new int[n]; //создаем массив тестовых примеров

			for (int i = 0; i < n; i++) //считываем в массив
			{
				cycles[i] = scanner.nextInt();
			}
			func1(n, cycles);
		}
	}