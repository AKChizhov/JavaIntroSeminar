import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ToSeminar_2_01 {

    public static void main(String[] args) throws IOException {
        final  String INFILE = "notes.txt";
        final  String OUTFILE = "notes_new.txt";
        String[] myNumbers = myReading(INFILE);
        myPrinting( myNumbers);
        int[] myCoef = myFind(myNumbers);
        myPrintingVisual (myCoef);
        myPrintingInFail (myCoef, OUTFILE);

    }

    public static String[] myReading(String myNumbers) throws FileNotFoundException{
        File file =  new File(myNumbers);
        Scanner scanner = new Scanner(file);        
        String line = scanner.nextLine();
        String[] numbeStrings = line.split(" ");
        scanner.close();
        String[] numbers = new String[6];
        int counter = 0;
        for(String number : numbeStrings) {
            numbers[counter++] = (number);
        }
        return numbers ;
    }

    public static void myPrinting(String[] name) {
        System.out.println(Arrays.toString(name));   
    }

    private static int[] myFind(String[] numbers) {
        String str1 = "a";
        String str2 = "b";
        int[] x = new int[3];
         x[0]= x[1] = x[2]= 0;
        for ( int i = 0; i < 6; i=i+2){
            if(numbers[i].equals(str1)) {
                x[0] = Integer.parseInt( numbers[i + 1]);
            }
            else if(numbers[i].equals(str2)) {
                x[1] = Integer.parseInt( numbers[i + 1]);
            }
            else {
                x[2] = Integer.parseInt( numbers[i + 1]);
            }
        }
        return x;
    }

    public static void myPrintingVisual(int[] x) {
        System.out.println(" a = "+x[0]+ " b = " + x[1] +" c = " +x[2]);
        System.out.println(" a ** b + c = "+ ( Math.pow(x[0], x[1]) + x[2])); 
    }

    private static void myPrintingInFail(int[] x, String name ) throws IOException {
        FileWriter newFile = new FileWriter(name);
        double result = Math.pow(x[0], x[1]) + x[2];
        newFile.write(" a ** b + c = "+ result);
        newFile.write("\n Where : a , b, c = "+x[0]+" "+x[1]+" "+x[2]);
        newFile.write("\n The calculation result is : "+ result);
        newFile.close();
    }
}
