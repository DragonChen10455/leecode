package greedy;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                // 当前累加rest[i]的和curSum一旦小于0，起始位置至少要是i+1，因为从i之前开始一定不行
                res = i + 1;
                curSum = 0;
            }
        }
        if(totalSum < 0) return -1;
        return res;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            min = Math.min(min, curSum);
        }

        // 如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
        if(curSum < 0) return -1;
        // rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
        if(min >= 0) return 0;
        // 如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能把这个负数填平，能把这个负数填平的节点就是出发节点
        for (int i = gas.length - 1; i >= 0; i--) {
            if(gas[i]-cost[i] >= min) return i;
        }
        return -1;
    }
}
