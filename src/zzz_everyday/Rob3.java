package zzz_everyday;

public class Rob3 {
    public int rob(TreeNode root) {
        int[] res = robrob(root);
        return Math.max(res[0], res[1]);
    }

    int[] robrob(TreeNode root) {
        int res[] = new int[2];
        if (root == null)
            return res;

        int[] left = robrob(root.left);
        int[] right = robrob(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
