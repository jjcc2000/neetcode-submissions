class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // bucket
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int[] result = new int[k];
        int idx = 0;

        for (int freq = buckets.length - 1; freq >= 1 && idx < k; freq--) {
            if (buckets[freq] != null) {
                for (int num : buckets[freq]) {
                    result[idx++] = num;
                    if (idx == k)
                        break;
                }
            }
        }
        return result;
    }
}
