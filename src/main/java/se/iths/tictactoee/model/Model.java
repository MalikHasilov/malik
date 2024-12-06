package se.iths.tictactoee.model;

public class Model {
    private final char[][] board; // Spelbrädan
    private char currentPlayer; // Håller reda på aktuell spelare x/o

    public Model() {
        board = new char[3][3]; // intierar spelbrädan i 3x3 formmat
        currentPlayer = 'X'; // Spelaren X börjar
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == '\0') {
            board[row][col] = currentPlayer;         //gör ett drag om angivna rutan är tom och växlar mellan spelarna.
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    public char checkWinner() {
        // Kontrollera rader, kolumner och diagonaler för att se om nån vunnit
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != '\0' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }
        if (board[0][0] != '\0' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != '\0' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return '\0'; // Ingen vinnare
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {   // kollar om brädan är full och returnerar true elle false
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\0'; // Återställer varje yta
            }
        }
        currentPlayer = 'X'; // Börja med spelare X
    }

    public char[][] getBoard() {
       return board; //retrunerar brädan
    }

    public char getCurrentPlayer() {
        return currentPlayer; //returnar spelaren
    }
}