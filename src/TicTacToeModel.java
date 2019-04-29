import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.floor;

public class TicTacToeModel {
    int turn = 0;
    int size = 3;
    int[][] board = new int[size][size];

    void initBoard(){
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                board[i][j] = -1;
            }
        }
    }

    int doClick(int index){
        int column = (index % size);
        int row = (index-column)/3;
        if (board[row][column] ==-1) {
            turn++;
            if (turn % 2 == 0) {
                board[row][column] = 0;
            } else {
                board[row][column] = 1;
            }
            return board[row][column];
        }
        return -1;
    }



    boolean checkForWin(){
        int countOnes = 0;
        int countZeros = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if(board[i][j] == 0)countZeros++;
                else if(board[i][j] == 1)countOnes++;
            }

            if(countZeros == size || countOnes == size){
                return true;
            }
            countOnes = 0;
            countZeros = 0;
        }

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {

                if(board[i][j] == 0)countZeros++;
                else if(board[i][j] == 1)countOnes++;

            }

            if(countZeros == size || countOnes == size) return true;
            countOnes = 0;
            countZeros = 0;
        }

        //check diagonal right

        for (int i = 0, j= 0; i <size ; i++, j++) {
            if (board[i][j] == 0) countZeros++;
            else if(board[i][j] == 1) countOnes++;
        }

        if(countOnes == size || countZeros == size) return true;
        countOnes = 0;
        countZeros = 0;

        //check diagonal left
        for (int i = size-1, j= 0; i >= 0 ; i--, j++) {
            if (board[i][j] == 0) countZeros++;
            else if(board[i][j] == 1) countOnes++;

        }

        if(countOnes == size || countZeros == size) return true;

        return false;
    }

    void clear(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = -1;
            }
        }
        turn = 0;
    }

    int[] computerTurn(){
        Random rand = new Random();
        int index = rand.nextInt(size*size);
        int player = doClick(index);
        while (player<0){
            index = rand.nextInt(size*size);
            player = doClick(index);
        }
        int[] data = {player,index};
        System.out.println(index);
        return data;
    }
}
