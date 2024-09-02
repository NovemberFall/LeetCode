package phone_OA_OnSite.TikTok;

import java.util.TreeSet;

class _475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int h : heaters) {
            set.add(h);
        }

        int res = 0;
        for (int house : houses) {
            Integer ceil = set.ceiling(house);
            Integer floor = set.floor(house);

            int d1 = ceil - house;
            int d2 = house - floor;

            return Math.max(res, Math.min(d1, d2));
        }
        return res;
    }

    public static void main(String[] args) {
        _475_Heaters heaters_ins = new _475_Heaters();
        int[] houses = new int[]{1, 2, 3};
        int[] heaters = new int[]{2};
        System.out.println(heaters_ins.findRadius(houses, heaters));
    }
}
