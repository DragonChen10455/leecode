package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.peek();
                q.poll();
                assert node != null;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

        }
        return depth;
    }
}
