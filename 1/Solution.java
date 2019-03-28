import java.util.Scanner;

public class Solution 
{
	/*
	 * создать обьект и выполнять его в отдельном потоке
	 * лябмда выражение
	 */
	public static void main(String[] args) {
		
		Thread thread1 = new Thread (
				() -> new RunnerL().run()
				);
		thread1.start();
	}
   
}

class RunnerL implements Runnable 
{

    @Override
    public void run() 
    {
    	new ObjectTriangle().Object();
    }
}

class ObjectTriangle
{
	/*
     *  Дано n - число уровней. Построить треугольник из символов #.
     *  Пример для n = 4:
     *	   #
     *	  ##
     *	 ###
     *	####
     */
	
	static void CreteTriangle(int n) 
	{

        int c = n - 1;
        for (int i = 0; i < n; i++) {
            for (int t = 0; t < n; t++) {
                System.out.print(c <= t ? "#" : " ");
            }
            System.out.println();
            c--;
        }
    }
	
	public void Object() 
	{
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        CreteTriangle(n);
    }
}

