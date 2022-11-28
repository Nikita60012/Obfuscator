import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ClassNames {
    private static int ReplacedNameCounter = 0;

    private static Map<String, String> BufferOfOldAndNewClassesName = new HashMap<>();


    private static String[] newsClassesName = new String[702];

    private static void namesGenerator(){
        int size = 0;
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUWXYZ".toCharArray();
        for(int i = 0; i < alphabet.length + 1; i++){
            for (int j = 0; j < alphabet.length; j++) {
                if(i == 0)
                    newsClassesName[size] = String.valueOf(alphabet[j]);
                else
                    newsClassesName[size] = (alphabet[i - 1] + "" + alphabet[j]);
                size++;
            }

        }
    }

    private static ArrayList<String> oldNames = new ArrayList<>();

    public static String giveNewClassName(String oldClassName){
        namesGenerator();
        if(!BufferOfOldAndNewClassesName.containsKey(oldClassName)){
            BufferOfOldAndNewClassesName.put(oldClassName, newsClassesName[ReplacedNameCounter]);
            oldNames.add(oldClassName);
        }
        ReplacedNameCounter++;
        return BufferOfOldAndNewClassesName.get(oldClassName);
    }
}
