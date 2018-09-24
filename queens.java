/*
*
*EIGHT QUEENS PUZZLE
*
* Problem description can be found at: https://open.kattis.com/problems/8queens
*
*Author: Schahin Rajab
*
*"In the eight queens puzzle, eight queens must be placed on a standard 8×8 chess board so that no 
*queen can attack another. The center figure below shows an invalid solution; two queens can attack
*each other diagonally. The figure on the right shows a valid solution. Given a description of a 
*chess board, your job is to determine whether or not it represents a valid solution to the eight 
*queens puzzle.
*
*INPUT
*
*Input will contain a description of a single chess board, given as eight lines of eight characters each. 
*Input lines will consist of only the characters ‘.’ and ‘*’. The ‘.’ character represents an empty
*space on the board, and the ‘*’ character represents a queen.
*
*OUTPUT
*
*Print a single line of output. Print the word 'valid' if the given chess board is a valid solution to the 
*eight queens problem. Otherwise, print 'invalid'. 
*
*SAMPLE INPUT:
**.......
*..*.....
*....*...
*......*.
*.*......
*.......*
*.....*..
*...*....
*
*SAMPLE OUTPUT:
*invalid
*
*SAMPLE INPUT:
**.......
*......*.
*....*...
*.......*
*.*......
*...*....
*.....*..
*..*.....
*
*SAMPLE OUTPUT:
*valid"
*
*(Source: https://open.kattis.com/problems/8queens)
*
*/

