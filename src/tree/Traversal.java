package tree;

import java.util.*;

public class Traversal {
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
    public void inorder(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
    public void postorder(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    // 先序：根左右，根入栈出栈，右入栈，左入栈
    public List<Integer> preorder2(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.peek();
            s.pop();
            res.add(node.val);
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
        return res;
    }

    // 中序：左根右，左一直入栈，入栈到没有左节点再根出栈，右入栈
    public List<Integer> inorder2(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){
            // 有左节点，就一直push进来
            if(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            // push到没有左节点了，就输出节点，把右节点push进来
            else {
                cur = s.peek();
                s.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    // 后序：左右根，根入栈出栈，左入栈，右入栈，输出根右左再逆序
    public List<Integer> postorder2(TreeNode root, List<Integer> result){
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.peek();
            s.pop();
            res.add(node.val);
            if(node.left != null) s.push(node.left);
            if(node.right != null) s.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右左中节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将中右左节点添加到栈中
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }
}
