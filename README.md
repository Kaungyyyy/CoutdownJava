# CoutdownJava
For this project, you will write a program that facilitates the letters portion of the game show Countdown.
At the beginning of the program, read the file words.txt and store its contents. Do not open the file again.
The game occurs over the course of ten rounds.
At the beginning of each round, display the round number and ask the user how many vowels they would like. The user must enter a number from 3 to 5 inclusive; otherwise, tell the user that their entry is invalid and ask again until the user enters a valid answer. Then generate and display nine random letters including the specified number of vowels (within each category, generate letters independently at random with each letter given equal probability). For our purposes, Y is a consonant and not a vowel.
Following that, ask player one and then player two for their words. A word is valid if it appears in words.txt and can be formed from the randomly-generated letters. If a word uses a letter more than once, it must appear that many times in the randomly-generated letters. If one or both players have invalid words, display a reason why.
Next, display a list of the longest valid words from words.txt.
If both players have valid words, the player with the longer word scores. If both players have valid words of equal length, both players score. If only one player has a valid word, that player scores. If neither player has a valid word, neither player scores. The number of points scored is equal to the size of the word unless it has all nine letters; in that case, the player scores 18 points.
At the end of each round, give the updated total scores. At the end of the game, declare the winner (or a tie).
You may assume all user input is correctly formatted.
You will be graded on the correctness of your program as well as coding style such as indentation, variable names, and comments.

