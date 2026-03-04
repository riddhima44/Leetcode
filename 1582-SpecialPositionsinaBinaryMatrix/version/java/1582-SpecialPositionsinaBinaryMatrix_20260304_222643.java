// Last updated: 3/4/2026, 10:26:43 PM
1class Solution {
2    public int numSpecial(int[][] mat) {
3        //tc: m*n
4        //sc : m+n
5        int[] row = new int[mat.length];
6        int[] column = new int[mat[0].length];
7        for(int i=0;i<row.length;i++){
8            for(int j=0;j<column.length;j++){
9                if(mat[i][j]==1){
10                    column[j]++;
11                    row[i]++;
12                }
13            }
14        }
15        int specpos=0;
16        // for(int i=0;i<row.length;i++){
17        //     for(int j=0;j<column.length;j++){
18        //         if(mat[i][j]==1 && column[j]==1 && row[i]==1){
19        //             specpos++;
20        //         }
21        //     }
22        // }
23        //you can use this for slight improvisation as it does not check 
24        //the rows which have more than one 1 in them.
25        for(int i=0;i<row.length;i++){
26            if(row[i]==1){
27                for(int j=0;j<column.length;j++){
28                    if(mat[i][j]==1 && column[j]==1){
29                        specpos++;
30                    }
31                }
32            }
33        }
34        return specpos;
35    }
36}