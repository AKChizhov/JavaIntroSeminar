package ToSeminar_06_01.src;

import ToSeminar_06_01.src.Services.Calculate;
import ToSeminar_06_01.src.Services.CalculateImpl;
import java.util.Formatter;

public class Main {
    public static void main(String[] args) throws Exception {
        UsIntf ui = new UsIntfImpl();
        Calculate calc = new CalculateImpl();
        Formatter f = new Formatter();
        BisLog log = new BisLog(ui, calc, f);
        log.run();
    }
}
