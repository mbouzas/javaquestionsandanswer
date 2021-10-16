package com.questionsandanswers.java.collections;

/*
 * Complete the solution function
 */

import java.util.ArrayList;
import java.util.List;

public class IslandConnectedCell {


    int width ;
    int height;
    int [][] table;


    public IslandConnectedCell(int width, int height, int[][] table) {
        this.width = width;
        this.height = height;
        this.table = table;
    }




    public static void main(String... args) {

        int [][] table =
                {
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1}
                };
        System.out.println(new IslandConnectedCell(4,5,table).solution());
    }




    java.util.List<Integer> solution() {
        /*
         *  Write your solution here !
         *  You can use the result variable
         *  below to return your answer
         */
        int result = 0;

	/*		int count = 0;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					this.table[i][j] = island_map[count];
					count++;
				}
			}*/

        boolean visited[][] = new boolean[width][height];
        List<Integer> countList = new ArrayList<>();
        for (int row = 0; row < width; row++)
            for (int col = 0; col < height; col++)
                if (table[row][col] == 1 && !visited[row][col])
                    countList.add(mark(row, col, visited));
        return countList;

    }


    private int mark(int row, int col, boolean[][] visited) {
        if (row >= width || row < 0 || col >= height || col < 0 || this.table[row][col] == 0 || visited[row][col])
            return 0;
        visited[row][col] = true;
        int count = 1;
        for (int r = -1; r <= 1; r++)
            for (int c = -1; c <= 1; c++)
                if (r != 0 || c != 0)
                    count += mark(row + r, col + c, visited);
        return count;
    }


}
