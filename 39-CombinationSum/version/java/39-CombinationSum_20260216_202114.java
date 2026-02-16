// Last updated: 2/16/2026, 8:21:14 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<Integer> list = new ArrayList<>();
4        List<List<Integer>> ans = new ArrayList<>();
5        fun(candidates,0,target,list,ans);
6        return ans;
7    }
8    public void fun(int arr[],int index, int target, List<Integer> list,List<List<Integer>> ans){
9        if(index==arr.length){
10            if(target==0){
11                ans.add(new ArrayList<>(list));
12            }
13            return;
14        }
15        if(arr[index]<=target){
16            list.add(arr[index]);
17            fun(arr,index,target-arr[index],list,ans);
18            list.remove(list.size()-1);
19        }
20        fun(arr,index+1,target,list,ans);
21    }
22}