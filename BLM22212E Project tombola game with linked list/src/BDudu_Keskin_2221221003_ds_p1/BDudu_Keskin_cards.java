/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDudu_Keskin_2221221003_ds_p1;

import java.util.Random;

/**
 * @param <T>
 * @file BDudu_Keskin_2221221003_ds_p1
 * @description tombola game for 2 players with linked list
 * @assignment 2023-2024 2nd term 1st project (midterm project)
 * @date 14.03.2024-31.03.2024
 * @author B. Dudu Keskin
 * @mail beyzadudu.keskin@stu.fsm.edu.tr
 */
public class BDudu_Keskin_cards<T> {

    BDudu_Keskin_node<T> head;

//------------------------------------------------------------------------------

    public static int[] generatePermutation() {
        int[] permutation = new int[90];
        for (int i = 0; i < 90; i++) {
            permutation[i] = i + 1;
        }
        Random rand = new Random();
        for (int i = 89; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = permutation[i];
            permutation[i] = permutation[j];
            permutation[j] = temp;
        }
        return permutation;
    }

//------------------------------------------------------------------------------
    
    public static <T> boolean containsValue(int[][] matrix, int value) {
        for (int[] row : matrix) {
            for (int column : row) {
                if (column == value) {
                    return true;
                }
            }
        }
        return false;
    }

//------------------------------------------------------------------------------
    
    public static int[][] createCardMatrix() {

        int[][] matrix = new int[3][9];
        int[] permutation = BDudu_Keskin_cards.generatePermutation();
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int randomCol;
                do {
                    randomCol = rand.nextInt(9);
                } while (matrix[i][randomCol] == -1);

                matrix[i][randomCol] = -1;
            }

            int minValue = 0;
            int maxValue = 0;
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] != -1) {

                    minValue = (j * 10) + 1;
                    maxValue = (j + 1) * 10;
                    
                    int value;
                    do {
                        value = permutation[rand.nextInt(90)];
                    } while (value < minValue || value > maxValue || containsValue(matrix, value));
                    
                    matrix[i][j] = value;
                }
            }
        } return matrix;
    }

//------------------------------------------------------------------------------
    
    public static int[][] reducedMatrix(int[][] matrix) {

        int[][] rdcMatrix = new int[3][5];

        for (int i = 0; i < 3; i++) {
            int k = 0;
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] != -1) {
                    rdcMatrix[i][k] = matrix[i][j];
                    k++;
                }
            }
        }
        return rdcMatrix;
    }

//------------------------------------------------------------------------------  
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                if (i == row.length - 1) {
                    System.out.print(row[i]);
                } else {
                    System.out.print(row[i] + ", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("");
    }

//------------------------------------------------------------------------------
    
    public static <T> BDudu_Keskin_cards<T> convertMatrixToList(int[][] matrix) {

        BDudu_Keskin_cards<T> card = new BDudu_Keskin_cards<>();

        for (int[] row : matrix) {
            BDudu_Keskin_node<T> curr = null;
            for (int j = 0; j < row.length; j++) {
                BDudu_Keskin_node<T> newNode = new BDudu_Keskin_node<>((T) Integer.valueOf(row[j]));
                
                
                if (j == 0) {
                    if (card.head == null) {
                        card.head = newNode;
                    } else {
                        BDudu_Keskin_node<T> temp = card.head;
                        while (temp.down != null) {
                            temp = temp.down;
                        }
                        temp.down = newNode;
                    }
                }
                
                if (curr != null) {
                    curr.next = newNode;
                }
                curr = newNode;
            }
        }
        return card;
    }

//------------------------------------------------------------------------------
    
    public void printLinkedList() {
        BDudu_Keskin_node temp = head;
        while (temp != null) {
            BDudu_Keskin_node<T> current = temp;
            int count = 0;
            while (current != null ) {
                if (count == 4) {
                    System.out.println(current.data);
                } else {
                    System.out.print(current.data + " > ");
                }
                current = current.next;
                count++;
            }
            temp = temp.down;
            if (temp != null) {
                System.out.println("|");
            }
        }
        System.out.println();
    }

//------------------------------------------------------------------------------
    
    //
    public static int drawNum(int[] permutation, int step) {
        if (step < permutation.length) {
            return permutation[step];
        } else {
            return -1;
        }
    }

//------------------------------------------------------------------------------
    
    public static <T> void markNum(BDudu_Keskin_node<T> head, T num) {
        BDudu_Keskin_node<T> temp = head;
        while (temp != null) {
            BDudu_Keskin_node<T> current = temp;
            while (current != null) {
                if (current.data == num) {
                    current.data = (T) (current.data + "*");
                }
                current = current.next;
            }
            temp = temp.down;
        }
    }

//------------------------------------------------------------------------------
    
    //
    public boolean checkRow1(BDudu_Keskin_cards<T> card) {

        boolean bingo = false;
        int asteriksCount = 0;

        BDudu_Keskin_node<T> temp = card.head;

        while (temp != null) {
            if (temp.data.toString().contains("*")) {
                asteriksCount++;
            }
            temp = temp.next;
        }
        if (asteriksCount == 5) {
            bingo = true;
        }
        return bingo;
    }

    public boolean checkRow2(BDudu_Keskin_cards<T> card) {

        boolean bingo = false;
        int asteriksCount = 0;

        BDudu_Keskin_node<T> temp = card.head.down;

        while (temp != null) {
            if (temp.data.toString().contains("*")) {
                asteriksCount++;
            }
            temp = temp.next;
        }
        if (asteriksCount == 5) {
            bingo = true;
        }
        return bingo;
    }

    public boolean checkRow3(BDudu_Keskin_cards<T> card) {

        boolean bingo = false;
        int asteriksCount = 0;

        BDudu_Keskin_node<T> temp = card.head.down.down;

        while (temp != null) {
            if (temp.data.toString().contains("*")) {
                asteriksCount++;
            }
            temp = temp.next;
        }
        if (asteriksCount == 5) {
            bingo = true;
        }
        return bingo;
    }
}
