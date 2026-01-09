import java.util.*;
public class Kth_smallest_in_matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                nums.add(matrix[i][j]);

            }
        }
        Collections.sort(nums);
        return nums.get(k-1);

    }
}
