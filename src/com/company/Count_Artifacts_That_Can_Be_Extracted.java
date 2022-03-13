package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Count_Artifacts_That_Can_Be_Extracted {
    public int digArtifacts_mywrongsolution(int n, int[][] artifacts, int[][] dig) {
        int count = 0;
        List<Cell> cells = new ArrayList<>();
        for(int i = 0;i< artifacts.length;i++)
        {
            cells.add( new Cell(artifacts[i][0], artifacts[i][1],artifacts[i][2],artifacts[i][3]));
        }

        for(int i = 0;i<dig.length;i++) {
            int x = dig[i][0];
            int y = dig[i][1];
            for (Cell cell : cells)
            {
                if( cell.r1<=x && x <= cell.r2 && cell.c1<=y && y <= cell.c2 )
                {
                    cell.size --;
                    if(cell.size == 0)
                    {
                        count++;
                        cells.remove(cell);
                    }
                }
            }
        }
        return  count;
    }
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        int m = dig.length;
        for(int i=0;i<m;i++){
            set.add(dig[i][0] + "-" + dig[i][1]);
        }
        m = artifacts.length;
        for(int i=0;i<m;i++){
            List<String> cells = getArtifactCells(artifacts[i]);
            boolean found = true;
            for(String cell: cells){
                if(!set.contains(cell)){
                    found = false;
                    break;
                }
            }
            if(found == true){
                ans++;
            }
        }
        return ans;
    }
    private List<String> getArtifactCells(int[] artifact){
        int r1= artifact[0];
        int c1= artifact[1];
        int r2= artifact[2];
        int c2= artifact[3];

        List<String> cells = new ArrayList<>();
        Set<String> uniqueCells = new HashSet<>();

        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                cells.add(i + "-" + j);
            }
        }

        return cells;
    }
    class Cell
    {
        int r1;
        int c1;
        int r2;
        int c2;
        int size;

        Cell(int r1, int c1, int r2, int c2)
        {
            this.r1 = r1;
            this.c1= c1;
            this.r2 = r2;
            this.c2 = c2;
            this.size = r2- r1 + c2 - c1;
        }
    }
}
