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
        String oldName = " ";
        //Ввод пути и считывание выбранного файла
        while (!correctInput) {
            String file = in.nextLine();
            File fl = new File(file);
            path = file;

            try (FileReader fr = new FileReader(fl)) {
                path = fl.getParent();
                oldName = fl.getName();

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
        /*
        3 прохода по обработке кода:
            1 - удаление комментариев, лишних пробелов и переходов на другую строку;
            2 - замена идентификаторов переменных на более короткие;
            3 - замена имени класса и его конструкторов
         */

        finishCode = FirstPass.commentsDel(input);
        finishCode = SecondPass.IdentifierNameReplacing(finishCode);
        String[] thirdPassResult = ThirdPass.classNameReplacing(finishCode);
        finishCode = thirdPassResult[0];

        String newName = " ";
        //Создание папки в директории с выбранным кодом
        new File(path + "//minimized").mkdir();

        /*Если название файла уже было коротким, то название обработанного файла остаётся неизменным,
        иначе меняется в соответствии с классом
         */
        if(!thirdPassResult[1].equals(0)) {
            newName = thirdPassResult[1];
            FileOutputStream out = new FileOutputStream(path + "//minimized//" + newName + ".java");
            out.write(finishCode.getBytes());
            out.close();
        }else {
            FileOutputStream out = new FileOutputStream(path + "//minimized//" + oldName);
            out.write(finishCode.getBytes());
            out.close();
        }

        System.out.println("Сжатый вариант выбранного кода сохранён в папке minimized, которая находится в корневой папке обработанного кода");
    }

}
