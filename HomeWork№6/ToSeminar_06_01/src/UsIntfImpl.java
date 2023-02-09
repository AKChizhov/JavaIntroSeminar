package ToSeminar_06_01.src;

import java.util.Scanner;

public class UsIntfImpl implements UsIntf {
    public void inputWords() {
        System.out.println(" \n\tЗадача нахождения кратчайшего пути на поле размерностью M x N "+
            "волновым методом (иначе методом Ли (Lee)).\n\tАлгоритм упрощен - возможность продвижения волны проверяется"+
            "по 4-м направлениям: вверх-налево-вниз-направо,без диагоналей\n");
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");// Очистка экрана
    }

    public int[] inputSize() {// Задание размерности поля (M,N) и начального положения фигуры(M0,N0)
        Scanner line = new Scanner(System.in);
        System.out.println("Вводим через пробел размер поля <MxN> (M, N меньше 14, для удобства )" +
                " нагляднее от <4 х 6> и координаты старта <M0,N0>): ");
        String mn = line.nextLine();
        line.close();
        String[] coordIn = mn.split(" ");
        int[] coordOut = new int[5];
        coordOut[4] = 1;// Переменная-flag для проверки правильности ввода
        for (int i = 0; i < 4; i++) {// Перевод в int
            coordOut[i] = Integer.parseInt(coordIn[i]);// Получение INT - массива начальных и граничных условий.
            if (coordOut[i] <= 0) {
                coordOut[4] = 0;// Присвоено некорректное значение
                System.out.printf("\n\tПрисвоено некорректное значение ( %d ) ", coordOut[i]);
            }
            if (coordOut[0] < coordOut[2] | coordOut[1] < coordOut[3]) {// Проверка входа за пределами поля
                System.out.println("\n\tПопытка входа в игру вне игрового поля - сколько сообщений - столько ошибок ");
                coordOut[4] = 0;
            }
        }
        return coordOut;
    }

    public void printArray(int[][] arr) {// Вид поля до начала игры
        int m = arr.length;
        int n = arr[0].length;
        System.out.println("\n");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" \t " + arr[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }
}