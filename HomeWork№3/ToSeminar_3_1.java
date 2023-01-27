import java.util.Scanner;

public class ToSeminar_3_1
{  
    // Восходящая функция для подсчета всех путей из первой ячейки (0, 0)
    // к последней ячейке (M-1, N-1) в данной прямоугольной сетке `M × N`
    
    public static void main(String[] args)
    {
        inputWords();
        int[] myCoord = inputSize();
        printArrayBefore(myCoord[0], myCoord[1]);
        int myQ = countPaths(myCoord[0], myCoord[1]);
        printResult(myQ);
    }

    private static void inputWords() {
        System.out.println("\nПрямоугольное поле размера MxN (N, M меньше 20). В поле стоит фигура в точке(Х, Y),"+
            "которая может ходить на одну клетку \n\tвправо или вниз за один ход."+
            " Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку.\n");
    }

    public static int[] inputSize () {
        Scanner line = new Scanner(System.in); 
        System.out.print("Вводим размер поля MxN (N, M меньше 20) и начальные координаты фигуры (M0,N0)): ");
        String mn = line.nextLine();
        line.close();     
        String[] coordIn = mn.split(" ");
        int[] coordOut = new int[4];
        coordOut[0] = Integer.parseInt(coordIn[0]);
        coordOut[1] = Integer.parseInt(coordIn[1]);
        return coordOut;
    }

    private static void printArrayBefore(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
                System.out.print(" \t " + arr[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static int countPaths(int m, int n)
    {
        
        int[][] T = new int[m][n];// `T[i][j]` хранит количество путей из ячейки (0, 0) в ячейку (i, j)
        for (int i = 0; i < m; i++) { // В первом столбце двигаемся только вниз.
            T[i][0] = 1;
        }
        for (int j = 0; j < n; j++) { // В первой строке двигаемся только вправо.
            T[0][j] = 1;
        }
        for (int i = 1; i < m; i++) // заполняем `T[][]` снизу вверх
        {
            for (int j = 1; j < n; j++) {
                T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }
        for (int i = 0; i < T.length; i++) { //последняя ячейка `T[][]` хранит количество путей из ячейки (0, 0) в  ячейку (i, j)
			for (int j = 0; j < T[i].length; j++) {
                System.out.printf(" %10d",T[i][j]);
            }
            System.out.print("\n");
        }
        return T[m-1][n-1];          
    }
 
    private static void printResult(int n) {
        System.out.printf("Из указанной точки в конечную есть столько  путей : %d\n", n);
    }
}

