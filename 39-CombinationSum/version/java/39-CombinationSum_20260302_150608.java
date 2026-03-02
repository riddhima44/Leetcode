// Last updated: 3/2/2026, 3:06:08 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> list2 = new ArrayList<>();
4        List<Integer> list = new ArrayList<>();
5        fun(candidates,target,list,list2,0);
6        return list2;
7
8    }
9    public void fun(int[] arr,int target,List<Integer> list,List<List<Integer>> list2,int index){
10        if(target==0) {
11            list2.add(new ArrayList<>(list));
12            return;
13        }
14        if(index==arr.length) return;
15        if(target>=arr[index]){
16            list.add(arr[index]);
17            fun(arr,target-arr[index],list,list2,index);
18            list.remove(list.size()-1);
19        }
20        fun(arr,target,list,list2,index+1);
21    }
22}