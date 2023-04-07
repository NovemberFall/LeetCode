package Greedy._134_GasStation;

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        int tank = 0, start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }
}
