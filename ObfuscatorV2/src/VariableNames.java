import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class VariableAndClassesNames {
    private static int ReplacedClassNameCounter = 0;
    private static int ReplacedNameCounter = 0;

    private static Map<String, String> BufferOfOldAndNewIdentifiersName = new HashMap<>();
    private static Map<String, String> BufferOfOldAndNewClassesName = new HashMap<>();

    private static  String[] newsIdentifiersName = new String[702];
    private static String[] newsClassesName = new String[702];

    private static ArrayList<String> oldVariableNames = new ArrayList<>();
    private static ArrayList<String> oldClassesNames = new ArrayList<>();

    //Генератор имён классов и переменных
    private static void namesGenerator(){
        int size = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabetUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for(int i = 0; i < alphabet.length + 1; i++){
            for (int j = 0; j < alphabet.length; j++) {
                if(i == 0) {
                    newsIdentifiersName[size] = String.valueOf(alphabet[j]);
                    newsClassesName[size] = String.valueOf(alphabetUp[j]);
                }
                else {
                    newsIdentifiersName[size] = (alphabet[i - 1] + "" + alphabet[j]);
                    newsClassesName[size] = (alphabetUp[i - 1] + "" + alphabetUp[j]);
                }
                size++;
            }

        }
    }

    public static String giveNewIdentifierName(String oldName){
        namesGenerator();
        if(!BufferOfOldAndNewIdentifiersName.containsKey(oldName)){
            BufferOfOldAndNewIdentifiersName.put(oldName, newsIdentifiersName[ReplacedNameCounter]);
            oldVariableNames.add(oldName);
        }
        ReplacedNameCounter++;
        return BufferOfOldAndNewIdentifiersName.get(oldName);
    }

    public static String giveNewClassName(String oldClassName){
        namesGenerator();
        if(!BufferOfOldAndNewClassesName.containsKey(oldClassName)){
            BufferOfOldAndNewClassesName.put(oldClassName, newsClassesName[ReplacedClassNameCounter]);
            oldClassesNames.add(oldClassName);
        }
        ReplacedClassNameCounter++;
        return BufferOfOldAndNewClassesName.get(oldClassName);
    }
}
