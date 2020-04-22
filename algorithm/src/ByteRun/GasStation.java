package ByteRun;

import common.CommonUtil;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * Note:
 * The solution is guaranteed to be unique.
 * <p>
 * 环形路线上有N个加油站，第i个加油站有汽油量gas[i]，从i加油站到i+1站需要消耗汽油cost[i]，
 * 问：从哪个加油站出发能够回到起始点，如果都不能则返回-1。
 * 注意：解唯一。即每次输入相同数据输出的结果相同。
 */
public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[]{2, 5, 6, 4, 7};
        int[] costs = new int[]{2, 1, 12, 3, 1};
        CommonUtil.printNumber(getSolution(gas, costs));
        gas = new int[]{2, 5, 6, 4, 7};
        costs = new int[]{2, 1, 12, 3, 7};
        CommonUtil.printNumber(getSolution(gas, costs));
    }

    private static int getSolution(int[] gas, int[] costs) {
        int allReserve = 0; // 当前总共的剩余量，最后总共的剩余不小于0才表示有这样的起点存在
        int sum = 0; // 当前新的起点开始的剩余量，如果小于0，即表示当前设定的起点油量不够，需要继续寻找新的起点
        int index = 0; // 当前新起点的下表
        for (int i = 0; i < gas.length; i++) {
            allReserve += gas[i] - costs[i];
            sum += gas[i] - costs[i];
            if (sum < 0) {
                index = i + 1;
                sum = 0;
            }
        }
        // 要满足：所有加油站的油量总和 > 所有路程消耗的总和
        return allReserve >= 0 ? index : -1;
    }
}
