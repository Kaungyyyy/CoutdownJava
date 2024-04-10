package javaProject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CountdownProject {
	
		public static void main(String[] args) throws FileNotFoundException {
		
		Scanner fileScanner = new Scanner(new File("Countdown.txt"));
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> dictionary = new ArrayList<String>();
		
		while(fileScanner.hasNext()) {			
			dictionary.add(fileScanner.nextLine());
		}
		
		int vowels = 0;
		
		String p1Word = null;		
		String p2Word = null;
		
		int playerOneScore = 0;		
		int playerTwoScore = 0;
		
		for (int rounds = 1; rounds <= 10; rounds++) {

			System.out.print("Round " + rounds + "\n" );		
			boolean isValidInput = false;			
			while (!isValidInput) {			
			System.out.println("How many vowels would you like? (3-5): ");
				
			vowels = input.nextInt();
				
			if (vowels >= 3 && vowels <= 5) {	
			isValidInput = true;
				
				}				
				else {					
					System.out.println("Please enter a valid input.");
				}				
			} //while loop bracket
			
			
			String randomLetters = generateRandomLetters(vowels);
			System.out.println("Letters:" + randomLetters);
			
			
			
			String playerOneWord = getPlayerOneWord(p1Word);
			String playerTwoWord = getPlayerTwoWord(p2Word);
			
			
			if (trueOrFalse(playerOneWord, randomLetters) == false) {
				System.out.println(playerOneWord + "cannot be made from the random words!");				
			}
			
			else if (!isValidWords(playerOneWord, dictionary)) {				
				System.out.println(playerOneWord + "is not valid!");				
			}
			
			if(trueOrFalse(playerTwoWord, randomLetters) == false) {				
				System.out.println(playerTwoWord + " cannot be made from the random words!");				
			}
			else if(!isValidWords(playerTwoWord, dictionary)) {					
				System.out.println(playerTwoWord + "is not valid!"); 				
			}
			
			
			if (!trueOrFalse(playerOneWord, randomLetters) || !isValidWords(playerOneWord, dictionary)) {
	            playerOneWord = "";
	        }
	        if (!trueOrFalse(playerTwoWord, randomLetters) || !isValidWords(playerTwoWord, dictionary)) {
	            playerTwoWord = "";
	        }
				
	        int[] newScores = p1AndP2Score(playerOneWord, playerTwoWord, playerOneScore, playerTwoScore);
	        playerOneScore = newScores[0];
	        playerTwoScore = newScores[1];
	        
			System.out.println("Player One: " + playerOneScore);
			System.out.println("Player Two: " + playerTwoScore);
			
			longestAvailableWords(randomLetters,dictionary);
			
					} // for loop bracket
		
			whoIsWinner(playerOneScore,playerTwoScore);
		
			} // main bracket
	
	
	public static String generateRandomLetters(int vowelCount) {
	    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
	    
	    char[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q','R', 'S', 'T','V', 'W', 'X','Y', 'Z'};
	    
	    Random randomLetters = new Random();
	    
	    String randomVandC = "";
	    for (int i = 0; i < vowelCount; i++) {
	    	
	        char randomVowel = vowels[randomLetters.nextInt(vowels.length)];
	        
	        randomVandC = randomVandC +  randomVowel;
	    }

	    int consonantCount = 9 - vowelCount;

	    
	    for (int j = 0; j < consonantCount; j++) {
	    	
	        char randomConsonant = consonants[randomLetters.nextInt(consonants.length)];
	        
	        randomVandC = randomVandC + randomConsonant;
	    }   
	    return randomVandC;
	    
	}
	
	public static String getPlayerOneWord (String a) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Player 1, what is your word: ");
		
		return a = input.nextLine();	
	}
	
	public static String getPlayerTwoWord (String b) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Player 2, what is your word: ");
		
		return b= input.nextLine();	
	}
	
	
	
	public static Boolean trueOrFalse (String playerWords, String randomWords) {
		
		Boolean trueOrFalse = true;
		
		for(int i = 0; i < playerWords.length(); i++) {
			
			char ltr1 = playerWords.charAt(i);
			
			randomWords.indexOf(ltr1);
			
			if(randomWords.indexOf(ltr1) == -1) {
				
				trueOrFalse = false;
			}
			
		}
		
		return trueOrFalse;		
	}

	public static Boolean isValidWords(String fileWords,  List<String> validWords) {
	
			return validWords.contains(fileWords);
	
}

	public static int calculateScore(String word) {
	
			int lengthOfWord = word.length();
	
			if(lengthOfWord == 9) {
		
		return 18;
	}
	
		else return lengthOfWord;
}
		
	public static int[] p1AndP2Score (String playerOneWord, String playerTwoWord, int playerOneScore, int playerTwoScore) {
		int[] scores = new int[2];
		if(playerOneWord.length() > playerTwoWord.length()) {
			
			playerOneScore += calculateScore(playerOneWord);		
		}
		else if(playerOneWord.length() == playerTwoWord.length()) {
			
			playerOneScore += calculateScore(playerOneWord);
			
			playerTwoScore += calculateScore(playerTwoWord);			
		}
		
		else {
			
			playerTwoScore += calculateScore(playerTwoWord);			
		}
		
		scores[0] = playerOneScore;
		scores[1] = playerTwoScore;
		return scores;
	}
	
	public static void longestAvailableWords(String randomLetters, List<String> dictionary ) {
		ArrayList <String> avlWrds = new ArrayList<String>();
		
		for (int i = 0; i < dictionary.size(); i++) {
            String dictWord = dictionary.get(i);
            if (trueOrFalse(dictWord, randomLetters)) {
                avlWrds.add(dictWord);
            }
	}		
		int maxLength = 0;		
		ArrayList <String> longestWrds = new ArrayList<String>();
		
		for (int i = 0; i < avlWrds.size(); i++) {
            String word = avlWrds.get(i);
            int wordLength = word.length();
            if (wordLength > maxLength) {
                maxLength = wordLength;
                longestWrds.clear();
                longestWrds.add(word);
            } else if (wordLength == maxLength) {
                longestWrds.add(word);
            }
        }
		System.out.println ("Longest available words: " + longestWrds);
}
	public static void whoIsWinner(int playerOneScore, int playerTwoScore) {

		if(playerOneScore > playerTwoScore) {
			
			System.out.println("Winner is player one!");	}
		
		else if(playerOneScore < playerTwoScore) {
			
			System.out.println("Winner is player two!");
			
		}
		
		else {
			System.out.println("It's a tie!");
		}
	}
	
			
		
} 


	
	
		
		
	
		
		
		
	
		

	

	
	

