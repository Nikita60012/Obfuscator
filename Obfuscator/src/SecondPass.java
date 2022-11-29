import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SecondPass {
    private static final String[] typesOfIdentifier = {
            "String", "int", "boolean", "double", "float", "BufferedWriter", "BufferedReader"};
    private static final int[] LengthsOfTypesNamesOfIdentifiers = {
            7, 4, 8, 7, 6, 15, 15};
    public static String IdentifierNameReplacing(String code) {
        String result = code;

        for (int i = 0; i < typesOfIdentifier.length; i++) {

            Pattern identifierPattern = Pattern.compile(typesOfIdentifier[i] + "\\s(\\w{2,})(\\s|;)");
            Matcher identifierMatcher = identifierPattern.matcher(result);
            while (identifierMatcher.find()) {

                int start = identifierMatcher.start();
                int end = identifierMatcher.end();
                String pattern = result.substring(start, end);
                String oldName = pattern.substring(LengthsOfTypesNamesOfIdentifiers[i], pattern.length() - 1);

                String newName = VariableNames.giveNewIdentifierName(oldName);

                result = replacer(result, "\\s*" + oldName + "\\s*", " " + newName + " ");
                //result = replacer(result, " " + oldName + ";", " " + newName + ";");
                result = replacer(result, "\\(|\\s|\\.|,|=|-|\\*|/|\\+|\\[|\\{|!" + oldName + "\\)|\\s|\\.|,|=|-|\\*|/|\\+|\\]|\\}|!|;",  newName);

            }
        }

        return result;
    }
    private static String replacer(String code, String oldName, String newName){
        String result = code;
        Pattern pattern = Pattern.compile(oldName);
        Matcher finder = pattern.matcher(result);
        finder.find();
        int start = finder.start();
        int end = finder.end();
        String begining = result.substring(start,start);
        String ending = result.substring(end,end);
        result = result.replaceAll(oldName, begining + newName + ending);

        return result;
    }
}
