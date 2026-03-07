// Last updated: 3/8/2026, 2:05:53 AM
1class Solution {
2    public int numberOfSteps(int num) {
3
4        return fun(num,0);
5    }
6    public int fun(int num,int count){
7        if(num==0) return count;
8        if(num%2==0) return fun(num/2,count+1);
9        return fun(num-1, count+1);
10
11    }
12}