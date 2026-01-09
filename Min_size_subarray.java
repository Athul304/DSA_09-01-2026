import java.util.*;
public class Min_size_subarray {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int size =Integer.MAX_VALUE;
        int n=0;
        while(r<nums.length){
            n=n+nums[r];
            while(n>=target){
                size = Math.min(size,r-l+1);
                n=n-nums[l];
                l++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }
}
