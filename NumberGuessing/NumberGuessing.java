import java.util.Random;
import java.util.Scanner;

public class NumberGuessing{
   
   public static final int limit = 100;
      
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      introduction();
      System.out.println();
      int count = 0;
      int guess = 0;
      int fewest = limit+1; 
      String playagain = "";
      while (!playagain.equals("n")){
         int thisturn = game();
         guess+=thisturn;
         if (thisturn<fewest)
            fewest = thisturn;
         System.out.print("Do you want to play again? ");
         String answer = in.next();
         playagain = answer.substring(0,1);
         playagain = playagain.toLowerCase();
         System.out.println();
         count++;
      }
      result(count,guess,fewest);
   }
   
   public static void introduction(){
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(limit + " and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lorwer");
      System.out.println("than your guess.");
   }
   
   public static int game(){
      Random rand = new Random();
      Scanner in = new Scanner(System.in);
      int number = rand.nextInt(limit)+1;
      int guess = 0;
      int count = 0;
      System.out.println("I'm thinking of a number between 1 and " + limit + "...");
      while (guess!=number){
         System.out.print("Your guess? ");
         guess = in.nextInt();
         count+=1;
         if (count==1 && guess==number)
            System.out.println("You got it right in 1 guess");
         else if (guess<number)
            System.out.println("It's higher.");
         else if (guess>number)
            System.out.println("It's lower.");
      }
      System.out.println("You got it right in " + count + " guesses");
      return count;
   }
   
   public static void result(int total, int guesses, int best){
      System.out.println("Overall results: ");
      System.out.println("\ttotal games   = " + total);
      System.out.println("\ttotal guesses = " + guesses);
      System.out.printf("\tguesses/game  = " + "%.1f\n",guesses/(double)total);
      System.out.println("\tbest game     = " + best);
   }
}