package zzz_everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LockingTree {
    private int[] locked;
    private int[] parent;
    private List<Integer>[] children;
    private boolean find;

    private void dfsLock(int num){
        for (int child : this.children[num]) {
            if(locked[child] != -1) {
                locked[child] = -1;
                find = true;
            }
            dfsLock(child);
        }
    }

    public LockingTree(int[] parent) {
        this.locked = new int[parent.length];
        this.parent = parent;
        this.children = new List[parent.length];
        Arrays.fill(locked, -1);
        Arrays.setAll(children, i -> new ArrayList<>());
        for (int i = 1; i < parent.length; i++) {
            children[parent[i]].add(i);
        }
    }

    public boolean lock(int num, int user) {
        if(locked[num] == -1) {
            locked[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if(locked[num] == user) {
            locked[num] = -1;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        int numTemp = num;
        while(numTemp != -1) {
            if(locked[numTemp] != -1) return false;
            numTemp = parent[numTemp];
        }
        find = false;
        dfsLock(num);
        if (!find) {
            return false;
        }
        locked[num] = user;
        return true;
    }
}
