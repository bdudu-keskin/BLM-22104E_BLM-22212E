/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package BDudu_Keskin_2221221003_ds_p1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @file BDudu_Keskin_2221221003_ds_p1
 * @description tombola game for 2 players with linked list
 * @assignment 2023-2024 2nd term 1st project (midterm project)
 * @date  14.03.2024-31.03.2024
 * @author B. Dudu Keskin
 * @mail beyzadudu.keskin@stu.fsm.edu.tr
 */
public class BDudu_Keskin_main {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        /*
        int[][] p1CardMatrix = {{5, -1, 22, -1, 45, -1, 60, 73, -1},
                                {-1, 10, -1, 31, 47, 58, 68, -1, -1},
                                {-1, 17, 26, 38, -1, -1, -1, 79, 86}};
        
        
        int[][] p2CardMatrix = {{-1, 17, -1, 34, -1, 51, 60, -1, 80},
                                {4, -1, 27, -1, 45, -1, -1, 74, 86},
                                {-1, -1, 29, 38, 49, -1, 65, 77, -1}};
        */

        
        /*
        To test your own matrices, simply take the two lines below as comment lines
        and remove the matrices above from the comment line.
        The above matrices are taken from the game example in the DataStr_Project#1.pdf file.
        You can change it as you want.
        There's no need to change the matrix names.
         */
        int[][] p1CardMatrix = BDudu_Keskin_cards.createCardMatrix();
        int[][] p2CardMatrix = BDudu_Keskin_cards.createCardMatrix();

//------------------------------------------------------------------------------

        int[][] p1rdcMatrix = BDudu_Keskin_cards.reducedMatrix(p1CardMatrix);
        int[][] p2rdcMatrix = BDudu_Keskin_cards.reducedMatrix(p2CardMatrix);
        
        // Convert matrix to linked list
        BDudu_Keskin_cards<Integer> p1Card = BDudu_Keskin_cards.convertMatrixToList(p1rdcMatrix);
        BDudu_Keskin_cards<Integer> p2Card = BDudu_Keskin_cards.convertMatrixToList(p2rdcMatrix);

        System.out.println("Array for card of player 1:");
        BDudu_Keskin_cards.printMatrix(p1CardMatrix);

        System.out.println("Array for card of player 2:");
        BDudu_Keskin_cards.printMatrix(p2CardMatrix);

        boolean gameRunning = true;

        int step = 0;  
        
        int[] permutation = BDudu_Keskin_cards.generatePermutation();
        
        System.out.println("permutation for numbers to be drawn: ");
        System.out.println(Arrays.toString(permutation));

        System.out.println("please press the enter for playing the game!");
        
        while (gameRunning && step <= 90) {
            
            String input = scanner.nextLine();

            int drawnNum = BDudu_Keskin_cards.drawNum(permutation, step);

            System.out.println("--------------------");

            System.out.println("turn " + (step + 1));

            if(drawnNum == -1)
                System.out.println("All number has been drawn");
            else
                System.out.println("drawn number: " + drawnNum);

            
            BDudu_Keskin_cards.markNum(p1Card.head, drawnNum);
            BDudu_Keskin_cards.markNum(p2Card.head, drawnNum);

            System.out.println("Player 1 Card:");
            p1Card.printLinkedList();

            System.out.println("Player 2 Card:");
            p2Card.printLinkedList();
            
            
            boolean p1bingo1 = p1Card.checkRow1(p1Card);
            boolean p2bingo1 = p2Card.checkRow1(p2Card);
            
            boolean p1bingo2 = p1Card.checkRow2(p1Card);
            boolean p2bingo2 = p2Card.checkRow2(p2Card);
            
            boolean p1bingo3 = p1Card.checkRow3(p1Card);
            boolean p2bingo3 = p2Card.checkRow3(p2Card);
            
            if(p1bingo1||p1bingo2||p1bingo3)
                System.out.println("First bingo for player 1!");        
            if(p2bingo1||p2bingo2||p2bingo3)
                System.out.println("First bingo for player 2!");
            
            if((p1bingo1&&p1bingo2)||(p1bingo1&&p1bingo3)||(p1bingo3&&p1bingo2))
                System.out.println("Second bingo for player 1!");            
            if((p2bingo1&&p2bingo2)||(p2bingo1&&p2bingo3)||(p2bingo3&&p2bingo2))
                System.out.println("Second bingo for player 2!");
            
            if(p1bingo1&&p1bingo2&&p1bingo3&&p2bingo1&&p2bingo2&&p2bingo3){
                System.out.println("Tombola at the same time! Game ended with a tie!");
                gameRunning = false;
            }else if(p1bingo1&&p1bingo2&&p1bingo3){
                System.out.println("Tombola for player 1! Game is over!");
                gameRunning = false;
            }else if(p2bingo1&&p2bingo2&&p2bingo3){
                System.out.println("Tombola for player 2! Game is over!");
                gameRunning = false;
            }
            
            else if(step == 90){
                System.out.println("No more numbers left to be drawn. Game over!");
                gameRunning = false;
            }
            System.out.println("--------------------");
            step++;
        }
    }
}
