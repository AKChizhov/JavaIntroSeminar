package ToSeminar_05_02.src;

import ToSeminar_05_02.src.Services.Calculate;
import ToSeminar_05_02.src.Services.CalculateImpl;

//import BisLog;

public class Main {
    public static void main(String[] args) throws Exception {
        UsIntf ui = new UsIntfImpl();
        Calculate calc = new CalculateImpl();
        BisLog log = new BisLog(ui, calc);
        log.run();
    }
}
