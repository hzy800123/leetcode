package 快速排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：
        // {2, 3, 1, 5, 6}
        // 输出：
        // {1, 2, 3, 5, 6}

        int[] array = {2, 3, 1, 5, 6};
        System.out.println("Before Quick Sort: array = ");
        Arrays.stream(array).forEach(System.out::println);
        System.out.println(" --- ");

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length-1);

        System.out.println("After Quick Sort: array = ");
        Arrays.stream(array).forEach(System.out::println);
    }

    static class QuickSort {

        public void quickSort(int[] array, int start, int end) {
            int i = start, j = end;
            int target = array[start];
            while (i < j) {
                // 找到右侧小于target的值
                while (i < j && target <= array[j]) {
                    j--;
                }
                // 找到左侧大于target的值
                while (i < j && array[i] <= target) {
                    i++;
                }
                // 交换找到的左右两侧的值
                if (i < j) {
                    swap(array, i, j);
                }
            }
            // 将基准位和中间的值交换
            swap(array, start, j);

            // 处理基准位左边的分片
            if (i - 1 > start){
                quickSort(array, start, i - 1);
            }
            // 处理基准位右边的分片
            if (j + 1 < end){
                quickSort(array,j + 1, end);
            }
        }

        public static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}