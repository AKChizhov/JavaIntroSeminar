package ToSeminar_06_01.src;

import ToSeminar_06_01.src.Services.Calculate;

public class BisLog {
    UsIntf ui;
    Calculate calc;

    public BisLog(UsIntf ui, Calculate calc) {
        this.ui = ui;
        this.calc = calc;
    }

    private void game() {
        ui.clearScreen();
        ui.inputWords();
        int[] myCoord = ui.inputSize();
        int[][] myPole = calc.makePole(myCoord);
        String res = String.format("\n\tИсходное игровое поле размерностью %d- строк на %d- столбцов", myCoord[0],
                myCoord[1]);
        System.out.println(res);
        ui.printArray(myPole);
        myPole = calc.fillPole(myCoord, myPole);
        res = String.format("\tИгровое поле с преградами (обозначены <-88 >) и точкой старта - (обозначена < 1 >))");
        System.out.println(res);
        ui.printArray(myPole);
        myPole = calc.findPath(myCoord, myPole);
        res = String.format("\tИгровое поле с расчетом оптимального пути из точки < 1 > в точку < %d >" +
                "- правый нижний угол ", myPole[myCoord[0] - 1][myCoord[1] - 1]);
        System.out.println(res);
        ui.printArray(myPole);
        myPole = calc.swowPath(myCoord, myPole);
        res = String
                .format("\tИгровое поле с оптимальным путем (обозначенным < 0 >) из точки < 1 > в правый нижний угол");
        System.out.println(res);
        ui.printArray(myPole);
    }

    public void run() {
        game();
    }
}
