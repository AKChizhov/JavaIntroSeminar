package ToSeminar_06_01.src.Services;

import java.util.ArrayDeque;

public class CalculateImpl implements Calculate{
    public int[][] fillPole(int[] arrCoord, int[][] arr) {// Заполнение игрового поля препятствиями и началом
        // игры
        arr[arrCoord[2] - 1][arrCoord[3] - 1] = 1;// Начало игры
        int n = (int) (4 + (Math.random() * 2));// Рандомное задание кол-ва препятствий
        while (n > 0) {
            int tempX = (int) (0 + (Math.random() * (arr.length - 1)));
            int tempY = (int) (0 + (Math.random() * (arr[0].length - 1)));
            if (tempX != (arrCoord[2] - 1) | tempY != (arrCoord[3] - 1)) {// проверка начала игры вне препятствия
                arr[tempX][tempY] = -88;// Обозначение препятствия
                n--;// кол-во "правильных" расположений препятсвий - не в точке начала игры
            }
        }
        return arr;
    }
    public int[][] makePole(int[] myCoord) { // Массив под игровое поле
        int[][] arr = new int[myCoord[0]][myCoord[1]];
        return arr;
    }

    public int[][] findPath(int[] arrCo, int[][] arrPo) {// Поиск оптимального пути
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

    public int[][] swowPath(int[] arrCo, int[][] arr00) {// Визуализация оптимального пути
        ArrayDeque<Integer> path00 = new ArrayDeque<Integer>();
        int m = arr00.length;
        int n = arr00[0].length;
        path00.addFirst(m * n - 1);// Конец пути ( в алгоритме визуализации - начало пути)
        int temp = path00.getFirst();// --//--
        int indexStop = (arrCo[2] - 1) * n + arrCo[3] - 1;// начало пути ( в алгоритме визуализации - конец пути)
        while ((temp != indexStop) == true) {// Пока не в точке начала игры
            temp = path00.pollFirst();// Возврат с удалением
            for (int i = 1; i < 5; i++) {
                if (i == 1) {// сверху
                    if ((temp / n - 1) < 0) {// Что клетка сверху в границах поля
                    } else if ((arr00[temp / n - 1][temp % n]) < arr00[temp / n][temp % n]// что сверху число меньше,
                                                                                          // необх. условие
                            & (arr00[temp / n - 1][temp % n] != 0) & // Что не попали на уже помеченное
                            (arr00[temp / n - 1][temp % n]) != -88) {// Что сверху нет препятствия
                        arr00[temp / n][temp % n] = 0;// метим путь
                        path00.addLast(temp - n);// перемещение в клетку сверху
                    }
                } else if (i == 2) {// слева
                    if ((temp % n - 1) < 0) {
                    } else if ((arr00[temp / n][temp % n - 1] < arr00[temp / n][temp % n])
                            & (arr00[temp / n][temp % n - 1] != 0) &
                            (arr00[temp / n][temp % n - 1] != -88)) {
                        arr00[temp / n][temp % n] = 0;
                        path00.addLast(temp - 1);
                    }
                } else if (i == 3) {// внизу
                    if ((temp / n + 1) >= m) {
                    } else if ((arr00[temp / n + 1][temp % n] < arr00[temp / n][temp % n])
                            & (arr00[temp / n + 1][temp % n] != 0) &
                            (arr00[temp / n + 1][temp % n] != -88)) {
                        arr00[temp / n][temp % n] = 0;
                        path00.addLast(temp + n);
                    }
                } else if (i == 4) {// справа
                    if ((temp % n + 1) >= n) {
                    } else if ((arr00[temp / n][temp % n + 1] < arr00[temp / n][temp % n])
                            & (arr00[temp / n][temp % n + 1] != 0) &
                            (arr00[temp / n][temp % n + 1] != -88)) {
                        arr00[temp / n][temp % n] = 0;
                        path00.addLast(temp + 1);
                    }
                }
            }
        }
        return arr00;
    }


}
