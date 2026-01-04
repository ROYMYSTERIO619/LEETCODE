class Solution {
    public int sumFourDivisors(int[] nums) {
        int sumOfDivisors = 0;
        for(int i=0; i<nums.length; i++) {
            Set<Integer> divisorsOfNum = getDivisorsOfNumIfExactFour(nums[i]);
            if(divisorsOfNum != null) {
                Iterator<Integer> iterator = divisorsOfNum.iterator();
                while (iterator.hasNext()) {
                    sumOfDivisors += iterator.next();
                }
            }
        }
        return sumOfDivisors;
    }

    public Set<Integer> getDivisorsOfNumIfExactFour(int num) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(num);
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                if(set.size() == 4) {
                    return null;
                }
                set.add(i);
                set.add((int)num/i);

            }
        }
        if(set.size() != 4) {
            return null;
        }
        return set;
    }
}