class FirstPass {
    public static String commentsDel(StringBuffer code){
        //Удаление комментариев
        String clearCode = code.toString();
        clearCode = clearCode.replaceAll("\\//.+","");
        clearCode = clearCode.replaceAll("/\\*(?s).*?\\*/","");
        clearCode = inOneLine(clearCode);
        return clearCode;
    }
    private static String inOneLine(String code){
        //Удаление переносов на новую строку
        String clearCode = code;
        clearCode = clearCode.replaceAll("\r\n", " ");
        clearCode = spaceDel(clearCode);
        return clearCode;
    }
    private static String spaceDel(String code){
        //Удаление лишних пробелов
        String clearCode = code;
        int counter = 0;
        String[] replacements = {"\\{", "\\}", "\\(", "\\)", "\\[", "\\]", "\\,", "\\.", "\\|","\\*", "\\+", "\\&", "\\|\\|", "\\&\\&",  "==", "=", "-", "<", ">", "<=", ">=", "!", "/", "%", ";"};
        clearCode = clearCode.replaceAll(" +", " ");
        for (String str:replacements) {
            if(counter < 12 || counter > 14 )
            clearCode = clearCode.replaceAll(("\\s*" + str + "\\s*"), String.valueOf(str.charAt(str.length() - 1)));
            else if(counter >= 12 && counter <= 14)
                clearCode = clearCode.replaceAll(("\\s*" + str + "\\s*"), String.valueOf(str.charAt(str.length() - 1)) + String.valueOf(str.charAt(str.length() - 1)));
            else if(counter == 19 || counter == 20)
                clearCode = clearCode.replaceAll(("\\s*" + str + "\\s*"), String.valueOf(str.charAt(str.length() - 2)) + String.valueOf(str.charAt(str.length() - 1)));
            counter++;
        }

        return clearCode;
    }
}
