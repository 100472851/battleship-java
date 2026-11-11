import java.lang.Math;
import java.util.Scanner;

public class BattleShip {

	public static void main(String[] args) {
	
		//Play Again Variables
		int PlayAgain = 1;
		int GamesPlayed = 0;
		while (PlayAgain == 1) {
			GamesPlayed += 1;
			
		// MAIN SCREEN
		char ModeOption, ModeOptionUP, Answer, AnswerUP;
		Scanner input = new Scanner(System.in);
		System.out.println("\nBATTLESHIP");
		System.out.print("Choose a playing mode: \n\n");
		System.out.print("(A) Basic Mode \n" 
				+ "(B) Advanced Mode \n\n");
		ModeOption = input.next().charAt(0);
		
		ModeOptionUP = Character.toUpperCase(ModeOption);

		while (ModeOptionUP != 'A' && ModeOptionUP != 'B') {
			System.out.print("ERROR: Insert again a playing mode between A or B. \n\n");
			ModeOptionUP = input.next().charAt(0);
			
				if (ModeOptionUP == 'a' || ModeOptionUP == 'b'){
					ModeOptionUP = Character.toUpperCase(ModeOptionUP);
				}
			}
		
		
		// BASIC MODE
		if (ModeOptionUP == 'A') {
			System.out.print("\n" + "BASIC MODE \n\n");
			int [][] axisLetters = new int [1][6];
			int [][] board = new int [5][5];
			int axisRows = 1;
			int axisRows2 = 1;
			
			// BOARD BATTLEFIELD
				for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
				 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
					 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
						 System.out.print(" " + "\t");
					 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
						 System.out.print(" A" + "\t");
					 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
						 System.out.print(" B" + "\t");
					 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
						 System.out.print(" C" + "\t");
					 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
						 System.out.print(" D" + "\t");
					 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
						 System.out.print(" E" + "\t");
				 }
				}
				 System.out.println("\n");
				 
				 //Prints the Board to Screen
				 char sea = '_';
				 System.out.print("1");
				 while (axisRows < board.length) {
					for(int rows = 0; rows < board.length; rows++) { 
					  for(int columns = 0; columns < board[rows].length; columns++) {
						  board[rows][columns] = -1;
						 System.out.print("\t" + "[" + sea + "]");
					 	 }
						  axisRows ++;
						  if (axisRows == 6) break;
					 System.out.print("\n\n" + axisRows);
					   }
					  }
				 System.out.print("\n\n");
				 
				 // BOATS PLACEMENT
				 //Coordinate Variables
				 int xcoord1, xcoord2, xcoord3, xcoord4,
				 xcoord1A, xcoord1B, xcoord2A,
				 ycoord1, ycoord2, ycoord3, ycoord4,
				 ycoord3A, ycoord3B, ycoord4A;
				 int randxA, randyA, randxA1, 
				 randxB, randyB, randyB1, randyB2, 
				 randxC, randyC, randyC1;
				 
				 //Coordinate Assignation
				//Ship Vertical 1
				 xcoord1 = (int)(Math.random() * 5.0);
				 ycoord1 = (int)(Math.random() * 5.0);
				 
				 if (xcoord1 == 0) {
					 xcoord1A = 1;
					 xcoord1B = 2;
				  }
				 else if (xcoord1 <= 3 && xcoord1 >= 1) {
					 xcoord1A = (xcoord1 - 1);
					 xcoord1B = (xcoord1 + 1);
				  }
				 else {
					 xcoord1A = 2;
					 xcoord1B = 3;
				  }
				 
				 board[xcoord1][ycoord1] = 11;
				 board[xcoord1A][ycoord1] = 12;
				 board[xcoord1B][ycoord1] = 13;
				 
				 
				//Ship Vertical 2
				 do {
				 randxA = (int)(Math.random() * 5.0);
				 randyA = (int)(Math.random() * 5.0);
				 	if (randxA == 4) {
				 		randxA1 = randxA - 1;
				 	}
				 	else {
				 		randxA1 = randxA + 1;
				 	}
				 }
				 while ((board[randxA][randyA] != -1) || 
						 (board[randxA1][randyA] != -1));
				 
				 xcoord2 = randxA;
				 xcoord2A = randxA1;
				 ycoord2 = randyA;
				 
					board[xcoord2][ycoord2] = 14;
					board[xcoord2A][ycoord2] = 15;
			
				 
				//Ship Horizontal 1
				do {
				 randxB = (int)(Math.random() * 5.0);
				 randyB = (int)(Math.random() * 5.0);	
				 if (randyB == 0) {
					 randyB1 = randyB + 1;
					 randyB2 = randyB + 2;
				  }
				 else if (randyB <= 3 && randyB >= 1) {
					 randyB1 = (randyB + 1);
					 randyB2 = (randyB - 1);
				  }
				 else {
					 randyB1 = randyB - 1;
					 randyB2 = randyB - 2;
				  }
				}
				while((board[randxB][randyB] != -1) || 
						 (board[randxB][randyB1] != -1) ||
						 (board[randxB][randyB2] != -1));
				
				 xcoord3 = randxB;
				 ycoord3 = randyB;
				 ycoord3A = randyB1;
				 ycoord3B = randyB2;
				 
				 board[xcoord3][ycoord3] = 16;
				 board[xcoord3][ycoord3A] = 17;
				 board[xcoord3][ycoord3B] = 18;
				 
				
				//Ship Horizontal 2
				 do {
				 randxC = (int)(Math.random() * 5.0);
				 randyC = (int)(Math.random() * 5.0);
				 if (randyC == 4) {
					 randyC1 = randyC - 1;
				  }
				 else {
					 randyC1 = randyC + 1;
				  }
				 }
				 while((board[randxC][randyC] != -1) || 
						 (board[randxC][randyC1] != -1));
				 
				 xcoord4 = randxC;
				 ycoord4 = randyC;
                 ycoord4A = randyC1;				 
				 
				 board[xcoord4][ycoord4] = 19;
				 board[xcoord4][ycoord4A] = 20;
				  
				 
				//BOAT SHOOTING
				 //Variables
				int ShotsFired = 0;
				int ShipsSunk = 0;
				int cond1 = 0;
				int cond2 = 0;
				int cond3 = 0;
				int cond4 = 0;
				char hit = '#';
				
				//Starts Game
				while (ShipsSunk < 4) {
				
				//Analysis Recap
				System.out.print("Shots Fired:" + ShotsFired + "\n");
				System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
				
				//Coordinate Input
				int xCoordinate;
				Character FirstBracket, Comma, yCoordinate, SecondBracket;
				System.out.print("Insert coordinate to shoot in the format (row, column): \n");
			    String Coordinate = input.next();
			    String Coordinate2 = input.next();
			    String CoordinateT = Coordinate.trim();
			    String Coordinate2T = Coordinate2.trim();
			    
			    FirstBracket = CoordinateT.charAt(0);
			    xCoordinate = CoordinateT.charAt(1);
			    Comma = CoordinateT.charAt(2);
				yCoordinate = Coordinate2T.charAt(0);
				SecondBracket = Coordinate2T.charAt(1);
				
				xCoordinate = Character.getNumericValue(xCoordinate);
				yCoordinate = Character.toUpperCase(yCoordinate);
				
				while ((FirstBracket != '(') || ((xCoordinate < 1) || (xCoordinate > 5)) ||
						(Comma != ',') || ((yCoordinate != 'A') && (yCoordinate != 'B') &&
						(yCoordinate != 'C') && (yCoordinate != 'D') && (yCoordinate != 'E')) ||
						(SecondBracket != ')') || (CoordinateT.length() != 3) 
						|| (Coordinate2T.length() != 2)) {
					System.out.print("ERROR : "
							+ "Please insert coordinate to shoot in the format, "
							+ "with the space included (row, column): \n");
					Coordinate = input.next();
				    Coordinate2 = input.next();
				    CoordinateT = Coordinate.trim();
				    Coordinate2T = Coordinate2.trim();
				    
					FirstBracket = CoordinateT.charAt(0);
				    xCoordinate = CoordinateT.charAt(1);
				    Comma = CoordinateT.charAt(2);
					yCoordinate = Coordinate2T.charAt(0);
					SecondBracket = Coordinate2T.charAt(1);
					
					xCoordinate = Character.getNumericValue(xCoordinate);
					yCoordinate = Character.toUpperCase(yCoordinate);
				}	
				
				System.out.print("The selected coordinate to shoot is ("
						+ (xCoordinate) + ", " + yCoordinate + "). \n");
				
			    //Coordinate Conversion
				xCoordinate = (xCoordinate - 1);
				if (yCoordinate == 'A') {
					yCoordinate = 0;
				}
				else if (yCoordinate == 'B') {
					yCoordinate = 1;
				}
				else if (yCoordinate == 'C') {
					yCoordinate = 2;
				}
				else if (yCoordinate == 'D') {
					yCoordinate = 3;
				}
				else {
					yCoordinate = 4;
				}
				
				       //Printing the Board with Boats and Hits
						System.out.print("\n");
						for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
							 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
								 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
									 System.out.print(" " + "\t");
								 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
									 System.out.print(" A" + "\t");
								 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
									 System.out.print(" B" + "\t");
								 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
									 System.out.print(" C" + "\t");
								 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
									 System.out.print(" D" + "\t");
								 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
									 System.out.print(" E" + "\t");
							 }
							}
							 System.out.println("\n");
							 
							 //Conditions for Hitting
							 if (board[xCoordinate][yCoordinate] == -1) {
								 board[xCoordinate][yCoordinate] = 0;
							 }
							 if ((board[xCoordinate][yCoordinate] > 10 ) && 
								 (board[xCoordinate][yCoordinate] < 21)) {
								  board[xCoordinate][yCoordinate] = (board[xCoordinate][yCoordinate] - 10);
							 }
							 
							 
							 System.out.print("1");
							 while (axisRows2 < board.length) {
								for(int rows = 0; rows < board.length; rows++) { 
								  for(int columns = 0; columns < board[rows].length; columns++) {
									  //Water Hit
									 if (board[rows][columns] == 0) {
										 System.out.print("\t" + "[0]");
									 }
									 //Vertical Boat 1 Hit 
									 else if ((board[rows][columns] >= 1) && 
											 (board[rows][columns] <= 3)){
										 if ((board[xcoord1][ycoord1] == 1) &&
												 (board[xcoord1A][ycoord1] == 2) &&
												 (board[xcoord1B][ycoord1] == 3)) {
											 hit = 'X';
											 System.out.print("\t" + "[" + hit + "]");
										 }
										 else {
										 hit = '#';
										 System.out.print("\t" + "[" + hit + "]");
										 }
									 }
									 //Vertical Boat 2 Hit
									 else if ((board[rows][columns] >= 4) && 
											 (board[rows][columns] <= 5)){
										 if ((board[xcoord2][ycoord2] == 4) &&
												 (board[xcoord2A][ycoord2] == 5)) {
											 hit = 'X';
											 System.out.print("\t" + "[" + hit + "]");
										 }
										 else {
										 hit = '#';
										 System.out.print("\t" + "[" + hit + "]");
										 }
									 }
									 //Horizontal Boat 1 Hit
									 else if ((board[rows][columns] >= 6) && 
											 (board[rows][columns] <= 8)){
										 if ((board[xcoord3][ycoord3] == 6) &&
												 (board[xcoord3][ycoord3A] == 7) &&
												 (board[xcoord3][ycoord3B] == 8)) {
											 hit = 'X';
											 System.out.print("\t" + "[" + hit + "]");
										 }
										 else {
										 hit = '#';
										 System.out.print("\t" + "[" + hit + "]");
										 }
									 }
									 //Horizontal Boat 2 Hit
									 else if ((board[rows][columns] >= 9) && 
											 (board[rows][columns] <= 10)){
										 if ((board[xcoord4][ycoord4] == 9) &&
												 (board[xcoord4][ycoord4A] == 10)) {
											 hit = 'X';
											 System.out.print("\t" + "[" + hit + "]");
										 }
										 else {
										 hit = '#';
										 System.out.print("\t" + "[" + hit + "]");
										 }
									 }
									 else {
									 System.out.print("\t" + "[" + sea + "]");
									 }
								 	 }
									  axisRows2 ++;
									  if (axisRows2 == 6) break;
								 System.out.print("\n\n" + axisRows2);
								   }
								  }
							 System.out.print("\n\n");
							
