import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите полный путь до нужного файла");
        String finishCode;
        StringBuffer  input = new StringBuffer();
        Scanner in = new Scanner(System.in);
        boolean correctInput = false;
        String path = " ";
        while (!correctInput) {

            String file = in.nextLine();
            path = file;

            try (FileReader fr = new FileReader(file)) {
                int textChar;
                while ((textChar = fr.read()) != -1) {
                    input.append((char) textChar);
                    correctInput = true;
                }
            } catch (IOException e) {
                System.out.println("Путь до файла указан неверно, введите ещё раз");
                in.reset();
            }
        }
        finishCode = FirstPass.commentsDel(input);
        finishCode = SecondPass.IdentifierNameReplacing(finishCode);
        String[] thirdPassResult = ThirdPass.classNameReplacing(finishCode);
        finishCode = thirdPassResult[0];
        String newName = " ";
        if(!thirdPassResult[1].equals(0)) {
            newName = thirdPassResult[1];
        }else {
            Pattern pattern = Pattern.compile(" \\w+\\.java");
            Matcher matcher = pattern.matcher(path);
            matcher.find();
            int start = matcher.start();
            int end = matcher.end();
            newName = path.substring(start, end - 5) ;
        }

        new File("output/").mkdir();

        FileOutputStream out = new FileOutputStream("output//" + newName + ".java");
        out.write(finishCode.getBytes());
        out.close();

        System.out.println("Сжатый вариант выбранного кода сохранён в папке output, которая находится в корневой папке обфускатора");
    }

}
