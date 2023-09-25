package Stack._739_DailyTemperatures;

class DailyTemperatures_bruteForce {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int left = 0; left < temperatures.length; left++) {
            for (int right = left + 1; right < temperatures.length; right++) {
                if (temperatures[left] < temperatures[right]) {
                    res[left] = right - left;
                    break;
                }
            }
        }
        return res;
    }
}
