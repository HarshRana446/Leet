// Last updated: 7/19/2026, 6:19:56 PM
class Solution {
    public int splitArray(int[] nums, int k) {
        return findPages(nums, k);
    }
    public int findPages(int[] arr, int k) {
		if(arr.length < k) return -1;
		long maxi = arr[0];
		long sum = 0;
		for(int i = 0; i < arr.length; i++){
		    maxi = Math.max(maxi, arr[i]);
		    sum = sum + arr[i];
		}
		long low = maxi; long high = sum;
		while(low <= high){
		    long mid = (low + high) / 2;
		    int students = countStudents(arr, mid);
		    if(students > k){
		        low = mid + 1;
		    }else{
		        high = mid - 1;
		    }
		}
		return (int) low;
	}
	int countStudents(int[] arr, long pages) {
		int students = 1;
		long pagesStudents = 0;
		for (int i = 0; i < arr.length; i++) {
			if (pagesStudents + arr[i] <= pages) {
				pagesStudents += arr[i];
			}
			else {
				students++;
				pagesStudents = arr[i];
			}
		}
		return students;
	}
}