							 //Vertical Boat 1 Sunk
							 if ((board[xcoord1][ycoord1] == 1) &&
									 (board[xcoord1A][ycoord1] == 2) &&
									 (board[xcoord1B][ycoord1] == 3)) {
								 while (cond1 == 0) {
								 ShipsSunk += 1;
								 cond1 += 1;
								 }
							}
							//Vertical Boat 2 Sunk
							 if ((board[xcoord2][ycoord2] == 4) &&
									 (board[xcoord2A][ycoord2] == 5)) {
								 while (cond2 == 0) {
								 ShipsSunk += 1;
								 cond2 += 1;
								 }
							}
							//Horizontal Boat 1 Sunk
							 if ((board[xcoord3][ycoord3] == 6) &&
									 (board[xcoord3][ycoord3A] == 7) &&
									 (board[xcoord3][ycoord3B] == 8)) {
								 while (cond3 == 0) {
								 ShipsSunk += 1;
								 cond3 += 1;
								 }
							}
							 //Horizontal Boat 2 Sunk
							 if ((board[xcoord4][ycoord4] == 9) &&
									 (board[xcoord4][ycoord4A] == 10)) {
								 while (cond4 == 0) {
								 ShipsSunk += 1;
								 cond4 += 1;
								 }
							}
					//Resets Board Counter		 
					axisRows2 = 1;
					//Adds Shots Fired each Turn
					ShotsFired += 1;
				}
				
				//System Analysis
				System.out.print("Shots Fired: " + ShotsFired + "\n");
				System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
				
				//Game Final Report
				System.out.print("The game is over! \n" + "It took " + ShotsFired + " shots! \n"
						+ GamesPlayed + " Games Played. \n" + "Do you want to play again? \n"
								+ "(Y / N) \n");
				Answer = input.next().charAt(0);
				
				AnswerUP = Character.toUpperCase(Answer);

				//Transforms the Play Again Answer until is correct
				while (AnswerUP != 'Y' && AnswerUP != 'N') {
					System.out.print("Please insert a character between Y or N "
							+ "(Y for Yes and N for No): \n\n");
					AnswerUP = input.next().charAt(0);
					
						if (AnswerUP == 'y' || AnswerUP == 'n'){
							AnswerUP = Character.toUpperCase(AnswerUP);
						}
					}
				//Ends the Game if No and if Yes continues as variable PlayAgain remains 1
				if (AnswerUP == 'N'){
					PlayAgain = 0;
					if (PlayAgain == 0) {
				    System.out.print("\nGAME ENDED.");
					}
				}
		}
				
		// ADVANCED MODE
		if (ModeOptionUP == 'B') {
			System.out.print("\n" + "ADVANCED MODE \n\n");
			Scanner select = new Scanner(System.in);
			
			System.out.print("Please select a board size between 5x5 and 10x10. \n"
					+ "(Write the format as the number of rows wanted): \n");
			int BoardSize = select.nextInt();
			
			while (BoardSize < 5 || BoardSize > 10) {
				System.out.print("The board size inserted must be an integer between "
						+ "5 and 10. \nPlease insert a board size again: \n");
				BoardSize = select.nextInt();
			}
			
			
			if (BoardSize == 5) {
				System.out.print("Select character symbol for water: \n");
				char SymbolWater = select.next().charAt(0);
				System.out.print("Select character symbol for a missed shot: \n");
				char SymbolMiss = select.next().charAt(0);
				System.out.print("Select character symbol for touched boats: \n");
				char SymbolTouched = select.next().charAt(0);
				System.out.print("Select character symbol for sunk boats: \n");
				char SymbolSunk = select.next().charAt(0);
				
				int PlayerMode = 1;
				
				if (PlayerMode == 1) {
					int [][] axisLetters = new int [1][6];
					int [][] board = new int [5][5];
					int axisRows = 1;
					int axisRows2 = 1;
					
					// BOARD BATTLEFIELD
						for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
						 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
								 System.out.print(" " + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
								 System.out.print(" A" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
								 System.out.print(" B" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
								 System.out.print(" C" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
								 System.out.print(" D" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
								 System.out.print(" E" + "\t");
						 }
						}
						 System.out.println("\n");
						 
						 //Prints the Board to Screen
						 char sea = SymbolWater;
						 System.out.print("1");
						 while (axisRows < board.length) {
							for(int rows = 0; rows < board.length; rows++) { 
							  for(int columns = 0; columns < board[rows].length; columns++) {
								  board[rows][columns] = -1;
								 System.out.print("\t" + "[" + sea + "]");
							 	 }
								  axisRows ++;
								  if (axisRows == 6) break;
							 System.out.print("\n\n" + axisRows);
							   }
							  }
						 System.out.print("\n\n");
						 
						 // BOATS PLACEMENT
						 //Coordinate Variables
						 int xcoord1, xcoord2, xcoord3, xcoord4,
						 xcoord1A, xcoord1B, xcoord2A,
						 ycoord1, ycoord2, ycoord3, ycoord4,
						 ycoord3A, ycoord3B, ycoord4A;
						 int randxA, randyA, randxA1, 
						 randxB, randyB, randyB1, randyB2, 
						 randxC, randyC, randyC1;
						 
						 //Coordinate Assignation
						//Ship Vertical 1
						 xcoord1 = (int)(Math.random() * 5.0);
						 ycoord1 = (int)(Math.random() * 5.0);
						 
						 if (xcoord1 == 0) {
							 xcoord1A = 1;
							 xcoord1B = 2;
						  }
						 else if (xcoord1 <= 3 && xcoord1 >= 1) {
							 xcoord1A = (xcoord1 - 1);
							 xcoord1B = (xcoord1 + 1);
						  }
						 else {
							 xcoord1A = 2;
							 xcoord1B = 3;
						  }
						 
						 board[xcoord1][ycoord1] = 11;
						 board[xcoord1A][ycoord1] = 12;
						 board[xcoord1B][ycoord1] = 13;
						 
						 
						//Ship Vertical 2
						 do {
						 randxA = (int)(Math.random() * 5.0);
						 randyA = (int)(Math.random() * 5.0);
						 	if (randxA == 4) {
						 		randxA1 = randxA - 1;
						 	}
						 	else {
						 		randxA1 = randxA + 1;
						 	}
						 }
						 while ((board[randxA][randyA] != -1) || 
								 (board[randxA1][randyA] != -1));
						 
						 xcoord2 = randxA;
						 xcoord2A = randxA1;
						 ycoord2 = randyA;
						 
							board[xcoord2][ycoord2] = 14;
							board[xcoord2A][ycoord2] = 15;
					
						 
						//Ship Horizontal 1
						do {
						 randxB = (int)(Math.random() * 5.0);
						 randyB = (int)(Math.random() * 5.0);	
						 if (randyB == 0) {
							 randyB1 = randyB + 1;
							 randyB2 = randyB + 2;
						  }
						 else if (randyB <= 3 && randyB >= 1) {
							 randyB1 = (randyB + 1);
							 randyB2 = (randyB - 1);
						  }
						 else {
							 randyB1 = randyB - 1;
							 randyB2 = randyB - 2;
						  }
						}
						while((board[randxB][randyB] != -1) || 
								 (board[randxB][randyB1] != -1) ||
								 (board[randxB][randyB2] != -1));
						
						 xcoord3 = randxB;
						 ycoord3 = randyB;
						 ycoord3A = randyB1;
						 ycoord3B = randyB2;
						 
						 board[xcoord3][ycoord3] = 16;
						 board[xcoord3][ycoord3A] = 17;
						 board[xcoord3][ycoord3B] = 18;
						 
						
						//Ship Horizontal 2
						 do {
						 randxC = (int)(Math.random() * 5.0);
						 randyC = (int)(Math.random() * 5.0);
						 if (randyC == 4) {
							 randyC1 = randyC - 1;
						  }
						 else {
							 randyC1 = randyC + 1;
						  }
						 }
						 while((board[randxC][randyC] != -1) || 
								 (board[randxC][randyC1] != -1));
						 
						 xcoord4 = randxC;
						 ycoord4 = randyC;
		                 ycoord4A = randyC1;				 
						 
						 board[xcoord4][ycoord4] = 19;
						 board[xcoord4][ycoord4A] = 20;
						  
						 
						//BOAT SHOOTING
						 //Variables
						int ShotsFired = 0;
						int ShipsSunk = 0;
						int cond1 = 0;
						int cond2 = 0;
						int cond3 = 0;
						int cond4 = 0;
						char hit = SymbolTouched;
						
						//Starts Game
						while (ShipsSunk < 4) {
						
						//Analysis Recap
						System.out.print("Shots Fired:" + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Coordinate Input
						int xCoordinate;
						Character FirstBracket, Comma, yCoordinate, SecondBracket;
						System.out.print("Insert coordinate to shoot in the format (row, column): \n");
					    String Coordinate = input.next();
					    String Coordinate2 = input.next();
					    String CoordinateT = Coordinate.trim();
					    String Coordinate2T = Coordinate2.trim();
					    
					    FirstBracket = CoordinateT.charAt(0);
					    xCoordinate = CoordinateT.charAt(1);
					    Comma = CoordinateT.charAt(2);
						yCoordinate = Coordinate2T.charAt(0);
						SecondBracket = Coordinate2T.charAt(1);
						
						xCoordinate = Character.getNumericValue(xCoordinate);
						yCoordinate = Character.toUpperCase(yCoordinate);
						
						while ((FirstBracket != '(') || ((xCoordinate < 1) || (xCoordinate > 5)) ||
								(Comma != ',') || ((yCoordinate != 'A') && (yCoordinate != 'B') &&
								(yCoordinate != 'C') && (yCoordinate != 'D') && (yCoordinate != 'E')) ||
								(SecondBracket != ')') || (CoordinateT.length() != 3) 
								|| (Coordinate2T.length() != 2)) {
							System.out.print("ERROR : "
									+ "Please insert coordinate to shoot in the format, "
									+ "with the space included (row, column): \n");
							Coordinate = input.next();
						    Coordinate2 = input.next();
						    CoordinateT = Coordinate.trim();
						    Coordinate2T = Coordinate2.trim();
						    
							FirstBracket = CoordinateT.charAt(0);
						    xCoordinate = CoordinateT.charAt(1);
						    Comma = CoordinateT.charAt(2);
							yCoordinate = Coordinate2T.charAt(0);
							SecondBracket = Coordinate2T.charAt(1);
							
							xCoordinate = Character.getNumericValue(xCoordinate);
							yCoordinate = Character.toUpperCase(yCoordinate);
						}	
						
						System.out.print("The selected coordinate to shoot is ("
								+ (xCoordinate) + ", " + yCoordinate + "). \n");
						
					    //Coordinate Conversion
						xCoordinate = (xCoordinate - 1);
						if (yCoordinate == 'A') {
							yCoordinate = 0;
						}
						else if (yCoordinate == 'B') {
							yCoordinate = 1;
						}
						else if (yCoordinate == 'C') {
							yCoordinate = 2;
						}
						else if (yCoordinate == 'D') {
							yCoordinate = 3;
						}
						else {
							yCoordinate = 4;
						}
						
						       //Printing the Board with Boats and Hits
								System.out.print("\n");
								for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
									 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
											 System.out.print(" " + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
											 System.out.print(" A" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
											 System.out.print(" B" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
											 System.out.print(" C" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
											 System.out.print(" D" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
											 System.out.print(" E" + "\t");
									 }
									}
									 System.out.println("\n");
									 
									 //Conditions for Hitting
									 if (board[xCoordinate][yCoordinate] == -1) {
										 board[xCoordinate][yCoordinate] = 0;
									 }
									 if ((board[xCoordinate][yCoordinate] > 10 ) && 
										 (board[xCoordinate][yCoordinate] < 21)) {
										  board[xCoordinate][yCoordinate] = (board[xCoordinate][yCoordinate] - 10);
									 }
									 
									 
									 System.out.print("1");
									 while (axisRows2 < board.length) {
										for(int rows = 0; rows < board.length; rows++) { 
										  for(int columns = 0; columns < board[rows].length; columns++) {
											  //Water Hit
											 if (board[rows][columns] == 0) {
												 hit = SymbolMiss;
												 System.out.print("\t" + "[" + hit + "]");
											 }
											 //Vertical Boat 1 Hit 
											 else if ((board[rows][columns] >= 1) && 
													 (board[rows][columns] <= 3)){
												 if ((board[xcoord1][ycoord1] == 1) &&
														 (board[xcoord1A][ycoord1] == 2) &&
														 (board[xcoord1B][ycoord1] == 3)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Vertical Boat 2 Hit
											 else if ((board[rows][columns] >= 4) && 
													 (board[rows][columns] <= 5)){
												 if ((board[xcoord2][ycoord2] == 4) &&
														 (board[xcoord2A][ycoord2] == 5)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 1 Hit
											 else if ((board[rows][columns] >= 6) && 
													 (board[rows][columns] <= 8)){
												 if ((board[xcoord3][ycoord3] == 6) &&
														 (board[xcoord3][ycoord3A] == 7) &&
														 (board[xcoord3][ycoord3B] == 8)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 2 Hit
											 else if ((board[rows][columns] >= 9) && 
													 (board[rows][columns] <= 10)){
												 if ((board[xcoord4][ycoord4] == 9) &&
														 (board[xcoord4][ycoord4A] == 10)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 else {
											 System.out.print("\t" + "[" + sea + "]");
											 }
										 	 }
											  axisRows2 ++;
											  if (axisRows2 == 6) break;
										 System.out.print("\n\n" + axisRows2);
										   }
										  }
									 System.out.print("\n\n");
									
									 //Vertical Boat 1 Sunk
									 if ((board[xcoord1][ycoord1] == 1) &&
											 (board[xcoord1A][ycoord1] == 2) &&
											 (board[xcoord1B][ycoord1] == 3)) {
										 while (cond1 == 0) {
										 ShipsSunk += 1;
										 cond1 += 1;
										 }
									}
									//Vertical Boat 2 Sunk
									 if ((board[xcoord2][ycoord2] == 4) &&
											 (board[xcoord2A][ycoord2] == 5)) {
										 while (cond2 == 0) {
										 ShipsSunk += 1;
										 cond2 += 1;
										 }
									}
									//Horizontal Boat 1 Sunk
									 if ((board[xcoord3][ycoord3] == 6) &&
											 (board[xcoord3][ycoord3A] == 7) &&
											 (board[xcoord3][ycoord3B] == 8)) {
										 while (cond3 == 0) {
										 ShipsSunk += 1;
										 cond3 += 1;
										 }
									}
									 //Horizontal Boat 2 Sunk
									 if ((board[xcoord4][ycoord4] == 9) &&
											 (board[xcoord4][ycoord4A] == 10)) {
										 while (cond4 == 0) {
										 ShipsSunk += 1;
										 cond4 += 1;
										 }
									}
							//Resets Board Counter		 
							axisRows2 = 1;
							//Adds Shots Fired each Turn
							ShotsFired += 1;
						}
						
						//System Analysis
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Game Final Report
						System.out.print("The game is over! \n" + "It took " + ShotsFired + " shots! \n"
								+ GamesPlayed + " Games Played. \n" + "Do you want to play again? \n"
										+ "(Y / N) \n");
						Answer = input.next().charAt(0);
						
						AnswerUP = Character.toUpperCase(Answer);

						//Transforms the Play Again Answer until is correct
						while (AnswerUP != 'Y' && AnswerUP != 'N') {
							System.out.print("Please insert a character between Y or N "
									+ "(Y for Yes and N for No): \n\n");
							AnswerUP = input.next().charAt(0);
							
								if (AnswerUP == 'y' || AnswerUP == 'n'){
									AnswerUP = Character.toUpperCase(AnswerUP);
								}
							}
						//Ends the Game if No and if Yes continues as variable PlayAgain remains 1
						if (AnswerUP == 'N'){
							PlayAgain = 0;
							if (PlayAgain == 0) {
						    System.out.print("\nGAME ENDED.");
							}
						}
					
				}
				
				
				
			}
			
			if (BoardSize == 6) {
				System.out.print("Select character symbol for water: \n");
				char SymbolWater = select.next().charAt(0);
				System.out.print("Select character symbol for a missed shot: \n");
				char SymbolMiss = select.next().charAt(0);
				System.out.print("Select character symbol for touched boats: \n");
				char SymbolTouched = select.next().charAt(0);
				System.out.print("Select character symbol for sunk boats: \n");
				char SymbolSunk = select.next().charAt(0);
				
				int PlayerMode = 1;
				
				if (PlayerMode == 1) {
					int [][] axisLetters = new int [1][7];
					int [][] board = new int [6][6];
					int axisRows = 1;
					int axisRows2 = 1;
					
					// BOARD BATTLEFIELD
						for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
						 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
								 System.out.print(" " + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
								 System.out.print(" A" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
								 System.out.print(" B" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
								 System.out.print(" C" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
								 System.out.print(" D" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
								 System.out.print(" E" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
								 System.out.print(" F" + "\t");
						 }
						}
						 System.out.println("\n");
						 
						 //Prints the Board to Screen
						 char sea = SymbolWater;
						 System.out.print("1");
						 while (axisRows < board.length) {
							for(int rows = 0; rows < board.length; rows++) { 
							  for(int columns = 0; columns < board[rows].length; columns++) {
								  board[rows][columns] = -1;
								 System.out.print("\t" + "[" + sea + "]");
							 	 }
								  axisRows ++;
								  if (axisRows == 7) break;
							 System.out.print("\n\n" + axisRows);
							   }
							  }
						 System.out.print("\n\n");
						 
						 // BOATS PLACEMENT
						 //Coordinate Variables
						 int xcoord1, xcoord2, xcoord3, xcoord4,
						 xcoord1A, xcoord1B, xcoord2A,
						 ycoord1, ycoord2, ycoord3, ycoord4,
						 ycoord3A, ycoord3B, ycoord4A;
						 int randxA, randyA, randxA1, 
						 randxB, randyB, randyB1, randyB2, 
						 randxC, randyC, randyC1;
						 
						 //Coordinate Assignation
						//Ship Vertical 1
						 xcoord1 = (int)(Math.random() * 6.0);
						 ycoord1 = (int)(Math.random() * 6.0);
						 
						 if (xcoord1 == 0) {
							 xcoord1A = 1;
							 xcoord1B = 2;
						  }
						 else if (xcoord1 <= 4 && xcoord1 >= 1) {
							 xcoord1A = (xcoord1 - 1);
							 xcoord1B = (xcoord1 + 1);
						  }
						 else {
							 xcoord1A = 3;
							 xcoord1B = 4;
						  }
						 
						 board[xcoord1][ycoord1] = 11;
						 board[xcoord1A][ycoord1] = 12;
						 board[xcoord1B][ycoord1] = 13;
						 
						 
						//Ship Vertical 2
						 do {
						 randxA = (int)(Math.random() * 6.0);
						 randyA = (int)(Math.random() * 6.0);
						 	if (randxA == 5) {
						 		randxA1 = randxA - 1;
						 	}
						 	else {
						 		randxA1 = randxA + 1;
						 	}
						 }
						 while ((board[randxA][randyA] != -1) || 
								 (board[randxA1][randyA] != -1));
						 
						 xcoord2 = randxA;
						 xcoord2A = randxA1;
						 ycoord2 = randyA;
						 
							board[xcoord2][ycoord2] = 14;
							board[xcoord2A][ycoord2] = 15;
					
						 
						//Ship Horizontal 1
						do {
						 randxB = (int)(Math.random() * 6.0);
						 randyB = (int)(Math.random() * 6.0);	
						 if (randyB == 0) {
							 randyB1 = randyB + 1;
							 randyB2 = randyB + 2;
						  }
						 else if (randyB <= 4 && randyB >= 1) {
							 randyB1 = (randyB + 1);
							 randyB2 = (randyB - 1);
						  }
						 else {
							 randyB1 = randyB - 1;
							 randyB2 = randyB - 2;
						  }
						}
						while((board[randxB][randyB] != -1) || 
								 (board[randxB][randyB1] != -1) ||
								 (board[randxB][randyB2] != -1));
						
						 xcoord3 = randxB;
						 ycoord3 = randyB;
						 ycoord3A = randyB1;
						 ycoord3B = randyB2;
						 
						 board[xcoord3][ycoord3] = 16;
						 board[xcoord3][ycoord3A] = 17;
						 board[xcoord3][ycoord3B] = 18;
						 
						
						//Ship Horizontal 2
						 do {
						 randxC = (int)(Math.random() * 6.0);
						 randyC = (int)(Math.random() * 6.0);
						 if (randyC == 5) {
							 randyC1 = randyC - 1;
						  }
						 else {
							 randyC1 = randyC + 1;
						  }
						 }
						 while((board[randxC][randyC] != -1) || 
								 (board[randxC][randyC1] != -1));
						 
						 xcoord4 = randxC;
						 ycoord4 = randyC;
		                 ycoord4A = randyC1;				 
						 
						 board[xcoord4][ycoord4] = 19;
						 board[xcoord4][ycoord4A] = 20;
						  
						 
						//BOAT SHOOTING
						 //Variables
						int ShotsFired = 0;
						int ShipsSunk = 0;
						int cond1 = 0;
						int cond2 = 0;
						int cond3 = 0;
						int cond4 = 0;
						char hit = SymbolTouched;
						
						//Starts Game
						while (ShipsSunk < 4) {
						
						//Analysis Recap
						System.out.print("Shots Fired:" + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Coordinate Input
						int xCoordinate;
						Character FirstBracket, Comma, yCoordinate, SecondBracket;
						System.out.print("Insert coordinate to shoot in the format (row, column): \n");
					    String Coordinate = input.next();
					    String Coordinate2 = input.next();
					    String CoordinateT = Coordinate.trim();
					    String Coordinate2T = Coordinate2.trim();
					    
					    FirstBracket = CoordinateT.charAt(0);
					    xCoordinate = CoordinateT.charAt(1);
					    Comma = CoordinateT.charAt(2);
						yCoordinate = Coordinate2T.charAt(0);
						SecondBracket = Coordinate2T.charAt(1);
						
						xCoordinate = Character.getNumericValue(xCoordinate);
						yCoordinate = Character.toUpperCase(yCoordinate);
						
						while ((FirstBracket != '(') || ((xCoordinate < 1) || (xCoordinate > 6)) ||
								(Comma != ',') || ((yCoordinate != 'A') && (yCoordinate != 'B') &&
								(yCoordinate != 'C') && (yCoordinate != 'D') && (yCoordinate != 'E') 
								&& (yCoordinate != 'F')) || (SecondBracket != ')') || (CoordinateT.length() != 3) 
								|| (Coordinate2T.length() != 2)) {
							System.out.print("ERROR : "
									+ "Please insert coordinate to shoot in the format, "
									+ "with the space included (row, column): \n");
							Coordinate = input.next();
						    Coordinate2 = input.next();
						    CoordinateT = Coordinate.trim();
						    Coordinate2T = Coordinate2.trim();
						    
							FirstBracket = CoordinateT.charAt(0);
						    xCoordinate = CoordinateT.charAt(1);
						    Comma = CoordinateT.charAt(2);
							yCoordinate = Coordinate2T.charAt(0);
							SecondBracket = Coordinate2T.charAt(1);
							
							xCoordinate = Character.getNumericValue(xCoordinate);
							yCoordinate = Character.toUpperCase(yCoordinate);
						}	
						
						System.out.print("The selected coordinate to shoot is ("
								+ (xCoordinate) + ", " + yCoordinate + "). \n");
						
					    //Coordinate Conversion
						xCoordinate = (xCoordinate - 1);
						if (yCoordinate == 'A') {
							yCoordinate = 0;
						}
						else if (yCoordinate == 'B') {
							yCoordinate = 1;
						}
						else if (yCoordinate == 'C') {
							yCoordinate = 2;
						}
						else if (yCoordinate == 'D') {
							yCoordinate = 3;
						}
						else if (yCoordinate == 'E') {
							yCoordinate = 4;
						}
						else {
							yCoordinate = 5;
						}
						
						       //Printing the Board with Boats and Hits
								System.out.print("\n");
								for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
									 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
											 System.out.print(" " + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
											 System.out.print(" A" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
											 System.out.print(" B" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
											 System.out.print(" C" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
											 System.out.print(" D" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
											 System.out.print(" E" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
											 System.out.print(" F" + "\t");
									 }
									}
									 System.out.println("\n");
									 
									 //Conditions for Hitting
									 if (board[xCoordinate][yCoordinate] == -1) {
										 board[xCoordinate][yCoordinate] = 0;
									 }
									 if ((board[xCoordinate][yCoordinate] > 10 ) && 
										 (board[xCoordinate][yCoordinate] < 21)) {
										  board[xCoordinate][yCoordinate] = (board[xCoordinate][yCoordinate] - 10);
									 }
									 
									 
									 System.out.print("1");
									 while (axisRows2 < board.length) {
										for(int rows = 0; rows < board.length; rows++) { 
										  for(int columns = 0; columns < board[rows].length; columns++) {
											  //Water Hit
											 if (board[rows][columns] == 0) {
												 hit = SymbolMiss;
												 System.out.print("\t" + "[" + hit + "]");
											 }
											 //Vertical Boat 1 Hit 
											 else if ((board[rows][columns] >= 1) && 
													 (board[rows][columns] <= 3)){
												 if ((board[xcoord1][ycoord1] == 1) &&
														 (board[xcoord1A][ycoord1] == 2) &&
														 (board[xcoord1B][ycoord1] == 3)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Vertical Boat 2 Hit
											 else if ((board[rows][columns] >= 4) && 
													 (board[rows][columns] <= 5)){
												 if ((board[xcoord2][ycoord2] == 4) &&
														 (board[xcoord2A][ycoord2] == 5)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 1 Hit
											 else if ((board[rows][columns] >= 6) && 
													 (board[rows][columns] <= 8)){
												 if ((board[xcoord3][ycoord3] == 6) &&
														 (board[xcoord3][ycoord3A] == 7) &&
														 (board[xcoord3][ycoord3B] == 8)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 2 Hit
											 else if ((board[rows][columns] >= 9) && 
													 (board[rows][columns] <= 10)){
												 if ((board[xcoord4][ycoord4] == 9) &&
														 (board[xcoord4][ycoord4A] == 10)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 else {
											 System.out.print("\t" + "[" + sea + "]");
											 }
										 	 }
											  axisRows2 ++;
											  if (axisRows2 == 7) break;
										 System.out.print("\n\n" + axisRows2);
										   }
										  }
									 System.out.print("\n\n");
									
									 //Vertical Boat 1 Sunk
									 if ((board[xcoord1][ycoord1] == 1) &&
											 (board[xcoord1A][ycoord1] == 2) &&
											 (board[xcoord1B][ycoord1] == 3)) {
										 while (cond1 == 0) {
										 ShipsSunk += 1;
										 cond1 += 1;
										 }
									}
									//Vertical Boat 2 Sunk
									 if ((board[xcoord2][ycoord2] == 4) &&
											 (board[xcoord2A][ycoord2] == 5)) {
										 while (cond2 == 0) {
										 ShipsSunk += 1;
										 cond2 += 1;
										 }
									}
									//Horizontal Boat 1 Sunk
									 if ((board[xcoord3][ycoord3] == 6) &&
											 (board[xcoord3][ycoord3A] == 7) &&
											 (board[xcoord3][ycoord3B] == 8)) {
										 while (cond3 == 0) {
										 ShipsSunk += 1;
										 cond3 += 1;
										 }
									}
									 //Horizontal Boat 2 Sunk
									 if ((board[xcoord4][ycoord4] == 9) &&
											 (board[xcoord4][ycoord4A] == 10)) {
										 while (cond4 == 0) {
										 ShipsSunk += 1;
										 cond4 += 1;
										 }
									}
							//Resets Board Counter		 
							axisRows2 = 1;
							//Adds Shots Fired each Turn
							ShotsFired += 1;
						}
						
						//System Analysis
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Game Final Report
						System.out.print("The game is over! \n" + "It took " + ShotsFired + " shots! \n"
								+ GamesPlayed + " Games Played. \n" + "Do you want to play again? \n"
										+ "(Y / N) \n");
						Answer = input.next().charAt(0);
						
						AnswerUP = Character.toUpperCase(Answer);

						//Transforms the Play Again Answer until is correct
						while (AnswerUP != 'Y' && AnswerUP != 'N') {
							System.out.print("Please insert a character between Y or N "
									+ "(Y for Yes and N for No): \n\n");
							AnswerUP = input.next().charAt(0);
							
								if (AnswerUP == 'y' || AnswerUP == 'n'){
									AnswerUP = Character.toUpperCase(AnswerUP);
								}
							}
						//Ends the Game if No and if Yes continues as variable PlayAgain remains 1
						if (AnswerUP == 'N'){
							PlayAgain = 0;
							if (PlayAgain == 0) {
						    System.out.print("\nGAME ENDED.");
							}
						}
				}
				
				
			}
			
			if (BoardSize == 7) {
				System.out.print("Select character symbol for water: \n");
				char SymbolWater = select.next().charAt(0);
				System.out.print("Select character symbol for a missed shot: \n");
				char SymbolMiss = select.next().charAt(0);
				System.out.print("Select character symbol for touched boats: \n");
				char SymbolTouched = select.next().charAt(0);
				System.out.print("Select character symbol for sunk boats: \n");
				char SymbolSunk = select.next().charAt(0);
				
				int PlayerMode = 1;
				
				if (PlayerMode == 1) {
					int [][] axisLetters = new int [1][8];
					int [][] board = new int [7][7];
					int axisRows = 1;
					int axisRows2 = 1;
					
					// BOARD BATTLEFIELD
						for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
						 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
								 System.out.print(" " + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
								 System.out.print(" A" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
								 System.out.print(" B" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
								 System.out.print(" C" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
								 System.out.print(" D" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
								 System.out.print(" E" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
								 System.out.print(" F" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
								 System.out.print(" G" + "\t");
						 }
						}
						 System.out.println("\n");
						 
						 //Prints the Board to Screen
						 char sea = SymbolWater;
						 System.out.print("1");
						 while (axisRows < board.length) {
							for(int rows = 0; rows < board.length; rows++) { 
							  for(int columns = 0; columns < board[rows].length; columns++) {
								  board[rows][columns] = -1;
								 System.out.print("\t" + "[" + sea + "]");
							 	 }
								  axisRows ++;
								  if (axisRows == 8) break;
							 System.out.print("\n\n" + axisRows);
							   }
							  }
						 System.out.print("\n\n");
						 
						 // BOATS PLACEMENT
						 //Coordinate Variables
						 int xcoord1, xcoord2, xcoord3, xcoord4,
						 xcoord1A, xcoord1B, xcoord2A,
						 ycoord1, ycoord2, ycoord3, ycoord4,
						 ycoord3A, ycoord3B, ycoord4A;
						 int randxA, randyA, randxA1, 
						 randxB, randyB, randyB1, randyB2, 
						 randxC, randyC, randyC1;
						 
						 //Coordinate Assignation
						//Ship Vertical 1
						 xcoord1 = (int)(Math.random() * 7.0);
						 ycoord1 = (int)(Math.random() * 7.0);
						 
						 if (xcoord1 == 0) {
							 xcoord1A = 1;
							 xcoord1B = 2;
						  }
						 else if (xcoord1 <= 5 && xcoord1 >= 1) {
							 xcoord1A = (xcoord1 - 1);
							 xcoord1B = (xcoord1 + 1);
						  }
						 else {
							 xcoord1A = 4;
							 xcoord1B = 5;
						  }
						 
						 board[xcoord1][ycoord1] = 11;
						 board[xcoord1A][ycoord1] = 12;
						 board[xcoord1B][ycoord1] = 13;
						 
						 
						//Ship Vertical 2
						 do {
						 randxA = (int)(Math.random() * 7.0);
						 randyA = (int)(Math.random() * 7.0);
						 	if (randxA == 6) {
						 		randxA1 = randxA - 1;
						 	}
						 	else {
						 		randxA1 = randxA + 1;
						 	}
						 }
						 while ((board[randxA][randyA] != -1) || 
								 (board[randxA1][randyA] != -1));
						 
						 xcoord2 = randxA;
						 xcoord2A = randxA1;
						 ycoord2 = randyA;
						 
							board[xcoord2][ycoord2] = 14;
							board[xcoord2A][ycoord2] = 15;
					
						 
						//Ship Horizontal 1
						do {
						 randxB = (int)(Math.random() * 7.0);
						 randyB = (int)(Math.random() * 7.0);	
						 if (randyB == 0) {
							 randyB1 = randyB + 1;
							 randyB2 = randyB + 2;
						  }
						 else if (randyB <= 5 && randyB >= 1) {
							 randyB1 = (randyB + 1);
							 randyB2 = (randyB - 1);
						  }
						 else {
							 randyB1 = randyB - 1;
							 randyB2 = randyB - 2;
						  }
						}
						while((board[randxB][randyB] != -1) || 
								 (board[randxB][randyB1] != -1) ||
								 (board[randxB][randyB2] != -1));
						
						 xcoord3 = randxB;
						 ycoord3 = randyB;
						 ycoord3A = randyB1;
						 ycoord3B = randyB2;
						 
						 board[xcoord3][ycoord3] = 16;
						 board[xcoord3][ycoord3A] = 17;
						 board[xcoord3][ycoord3B] = 18;
						 
						
						//Ship Horizontal 2
						 do {
						 randxC = (int)(Math.random() * 7.0);
						 randyC = (int)(Math.random() * 7.0);
						 if (randyC == 6) {
							 randyC1 = randyC - 1;
						  }
						 else {
							 randyC1 = randyC + 1;
						  }
						 }
						 while((board[randxC][randyC] != -1) || 
								 (board[randxC][randyC1] != -1));
						 
						 xcoord4 = randxC;
						 ycoord4 = randyC;
		                 ycoord4A = randyC1;				 
						 
						 board[xcoord4][ycoord4] = 19;
						 board[xcoord4][ycoord4A] = 20;
						  
						 
						//BOAT SHOOTING
						 //Variables
						int ShotsFired = 0;
						int ShipsSunk = 0;
						int cond1 = 0;
						int cond2 = 0;
						int cond3 = 0;
						int cond4 = 0;
						char hit = SymbolTouched;
						
						//Starts Game
						while (ShipsSunk < 4) {
						
						//Analysis Recap
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Coordinate Input
						int xCoordinate;
						Character FirstBracket, Comma, yCoordinate, SecondBracket;
						System.out.print("Insert coordinate to shoot in the format (row, column): \n");
					    String Coordinate = input.next();
					    String Coordinate2 = input.next();
					    String CoordinateT = Coordinate.trim();
					    String Coordinate2T = Coordinate2.trim();
					    
					    FirstBracket = CoordinateT.charAt(0);
					    xCoordinate = CoordinateT.charAt(1);
					    Comma = CoordinateT.charAt(2);
						yCoordinate = Coordinate2T.charAt(0);
						SecondBracket = Coordinate2T.charAt(1);
						
						xCoordinate = Character.getNumericValue(xCoordinate);
						yCoordinate = Character.toUpperCase(yCoordinate);
						
						while ((FirstBracket != '(') || ((xCoordinate < 1) || (xCoordinate > 7)) ||
								(Comma != ',') || ((yCoordinate != 'A') && (yCoordinate != 'B') &&
								(yCoordinate != 'C') && (yCoordinate != 'D') && (yCoordinate != 'E') 
								&& (yCoordinate != 'F') && (yCoordinate != 'G')) || (SecondBracket != ')') 
								|| (CoordinateT.length() != 3) || (Coordinate2T.length() != 2)) {
							System.out.print("ERROR : "
									+ "Please insert coordinate to shoot in the format, "
									+ "with the space included (row, column): \n");
							Coordinate = input.next();
						    Coordinate2 = input.next();
						    CoordinateT = Coordinate.trim();
						    Coordinate2T = Coordinate2.trim();
						    
							FirstBracket = CoordinateT.charAt(0);
						    xCoordinate = CoordinateT.charAt(1);
						    Comma = CoordinateT.charAt(2);
							yCoordinate = Coordinate2T.charAt(0);
							SecondBracket = Coordinate2T.charAt(1);
							
							xCoordinate = Character.getNumericValue(xCoordinate);
							yCoordinate = Character.toUpperCase(yCoordinate);
						}	
						
						System.out.print("The selected coordinate to shoot is ("
								+ (xCoordinate) + ", " + yCoordinate + "). \n");
						
					    //Coordinate Conversion
						xCoordinate = (xCoordinate - 1);
						if (yCoordinate == 'A') {
							yCoordinate = 0;
						}
						else if (yCoordinate == 'B') {
							yCoordinate = 1;
						}
						else if (yCoordinate == 'C') {
							yCoordinate = 2;
						}
						else if (yCoordinate == 'D') {
							yCoordinate = 3;
						}
						else if (yCoordinate == 'E') {
							yCoordinate = 4;
						}
						else if (yCoordinate == 'F') {
							yCoordinate = 5;
						}
						else {
							yCoordinate = 6;
						}
						
						       //Printing the Board with Boats and Hits
								System.out.print("\n");
								for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
									 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
											 System.out.print(" " + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
											 System.out.print(" A" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
											 System.out.print(" B" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
											 System.out.print(" C" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
											 System.out.print(" D" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
											 System.out.print(" E" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
											 System.out.print(" F" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
											 System.out.print(" G" + "\t");
									 }
									}
									 System.out.println("\n");
									 
									 //Conditions for Hitting
									 if (board[xCoordinate][yCoordinate] == -1) {
										 board[xCoordinate][yCoordinate] = 0;
									 }
									 if ((board[xCoordinate][yCoordinate] > 10 ) && 
										 (board[xCoordinate][yCoordinate] < 21)) {
										  board[xCoordinate][yCoordinate] = (board[xCoordinate][yCoordinate] - 10);
									 }
									 
									 
									 System.out.print("1");
									 while (axisRows2 < board.length) {
										for(int rows = 0; rows < board.length; rows++) { 
										  for(int columns = 0; columns < board[rows].length; columns++) {
											  //Water Hit
											 if (board[rows][columns] == 0) {
												 hit = SymbolMiss;
												 System.out.print("\t" + "[" + hit + "]");
											 }
											 //Vertical Boat 1 Hit 
											 else if ((board[rows][columns] >= 1) && 
													 (board[rows][columns] <= 3)){
												 if ((board[xcoord1][ycoord1] == 1) &&
														 (board[xcoord1A][ycoord1] == 2) &&
														 (board[xcoord1B][ycoord1] == 3)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Vertical Boat 2 Hit
											 else if ((board[rows][columns] >= 4) && 
													 (board[rows][columns] <= 5)){
												 if ((board[xcoord2][ycoord2] == 4) &&
														 (board[xcoord2A][ycoord2] == 5)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 1 Hit
											 else if ((board[rows][columns] >= 6) && 
													 (board[rows][columns] <= 8)){
												 if ((board[xcoord3][ycoord3] == 6) &&
														 (board[xcoord3][ycoord3A] == 7) &&
														 (board[xcoord3][ycoord3B] == 8)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 2 Hit
											 else if ((board[rows][columns] >= 9) && 
													 (board[rows][columns] <= 10)){
												 if ((board[xcoord4][ycoord4] == 9) &&
														 (board[xcoord4][ycoord4A] == 10)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 else {
											 System.out.print("\t" + "[" + sea + "]");
											 }
										 	 }
											  axisRows2 ++;
											  if (axisRows2 == 8) break;
										 System.out.print("\n\n" + axisRows2);
										   }
										  }
									 System.out.print("\n\n");
									
									 //Vertical Boat 1 Sunk
									 if ((board[xcoord1][ycoord1] == 1) &&
											 (board[xcoord1A][ycoord1] == 2) &&
											 (board[xcoord1B][ycoord1] == 3)) {
										 while (cond1 == 0) {
										 ShipsSunk += 1;
										 cond1 += 1;
										 }
									}
									//Vertical Boat 2 Sunk
									 if ((board[xcoord2][ycoord2] == 4) &&
											 (board[xcoord2A][ycoord2] == 5)) {
										 while (cond2 == 0) {
										 ShipsSunk += 1;
										 cond2 += 1;
										 }
									}
									//Horizontal Boat 1 Sunk
									 if ((board[xcoord3][ycoord3] == 6) &&
											 (board[xcoord3][ycoord3A] == 7) &&
											 (board[xcoord3][ycoord3B] == 8)) {
										 while (cond3 == 0) {
										 ShipsSunk += 1;
										 cond3 += 1;
										 }
									}
									 //Horizontal Boat 2 Sunk
									 if ((board[xcoord4][ycoord4] == 9) &&
											 (board[xcoord4][ycoord4A] == 10)) {
										 while (cond4 == 0) {
										 ShipsSunk += 1;
										 cond4 += 1;
										 }
									}
							//Resets Board Counter		 
							axisRows2 = 1;
							//Adds Shots Fired each Turn
							ShotsFired += 1;
						}
						
						//System Analysis
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Game Final Report
						System.out.print("The game is over! \n" + "It took " + ShotsFired + " shots! \n"
								+ GamesPlayed + " Games Played. \n" + "Do you want to play again? \n"
										+ "(Y / N) \n");
						Answer = input.next().charAt(0);
						
						AnswerUP = Character.toUpperCase(Answer);

						//Transforms the Play Again Answer until is correct
						while (AnswerUP != 'Y' && AnswerUP != 'N') {
							System.out.print("Please insert a character between Y or N "
									+ "(Y for Yes and N for No): \n\n");
							AnswerUP = input.next().charAt(0);
							
								if (AnswerUP == 'y' || AnswerUP == 'n'){
									AnswerUP = Character.toUpperCase(AnswerUP);
								}
							}
						//Ends the Game if No and if Yes continues as variable PlayAgain remains 1
						if (AnswerUP == 'N'){
							PlayAgain = 0;
							if (PlayAgain == 0) {
						    System.out.print("\nGAME ENDED.");
							}
						}
				}
				
				
			}
			
			if (BoardSize == 8) {
				System.out.print("Select character symbol for water: \n");
				char SymbolWater = select.next().charAt(0);
				System.out.print("Select character symbol for a missed shot: \n");
				char SymbolMiss = select.next().charAt(0);
				System.out.print("Select character symbol for touched boats: \n");
				char SymbolTouched = select.next().charAt(0);
				System.out.print("Select character symbol for sunk boats: \n");
				char SymbolSunk = select.next().charAt(0);
				
				int PlayerMode = 1;
				
				if (PlayerMode == 1) {
					int [][] axisLetters = new int [1][9];
					int [][] board = new int [8][8];
					int axisRows = 1;
					int axisRows2 = 1;
					
					// BOARD BATTLEFIELD
						for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
						 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
								 System.out.print(" " + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
								 System.out.print(" A" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
								 System.out.print(" B" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
								 System.out.print(" C" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
								 System.out.print(" D" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
								 System.out.print(" E" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
								 System.out.print(" F" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
								 System.out.print(" G" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (9 * columnLetters))
								 System.out.print(" H" + "\t");
						 }
						}
						 System.out.println("\n");
						 
						 //Prints the Board to Screen
						 char sea = SymbolWater;
						 System.out.print("1");
						 while (axisRows < board.length) {
							for(int rows = 0; rows < board.length; rows++) { 
							  for(int columns = 0; columns < board[rows].length; columns++) {
								  board[rows][columns] = -1;
								 System.out.print("\t" + "[" + sea + "]");
							 	 }
								  axisRows ++;
								  if (axisRows == 9) break;
							 System.out.print("\n\n" + axisRows);
							   }
							  }
						 System.out.print("\n\n");
						 
						 // BOATS PLACEMENT
						 //Coordinate Variables
						 int xcoord1, xcoord2, xcoord3, xcoord4,
						 xcoord1A, xcoord1B, xcoord2A,
						 ycoord1, ycoord2, ycoord3, ycoord4,
						 ycoord3A, ycoord3B, ycoord4A;
						 int randxA, randyA, randxA1, 
						 randxB, randyB, randyB1, randyB2, 
						 randxC, randyC, randyC1;
						 
						 //Coordinate Assignation
						//Ship Vertical 1
						 xcoord1 = (int)(Math.random() * 8.0);
						 ycoord1 = (int)(Math.random() * 8.0);
						 
						 if (xcoord1 == 0) {
							 xcoord1A = 1;
							 xcoord1B = 2;
						  }
						 else if (xcoord1 <= 6 && xcoord1 >= 1) {
							 xcoord1A = (xcoord1 - 1);
							 xcoord1B = (xcoord1 + 1);
						  }
						 else {
							 xcoord1A = 5;
							 xcoord1B = 6;
						  }
						 
						 board[xcoord1][ycoord1] = 11;
						 board[xcoord1A][ycoord1] = 12;
						 board[xcoord1B][ycoord1] = 13;
						 
						 
						//Ship Vertical 2
						 do {
						 randxA = (int)(Math.random() * 8.0);
						 randyA = (int)(Math.random() * 8.0);
						 	if (randxA == 7) {
						 		randxA1 = randxA - 1;
						 	}
						 	else {
						 		randxA1 = randxA + 1;
						 	}
						 }
						 while ((board[randxA][randyA] != -1) || 
								 (board[randxA1][randyA] != -1));
						 
						 xcoord2 = randxA;
						 xcoord2A = randxA1;
						 ycoord2 = randyA;
						 
							board[xcoord2][ycoord2] = 14;
							board[xcoord2A][ycoord2] = 15;
					
						 
						//Ship Horizontal 1
						do {
						 randxB = (int)(Math.random() * 8.0);
						 randyB = (int)(Math.random() * 8.0);	
						 if (randyB == 0) {
							 randyB1 = randyB + 1;
							 randyB2 = randyB + 2;
						  }
						 else if (randyB <= 6 && randyB >= 1) {
							 randyB1 = (randyB + 1);
							 randyB2 = (randyB - 1);
						  }
						 else {
							 randyB1 = randyB - 1;
							 randyB2 = randyB - 2;
						  }
						}
						while((board[randxB][randyB] != -1) || 
								 (board[randxB][randyB1] != -1) ||
								 (board[randxB][randyB2] != -1));
						
						 xcoord3 = randxB;
						 ycoord3 = randyB;
						 ycoord3A = randyB1;
						 ycoord3B = randyB2;
						 
						 board[xcoord3][ycoord3] = 16;
						 board[xcoord3][ycoord3A] = 17;
						 board[xcoord3][ycoord3B] = 18;
						 
						
						//Ship Horizontal 2
						 do {
						 randxC = (int)(Math.random() * 8.0);
						 randyC = (int)(Math.random() * 8.0);
						 if (randyC == 7) {
							 randyC1 = randyC - 1;
						  }
						 else {
							 randyC1 = randyC + 1;
						  }
						 }
						 while((board[randxC][randyC] != -1) || 
								 (board[randxC][randyC1] != -1));
						 
						 xcoord4 = randxC;
						 ycoord4 = randyC;
		                 ycoord4A = randyC1;				 
						 
						 board[xcoord4][ycoord4] = 19;
						 board[xcoord4][ycoord4A] = 20;
						  
						 
						//BOAT SHOOTING
						 //Variables
						int ShotsFired = 0;
						int ShipsSunk = 0;
						int cond1 = 0;
						int cond2 = 0;
						int cond3 = 0;
						int cond4 = 0;
						char hit = SymbolTouched;
						
						//Starts Game
						while (ShipsSunk < 4) {
						
						//Analysis Recap
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Coordinate Input
						int xCoordinate;
						Character FirstBracket, Comma, yCoordinate, SecondBracket;
						System.out.print("Insert coordinate to shoot in the format (row, column): \n");
					    String Coordinate = input.next();
					    String Coordinate2 = input.next();
					    String CoordinateT = Coordinate.trim();
					    String Coordinate2T = Coordinate2.trim();
					    
					    FirstBracket = CoordinateT.charAt(0);
					    xCoordinate = CoordinateT.charAt(1);
					    Comma = CoordinateT.charAt(2);
						yCoordinate = Coordinate2T.charAt(0);
						SecondBracket = Coordinate2T.charAt(1);
						
						xCoordinate = Character.getNumericValue(xCoordinate);
						yCoordinate = Character.toUpperCase(yCoordinate);
						
						while ((FirstBracket != '(') || ((xCoordinate < 1) || (xCoordinate > 8)) ||
								(Comma != ',') || ((yCoordinate != 'A') && (yCoordinate != 'B') &&
								(yCoordinate != 'C') && (yCoordinate != 'D') && (yCoordinate != 'E') 
								&& (yCoordinate != 'F') && (yCoordinate != 'G') && (yCoordinate != 'H')) 
								|| (SecondBracket != ')') || (CoordinateT.length() != 3) 
								|| (Coordinate2T.length() != 2)) {
							System.out.print("ERROR : "
									+ "Please insert coordinate to shoot in the format, "
									+ "with the space included (row, column): \n");
							Coordinate = input.next();
						    Coordinate2 = input.next();
						    CoordinateT = Coordinate.trim();
						    Coordinate2T = Coordinate2.trim();
						    
							FirstBracket = CoordinateT.charAt(0);
						    xCoordinate = CoordinateT.charAt(1);
						    Comma = CoordinateT.charAt(2);
							yCoordinate = Coordinate2T.charAt(0);
							SecondBracket = Coordinate2T.charAt(1);
							
							xCoordinate = Character.getNumericValue(xCoordinate);
							yCoordinate = Character.toUpperCase(yCoordinate);
						}	
						
						System.out.print("The selected coordinate to shoot is ("
								+ (xCoordinate) + ", " + yCoordinate + "). \n");
						
					    //Coordinate Conversion
						xCoordinate = (xCoordinate - 1);
						if (yCoordinate == 'A') {
							yCoordinate = 0;
						}
						else if (yCoordinate == 'B') {
							yCoordinate = 1;
						}
						else if (yCoordinate == 'C') {
							yCoordinate = 2;
						}
						else if (yCoordinate == 'D') {
							yCoordinate = 3;
						}
						else if (yCoordinate == 'E') {
							yCoordinate = 4;
						}
						else if (yCoordinate == 'F') {
							yCoordinate = 5;
						}
						else if (yCoordinate == 'G') {
							yCoordinate = 6;
						}
						else {
							yCoordinate = 7;
						}
						
						       //Printing the Board with Boats and Hits
								System.out.print("\n");
								for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
									 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
											 System.out.print(" " + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
											 System.out.print(" A" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
											 System.out.print(" B" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
											 System.out.print(" C" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
											 System.out.print(" D" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
											 System.out.print(" E" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
											 System.out.print(" F" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
											 System.out.print(" G" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (9 * columnLetters))
											 System.out.print(" H" + "\t");
									 }
									}
									 System.out.println("\n");
									 
									 //Conditions for Hitting
									 if (board[xCoordinate][yCoordinate] == -1) {
										 board[xCoordinate][yCoordinate] = 0;
									 }
									 if ((board[xCoordinate][yCoordinate] > 10 ) && 
										 (board[xCoordinate][yCoordinate] < 21)) {
										  board[xCoordinate][yCoordinate] = (board[xCoordinate][yCoordinate] - 10);
									 }
									 
									 
									 System.out.print("1");
									 while (axisRows2 < board.length) {
										for(int rows = 0; rows < board.length; rows++) { 
										  for(int columns = 0; columns < board[rows].length; columns++) {
											  //Water Hit
											 if (board[rows][columns] == 0) {
												 hit = SymbolMiss;
												 System.out.print("\t" + "[" + hit + "]");
											 }
											 //Vertical Boat 1 Hit 
											 else if ((board[rows][columns] >= 1) && 
													 (board[rows][columns] <= 3)){
												 if ((board[xcoord1][ycoord1] == 1) &&
														 (board[xcoord1A][ycoord1] == 2) &&
														 (board[xcoord1B][ycoord1] == 3)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Vertical Boat 2 Hit
											 else if ((board[rows][columns] >= 4) && 
													 (board[rows][columns] <= 5)){
												 if ((board[xcoord2][ycoord2] == 4) &&
														 (board[xcoord2A][ycoord2] == 5)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 1 Hit
											 else if ((board[rows][columns] >= 6) && 
													 (board[rows][columns] <= 8)){
												 if ((board[xcoord3][ycoord3] == 6) &&
														 (board[xcoord3][ycoord3A] == 7) &&
														 (board[xcoord3][ycoord3B] == 8)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 2 Hit
											 else if ((board[rows][columns] >= 9) && 
													 (board[rows][columns] <= 10)){
												 if ((board[xcoord4][ycoord4] == 9) &&
														 (board[xcoord4][ycoord4A] == 10)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 else {
											 System.out.print("\t" + "[" + sea + "]");
											 }
										 	 }
											  axisRows2 ++;
											  if (axisRows2 == 9) break;
										 System.out.print("\n\n" + axisRows2);
										   }
										  }
									 System.out.print("\n\n");
									
									 //Vertical Boat 1 Sunk
									 if ((board[xcoord1][ycoord1] == 1) &&
											 (board[xcoord1A][ycoord1] == 2) &&
											 (board[xcoord1B][ycoord1] == 3)) {
										 while (cond1 == 0) {
										 ShipsSunk += 1;
										 cond1 += 1;
										 }
									}
									//Vertical Boat 2 Sunk
									 if ((board[xcoord2][ycoord2] == 4) &&
											 (board[xcoord2A][ycoord2] == 5)) {
										 while (cond2 == 0) {
										 ShipsSunk += 1;
										 cond2 += 1;
										 }
									}
									//Horizontal Boat 1 Sunk
									 if ((board[xcoord3][ycoord3] == 6) &&
											 (board[xcoord3][ycoord3A] == 7) &&
											 (board[xcoord3][ycoord3B] == 8)) {
										 while (cond3 == 0) {
										 ShipsSunk += 1;
										 cond3 += 1;
										 }
									}
									 //Horizontal Boat 2 Sunk
									 if ((board[xcoord4][ycoord4] == 9) &&
											 (board[xcoord4][ycoord4A] == 10)) {
										 while (cond4 == 0) {
										 ShipsSunk += 1;
										 cond4 += 1;
										 }
									}
							//Resets Board Counter		 
							axisRows2 = 1;
							//Adds Shots Fired each Turn
							ShotsFired += 1;
						}
						
						//System Analysis
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Game Final Report
						System.out.print("The game is over! \n" + "It took " + ShotsFired + " shots! \n"
								+ GamesPlayed + " Games Played. \n" + "Do you want to play again? \n"
										+ "(Y / N) \n");
						Answer = input.next().charAt(0);
						
						AnswerUP = Character.toUpperCase(Answer);

						//Transforms the Play Again Answer until is correct
						while (AnswerUP != 'Y' && AnswerUP != 'N') {
							System.out.print("Please insert a character between Y or N "
									+ "(Y for Yes and N for No): \n\n");
							AnswerUP = input.next().charAt(0);
							
								if (AnswerUP == 'y' || AnswerUP == 'n'){
									AnswerUP = Character.toUpperCase(AnswerUP);
								}
							}
						//Ends the Game if No and if Yes continues as variable PlayAgain remains 1
						if (AnswerUP == 'N'){
							PlayAgain = 0;
							if (PlayAgain == 0) {
						    System.out.print("\nGAME ENDED.");
							}
						}
				}
				
				
			}
			
			if (BoardSize == 9) {
				System.out.print("Select character symbol for water: \n");
				char SymbolWater = select.next().charAt(0);
				System.out.print("Select character symbol for a missed shot: \n");
				char SymbolMiss = select.next().charAt(0);
				System.out.print("Select character symbol for touched boats: \n");
				char SymbolTouched = select.next().charAt(0);
				System.out.print("Select character symbol for sunk boats: \n");
				char SymbolSunk = select.next().charAt(0);
				
				int PlayerMode = 1;
				
				if (PlayerMode == 1) {
					int [][] axisLetters = new int [1][10];
					int [][] board = new int [9][9];
					int axisRows = 1;
					int axisRows2 = 1;
					
					// BOARD BATTLEFIELD
						for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
						 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
								 System.out.print(" " + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
								 System.out.print(" A" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
								 System.out.print(" B" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
								 System.out.print(" C" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
								 System.out.print(" D" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
								 System.out.print(" E" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
								 System.out.print(" F" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
								 System.out.print(" G" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (9 * columnLetters))
								 System.out.print(" H" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (10 * columnLetters))
								 System.out.print(" I" + "\t");
						 }
						}
						 System.out.println("\n");
						 
						 //Prints the Board to Screen
						 char sea = SymbolWater;
						 System.out.print("1");
						 while (axisRows < board.length) {
							for(int rows = 0; rows < board.length; rows++) { 
							  for(int columns = 0; columns < board[rows].length; columns++) {
								  board[rows][columns] = -1;
								 System.out.print("\t" + "[" + sea + "]");
							 	 }
								  axisRows ++;
								  if (axisRows == 10) break;
							 System.out.print("\n\n" + axisRows);
							   }
							  }
						 System.out.print("\n\n");
						 
						 // BOATS PLACEMENT
						 //Coordinate Variables
						 int xcoord1, xcoord2, xcoord3, xcoord4,
						 xcoord1A, xcoord1B, xcoord2A,
						 ycoord1, ycoord2, ycoord3, ycoord4,
						 ycoord3A, ycoord3B, ycoord4A;
						 int randxA, randyA, randxA1, 
						 randxB, randyB, randyB1, randyB2, 
						 randxC, randyC, randyC1;
						 
						 //Coordinate Assignation
						//Ship Vertical 1
						 xcoord1 = (int)(Math.random() * 9.0);
						 ycoord1 = (int)(Math.random() * 9.0);
						 
						 if (xcoord1 == 0) {
							 xcoord1A = 1;
							 xcoord1B = 2;
						  }
						 else if (xcoord1 <= 7 && xcoord1 >= 1) {
							 xcoord1A = (xcoord1 - 1);
							 xcoord1B = (xcoord1 + 1);
						  }
						 else {
							 xcoord1A = 6;
							 xcoord1B = 7;
						  }
						 
						 board[xcoord1][ycoord1] = 11;
						 board[xcoord1A][ycoord1] = 12;
						 board[xcoord1B][ycoord1] = 13;
						 
						 
						//Ship Vertical 2
						 do {
						 randxA = (int)(Math.random() * 9.0);
						 randyA = (int)(Math.random() * 9.0);
						 	if (randxA == 8) {
						 		randxA1 = randxA - 1;
						 	}
						 	else {
						 		randxA1 = randxA + 1;
						 	}
						 }
						 while ((board[randxA][randyA] != -1) || 
								 (board[randxA1][randyA] != -1));
						 
						 xcoord2 = randxA;
						 xcoord2A = randxA1;
						 ycoord2 = randyA;
						 
							board[xcoord2][ycoord2] = 14;
							board[xcoord2A][ycoord2] = 15;
					
						 
						//Ship Horizontal 1
						do {
						 randxB = (int)(Math.random() * 9.0);
						 randyB = (int)(Math.random() * 9.0);	
						 if (randyB == 0) {
							 randyB1 = randyB + 1;
							 randyB2 = randyB + 2;
						  }
						 else if (randyB <= 7 && randyB >= 1) {
							 randyB1 = (randyB + 1);
							 randyB2 = (randyB - 1);
						  }
						 else {
							 randyB1 = randyB - 1;
							 randyB2 = randyB - 2;
						  }
						}
						while((board[randxB][randyB] != -1) || 
								 (board[randxB][randyB1] != -1) ||
								 (board[randxB][randyB2] != -1));
						
						 xcoord3 = randxB;
						 ycoord3 = randyB;
						 ycoord3A = randyB1;
						 ycoord3B = randyB2;
						 
						 board[xcoord3][ycoord3] = 16;
						 board[xcoord3][ycoord3A] = 17;
						 board[xcoord3][ycoord3B] = 18;
						 
						
						//Ship Horizontal 2
						 do {
						 randxC = (int)(Math.random() * 9.0);
						 randyC = (int)(Math.random() * 9.0);
						 if (randyC == 8) {
							 randyC1 = randyC - 1;
						  }
						 else {
							 randyC1 = randyC + 1;
						  }
						 }
						 while((board[randxC][randyC] != -1) || 
								 (board[randxC][randyC1] != -1));
						 
						 xcoord4 = randxC;
						 ycoord4 = randyC;
		                 ycoord4A = randyC1;				 
						 
						 board[xcoord4][ycoord4] = 19;
						 board[xcoord4][ycoord4A] = 20;
						  
						 
						//BOAT SHOOTING
						 //Variables
						int ShotsFired = 0;
						int ShipsSunk = 0;
						int cond1 = 0;
						int cond2 = 0;
						int cond3 = 0;
						int cond4 = 0;
						char hit = SymbolTouched;
						
						//Starts Game
						while (ShipsSunk < 4) {
						
						//Analysis Recap
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Coordinate Input
						int xCoordinate;
						Character FirstBracket, Comma, yCoordinate, SecondBracket;
						System.out.print("Insert coordinate to shoot in the format (row, column): \n");
					    String Coordinate = input.next();
					    String Coordinate2 = input.next();
					    String CoordinateT = Coordinate.trim();
					    String Coordinate2T = Coordinate2.trim();
					    
					    FirstBracket = CoordinateT.charAt(0);
					    xCoordinate = CoordinateT.charAt(1);
					    Comma = CoordinateT.charAt(2);
						yCoordinate = Coordinate2T.charAt(0);
						SecondBracket = Coordinate2T.charAt(1);
						
						xCoordinate = Character.getNumericValue(xCoordinate);
						yCoordinate = Character.toUpperCase(yCoordinate);
						
						while ((FirstBracket != '(') || ((xCoordinate < 1) || (xCoordinate > 9)) ||
								(Comma != ',') || ((yCoordinate != 'A') && (yCoordinate != 'B') &&
								(yCoordinate != 'C') && (yCoordinate != 'D') && (yCoordinate != 'E') 
								&& (yCoordinate != 'F') && (yCoordinate != 'G') && (yCoordinate != 'H')
								&& (yCoordinate != 'I')) || (SecondBracket != ')') || (CoordinateT.length() != 3) 
								|| (Coordinate2T.length() != 2)) {
							System.out.print("ERROR : "
									+ "Please insert coordinate to shoot in the format, "
									+ "with the space included (row, column): \n");
							Coordinate = input.next();
						    Coordinate2 = input.next();
						    CoordinateT = Coordinate.trim();
						    Coordinate2T = Coordinate2.trim();
						    
							FirstBracket = CoordinateT.charAt(0);
						    xCoordinate = CoordinateT.charAt(1);
						    Comma = CoordinateT.charAt(2);
							yCoordinate = Coordinate2T.charAt(0);
							SecondBracket = Coordinate2T.charAt(1);
							
							xCoordinate = Character.getNumericValue(xCoordinate);
							yCoordinate = Character.toUpperCase(yCoordinate);
						}	
						
						System.out.print("The selected coordinate to shoot is ("
								+ (xCoordinate) + ", " + yCoordinate + "). \n");
						
					    //Coordinate Conversion
						xCoordinate = (xCoordinate - 1);
						if (yCoordinate == 'A') {
							yCoordinate = 0;
						}
						else if (yCoordinate == 'B') {
							yCoordinate = 1;
						}
						else if (yCoordinate == 'C') {
							yCoordinate = 2;
						}
						else if (yCoordinate == 'D') {
							yCoordinate = 3;
						}
						else if (yCoordinate == 'E') {
							yCoordinate = 4;
						}
						else if (yCoordinate == 'F') {
							yCoordinate = 5;
						}
						else if (yCoordinate == 'G') {
							yCoordinate = 6;
						}
						else if (yCoordinate == 'H') {
							yCoordinate = 7;
						}
						else {
							yCoordinate = 8;
						}
						
						       //Printing the Board with Boats and Hits
								System.out.print("\n");
								for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
									 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
											 System.out.print(" " + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
											 System.out.print(" A" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
											 System.out.print(" B" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
											 System.out.print(" C" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
											 System.out.print(" D" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
											 System.out.print(" E" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
											 System.out.print(" F" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
											 System.out.print(" G" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (9 * columnLetters))
											 System.out.print(" H" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (10 * columnLetters))
											 System.out.print(" I" + "\t");
									 }
									}
									 System.out.println("\n");
									 
									 //Conditions for Hitting
									 if (board[xCoordinate][yCoordinate] == -1) {
										 board[xCoordinate][yCoordinate] = 0;
									 }
									 if ((board[xCoordinate][yCoordinate] > 10 ) && 
										 (board[xCoordinate][yCoordinate] < 21)) {
										  board[xCoordinate][yCoordinate] = (board[xCoordinate][yCoordinate] - 10);
									 }
									 
									 
									 System.out.print("1");
									 while (axisRows2 < board.length) {
										for(int rows = 0; rows < board.length; rows++) { 
										  for(int columns = 0; columns < board[rows].length; columns++) {
											  //Water Hit
											 if (board[rows][columns] == 0) {
												 hit = SymbolMiss;
												 System.out.print("\t" + "[" + hit + "]");
											 }
											 //Vertical Boat 1 Hit 
											 else if ((board[rows][columns] >= 1) && 
													 (board[rows][columns] <= 3)){
												 if ((board[xcoord1][ycoord1] == 1) &&
														 (board[xcoord1A][ycoord1] == 2) &&
														 (board[xcoord1B][ycoord1] == 3)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Vertical Boat 2 Hit
											 else if ((board[rows][columns] >= 4) && 
													 (board[rows][columns] <= 5)){
												 if ((board[xcoord2][ycoord2] == 4) &&
														 (board[xcoord2A][ycoord2] == 5)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 1 Hit
											 else if ((board[rows][columns] >= 6) && 
													 (board[rows][columns] <= 8)){
												 if ((board[xcoord3][ycoord3] == 6) &&
														 (board[xcoord3][ycoord3A] == 7) &&
														 (board[xcoord3][ycoord3B] == 8)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 2 Hit
											 else if ((board[rows][columns] >= 9) && 
													 (board[rows][columns] <= 10)){
												 if ((board[xcoord4][ycoord4] == 9) &&
														 (board[xcoord4][ycoord4A] == 10)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 else {
											 System.out.print("\t" + "[" + sea + "]");
											 }
										 	 }
											  axisRows2 ++;
											  if (axisRows2 == 10) break;
										 System.out.print("\n\n" + axisRows2);
										   }
										  }
									 System.out.print("\n\n");
									
									 //Vertical Boat 1 Sunk
									 if ((board[xcoord1][ycoord1] == 1) &&
											 (board[xcoord1A][ycoord1] == 2) &&
											 (board[xcoord1B][ycoord1] == 3)) {
										 while (cond1 == 0) {
										 ShipsSunk += 1;
										 cond1 += 1;
										 }
									}
									//Vertical Boat 2 Sunk
									 if ((board[xcoord2][ycoord2] == 4) &&
											 (board[xcoord2A][ycoord2] == 5)) {
										 while (cond2 == 0) {
										 ShipsSunk += 1;
										 cond2 += 1;
										 }
									}
									//Horizontal Boat 1 Sunk
									 if ((board[xcoord3][ycoord3] == 6) &&
											 (board[xcoord3][ycoord3A] == 7) &&
											 (board[xcoord3][ycoord3B] == 8)) {
										 while (cond3 == 0) {
										 ShipsSunk += 1;
										 cond3 += 1;
										 }
									}
									 //Horizontal Boat 2 Sunk
									 if ((board[xcoord4][ycoord4] == 9) &&
											 (board[xcoord4][ycoord4A] == 10)) {
										 while (cond4 == 0) {
										 ShipsSunk += 1;
										 cond4 += 1;
										 }
									}
							//Resets Board Counter		 
							axisRows2 = 1;
							//Adds Shots Fired each Turn
							ShotsFired += 1;
						}
						
						//System Analysis
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Game Final Report
						System.out.print("The game is over! \n" + "It took " + ShotsFired + " shots! \n"
								+ GamesPlayed + " Games Played. \n" + "Do you want to play again? \n"
										+ "(Y / N) \n");
						Answer = input.next().charAt(0);
						
						AnswerUP = Character.toUpperCase(Answer);

						//Transforms the Play Again Answer until is correct
						while (AnswerUP != 'Y' && AnswerUP != 'N') {
							System.out.print("Please insert a character between Y or N "
									+ "(Y for Yes and N for No): \n\n");
							AnswerUP = input.next().charAt(0);
							
								if (AnswerUP == 'y' || AnswerUP == 'n'){
									AnswerUP = Character.toUpperCase(AnswerUP);
								}
							}
						//Ends the Game if No and if Yes continues as variable PlayAgain remains 1
						if (AnswerUP == 'N'){
							PlayAgain = 0;
							if (PlayAgain == 0) {
						    System.out.print("\nGAME ENDED.");
							}
						}
				}
				
				
			}
			
			if (BoardSize == 10) {
				System.out.print("Select character symbol for water: \n");
				char SymbolWater = select.next().charAt(0);
				System.out.print("Select character symbol for a missed shot: \n");
				char SymbolMiss = select.next().charAt(0);
				System.out.print("Select character symbol for touched boats: \n");
				char SymbolTouched = select.next().charAt(0);
				System.out.print("Select character symbol for sunk boats: \n");
				char SymbolSunk = select.next().charAt(0);
			
				int PlayerMode = 1;
				
				if (PlayerMode == 1) {
					int [][] axisLetters = new int [1][11];
					int [][] board = new int [10][10];
					int axisRows = 1;
					int axisRows2 = 1;
					
					// BOARD BATTLEFIELD
						for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
						 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
								 System.out.print(" " + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
								 System.out.print(" A" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
								 System.out.print(" B" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
								 System.out.print(" C" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
								 System.out.print(" D" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
								 System.out.print(" E" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
								 System.out.print(" F" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
								 System.out.print(" G" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (9 * columnLetters))
								 System.out.print(" H" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (10 * columnLetters))
								 System.out.print(" I" + "\t");
							 if (axisLetters[rowLetters][columnLetters] == rowLetters + (11 * columnLetters))
								 System.out.print(" J" + "\t");
						 }
						}
						 System.out.println("\n");
						 
						 //Prints the Board to Screen
						 char sea = SymbolWater;
						 System.out.print("1");
						 while (axisRows < board.length) {
							for(int rows = 0; rows < board.length; rows++) { 
							  for(int columns = 0; columns < board[rows].length; columns++) {
								  board[rows][columns] = -1;
								 System.out.print("\t" + "[" + sea + "]");
							 	 }
								  axisRows ++;
								  if (axisRows == 11) break;
							 System.out.print("\n\n" + axisRows);
							   }
							  }
						 System.out.print("\n\n");
						 
						 // BOATS PLACEMENT
						 //Coordinate Variables
						 int xcoord1, xcoord2, xcoord3, xcoord4,
						 xcoord1A, xcoord1B, xcoord2A,
						 ycoord1, ycoord2, ycoord3, ycoord4,
						 ycoord3A, ycoord3B, ycoord4A;
						 int randxA, randyA, randxA1, 
						 randxB, randyB, randyB1, randyB2, 
						 randxC, randyC, randyC1;
						 
						 //Coordinate Assignation
						//Ship Vertical 1
						 xcoord1 = (int)(Math.random() * 10.0);
						 ycoord1 = (int)(Math.random() * 10.0);
						 
						 if (xcoord1 == 0) {
							 xcoord1A = 1;
							 xcoord1B = 2;
						  }
						 else if (xcoord1 <= 8 && xcoord1 >= 1) {
							 xcoord1A = (xcoord1 - 1);
							 xcoord1B = (xcoord1 + 1);
						  }
						 else {
							 xcoord1A = 7;
							 xcoord1B = 8;
						  }
						 
						 board[xcoord1][ycoord1] = 11;
						 board[xcoord1A][ycoord1] = 12;
						 board[xcoord1B][ycoord1] = 13;
						 
						 
						//Ship Vertical 2
						 do {
						 randxA = (int)(Math.random() * 10.0);
						 randyA = (int)(Math.random() * 10.0);
						 	if (randxA == 9) {
						 		randxA1 = randxA - 1;
						 	}
						 	else {
						 		randxA1 = randxA + 1;
						 	}
						 }
						 while ((board[randxA][randyA] != -1) || 
								 (board[randxA1][randyA] != -1));
						 
						 xcoord2 = randxA;
						 xcoord2A = randxA1;
						 ycoord2 = randyA;
						 
							board[xcoord2][ycoord2] = 14;
							board[xcoord2A][ycoord2] = 15;
					
						 
						//Ship Horizontal 1
						do {
						 randxB = (int)(Math.random() * 10.0);
						 randyB = (int)(Math.random() * 10.0);	
						 if (randyB == 0) {
							 randyB1 = randyB + 1;
							 randyB2 = randyB + 2;
						  }
						 else if (randyB <= 8 && randyB >= 1) {
							 randyB1 = (randyB + 1);
							 randyB2 = (randyB - 1);
						  }
						 else {
							 randyB1 = randyB - 1;
							 randyB2 = randyB - 2;
						  }
						}
						while((board[randxB][randyB] != -1) || 
								 (board[randxB][randyB1] != -1) ||
								 (board[randxB][randyB2] != -1));
						
						 xcoord3 = randxB;
						 ycoord3 = randyB;
						 ycoord3A = randyB1;
						 ycoord3B = randyB2;
						 
						 board[xcoord3][ycoord3] = 16;
						 board[xcoord3][ycoord3A] = 17;
						 board[xcoord3][ycoord3B] = 18;
						 
						
						//Ship Horizontal 2
						 do {
						 randxC = (int)(Math.random() * 10.0);
						 randyC = (int)(Math.random() * 10.0);
						 if (randyC == 9) {
							 randyC1 = randyC - 1;
						  }
						 else {
							 randyC1 = randyC + 1;
						  }
						 }
						 while((board[randxC][randyC] != -1) || 
								 (board[randxC][randyC1] != -1));
						 
						 xcoord4 = randxC;
						 ycoord4 = randyC;
		                 ycoord4A = randyC1;				 
						 
						 board[xcoord4][ycoord4] = 19;
						 board[xcoord4][ycoord4A] = 20;
						  
						 
						//BOAT SHOOTING
						 //Variables
						int ShotsFired = 0;
						int ShipsSunk = 0;
						int cond1 = 0;
						int cond2 = 0;
						int cond3 = 0;
						int cond4 = 0;
						char hit = SymbolTouched;
						
						//Starts Game
						while (ShipsSunk < 4) {
						
						//Analysis Recap
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Coordinate Input
						int xCoordinate;
						Character FirstBracket, Comma, yCoordinate, SecondBracket;
						System.out.print("Insert coordinate to shoot in the format (row, column): \n");
					    String Coordinate = input.next();
					    String Coordinate2 = input.next();
					    String CoordinateT = Coordinate.trim();
					    String Coordinate2T = Coordinate2.trim();
					    
					    FirstBracket = CoordinateT.charAt(0);
					    xCoordinate = CoordinateT.charAt(1);
					    Comma = CoordinateT.charAt(2);
					    if (Comma == 0){
					    	Comma = CoordinateT.charAt(3);
					    }
						yCoordinate = Coordinate2T.charAt(0);
						SecondBracket = Coordinate2T.charAt(1);
						
						xCoordinate = Character.getNumericValue(xCoordinate);
						yCoordinate = Character.toUpperCase(yCoordinate);
					    
					    
						while ((FirstBracket != '(') || ((xCoordinate < 1) || (xCoordinate > 10)) ||
								(Comma != ',') || ((yCoordinate != 'A') && (yCoordinate != 'B') &&
								(yCoordinate != 'C') && (yCoordinate != 'D') && (yCoordinate != 'E') 
								&& (yCoordinate != 'F') && (yCoordinate != 'G') && (yCoordinate != 'H')
								&& (yCoordinate != 'I') && (yCoordinate != 'J')) || (SecondBracket != ')') 
								|| (CoordinateT.length() != 3) || (Coordinate2T.length() != 2)) {
							System.out.print("ERROR : "
									+ "Please insert coordinate to shoot in the format, "
									+ "with the space included (row, column): \n");
							Coordinate = input.next();
						    Coordinate2 = input.next();
						    CoordinateT = Coordinate.trim();
						    Coordinate2T = Coordinate2.trim();
						    
							FirstBracket = CoordinateT.charAt(0);
						    xCoordinate = CoordinateT.charAt(1);
						    Comma = CoordinateT.charAt(2);
							yCoordinate = Coordinate2T.charAt(0);
							SecondBracket = Coordinate2T.charAt(1);
							
							xCoordinate = Character.getNumericValue(xCoordinate);
							yCoordinate = Character.toUpperCase(yCoordinate);
						}	
						
						System.out.print("The selected coordinate to shoot is ("
								+ (xCoordinate) + ", " + yCoordinate + "). \n");
						
					    //Coordinate Conversion
						xCoordinate = (xCoordinate - 1);
						if (yCoordinate == 'A') {
							yCoordinate = 0;
						}
						else if (yCoordinate == 'B') {
							yCoordinate = 1;
						}
						else if (yCoordinate == 'C') {
							yCoordinate = 2;
						}
						else if (yCoordinate == 'D') {
							yCoordinate = 3;
						}
						else if (yCoordinate == 'E') {
							yCoordinate = 4;
						}
						else if (yCoordinate == 'F') {
							yCoordinate = 5;
						}
						else if (yCoordinate == 'G') {
							yCoordinate = 6;
						}
						else if (yCoordinate == 'H') {
							yCoordinate = 7;
						}
						else if (yCoordinate == 'I') {
							yCoordinate = 8;
						}
						else {
							yCoordinate = 9;
						}
						
						       //Printing the Board with Boats and Hits
								System.out.print("\n");
								for(int rowLetters = 0; rowLetters < axisLetters.length; rowLetters++){
									 for(int columnLetters = 0; columnLetters < axisLetters[rowLetters].length; columnLetters++){
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + columnLetters)
											 System.out.print(" " + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (2 * columnLetters))
											 System.out.print(" A" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (3 * columnLetters))
											 System.out.print(" B" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (4 * columnLetters))
											 System.out.print(" C" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (5 * columnLetters))
											 System.out.print(" D" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (6 * columnLetters))
											 System.out.print(" E" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (7 * columnLetters))
											 System.out.print(" F" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (8 * columnLetters))
											 System.out.print(" G" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (9 * columnLetters))
											 System.out.print(" H" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (10 * columnLetters))
											 System.out.print(" I" + "\t");
										 if (axisLetters[rowLetters][columnLetters] == rowLetters + (11 * columnLetters))
											 System.out.print(" J" + "\t");
									 }
									}
									 System.out.println("\n");
									 
									 //Conditions for Hitting
									 if (board[xCoordinate][yCoordinate] == -1) {
										 board[xCoordinate][yCoordinate] = 0;
									 }
									 if ((board[xCoordinate][yCoordinate] > 10 ) && 
										 (board[xCoordinate][yCoordinate] < 21)) {
										  board[xCoordinate][yCoordinate] = (board[xCoordinate][yCoordinate] - 10);
									 }
									 
									 
									 System.out.print("1");
									 while (axisRows2 < board.length) {
										for(int rows = 0; rows < board.length; rows++) { 
										  for(int columns = 0; columns < board[rows].length; columns++) {
											  //Water Hit
											 if (board[rows][columns] == 0) {
												 hit = SymbolMiss;
												 System.out.print("\t" + "[" + hit + "]");
											 }
											 //Vertical Boat 1 Hit 
											 else if ((board[rows][columns] >= 1) && 
													 (board[rows][columns] <= 3)){
												 if ((board[xcoord1][ycoord1] == 1) &&
														 (board[xcoord1A][ycoord1] == 2) &&
														 (board[xcoord1B][ycoord1] == 3)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Vertical Boat 2 Hit
											 else if ((board[rows][columns] >= 4) && 
													 (board[rows][columns] <= 5)){
												 if ((board[xcoord2][ycoord2] == 4) &&
														 (board[xcoord2A][ycoord2] == 5)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 1 Hit
											 else if ((board[rows][columns] >= 6) && 
													 (board[rows][columns] <= 8)){
												 if ((board[xcoord3][ycoord3] == 6) &&
														 (board[xcoord3][ycoord3A] == 7) &&
														 (board[xcoord3][ycoord3B] == 8)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 //Horizontal Boat 2 Hit
											 else if ((board[rows][columns] >= 9) && 
													 (board[rows][columns] <= 10)){
												 if ((board[xcoord4][ycoord4] == 9) &&
														 (board[xcoord4][ycoord4A] == 10)) {
													 hit = SymbolSunk;
													 System.out.print("\t" + "[" + hit + "]");
												 }
												 else {
												 hit = SymbolTouched;
												 System.out.print("\t" + "[" + hit + "]");
												 }
											 }
											 else {
											 System.out.print("\t" + "[" + sea + "]");
											 }
										 	 }
											  axisRows2 ++;
											  if (axisRows2 == 11) break;
										 System.out.print("\n\n" + axisRows2);
										   }
										  }
									 System.out.print("\n\n");
									
									 //Vertical Boat 1 Sunk
									 if ((board[xcoord1][ycoord1] == 1) &&
											 (board[xcoord1A][ycoord1] == 2) &&
											 (board[xcoord1B][ycoord1] == 3)) {
										 while (cond1 == 0) {
										 ShipsSunk += 1;
										 cond1 += 1;
										 }
									}
									//Vertical Boat 2 Sunk
									 if ((board[xcoord2][ycoord2] == 4) &&
											 (board[xcoord2A][ycoord2] == 5)) {
										 while (cond2 == 0) {
										 ShipsSunk += 1;
										 cond2 += 1;
										 }
									}
									//Horizontal Boat 1 Sunk
									 if ((board[xcoord3][ycoord3] == 6) &&
											 (board[xcoord3][ycoord3A] == 7) &&
											 (board[xcoord3][ycoord3B] == 8)) {
										 while (cond3 == 0) {
										 ShipsSunk += 1;
										 cond3 += 1;
										 }
									}
									 //Horizontal Boat 2 Sunk
									 if ((board[xcoord4][ycoord4] == 9) &&
											 (board[xcoord4][ycoord4A] == 10)) {
										 while (cond4 == 0) {
										 ShipsSunk += 1;
										 cond4 += 1;
										 }
									}
							//Resets Board Counter		 
							axisRows2 = 1;
							//Adds Shots Fired each Turn
							ShotsFired += 1;
						}
						
						//System Analysis
						System.out.print("Shots Fired: " + ShotsFired + "\n");
						System.out.print("Ships Sunk: " + ShipsSunk + "\n\n");
						
						//Game Final Report
						System.out.print("The game is over! \n" + "It took " + ShotsFired + " shots! \n"
								+ GamesPlayed + " Games Played. \n" + "Do you want to play again? \n"
										+ "(Y / N) \n");
						Answer = input.next().charAt(0);
						
						AnswerUP = Character.toUpperCase(Answer);

						//Transforms the Play Again Answer until is correct
						while (AnswerUP != 'Y' && AnswerUP != 'N') {
							System.out.print("Please insert a character between Y or N "
									+ "(Y for Yes and N for No): \n\n");
							AnswerUP = input.next().charAt(0);
							
								if (AnswerUP == 'y' || AnswerUP == 'n'){
									AnswerUP = Character.toUpperCase(AnswerUP);
								}
							}
						//Ends the Game if No and if Yes continues as variable PlayAgain remains 1
						if (AnswerUP == 'N'){
							PlayAgain = 0;
							if (PlayAgain == 0) {
						    System.out.print("\nGAME ENDED.");
							}
						}
				}
				
				
			  }
			}
		}
	}
}
	

		 
		



			
		 
	
	
