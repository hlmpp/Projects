package arith;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Gap {

    class Bucket {
        int low;
        int high;

        public Bucket() {
            this.low = -1;
            this.high = -1;
        }
    }

    public int testGap(int [] array) {

        if (array == null || array.length < 2) {
            return 0;
        }

        int min = array[0];
        int max = array[0];
        for (int elment : array) {
            min = Math.min(min, elment);
            max = Math.max(max, elment);
        }

        Bucket[] buckets = new Bucket[array.length + 1];



        for(int index = 0; index < buckets.length; index++) {
            buckets[index] = new Bucket();
        }

        double interval = (double) (max - min) / array.length;
        for (int elment : array) {
            int index = (int) (( elment - min ) / interval);
            buckets[index] = new Bucket();

            if (buckets[index].low == -1) {
                buckets[index].low = buckets[index].high = elment;
            } else {
                buckets[index].low = Math.min(elment, buckets[index].low);
                buckets[index].high = Math.max(elment, buckets[index].high);
            }

        }

        int preValue = 0;
        int gap = -1;
        for (int index = 0; index < buckets.length && buckets[index] != null; index ++) {

            if (buckets[index].high != -1) {
                gap = Math.max(buckets[index].low - preValue, gap);
                preValue = buckets[index].high;
            }
        }

        return gap;
    }



    @Test
    public void testForFun() {

        int[] array = {1, 3, 9};
        System.out.println(testGap(array));
    }
}
