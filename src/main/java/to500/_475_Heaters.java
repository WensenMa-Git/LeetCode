package to500;

import java.util.Arrays;
import java.util.TreeSet;


public class _475_Heaters {


    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);

        int i = 0, res = 0;
        for (int house : houses) {
            while (i < heaters.length - 1
                    && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }

    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;

        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1);
            }
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }

    public int findRadius3(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int heater : heaters) {
            set.add(heater);
        }
        int index = 0, res = 0;
        for (int house : houses) {
            int dist1 = set.ceiling(house) == null ? Integer.MAX_VALUE : set.ceiling(house) - house;
            int dist2 = set.floor(house) == null ? Integer.MAX_VALUE : house - set.floor(house);
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}