import java.util.*;

	public class queens{
		
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			
			String input = new String();
			StringBuilder squares = new StringBuilder();
			
			int numQueens = 0;
			
			//user input queens and squares			
			for(int in = 0; in < 8; in++){
				input = sc.next();
				squares.append(input);
			}
			
			
       
			char[][] board = new char[8][8];
			int k = 0;
			//input queens and squares to chess board
			if(squares.length() == 64){
			while(k < 64){
				for(int i = 0; i < 8; i++){
					for(int j = 0; j < 8; j++){
						board[i][j] = squares.charAt(k);
						k++;
					}
				}
			}
			}	 
											
			/*print chessboard for debugging
			for (int a = 0; a < 8; a++){  
				for (int b = 0; b < 8; b++){
					System.out.print(board[a][b]);
					if (b==7)
					System.out.println(" ");
				}
			}*/
   
			int count = 0;
   
			//check ranks
			for (int file = 0; file < 8; file++){
				count = 0;
				for (int rank=0; rank < 8; rank++){
					if(board [file][rank]=='*'){
					count++;
					numQueens++; //counts total number of queens on the board
					}
				}
				if (count != 1){ //if more than one queen or no queen is on a rank, output 'invalid'
				invalid ();
				System.exit(0); //terminate program when invalid found
				}
			}
			
			/*used for debugging
			if (count < 2)
			System.out.println ("ranks valid");
			*/
			
			count = 0;
		
		//check files
			for (int rank2 = 0; rank2 < 8; rank2++){
				count = 0;
				for (int file2 = 0; file2 < 8; file2++){
					if(board [file2][rank2]=='*')
					count++;
				}
				if (count != 1){ //if more than one queen or no queen is on a file, output 'invalid'
				invalid ();
				System.exit(0); //terminate program when invalid found
				}
			}
			/*used for debugging
			if (count < 2)
			System.out.println ("files valid");
			*/
			
			int tmp = 0;
			int d1 = 0;
			int d2 = 0;
			count = 0;
			//checks diagonals from diagonal [0][0] to diagonal [7][0]-[0][7]
			while(true){
			
				//used for debugging, iterates through every index
				//System.out.println("line 148: " + "d1 " + d1 + " d2 " + d2);
			
				if(board[d1][d2] == '*')
				count++;

				if (count > 1){ //if more than one queen is on a diagonal, output 'invalid'
				invalid ();
				System.exit(0); //terminate program when invalid found
				}

				if(d1 == 0 && d2 == 7) //break out of while if last diagonal has been checked
					break;

				if(d1 == 0 && d2 == 0){
				d1 = tmp+1 ;
				count = 0;
				}

				else if(d1 != 0 && d2 == 0){
				tmp = d1;
				d1--;
				d2++;
				}

				else if(d1 != 0 && d2 != 0){
				d1--;
				d2++;
				}

				else if(d1 == 0 && d2 != 0){	
				d1 = tmp+1;
				d2 = 0;
				count = 0;
				}

			}
			
			tmp = 7;
			d1 = 7;
			d2 = 7;
			count = 0;
			
			//checks diagonals from diagonal [7][7] to diagonal [7][0]-[0][7]
			while(true){
			
				//used for debugging, iterates through every index
				//System.out.println("line 193: " + "d1 " + d1 + " d2 " + d2);
			
				if(board[d1][d2] == '*')
				count++;

				if (count > 1){ //if more than one queen is on a diagonal, output 'invalid'
				invalid ();
				System.exit(0); //terminate program when invalid found
				}

				if(d1 == 0 && d2 == 7) //break out of while if last diagonal has been checked
					break;

				if(d1 == 7 && d2 == 7){
				d2 = tmp-1 ;
				count = 0;
				}

				else if(d1 != 7 && d2 == 7){
				d2 = tmp-1;
				d1 = 7;
				count = 0;
				}

				else if(d1 != 7 && d2 != 7){
				d1--;
				d2++;
				}

				else if(d1 == 7 && d2 != 7){	
				d1--;
				d2++;
				tmp = d2-1;
				}

			}
			
			tmp = 0;
			d1 = 0;
			d2 = 7;
			count = 0;
			
			
			//checks diagonals from diagonal [0][7] to diagonal [0][0]-[7][7]
			while(true){
			
				//used for debugging, iterates through every index
				//System.out.println("line 241: " + "d1 " + d1 + " d2 " + d2);
			
				if(board[d1][d2] == '*')
				count++;

				if (count > 1){ //if more than one queen is on a diagonal, output 'invalid'
				invalid ();
				System.exit(0); //terminate program when invalid found
				}

				if(d1 == 7 && d2 == 7) //break out of while if last diagonal has been checked
					break;

				if(d1 == 0 && d2 == 7){
				d1 = tmp+1 ;
				count = 0;
				}

				else if(d1 != 7 && d2 == 7){
				tmp = d1+1;
				d1--;
				d2--;
				}
				
				else if(d1 == 0 && d2 != 7){	
				d1=tmp;
				d2=7;
				count = 0;
				}
				
				else if(d1 != 7 && d2 != 7){
				d1--;
				d2--;
				}
				
				



			}
			
			tmp = 0;
			d1 = 7;
			d2 = 0;
			count = 0;
			
			
			//checks diagonals from diagonal [7][0] to diagonal [0][0]-[7][7]
			while(true){
			
				//used for debugging, iterates through every index
				//System.out.println("line 290: " + "d1 " + d1 + " d2 " + d2);
			
				if(board[d1][d2] == '*')
				count++;

				if (count > 1){ //if more than one queen is on a diagonal, output 'invalid'
				invalid ();
				System.exit(0); //terminate program when invalid found
				}

				if(d1 == 0 && d2 == 0) //break out of while if last diagonal has been checked
					break;

				if(d1 == 7 && d2 == 0){
				d2++;
				count = 0;
				}
				
				else if(d1 != 7 && d2 == 0){
				d2=tmp;
				d1=7;
				count = 0;
				}

				
				else if(d1 == 7 && d2 != 7){
				tmp=d2+1;
				d1--;
				d2--;
				}
				
				else if(d1 != 7 && d2 != 7){
				d1--;
				d2--;
				}
				
				else if(d1 == 7 && d2 == 7){
				d1--;
				d2--;
				}


			}
			
		
		if(count < 2 && numQueens == 8)
			System.out.println ("valid");
		else
			System.out.println ("invalid");
		//close main
		}
   
		public static void invalid (){
			System.out.println ("invalid");
		}
  //close class
	}