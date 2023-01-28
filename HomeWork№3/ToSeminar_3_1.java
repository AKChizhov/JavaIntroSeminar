/*  Динамическое программирование для подсчета всех путей из ячейки начального положения фигуры (M0,N0)
    к последней ячейке (M-1, N-1) в данном прямоугольном поле размерностью M × N
    Где : myQ - искомое кол-во маршрутов
          myArrBefore - массив для хранения игрового поля до и после игры (один для экономии памяти)
          myCoord - массив для размеров игрового поля и начального положения фигуры.
                    Замечание myCoord[4] переменная-flag для проверки ввода.
*/
import java.util.Scanner;
public class ToSeminar_3_1
{   public static void main(String[] args)//Точка входа
    {
        System.out.print("\033[H\033[2J");//Очистка экрана
        inputWords();
        int[] myCoord = inputSize();//Ввод размерений поля и начального положения фигуры
        if(myCoord[4] != 1){
            System.out.printf("\n\t\t ДО СВИДАНИЯ !\n\n");
            return;
        }
        System.out.println("\n\tИсходное игровое поле \n");
        int[][]  myArrBefore = printArrayBefore(myCoord[0], myCoord[1]);
        System.out.println("\n\tИгровое поле после игры\n");
        int myQ = countPaths(myCoord,myArrBefore);//вывод количества путей (маршрутов)
        printArrayResulte(myArrBefore);//Массив - ссылочный тип, можно не переприсваивать для вывода итогового поля
        printResult(myQ);
    }

    private static void inputWords() {//Вводная часть, чтобы не было индейского вопроса - "нахуа"
        System.out.println("\nПрямоугольное поле размера MxN (N, M меньше 14 - для наглядности на экране)."+
        " В поле стоит фигура в точке(Х, Y),которая может ходить\nна одну клетку вправо или вниз за один ход."+
            " Посчитать  количество  маршрутов, которыми  фигура может попасть в нижнюю правую клетку.\n");
    }

    public static int[] inputSize (){//Задание размерности поля (M,N) и начального положения фигуры(M0,N0)
        Scanner line = new Scanner(System.in); 
        System.out.print("Вводим через пробел размер поля MxN (N, M меньше 14) и начальные координаты фигуры (M0,N0)): ");
        String mn = line.nextLine();
        line.close();     
        String[] coordIn = mn.split(" ");
        int[] coordOut = new int[5];
        coordOut[4] = 1;//Переменная-flag для проверки правильности ввода
        for(int i =0;i < 4; i++){// Перевод в int
            coordOut[i] = Integer.parseInt(coordIn[i]);//Получение INT - массива начальных и граничных условий.
            if(coordOut[i] <=0){
                coordOut[4]  =0;//Присвоено некорректное значение
                System.out.printf("\n\tПрисвоено некорректное значение ( %d ) ",coordOut[i]);
            } 
        if(coordOut[0]<coordOut[2] | coordOut[1]<coordOut[3] ){//Проверка вход за пределами поля
            System.out.println("\n\tПопытка входа в игру вне игрового поля - сколько сообщений - столько ошибок ");
            coordOut[4] = 0;
        }        
        }    
        return coordOut;
    }

    private static int[][] printArrayBefore(int m, int n) {//Вид поля до появления фигуры
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
                System.out.print(" \t " + arr[i][j]);
            }
            System.out.print("\n");
        }
        return arr;
    }

    public static int countPaths(int[] arrIn , int[][] arr)
    {    
        int m = arrIn[0]; int n = arrIn[1]; //Перепресвоено для удобства и читаемости кода
        int m0 = arrIn[2]; int n0 = arrIn[3]; //Перепресвоено для удобства и читаемости кода

        for (int i = m0 - 1; i < m; i++) { // В первом столбце от ячейки (M0,N0) движение только вниз.
            arr[i][n0 - 1] = 1;
        }
        for (int j = n0 - 1; j < n; j++) { // В первой строке от ячейки (M0,N0) движение только вправо.
            arr[m0 - 1][j] = 1;
        }
        for (int i = m0 ; i < m; i++) // Заполнение arr[][] (массива - игрового поля) вправо-вниз
        {
            for (int j = n0 ; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];//последняя ячейка arr[][] хранит количество путей из ячейки (M0,N0) в крайнюю ячейку. 
            }
        }
        return arr[m-1][n-1];          
    }
 
    private static void printArrayResulte(int[][] arr) { //Вид поля после завершения игры
        for (int i = 0; i < arr.length; i++) { 
			for (int j =0; j < arr[i].length; j++) {
                System.out.printf(" %9d",arr[i][j]);//Вывод на экран, на поле 9 символов и пробел между
            }
            System.out.print("\n");
            }
    }

    private static void printResult(int n) {//Вывод итогового результата
        System.out.printf("\nИз указанной точки в конечную есть столько  путей (маршрутов) : %d\n\n", n);
    }
}


