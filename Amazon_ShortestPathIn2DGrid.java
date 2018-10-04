/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KD
 */
import java.util.*;
public class Amazon_ShortestPathIn2DGrid {
    public int shortestPath(char[][] matrix) {
        int s_row = 0, s_col = 0;
        boolean flag = false;
        for (s_row = 0; s_row < matrix.length; s_row++) {
            for (s_col = 0; s_col < matrix[0].length; s_col++) {
                if (matrix[s_row][s_col] == 'S') flag = true;
                if (flag) break;
            }
            if (flag) break;
        }
        return shortestPath(matrix, s_row, s_col);
    }
    
    public int shortestPath(char[][] matrix, int s_row, int s_col) {
        int count = 0;
        Queue<int[]> nextToVisit = new LinkedList<>();
        nextToVisit.offer(new int[]{s_row, s_col});
        Set<int[]> visited = new HashSet<>();
        Queue<int[]> temp = new LinkedList<>();
        
        while (!nextToVisit.isEmpty()) {
            int[] position = nextToVisit.poll();
            int row = position[0];
            int col = position[1];
            
            if (matrix[row][col] == 'E') 
                return count;
            if (row > 0 && !visited.contains(new int[]{row-1, col}) && matrix[row-1][col] != 'X') 
                temp.offer(new int[]{row-1, col});
            if (row < matrix.length-1 && !visited.contains(new int[]{row+1, col}) && matrix[row+1][col] != 'X') 
                temp.offer(new int[]{row+1, col});
            if (col > 0 && !visited.contains(new int[]{row, col-1}) && matrix[row][col-1] != 'X') 
                temp.offer(new int[]{row, col-1});
            if (col < matrix[0].length-1 && !visited.contains(new int[]{row, col+1}) && matrix[row][col+1] != 'X') 
                temp.offer(new int[]{row, col+1});
            
            if (nextToVisit.isEmpty() && !temp.isEmpty()) {
                nextToVisit = temp;
                temp = new LinkedList<>();
                count++;
            }
            
        }
        
        return count;
    }

    public static void main(String[] args) {
        char[][] matrix =  {{'S','X','1','1','1'},
                            {'1','X','X','1','1'},
                            {'1','1','1','1','1'},
                            {'X','1','1','E','1'},
                            {'1','1','1','1','X'}};
        
        
        Amazon_ShortestPathIn2DGrid ama = new Amazon_ShortestPathIn2DGrid();
        System.out.println(ama.shortestPath(matrix));
    }

}
