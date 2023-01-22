/*Написать программу вычисления n-ого треугольного числа.
  Где : input  - "треугольное число"(его размерность),
        result - значение "треугольного числа"
*/
import java.util.Arrays;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args){ //Точка входа
        System.out.print("\033[H\033[2J");//Очистка экрана
        int inNum = input();
        printTtiangle(inNum);
        summaTriangle(inNum);
        Req(inNum);
        System.out.printf("\n\n");
    }
    
    private static int input() { // Ввод вычисляемого числа
        Scanner in = new Scanner(System.in);
        System.out.print("Ввод размерности треугольного числа: ");
        int num = in.nextInt(); 
        System.out.printf("Введена размерность треугольного числа: %d \n", num);
        in.close();
        return num;
    }

    private static void printTtiangle(int num) { // " Визуальное представление "треугольного числа  
        System.out.printf("\nВизуальное представление 'треугольного числа' %d\n", num);
        for(int i = 1; i <= num ; i++){
            int[] myA = new int[i];
            for(int j = 1; j <= i ; j++){
                myA[j-1] = j;  
            }
            System.out.println (Arrays.toString( myA));
        }
    }

    private static int summaTriangle(int num) { //Вычисление "треугольного числа" по формуле f(n) =  0,5 * n * (n+1)
        int result = (int) (0.5 * num*(num +1));
        System.out.printf("\nЗначение треугольного числа (по формуле) при размерности %d равно %d\n", num ,result);
        return(result);
    }

    private static int Req(int num) { // Вычисление "треугольного числа" с использованием рекурсии
        int result = 1;
        if (num == 1 || num == 0) {
            System.out.printf("\nЗначение треугольного числа (с рекурcией) при размерности %d равно %d",num ,result);
            return result;
        }
        result = num + Req(num-1);  
        System.out.printf("\nЗначение треугольного числа (с рекурcией) при размерности %d равно %d",num ,result);
        return(result);
    }
}
