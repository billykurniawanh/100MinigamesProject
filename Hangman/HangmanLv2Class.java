import java.util.*;

public class HangmanLv2Class{   
   private Set<String> wordList;
   private SortedSet<Character> guesses;
   private int guessesLeft;
   private String pattern;
   
   public HangmanLv2Class(Collection<String> dictionary, int length, int max){
      if (length < 1 || max < 0)
         throw new IllegalArgumentException();
               
      wordList = new TreeSet<>();
      guesses = new TreeSet<>();
      pattern = "";
      
      Iterator<String> iterator = dictionary.iterator(); 
      
      while (iterator.hasNext()){
         String s = iterator.next();
         if (s.length() == length)
            wordList.add(s);
      }
      
      for (int i = 0; i < length; i++){
         pattern += "- ";
      }
      
      guessesLeft = max;
   } 
   
   public Set<String> words(){
      return wordList;
   }
   
   public int guessesLeft(){
      return guessesLeft;
   }
   
   public SortedSet<Character> guesses(){
      return guesses;
   }
   
   public String pattern(){
      if (wordList.size() == 0)
         throw new IllegalStateException();
            
      return pattern;
   }
   
   public int record(char guess){
      if (wordList.size() == 0 || guessesLeft < 1)
         throw new IllegalStateException();
       
      else if (guesses.contains(guess))
         throw new IllegalArgumentException();
      
      guesses.add(guess);
      
      ArrayList<String> patternArray = new ArrayList<String>();
      
      Iterator<String> iterator = wordList.iterator(); 

      while (iterator.hasNext()){
         String word = iterator.next();
         String patternForWord = createPattern(word,guess);
         patternArray.add(patternForWord);
      }
            
      int count1 = 0;
      int best = 0;
      int index = 0;
      
      for(int i = 0; i < patternArray.size(); i++){
         for(int j = i; j < patternArray.size(); j++){
            if (patternArray.get(i).equals(patternArray.get(j)))
               count1++;
         }
         if (best < count1){
            index = i;
            best = count1;
         }
         count1 = 0;
      }
      
      String pickedPattern = patternArray.get(index);
      
      for(int i = 0; i < pattern.length(); i++){
         if(pattern.substring(i,i+1).equals("-") && pickedPattern.charAt(i) == guess)
            pattern = pattern.substring(0,i) + guess + pattern.substring(i+1);
      }
  
      Iterator<String> iterator2 = wordList.iterator(); 
      
      while (iterator2.hasNext()){
         if (!createPattern(iterator2.next(),guess).equals(pickedPattern)){
            iterator2.remove();
         }
      }
      
      int count2 = 0;
      for (int i = 0; i < pickedPattern.length(); i++){
        if(pickedPattern.charAt(i) == guess)
           count2++;
      }
      
      if (count2 == 0)
         guessesLeft--;
      
      return count2;
   }  
   
   public String createPattern(String word, char guess){
      String output = "";
      for(int i = 0; i < word.length(); i++){
         if (word.charAt(i) != guess)
            output += "- ";
         else
            output += Character.toString(guess) + " ";
      }
      return output;
   }   
}