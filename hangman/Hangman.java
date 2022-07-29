
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static String randomWord(){
        int NumWords = words.length;
        int WordIndex = (int)((Math.random() * NumWords));
        String Word = words[WordIndex];
        return Word;
    }

    public static boolean checkGuess(char guess , char[] arr){
        for(int i =0; i<arr.length; i++){
            if (guess == arr[i]){
                return true;
            }
        }
        return false;
    }

    public static void updatePlaceHolders(char[] PlaceHolders, char[] arr, char guess){
        for(int i =0; i<PlaceHolders.length; i++){
            if(guess==arr[i]){
                PlaceHolders[i]=arr[i];
                
            }
        }
    }
    public static void printPlaceHolders(char[] PlaceHolders){
        for (int i =0; i< PlaceHolders.length;i++){
            System.out.print(PlaceHolders[i]+" ");
        }
    }

    public static void printMissedGuesses(char[] MissedGuesses){
        for(int i = 0; i<MissedGuesses.length;i++){
            System.out.print(MissedGuesses[i]);
        }
    }

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        
        String Word = randomWord();
        char[] WordArray = Word.toCharArray();
        char[] PlaceHolders = new char[WordArray.length];
        char[] MissedGuesses = new char[6];
        int NoOfMisses=0;
        for(int j=0; j<Word.length();j++){
            PlaceHolders[j]='_';
        }
        

        while (NoOfMisses < 6){
        System.out.println(gallows[NoOfMisses]);
        System.out.print("Word: ");
        printPlaceHolders(PlaceHolders);
        System.out.println();
        System.out.print("Misses:");
        printMissedGuesses(MissedGuesses);
        System.out.println();
        System.out.println();
        System.out.print("Guess: ");
        char guess = scan.next().charAt(0);
        

        if (checkGuess(guess, WordArray)){
            updatePlaceHolders(PlaceHolders, WordArray, guess);
        }
        else{
            MissedGuesses[NoOfMisses]=guess;
            NoOfMisses++;
        }
        
        if (Arrays.equals(PlaceHolders, WordArray)){
            System.out.println(gallows[NoOfMisses]);
            printPlaceHolders(PlaceHolders);
            System.out.println("Good Work");
            break;
        }
    }
    if(NoOfMisses==6){
        System.out.println(gallows[NoOfMisses]+"\n");
        System.out.println("RIP\n");
        System.out.println("The Word Was "+Word);
    }
    scan.close();
}

}



