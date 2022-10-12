import java.util.HashMap;
import java.util.Map;

class Count_Distinct_in_K_Window {

    static void countDistinctWindow(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(map.size());
        for (int i = k; i < arr.length; i++) {
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.println(map.size());
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4, 2 , 3 };
        int k = 4;
        countDistinctWindow(arr, k);
    }
}
