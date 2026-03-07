// Last updated: 3/8/2026, 2:12:49 AM
1class Solution {
2    public int numberOfSteps(int num) {
3
4        return fun(num);
5    }
6    public int fun(int num){
7        return helper(num,0);
8    }
9    public int helper(int num,int count){
10        if(num==0) return count;
11        if(num%2==0) return helper(num/2,count+1);
12        return helper(num-1, count+1);
13    }
14}