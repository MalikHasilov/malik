package se.iths.tictactoee.model;


import java.util.Random;  // generera slumptal

public class Computer {
    public int[] getMove(char[][] board) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3); //datorn gör slumpmässiga drag tills den hittar en ruta som är tom
            int col = random.nextInt(3);
            if (board[row][col] == '\0') {
                return new int[]{row, col};
            }
        }
    }
}
