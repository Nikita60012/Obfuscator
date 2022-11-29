class FirstPass {
    public static String commentsDel(StringBuffer code){
        String clearCode = code.toString();
        clearCode = clearCode.replaceAll("\\//.+","");
        clearCode = clearCode.replaceAll("/\\*(?s).*?\\*/","");
        clearCode = inOneLine(clearCode);
        return clearCode;
    }
    private static String inOneLine(String code){
        String clearCode = code;
        clearCode = clearCode.replaceAll("\r\n", " ");
        clearCode = spaceDel(clearCode);
        return clearCode;
    }
    private static String spaceDel(String code){
        String clearCode = code;
        clearCode = clearCode.replaceAll(" +", " ");
        clearCode = clearCode.replaceAll(";\\s", ";");
        clearCode = clearCode.replaceAll("\\s*\\{\\s*", "\\{");
        clearCode = clearCode.replaceAll("\\s*\\}\\s*", "\\}");
        clearCode = clearCode.replaceAll("\\s*\\(\\s*", "\\(");
        clearCode = clearCode.replaceAll("\\s*\\)\\s*", "\\)");
        clearCode = clearCode.replaceAll("\\s*\\,\\s*", "\\,");
        clearCode = clearCode.replaceAll("\\s*=\\s*", "=");
        clearCode = clearCode.replaceAll("\\s*==\\s*", "==");
        clearCode = clearCode.replaceAll("\\s*<=\\s*", "<=");
        clearCode = clearCode.replaceAll("\\s*=>\\s*", "=>");
        clearCode = clearCode.replaceAll("\\s*\\+\\s*", "\\+");
        clearCode = clearCode.replaceAll("\\s*-\\s*", "-");
        clearCode = clearCode.replaceAll("\\s*\\*\\s*", "\\*");
        clearCode = clearCode.replaceAll("\\s*/\\s*", "/");
        return clearCode;
    }
}
