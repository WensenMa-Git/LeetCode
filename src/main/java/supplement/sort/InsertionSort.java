package supplement.sort;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int preIndex = i - 1;
            int cur = array[i];
            while(preIndex >= 0 && array[preIndex] > cur) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,4,1,8};
        new InsertionSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

}
