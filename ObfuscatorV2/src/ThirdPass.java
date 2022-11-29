import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ThirdPass {
    public static String[] classNameReplacing(String code){
        String result = code;

        Pattern commentPattern = Pattern.compile("class\\s(\\w{2,})\\{");
        Matcher matcher = commentPattern.matcher(result);
        //При не нахождении названия класса в 2 и более символов, код остаётся без изменений
        if (!matcher.find()) {
            String[] relustinhArray = {result, 0 + ""};
            return relustinhArray;
        }

            int start = matcher.start();
            int end = matcher.end();
            String oldName = result.substring(start + 6, end - 1);
            String newName = VariableAndClassesNames.giveNewClassName(oldName);
            //Замена имени класса при объявлении
            result = matcher.replaceFirst("class " + newName + "\\{");
            //Замена имён конструкторов
            result = result.replaceAll( (" " + oldName + "\\("), (" " + newName + "\\("));
            String[] relustinhArray = {result, newName};
        return relustinhArray;
    }

}
