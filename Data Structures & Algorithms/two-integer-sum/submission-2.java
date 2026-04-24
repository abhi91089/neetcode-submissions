class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> pmap = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            int diff = target - num;

            if(pmap.containsKey(diff))
            {
                return new int[]{pmap.get(diff),i};
            }
            else
            {
                pmap.put(num,i);
            }

        }
    return new int[]{-1,-1};
    }
    
}
