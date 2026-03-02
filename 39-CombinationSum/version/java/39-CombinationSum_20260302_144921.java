// Last updated: 3/2/2026, 2:49:21 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> list2 = new ArrayList<>();
4        List<Integer> list = new ArrayList<>();
5        fun(candidates,target,0,list,list2,0);
6        return list2;
7
8    }
9    public void fun(int[] arr,int target, int sum,List<Integer> list,List<List<Integer>> list2,int index){
10        if(sum>target) return;
11        if(sum==target){
12            list2.add(new ArrayList<>(list));
13            return;
14        }
15        if(index==arr.length){
16            return;
17        }
18        list.add(arr[index]);
19        fun(arr,target,sum+arr[index],list,list2,index);
20        list.remove(list.size()-1);
21        fun(arr,target,sum,list,list2,index+1);
22    }
23}