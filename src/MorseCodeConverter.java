import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This class contains a static MorseCodeTree object and two static methods to convert from
 * Morse Code to English. There is also a static printTree method that is used for testing
 * purposes
 * @author John Mobarry
 */
public class MorseCodeConverter {

public static MorseCodeTree tree;
public static String answer;
public static String[] codes;

    /**
     * Converts a file of MorseCode into English. Each letter is delimited by a space.
     * @param codeFile
     * @return String
     * @throws FileNotFoundException
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException{
    tree = new MorseCodeTree();
    answer = "";
    try{
        Scanner keyboard = new Scanner(codeFile);
        while(keyboard.hasNextLine()){
            codes = keyboard.nextLine().split(" ");
            for(int i = 0; i < codes.length; i++){
                answer+= tree.fetch(codes[i]);
            }
        }
        keyboard.close();
        return answer;
    } catch(IOException e){
        throw new FileNotFoundException();
    }
}

    /**
     * This method converts an entered MorseCode string into English
     * @param code
     * @return String
     */
    public static String convertToEnglish(String code){
    tree = new MorseCodeTree();
    answer = "";
    codes = code.split(" ");

    for(int i = 0; i <codes.length; i++){
        answer += tree.fetch(codes[i]);
    }
    return answer;
}
    /**
     * This method returns a string with all the data in the tree in LNR order with a space between them
     * @return String
     */
    public static String printTree(){
    tree = new MorseCodeTree();
    String answer = "";
    for(String let: tree.toArrayList()){
        answer+= let += " ";
    }
    return answer.substring(0,answer.length()-1);
}
}
