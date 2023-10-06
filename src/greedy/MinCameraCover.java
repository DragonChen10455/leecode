package greedy;

public class MinCameraCover {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int result = 0;

    public int minCameraCover(TreeNode root) {
        if(traversal(root) == 0) {
            result++;
        }
        return result;
    }

    private int traversal(TreeNode cur){
        // 0表示无覆盖
        // 1表示有摄像头
        // 2表示有覆盖
        if(cur == null) {
            return 2;
        }

        int left = traversal(cur.left);
        int right = traversal(cur.right);

        if(left == 2 && right == 2) return 0;
        if(left == 0 || right == 0) {
            result++;
            return 1;
        }
        // left == 1 || right == 1
        else return 2;
    }
}
