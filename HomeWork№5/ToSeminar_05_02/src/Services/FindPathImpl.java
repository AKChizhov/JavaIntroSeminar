package ToSeminar_05_02.src.Services;

import java.util.ArrayDeque;

public class FindPathImpl {
    private static int[][] findPath(int[] arrCo, int[][] arrPo) {// Поиск оптимального пути
        ArrayDeque<Integer> pathLe = new ArrayDeque<Integer>();// Создание очереди
        int m = arrPo.length;// Для быстродействия считаетя один раз, а не в цикле, да и читабельнее
        int n = arrPo[0].length;// -- // --
        pathLe.addFirst((arrCo[2] - 1) * n + (arrCo[3] - 1));// точка начала игры
        while ((arrPo[m - 1][n - 1] == 0) == true) {    
            int temp = pathLe.pollFirst();
            for (int i = 1; i < 5; i++) {
                if (i == 1) {// Анализ что сверху
                    if ((temp / n - 1) < 0) {
                    } else if ((arrPo[temp / n - 1][temp % n]) == 0) {
                        arrPo[temp / n - 1][temp % n] = arrPo[temp / n][temp % n] + 1;
                        pathLe.addLast((temp / n - 1) * n + temp % n);
                    }
                } else if (i == 2) {// Анализ что слева
                    if ((temp % n - 1) < 0) {
                    } else if (arrPo[temp / n][temp % n - 1] == 0) {
                        arrPo[temp / n][temp % n - 1] = arrPo[temp / n][temp % n] + 1;
                        pathLe.addLast(temp - 1);
                    }
                } else if (i == 3) {// Анализ что внизу
                    if ((temp / n + 1) >= m) {
                    } else if (arrPo[temp / n + 1][temp % n] == 0) {
                        arrPo[temp / n + 1][temp % n] = arrPo[temp / n][temp % n] + 1;
                        pathLe.addLast((temp / n + 1) * n + temp % n);
                    }
                } else if (i == 4) {// Анализ что справа
                    if ((temp % n + 1) >= n) {
                    } else if (arrPo[temp / n][temp % n + 1] == 0) {
                        arrPo[temp / n][temp % n + 1] = arrPo[temp / n][temp % n] + 1;
                        pathLe.addLast(temp + 1);
                    }
                }
            }
        }
        return arrPo;
    }
}
