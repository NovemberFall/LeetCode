package Greedy._134_GasStation;

class GasStation_bruteForce {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            if (helper(i, n, gas, cost) == i) {
                return i;
            }
        }
        return -1;
    }

    private int helper(int start, int n, int[] gas, int[] cost) {
        int j = (start + 1) % n;
        int curGas = gas[start] - cost[start];
        while (j != start) {
            curGas = curGas + gas[j] - cost[j];
            if (curGas < 0) {
                break;
            }
            j = (j + 1) % n;
        }
        return j == start ? start : -1;
    }
}
