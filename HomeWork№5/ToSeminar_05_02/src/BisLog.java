package ToSeminar_05_02.src;
import ToSeminar_05_02.src.Services.Calculate;




public class BisLog {
    UsIntf ui;
    Calculate calc;
    public BisLog(UsIntf ui ,Calculate calc){
        this.ui = ui;
        this.calc = calc;
    }
    private void game() {
        ui.clearScreen();
        ui.inputWords();  
        int[] myCoord = ui.inputSize();
        int[][] myPole = calc.makePole( myCoord);
        ui.printArray(myPole);
        myPole = calc.fillPole( myCoord,myPole);
        ui.printArray(myPole);
        
    }
    public void run(){
      game();
    }
}
