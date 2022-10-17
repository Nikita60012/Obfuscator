import java.io.*;

public class Main {
    public static void main(String[] args){
        String inpCode = " ";
        String code = " ";
        String  str;
        String[] editCode;
        try(BufferedReader br = new BufferedReader(new FileReader("InputProgram.java"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("OutputProgram.txt"))){
            while ((inpCode = br.readLine()) != null){
                code += inpCode;
            }
            str = code.replaceAll("/\\*.*\\*/", "");
            code = str;
            str = code.replaceAll("//.*(?=\\n)", "");
            code = str;
            code = splitter(code,"\r\n");

            //str = code.replaceAll("(\\/\\/.*)|(\\/\\*([\\S\\s]+?)\\*\\/)", " ");
            //code = str;
            code = splitter(code,"\\s");
            System.out.print(code);
            str = code.replace("inti","inta");
            code = str.replace("i<10", "a<10");
            str = code.replace("i++", "a++");
            System.out.println();
            System.out.print(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String splitter(String str, String regXp){
        String code = " ";
        String[] editCode;

        editCode = str.split(regXp);

        for (int i = 0; i < editCode.length; i++){
            code += editCode[i];
        }
        return code;
    }
}
