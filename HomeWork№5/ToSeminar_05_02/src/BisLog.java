package ToSeminar_05_02.src;
import ToSeminar_05_02.src.Services.Calculate;
import java.util.Formatter;



public class BisLog {
    UsIntf ui;
    Calculate calc;
    Formatter f;
    public BisLog(UsIntf ui ,Calculate calc, Formatter f){
        this.ui = ui;
        this.calc = calc;
        this.f = f;
    }
    private void game() {
        ui.clearScreen();
        ui.inputWords();  
        int[] myCoord = ui.inputSize();
        int[][] myPole = calc.makePole( myCoord);  
        f.format("\n\tИсходное игровое поле размерностью %d - строк на %d - столбцов\n\n", myCoord[0],myCoord[1]);
        ui.printMessage(f.toString());
        ui.printArray(myPole);
        myPole = calc.fillPole( myCoord,myPole);
        f.format("\n\tИгровое поле с преградами (обозначены <-88 >) и точкой старта - (обозначена < 1 >))\n");
        ui.printMessage(f.toString());
        f.format("\n\tИгровое поле с преградами (обозначены <-88 >) и точкой старта - (обозначена < 1 >))\n");
        ui.printMessage(f.toString());
        ui.printArray(myPole);
        myPole = calc.findPath(myCoord, myPole);
        ui.printArray(myPole);
        myPole = calc.swowPath(myCoord, myPole);
        ui.printArray(myPole);
    }
    public void run(){
      game();
    }
}
