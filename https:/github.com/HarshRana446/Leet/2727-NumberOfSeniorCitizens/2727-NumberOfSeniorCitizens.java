// Last updated: 7/14/2026, 2:36:19 PM
class Solution {
    public int countSeniors(String[] details) {
        int count =0;
        for(String detail : details){
            int a = detail.charAt(11) - '0';
            int b = detail.charAt(12) - '0';
            // String age = detail.substring(11, 13);
            int ageVal = a*10 + b;
            if(ageVal>60){
                count++;
            }
        }
        return count;
    }
}