package zzz_everyday;

public class LockingTreeTest {
    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        LockingTree lockingTree = new LockingTree(parent);
        lockingTree.lock(2, 2);    // 返回 true ，因为节点 2 未上锁。
        // 节点 2 被用户 2 上锁。
        lockingTree.unlock(2, 3);  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
        lockingTree.unlock(2, 2);  // 返回 true ，因为节点 2 之前被用户 2 上锁。
        // 节点 2 现在变为未上锁状态。
        lockingTree.lock(4, 5);    // 返回 true ，因为节点 4 未上锁。
        System.out.println(lockingTree.upgrade(0, 1));
    }
}
