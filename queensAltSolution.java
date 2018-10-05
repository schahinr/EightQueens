/*
 * Author: Schahin Rajab
 * 
 * This program solves the same problem but with less code.
 * This code does not use any arrays, instead it uses the fact
 * that the chess board is always a square. Knowing this we can
 * just work with the 64-character string directly to find queens.
 * 
 */

import java.util.*;

public class queensAltSolution {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
         
         String input = new String();
         StringBuilder board = new StringBuilder();
         
         int numQueens = 0;
         int tmp;
         
         //user input queens and squares         
         for(int in = 0; in < 8; in++){
             input = sc.next();
             board.append(input);
         }
         
     	int row = 8;
     	int i = -1;
     	
     	while(true) {
     		i++;	//traverse the whole board
     		
     		if(i >= board.length())
     			break;	//exit while loop when traversed through the whole board
     		
     		//if queen is found, search if it can reach another queen
     		if(board.charAt(i) == '*') {
     			numQueens++;	//we want to know if there were 8 queens on board
     			tmp = i;	//save i to tmp
     			
     			//check file (|) for another queen
     			while(true) {
     				tmp = tmp + row;	//increment to the next row
     				if(tmp >= board.length())
     					break;	//exit while loop when traversed the whole file
     				if(board.charAt(tmp) == '*') {
     					invalid ();
     					System.exit(0); //terminate program when invalid found
     				}
     			}
     			
 				tmp = i;
 				//check row (-) for another queen
 				if(tmp % 8 != 7) {
 					while(true) {
 						tmp++;
 						 	     				
     					if(board.charAt(tmp) == '*') {
     					invalid ();
 						System.exit(0); //terminate program when invalid found
     					}
     					
 						if(tmp % 8 == 7) //check if reached edge of board
     						break;	//exit while loop 
 					}
 				}

 				tmp = i;
     			//check diagonal (\) for another queen
 				if(tmp % 8 != 7) {
 					while(true) {
 						tmp = tmp + 9;
 						if(tmp > board.length())
 							break;
     				
 						if(board.charAt(tmp) == '*') {
 							invalid ();
 							System.exit(0); //terminate program when invalid found
 						}
     				
 						if(tmp % 8 == 7) //check if reached edge of board	
 							break;
 					}
 				}
 				//check diagonal (/) for another queen
 				tmp = i;
 				if(tmp % 8 != 0) {
 					while(true) {
 						tmp = tmp + 7;
 						if(tmp >= board.length())
 							break;
         			
 						if(board.charAt(tmp) == '*') {
 							invalid ();
 							System.exit(0); //terminate program when invalid found
 						}
         			
 						if(tmp % 8 == 0)  //check if reached edge of board
 							break;
 					}
 				}
 			//close if-statement used when searching for multiple queens
     		}
     	//close while loop
     	}
     	
     	 if(numQueens == 8)
             System.out.println ("valid");
         else
             System.out.println ("invalid");
    //close main    
	}
	
	   public static void invalid (){
           System.out.println ("invalid");
           System.exit(0); 
       }
//close class
}
