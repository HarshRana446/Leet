// Last updated: 7/14/2026, 2:36:44 PM
class Solution {
    public int[] rearrangeArray(int[] nums) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        if (pos.size() > neg.size()) {

            for (int i = 0; i < neg.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int index = 2 * neg.size();

            for (int i = neg.size(); i < pos.size(); i++) {
                nums[index++] = pos.get(i);
            }

        } else {

            for (int i = 0; i < pos.size(); i++) {
                nums[2 * i] = pos.get(i);
                nums[2 * i + 1] = neg.get(i);
            }

            int index = 2 * pos.size();

            for (int i = pos.size(); i < neg.size(); i++) {
                nums[index++] = neg.get(i);
            }
        }

        return nums;
    }
}