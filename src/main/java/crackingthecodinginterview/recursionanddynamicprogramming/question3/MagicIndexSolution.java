package crackingthecodinginterview.recursionanddynamicprogramming.question3;

public class MagicIndexSolution {
    //Time Complexity: O(LogN)
    //Space Complexity: O(LogN)
    public int findMagicIndex(int[] arr){
        if(arr == null || arr.length == 0)
            return -1;
        return findMagicIndexHelper(arr, 0, arr.length - 1);
    }

    private int findMagicIndexHelper(int[] arr, int start, int end){
        if(start > end)
            return -1;
        int mid = (start + end)/2;
        if(arr[mid] == mid)
            return mid;
        if(arr[mid] > mid){
            return findMagicIndexHelper(arr, start, Math.min(mid - 1, arr[mid]));
        } else{
            return findMagicIndexHelper(arr, Math.max(mid + 1, arr[mid]), end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MagicIndexSolution().findMagicIndex(new int[]{-10,-5,2,2,2,3,4,7,9,12,13}));
    }
}
