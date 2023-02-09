package ToSeminar_06_01.src;

import ToSeminar_06_01.src.Services.Calculate;
import ToSeminar_06_01.src.Services.CalculateImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        UsIntf ui = new UsIntfImpl();
        Calculate calc = new CalculateImpl();
        BisLog log = new BisLog(ui, calc);
        log.run();
    }
}
