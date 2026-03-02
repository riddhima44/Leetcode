// Last updated: 3/2/2026, 3:01:21 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> list2 = new ArrayList<>();
4        List<Integer> list = new ArrayList<>();
5        fun(candidates,target,list,list2,0);
6        return list2;
7
8    }
9    public void fun(int[] arr,int target,List<Integer> list,List<List<Integer>> list2,int index){
10        if(target<0) return;
11        if(target==0) {
12            list2.add(new ArrayList<>(list));
13            return;
14        }
15        if(index==arr.length) return;
16        if(target>=arr[index]){
17            list.add(arr[index]);
18            fun(arr,target-arr[index],list,list2,index);
19            list.remove(list.size()-1);
20        }
21        fun(arr,target,list,list2,index+1);
22    }
23}