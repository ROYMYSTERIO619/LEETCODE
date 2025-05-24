class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for (String s : words) {
            if (s.contains(Character.toString(x))) {
                list.add(i);
            }
            i++;
        }
        return list;
    }
}