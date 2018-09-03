package arith;

import org.junit.Test;

public class SumDiff {
    public int maxDiffSubArrays(int [] array) {
        if (array == null || array.length < 1) {
            return 0;
        }

        int[] leftMax = new int[array.length];
        int[] rightMin = new int[array.length];
        int[] rightMax = new int[array.length];
        int[] leftMin = new int[array.length];
        int localMax = 0;
        int localMin = 0;
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        for (int index = 0; index < array.length; index ++) {
            localMax = Math.max(array[index], localMax + array[index]);
            globalMax = Math.max(localMax, globalMax);
            leftMax[index] = globalMax;

            localMin = Math.min(array[index], localMin + array[index]);
            globalMin = Math.min(localMin, globalMin);
            leftMin[index] = globalMin;
        }

        localMax = 0;
        localMin = 0;
        globalMax = Integer.MIN_VALUE;
        globalMin = Integer.MAX_VALUE;
        for (int index = array.length - 1; index >= 0; index --) {
            localMax = Math.max(array[index], localMax + array[index]);
            globalMax = Math.max(localMax, globalMax);
            rightMax[index] = globalMax;

            localMin = Math.min(array[index], localMin + array[index]);
            globalMin = Math.min(localMin, globalMin);
            rightMin[index] = globalMin;
        }

        int leftMaxDiff = Integer.MIN_VALUE;
        int rightMaxDiff = Integer.MIN_VALUE;
        for (int index = 0; index < array.length - 1; index ++) {
            leftMaxDiff = Math.max(leftMaxDiff, Math.abs(leftMax[index] - rightMin[index + 1]));
            rightMaxDiff = Math.max(rightMaxDiff, Math.abs(rightMax[index + 1] - leftMin[index]));
        }

        return Math.max(leftMaxDiff, rightMaxDiff);

    }

    @Test
    public void testDiff() {
        int [] array = {1,2,-3,1};
        System.out.println(maxDiffSubArrays(array));
    }

}
