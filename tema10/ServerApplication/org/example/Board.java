package org.example;

public class Board {
    private int[][] board =new int[7][7];
    private int nrJucatori;
    public Board()
    {
        nrJucatori=1;
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                board[i][j]=0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }
    public int getNrJucatori() {
        return nrJucatori;
    }

    public void setNrJucatori() {
        ++nrJucatori;
    }

    public void printBoard()
    {
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
                System.out.print(board[i][j]+ "  ");
            System.out.println();
        }
    }

    String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("\n");
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                sb.append(matrix[i][j]);
                sb.append("  ");
            }
            sb.append("\n");
        }
        sb.append("]\n");
        sb.append("#");
        return sb.toString();
    }
    public boolean updateMatrix(int[][] matrix,int i,int j,int idJucator)
    {
        if(i< 7 && j<7)
        {
            matrix[i][j]=idJucator;
            return true;
        }
        return false;
    }
    public void resetBoard()
    {
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                board[i][j]=0;
            }
        }
    }
}

