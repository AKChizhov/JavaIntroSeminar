import java.util.Scanner;

public class ToSeminar_04_01 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");//Очистка экрана
        inputWords();
        int[] myCoord = inputSize();//Ввод размерений поля и начального положения фигуры
        if(myCoord[4] != 1){
            System.out.printf("\n\t\t ДО СВИДАНИЯ !\n\n");
            return;
        }
        int[][] myPole = makePole(myCoord);
        System.out.println("\n\tИсходное игровое поле \n");
        int[][]  myArrPole = printArray(myPole);
        myArrPole = fillPole(myCoord, myArrPole);
        System.out.println("\n\tИгровое поле с преградами (обозначены -88) и точкой старта - (обозначена (1)) \n");
        printArray(myArrPole);
        System.out.println("\n");
        findPath(myArrPole);
    }

    private static void inputWords() {
        System.out.println(" \n\tЗадача нахождения кратчайшего пути на карте размерностью M x N \n");
    }

    public static int[] inputSize (){//Задание размерности поля (M,N) и начального положения фигуры(M0,N0)
        Scanner line = new Scanner(System.in); 
        System.out.print("Вводим через пробел размер поля MxN (M, N меньше 14) и начальные координаты фигуры (M0,N0)): ");
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

    private static int[][] makePole(int[] myCoord) {
        int[][] arr = new int[myCoord[0]][myCoord[1]];
        return arr;
    }

    private static int[][] printArray(int[][] arr) {//Вид поля до появления фигуры
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
                System.out.print(" \t " + arr[i][j]);
            }
            System.out.print("\n");
        }
        return arr;    
    }

    private static int[][] fillPole(int[] arrCoord, int[][] arr) {
        arr[arrCoord[2] - 1][arrCoord[3] - 1] = 1;
        int n = (int) ( 5 + (Math.random() * 2) );
        while(n > 0){
            int tempX = (int) (0 + (Math.random() * (arr.length - 2)) );
            int tempY = (int) (0 + (Math.random() * (arr[0].length - 2)) );  
            if(tempX != (arrCoord[2] - 1) & tempY != (arrCoord[3] - 1)){
                arr[tempX][tempY] = -88;
                n--;
            } 
        }     
        return arr;
    }

    private static int[][] findPath(int[][] arr) {

        return arr;
    }

}