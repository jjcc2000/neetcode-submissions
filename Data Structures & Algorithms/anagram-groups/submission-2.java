class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        // for (int wordList = 0; wordList < strs.length; wordList++) {
        for (int wordList = 0; wordList < strs.length; wordList++) {
            int[] count = new int[26];
            String word = strs[wordList];
            for (int c = 0; c < word.length(); c++) {
                int code = word.charAt(c) - 'a';
                count[code]++;
            }
            String key = Arrays.toString(count);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
