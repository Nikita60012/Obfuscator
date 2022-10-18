package src;

import java.io.*;

public class Main {
    public static void main(String[] args){
        StringBuilder code = new StringBuilder();

        try(FileReader rd = new FileReader("InputProgram.txt")) {
            int textChar;
            while((textChar = rd.read()) != -1){
                code.append((char) textChar);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String editCode = code.toString();
        String str;
        editCode = editCode.replaceAll("(\\/\\/.*)|(\\/\\*([\\S\\s]+?)\\*\\/)", " ");

        str = replacer(editCode);

        str = splitter(str,"\\s");


        try(FileWriter wr = new FileWriter("OutputProgram.txt")) {
            wr.write(str);
            wr.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //String inpCode = " ";
        //String code = " ";
        //String  str;
        //String[] editCode;
       /*
       try(BufferedReader br = new BufferedReader(new FileReader("InputProgram.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("OutputProgram.txt"))){
            while ((inpCode = br.readLine()) != null){
                code += inpCode;
            }
            */
           // str = code.replaceAll("/\\*.*\\*/;
           // code = str;
           // str = code.replaceAll("//.*(?=\\n)", "");
            //code = str;
        /*
            code = splitter(code,"\r\n");

            str = code.replaceAll("(\\/\\/.*)|(\\/\\*([\\S\\s]+?)\\*\\/)", " ");
            code = str;
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
        */
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

    public static String replacer(String str){
        String code = " ";
        String[] editCode;
        String var = " ";

        editCode = str.split("\\s");

        for(int i = 0; i < editCode.length-1; i++){
            if(editCode[i].equals("String") || editCode[i].equals("int") || editCode[i].equals("float") || editCode[i].equals("boolean") || editCode[i].equals("void") || editCode[i].equals("class") || editCode[i].equals("InputStream") || editCode[i].equals("OutputStream") || editCode[i].equals("StringBuilder") || editCode[i].equals("StringBuffer")){
                var = editCode[i+1];

            }
        }

        for (int i = 0; i < editCode.length; i++){
            code += editCode[i];
        }
        code.replaceAll(var, "ok");
        return code;
    }
}
