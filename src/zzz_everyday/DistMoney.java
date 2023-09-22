package zzz_everyday;

public class DistMoney {
    public static int distMoney(int money, int children) {
        if(money < children) return -1;
        if (money > 8 * children) {
            return children - 1;
        }
        if (money == 8 * children - 4) {
            return children - 2;
        }
        // money-8x >= children-x, x <= (money-children)/7
        return (money - children) / 7;
    }

    public static int distMoneyNB(int money, int children) {
        if(money < children)return -1;  // 钱小于儿童数，无法满足至少每人一块，返回-1
        money -= children;  // 每个孩子先分一块，满足第二个条件
        int eightOwners = Math.min(money / 7, children);    // 将剩余的钱给尽可能多的孩子再分配七块钱，凑到八块
        money -= eightOwners * 7;   // 减去再次分出去的钱
        children -= eightOwners;    // 剩下没有拿到八块钱的孩子数量
        // 所有孩子都得到八块钱但还剩钱，不满足第一个条件；剩下的钱给某一个孩子，八块钱孩子数少一个
        // 还有一个孩子没拿到八块钱且刚好剩三块钱，为了满足第一个条件，钱都给剩下的孩子，得到了四块钱，不满足第三个条件。因此前面一个孩子不能拿八块钱，得分至少一块钱出来给最后一个孩子，因此八块钱孩子数少一个。
        if(children == 0 && money > 0 || children == 1 && money == 3)eightOwners--;
        return eightOwners;
    }

    public static void main(String[] args){
        System.out.println(distMoney(32, 19));
    }
}
