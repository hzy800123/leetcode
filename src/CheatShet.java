import java.util.*;
import java.util.stream.Collectors;

public class CheatShet {

    static List<Integer> numsList = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5));
    static List<Integer> numsList2 = new ArrayList<>(5);
    static int[] numsArray = new int[]{1, 2, 3, 6, 5};

    public static void main(String[] args) {
//        testCollectionOperation();
//        testStringCharArray();
        int result = binSearch(numsArray, 6);
        System.out.println("result = " + result);
    }

    // 排序 (List, Array）
    static void testSort() {
        Collections.sort(numsList); // List 排序
        Collections.reverse(numsList); // List 反向排序

        Arrays.sort(numsArray);  // Array 排序

        // Array Mirroring
        // 数组反转（例如：先 正向排序，然后反转，即为 反向排序）
        int temp;
        for ( int i = 0; i < numsArray.length/2; ++i )
        {
            temp = numsArray[i];
            numsArray[i] = numsArray[numsArray.length - i - 1];
            numsArray[numsArray.length - i - 1] = temp;
        }
    }

    // 数组和列表 相互转换
    // Array -> List, List -> Array
    static void testListToArray() {
        // Array int[] -> List<Integer>
        List<Integer> newNumsList =
                Arrays.stream(numsArray).boxed().collect(Collectors.toList());

        // List<Integer> -> Array int[]
        int[] newNums = numsList.stream().mapToInt(Integer::intValue).toArray();
    }


    // 结合的常用静态函数：取最大值，取最小值，集合复制，集合倒序
    static void testCollectionOperation() {
        List<Integer> numsList = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 5));
        List<Integer> numsList2 = new ArrayList<>(5);

        // More collections static methods:
        int max = Collections.max(numsList);              // returns maximum
        int min = Collections.min(numsList);              // returns maximum

//        Collections.copy(numsList2, numsList);  // A list into B --- Can Not use this !!!

        // Should use 'addAll' method
        numsList2.addAll(numsList);
        // Or use Constructor method
        numsList2 = new ArrayList<>(numsList);

        Collections.reverse(numsList);          // if A is list
    }

    // 字符串 和 字符数组 的转换
    static void testStringCharArray() {
        String str = new String("abc");
        char[] strArray = new char[]{'d', 'e', 'f'};

        // String -> Char Array
        char[] chars = str.toCharArray();
        System.out.println(chars);

        // Char Array -> String
        String newStr = new String(strArray);
        System.out.println(newStr);

        String newStr2 = String.valueOf(strArray);
        System.out.println(newStr2);
    }


    /*
     * 循环实现二分查找算法
     *
     * @param arr 有序数组
     *
     * @param x 要查找的数
     *
     * @return
     * >0 返回查找到的数据的下标位置
     * -1 无法查到数据
     */
    public static int binSearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
