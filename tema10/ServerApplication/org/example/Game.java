package org.example;

public class Game {

    private boolean gameOver=false;
    private int player;
    private int nrJucatori;
    Game()
    {
        player=0;
        nrJucatori=1;
    }

    public int getNrJucatori() {
        return nrJucatori;
    }

    public void setNrJucatori() {
        ++nrJucatori;
    }
    public void removePlayer()
    {
        --nrJucatori;
    }
    public synchronized int getPlayer() {
        return player;
    }

    public synchronized void setPlayer(int player) {
        this.player = player;
    }

    public boolean checkWinner(Board board, int i, int j)
    {
        int[][] matrix ;
        matrix=board.getBoard();
        if(checkLine(matrix,i,j)==5 || checkColumn(matrix,i,j)==5)
        {
            gameOver=true;
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int checkLine(int[][] matrix, int i, int j){
        int count=1;
        int jCopy=j;
        while(jCopy-1>=0 && matrix[i][j]==matrix[i][jCopy-1] && matrix[i][j]!=0)
        {
            --jCopy;
            ++count;
        }
        jCopy=j;
        while(jCopy+1<7 && matrix[i][j]==matrix[i][jCopy+1] && matrix[i][j]!=0)
        {
            ++jCopy;
            ++count;
        }
        return count;
    }
    public int checkColumn(int[][] matrix,int i,int j){
        int count=1;
        int iCopy=i;
        while(iCopy-1>=0 && matrix[i][j]==matrix[iCopy-1][j] && matrix[i][j]!=0)
        {
            --iCopy;
            ++count;
        }
        iCopy=i;
        while(iCopy+1<7 && matrix[i][j]==matrix[iCopy+1][j] && matrix[i][j]!=0)
        {
            ++iCopy;
            ++count;
        }
        return count;
    }

}
