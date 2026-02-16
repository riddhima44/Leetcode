// Last updated: 2/17/2026, 12:11:55 AM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<Integer> list = new ArrayList<>();
4        List<List<Integer>> ans = new ArrayList<>();
5        fun(candidates,0,target,list,ans);
6        return ans;
7    }
8    public void fun(int arr[],int index, int target, List<Integer> list,List<List<Integer>> ans){
9        if(target==0){
10                ans.add(new ArrayList<>(list));
11                return;
12        }
13        if(index==arr.length){
14            return;
15        }
16        if(arr[index]<=target){
17            list.add(arr[index]);
18            fun(arr,index,target-arr[index],list,ans);
19            list.remove(list.size()-1);
20        }
21        fun(arr,index+1,target,list,ans);
22
23    }  
24}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
25       