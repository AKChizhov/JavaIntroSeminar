import java.util.ArrayDeque;
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
        findPath(myCoord, myArrPole);
        System.out.printf("\n\tИгровое поле с расчетом оптимальным путем из точки < 1 > в точку < %d >\n\n",+
                                    myArrPole[myCoord[0]-1][myCoord[1] - 1]);
        printArray(myArrPole);
        System.out.println("\n\tИгровое с оптимальным путем, отмеченным < 0 >\n");
        swowPath(myCoord, myArrPole);
        printArray(myArrPole);
        System.out.println("\n");
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
        if(coordOut[0]<coordOut[2] | coordOut[1]<coordOut[3] ){//Проверка входа за пределами поля
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
        int n = (int) ( 4 + (Math.random() * 2) );
        while(n > 0){
            int tempX = (int) (0 + (Math.random() * (arr.length - 1)) );
            int tempY = (int) (0 + (Math.random() * (arr[0].length - 1)) );  
            if(tempX != (arrCoord[2] - 1) | tempY != (arrCoord[3] - 1)){
                arr[tempX][tempY] = -88;
                n--;
            } 
        }     
        return arr;
    }

    private static int[][] findPath(int[]arrCo, int[][] arrPo) {
        ArrayDeque<Integer> pathLe = new ArrayDeque<Integer>();
        int m = arrPo.length;
        int n = arrPo[0].length;
        pathLe.addFirst((arrCo[2] - 1) * n + ( arrCo[3] - 1));
        while((arrPo[m - 1][n - 1] == 0) == true){
            int temp =  pathLe.pollFirst();
            for(int i = 1; i < 5; i++){
                if(i == 1){
                    if( (temp / n - 1) < 0 ){}
                    else if((arrPo[temp /n - 1][temp % n]) == 0 ){
                        arrPo[temp/ n - 1][temp % n] = arrPo[temp / n][temp % n] +1;
                        pathLe.addLast((temp/ n - 1) * n + temp % n);
                    }   
                }
                else if( i == 2){
                    if( (temp % n - 1) < 0) {} 
                    else if( arrPo[temp / n][temp % n - 1] == 0){
                        arrPo[temp/ n][temp % n - 1] = arrPo[temp / n][temp % n ]+ 1;
                        pathLe.addLast(temp - 1);
                    }   
                }
                else if( i == 3){
                    if( (temp / n + 1) >= m){} 
                    else if( arrPo[temp / n + 1][temp % n] == 0 ){
                        arrPo[temp/ n + 1][temp % n] = arrPo[temp / n][temp % n] +1;
                        pathLe.addLast((temp/ n + 1) * n + temp % n);
                    }   
                }
                else if(i == 4){
                    if( (temp % n + 1) >= n) {}
                    else if( arrPo[temp / n][temp % n + 1] == 0 ){
                        arrPo[temp/ n][temp % n + 1] = arrPo[temp /n][temp % n] + 1;
                        pathLe.addLast(temp + 1);
                    }   
                }
            }
        }
        return arrPo;
    }

    private static int[][] swowPath(int[] arrCo, int[][] arr00) {
        ArrayDeque<Integer> path00 = new ArrayDeque<Integer>();
        int m = arr00.length;
        int n = arr00[0].length;
        path00.addFirst(m * n - 1);
        int temp = path00.getFirst();
        int indexStop = (arrCo[2] -1) * n + arrCo[3] - 1;
        System.out.println("\n\t"+indexStop);
        //while((arr00[arrCo[2] - 1][arrCo[3] - 1] != 0) == true) {
        while((temp != indexStop) == true) {    
            temp =  path00.pollFirst();
            System.out.println("\n\t"+temp);
            for(int i = 1; i < 5; i++){
                if(i == 1){
                    if( (temp / n - 1) < 0 ){}
                    else if((arr00[temp/n - 1][temp % n]) < arr00[temp/n][temp % n] & (arr00[temp/n - 1][temp % n]!= 0) & 
                    (arr00[temp/n - 1][temp % n]) != - 88){
                        arr00[temp / n][temp % n] = 0;
                        //arr00[temp/ n - 1][temp % n] = 0;
                        path00.addLast(temp - n);
                    }   
                }
                else if( i == 2){
                    if( (temp % n - 1) < 0) {} 
                    else if( (arr00[temp / n][temp % n - 1] <  arr00[temp / n][temp % n ]) & (arr00[temp/ n][temp % n - 1] != 0) & 
                    (arr00[temp/ n][temp % n - 1] != -88)){
                        arr00[temp / n][temp % n] = 0;
                        //arr00[temp/ n][temp % n - 1] = 0;
                        path00.addLast(temp - 1);
                    }   
                }
                else if( i == 3){
                    if( (temp / n + 1) >= m){} 
                    else if(( arr00[temp / n + 1][temp % n] < arr00[temp / n][temp % n]) & ( arr00[temp/ n + 1][temp % n] != 0) &
                    ( arr00[temp/ n + 1][temp % n] != -88)){
                        arr00[temp / n][temp % n] = 0;
                        //arr00[temp/ n + 1][temp % n] = 0;
                        path00.addLast(temp + n);
                    }   
                }
                else if(i == 4){
                    if( (temp % n + 1) >= n) {}
                    else if(( arr00[temp / n][temp % n + 1] < arr00[temp /n][temp % n]) & (arr00[temp/ n][temp % n + 1] != 0) &
                    (arr00[temp/ n][temp % n + 1] != - 88)){
                        arr00[temp / n][temp % n] = 0;
                        //arr00[temp/ n][temp % n + 1] = 0;
                        path00.addLast(temp + 1);
                    }   
                }
            }
        }
        System.out.println(path00);
        return arr00;
    }
}