// Last updated: 7/14/2026, 2:50:59 PM
class Solution {
    public int strStr(String haystack, String needle) {
        // Check if the needle is an empty string
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        
        // Use the indexOf method to find the first occurrence of needle in haystack
        return haystack.indexOf(needle);
    }
}
