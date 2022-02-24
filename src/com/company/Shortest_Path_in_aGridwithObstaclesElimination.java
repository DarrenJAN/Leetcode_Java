package com.company;

import java.util.*;

public class Shortest_Path_in_aGridwithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dir = new int[][]{{-1,0}, { 0, 1}, {1, 0}, {0,-1}};

        HashSet<Cell> cells = new HashSet<>();
        Cell start = new Cell(0,0, k);
        Queue<Cell> queue = new LinkedList<>();
        cells.add(start);
        queue.add(start);
        int step = 0;

        while(! queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i < size;i++)
            {
                Cell cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                int obs = cur.obs;
                if(x == row-1 && y == col-1)
                    return  step;
                for(int j= 0;j< 4;j++)
                {
                    int new_x = x + dir[j][0];
                    int new_y = y + dir[j][1];
                    if(new_x<0 || new_x >= row || new_y< 0 || new_y >= col)
                        continue;

                    Cell new_cell;
                    if(grid[new_x][new_y] == 1)
                    {
                        if(obs == 0)
                            continue;
                        new_cell = new Cell(new_x, new_y, obs-1);
                    }else
                    {
                        new_cell = new Cell(new_x, new_y, obs);
                    }

                    if(!cells.contains(new_cell))
                    {
                        cells.add(new_cell);
                        queue.add(new_cell);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    static class  Cell
    {
        int x;
        int y;
        int obs;

        public  Cell(int x, int y ,int obs)
        {
            this.x = x;
            this.y = y;
            this.obs = obs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y && obs == cell.obs;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, obs);
        }

        //for print
        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    ", obs=" + obs +
                    '}';
        }

    }


    public static void main(String[] args) {

        HashSet<Cell> hashSet = new HashSet<>();

        Cell cell1 = new Cell(0,0,0);
        Cell cell2 = new Cell(0,0,0);

        hashSet.add(cell1);

        System.out.println(hashSet.contains(cell2));
    }
}
