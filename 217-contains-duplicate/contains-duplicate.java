class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> items = new HashSet<>();

        for(int num : nums){
            if(items.contains(num))
                return true;
            items.add(num);
        }

        return false;
    }
}