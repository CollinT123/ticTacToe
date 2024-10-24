Welcome to my Tic-Tac-Toe project
---------------------------------

Here I will highlight the different classes and methods used and my thought process when creating each one. This project was done after completing my intro year of programming to practice the basic concepts of object oriented programming and recursion.

My goal in this project was not only to create a working TicTacToe game using a CLI but to create a working artificial intelligence. Also to practice compartmentalizing my code, meaning to create readable method headers and parameters so someone could use the class without knowing how it works. I also learned a lot about the difference between using primitive	and non primitive data types, and how they are passed as parameters. 

Cell-
	The cells are what each TTTBoard is made up of. They are passed a cell number as a String and contain getters and setters for their contents.

TTTBoard-
	The constructor creates an Array of Cells from 1-9. It contains the methods to make moves, a toString override, and the ability to check if either player has met a win condition. It also has the ability to throw TTTExceptions, this is used to prevent crashes for out of bounds or already full spaces. 

TTTAI - 
	This class contains two functions, makeMove and simulateBoard. The makeMove is what the main function will call to trigger the AI, and the simulate board is the recursive function. 
	simulateBoard-
		This method accepts a TTTBoard simBoard, int moveToMake, int[] probabilityOfMoveWinning, and intIndexOfProbabilityOfMoveWinning. The simBoard is cloned as simBoard2 to not affect the current game board. The moveToMake is what the method is initially checking, to see if each move results in a win or a loss for the AI. The probabilityOfMoveWinning is used in the makeMove function to decide what move to make. I used an array so it would pass a reference to the actual object, allowing me to update each cell and it would be saved after each iteration. The intIndexOfProbabilityOfMoveWinning is what index we are accessing of the probabilityOfMoveWinningArray. 