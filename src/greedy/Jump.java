package greedy;

public class Jump {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return 0;
        }
        int step = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, i + nums[i]);
            if (i == curDistance) {
                step++;
                if(nextDistance >= nums.length - 1) {
                    return step;
                }
                curDistance = nextDistance;
            }
        }
        return step;
    }
}
