import java.util.Arrays;
import java.util.Collections;

/**
 * BinarySearch
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] array = { 1, 212, 45, 7, 6, 9, 98, 43, 123, 440, 76, 10, 55, 102, 67 };
       Arrays.sort(array);
       for (int i : array) {
        System.out.println("排序后的数组为-->"+i);  
       }
     
    //    int index = BinarySearch.binarySearch(array, 45);
    //     System.out.println("查找到的目标值的下标为-->"+index);



    

        int index = BinarySearch.binarySearchRecursive(array, 2,0,array.length-1);
        System.out.println("查找到的目标值的下标为-->"+index);
    }
}


class BinarySearch {
/**
 * 循环法
 */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }
        return -1;
    }
/**
 * 递归法
 */
public static int binarySearchRecursive(int[] arr, int target,int left,int right) {
    // int left = 0;
    // int right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
            binarySearchRecursive(arr, target,left,right);
        } else {
            right = mid - 1;
            binarySearchRecursive(arr, target,left,right);
        }

    }
    return -1;
}
}