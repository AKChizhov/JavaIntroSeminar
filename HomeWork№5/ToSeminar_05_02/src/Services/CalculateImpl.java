package ToSeminar_05_02.src.Services;

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
}
