import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class VariableNames {
    private static int ReplacedNameCounter = 0;

    private static Map<String, String> BufferOfOldAndNewIdentifiersName = new HashMap<>();

    private static  String[] newsIdentifiersName = new String[702];

    private static ArrayList<String> oldNames = new ArrayList<>();

    private static void namesGenerator(){
        int size = 0;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(int i = 0; i < alphabet.length + 1; i++){
            for (int j = 0; j < alphabet.length; j++) {
                if(i == 0)
                    newsIdentifiersName[size] = String.valueOf(alphabet[j]);
                else
                    newsIdentifiersName[size] = (alphabet[i - 1] + "" + alphabet[j]);
                size++;
            }

        }
    }

    public static String giveNewIdentifierName(String oldName){
        namesGenerator();
        if(!BufferOfOldAndNewIdentifiersName.containsKey(oldName)){
            BufferOfOldAndNewIdentifiersName.put(oldName, newsIdentifiersName[ReplacedNameCounter]);
            oldNames.add(oldName);
        }
        ReplacedNameCounter++;
        return BufferOfOldAndNewIdentifiersName.get(oldName);
    }
}
