package extraquestions;

import java.util.HashMap;

public class JumpPathToEndSolution {
    int minJump = Integer.MAX_VALUE;
    private HashMap<Integer, Boolean> hmap = new HashMap<>();
    public boolean canJump(int[] nums) {

        if(nums == null || nums.length == 0)
            return false;

        return canJumpHelper(nums, 0, 0);
    }

    private boolean canJumpHelper(int[] nums, int currentIndex, int jump){
        if(currentIndex >= nums.length)
            return false;
        if(currentIndex == nums.length - 1 || (nums[currentIndex] + currentIndex)  == nums.length - 1){
            minJump = Math.min(jump, minJump) + 1;
            System.out.println("MinJump="+ minJump);
            return true;
        }


        if(hmap.containsKey(currentIndex)){
            return hmap.get(currentIndex);
        }
        for(int i=currentIndex + 1; i <= currentIndex + nums[currentIndex]; i++){
            if(canJumpHelper(nums, i, jump + 1)){
                hmap.put(currentIndex, true);
                return true;
            }
        }
        hmap.put(currentIndex, false);
        return false;
    }

    public static void main(String[] args) {
        JumpPathToEndSolution sol = new JumpPathToEndSolution();
        sol.canJump(new int[]{2,3,1,1,4});
        new JumpPathToEndSolution().canJump(new int[]{1,1,2,1,4});
    }
}
