import java.io.*;
import java.util.*;

public class HangmanLv1{
   
   public static final int maxWrong = 5;

   public static void main(String[] args) throws FileNotFoundException{
      System.out.println("Let's play a game of word guess.");
      System.out.println("You can guess wrong up to " + maxWrong + " times.");
      System.out.println();
      PlayGame();
   }
   
   public static String[] LoadInput() throws FileNotFoundException{ //Inserting the phrases in the file to an array
      Scanner phrasesInput = new Scanner(new File("DictionaryLv1.txt"));
      int numberOfLines = phrasesInput.nextInt();
      String[] phrasesArray = new String[numberOfLines];
      String phrases = phrasesInput.nextLine();
      int line = 0;
      while (phrasesInput.hasNextLine()){
         phrases = phrasesInput.nextLine();
         phrasesArray[line] = phrases;
         line++;
      }
      return phrasesArray;
   }
   
   public static String PickPuzzle(String[] a){ //Choosing a random phrase to be used in the game
      Random rand = new Random();
      int number = rand.nextInt(a.length);
      String words = a[number];
      return words;
   }
         
   public static void PlayGame() throws FileNotFoundException{ //Playing one game of hangman
      String[] array = LoadInput();
      String puzzle = PickPuzzle(array);
      String variable = puzzle;
      variable = variable.replace(" ","");
      boolean[] values = new boolean[variable.length()];
      //check for special character (code below)
      int symbolIndex1 = variable.indexOf(",");
      int symbolIndex2 = variable.indexOf("-");
      int symbolIndex3 = variable.indexOf("!");
      int symbolIndex4 = variable.indexOf(".");
      int symbolIndex5 = variable.indexOf("'");
      while (symbolIndex1!=-1){
         values[symbolIndex1] = true;
         symbolIndex1 = variable.indexOf(",",symbolIndex1 + 1);
      }
      while (symbolIndex2!=-1){
         values[symbolIndex2] = true;
         symbolIndex2 = variable.indexOf("-",symbolIndex2 + 1);
      }
      while (symbolIndex3!=-1){
         values[symbolIndex3] = true;
         symbolIndex3 = variable.indexOf("!",symbolIndex3 + 1);
      }
      while (symbolIndex4!=-1){
         values[symbolIndex4] = true;
         symbolIndex4 = variable.indexOf(".",symbolIndex4 + 1);
      }
      while (symbolIndex5!=-1){
         values[symbolIndex5] = true;
         symbolIndex5 = variable.indexOf("'",symbolIndex5 + 1);
      }
      //check for special character (code above)
      int tries = 0;
      Scanner userInput = new Scanner(System.in);
      boolean finalCheck = false;
      while (finalCheck != true){
         PrintPuzzle(variable,values);
         System.out.println();
         System.out.print("Guess a letter > ");
         char answer = userInput.next().charAt(0);
         int times = CheckGuess(answer,variable,values);
         if (times!=0)
            System.out.println(answer + " was found in the puzzle " + times + " times.");
         else{
            tries++;
            System.out.println(answer + " was not in the puzzle.");
            System.out.println("You have " + (maxWrong - tries) + " more incorrect tries.");
         }
         finalCheck = CheckIfSolved(values);
         if (finalCheck){
            System.out.println();
            System.out.println("You solved the puzzle! Good job!");
         }
         else if (maxWrong - tries == 0){
            System.out.println();
            System.out.println("You have reached the max guesses.");
            System.out.println("The puzzle was " + puzzle);
            finalCheck = true;
         }
         System.out.println();   
      }      
   }
   
   public static void PrintPuzzle(String b, boolean[] c){ //A method to setup the printing of puzzle    
      for (int i = 0; i<c.length; i++){
         if (c[i])
            System.out.print(b.charAt(i) + " ");
         else
            System.out.print("_ ");
      }
   }
   
   public static boolean CheckIfSolved(boolean[] d){ //Checking if the user had solved the puzzle or not
      for (int i = 0; i<d.length; i++){
         if (!d[i])
            return false;
      }
      return true;
   }

   public static int CheckGuess(char e, String f, boolean[] g){ //Checking if the character input is in the puzzle or not
      int countLetter = 0;
      char upper = Character.toUpperCase(e);
      char lower = Character.toLowerCase(e);
      int length = f.length();
      for (int i = 0; i<length; i++){
         if (upper == f.charAt(i) || lower == f.charAt(i)){
            g[i] = true;
            countLetter++;
         }
      }
      return countLetter;
   }
   
}