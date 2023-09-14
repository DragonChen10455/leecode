package greedy;

public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int coverIndex = 0;
        for (int i = 0; i <= coverIndex; i++) {
            coverIndex = Math.max(coverIndex, i + nums[i]);
            if(coverIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
