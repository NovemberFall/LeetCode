package Design._362_DesignHitCounter;

class DesignHitCounter_array {
    private int[] times;
    private int[] hits;

    public DesignHitCounter_array() {
        times = new int[300];
        hits = new int[300];
    }

    /**
     * Record a hit.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHist(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        DesignHitCounter_array designHitCounter = new DesignHitCounter_array();
        designHitCounter.hit(1);
        designHitCounter.hit(1);
        designHitCounter.hit(1);
        designHitCounter.hit(2);
        designHitCounter.hit(3);
        System.out.println(designHitCounter.getHist(4)); // 5

        designHitCounter.hit(300);
        designHitCounter.hit(300);
        designHitCounter.hit(300);
        System.out.println(designHitCounter.getHist(300)); // 8
        System.out.println(designHitCounter.getHist(301)); // 5
    }
}
