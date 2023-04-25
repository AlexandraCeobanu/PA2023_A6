package org.example.tema7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private static final Cell [][] matrix =new Cell[5][5];
    //Cell should be a wrapper or alias for List<Token>
    ExplorationMap()
    {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = new Cell();
            }
        }}
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].getTokens().isEmpty() == true) {
                robot.fail=false;
                robot.explore.getMem().extractTokens(5);
                List<Token> extractedTokens = robot.explore.getMem().extractTokens(5);
                matrix[row][col].setTokens(extractedTokens);
                   System.out.println("Robotul " + robot.getName() + " a reusit sa viziteze " + row + " "+ col);
                   robot.setNumberOfTokenset();
               /* System.out.println(extractedTokens);*/
            } else   {
                System.out.println("Un robot a vizitat deja celula "+ row + " " + col);
                robot.fail=true;
            }
        }
        synchronized (matrix) {
            if (checkUnvisitedCells(matrix) == 0)
                return false;
        }
        return true;
    }
    public int checkUnvisitedCells(Cell[][] matrix)
    {
        int nrOfUnvisitedCells = 0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(matrix[i][j].getTokens().isEmpty()==true)
                    ++nrOfUnvisitedCells;
            }
        }
        return nrOfUnvisitedCells;
    }
    public Cell[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder s=new StringBuilder();
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                s.append(matrix[i][j].getTokens().toString());
                s.append(" ");
            }
            s.append("\n");
        }
        return "ExplorationMap{" +
                s;
    }
}
