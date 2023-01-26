import java.io.*;
 
public class ToSeminar_2_02 {
    public static void main(String[] args) {
        String fileName = "notes1.txt";
        System.out.printf("File %s:%s%s", fileName, System.lineSeparator(), readFileToString(fileName));        
    }
 
    public static String readFileToString(String fileName) {
       StringBuilder sb = new StringBuilder();
       try (FileReader fileReader = new FileReader(new File(fileName));
            BufferedReader reader = new BufferedReader(fileReader)) {
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str.replaceAll(" ", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
        return sb.toString();
    }
}