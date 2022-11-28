import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ThirdPass {
    public static String[] classNameReplacing(String code){
        String result = code;

        Pattern commentPattern = Pattern.compile("class\\s(\\w{2,})\\s");
        Matcher matcher = commentPattern.matcher(result);
        if (!matcher.find()) {
            String[] relustinhArray = {result, 0 + ""};
            return relustinhArray;
        }

            int start = matcher.start();
            int end = matcher.end();
            String oldName = result.substring(start + 6, end - 1);
            String newName = ClassNames.giveNewClassName(oldName);
            result = matcher.replaceFirst("class " + newName + " ");
            result = result.replaceAll( (" " + oldName + "\\("), (" " + newName + "\\("));

            String[] relustinhArray = {result, newName};
        return relustinhArray;
    }
    private static String replacer(String code, String oldName, String newName){
        String result = code;

        result = result.replaceAll(oldName, newName);

        return result;
    }
}
