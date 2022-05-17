package chou.pr;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum_Solution solution = new TwoSum_Solution();
		int[] ans = solution.twoSum(new int []{3,3}, 6);
		Arrays.stream(ans).forEach(c->System.out.println(c));
	}

}

class TwoSum_Solution {
    public int[] twoSum(int[] nums, int target) {
		
    	if(nums.length<2 || nums.length>10000) {
    		return new int[]{};
    	}
    	if(target<-1000000000 ||target>1000000000) {
    		return new int[]{};
    	}
    	
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i]<-1000000000 ||nums[i]>1000000000) {
    			return new int[]{};
    		}
    		
    		for(int j=i+1; j<nums.length; j++) {
    			if(nums[i] + nums[j] == target) {
    				return new int[]{i,j};
    			}
    		}
    		
    	}
    	
    	
    	return new int[]{};
        
    }
}