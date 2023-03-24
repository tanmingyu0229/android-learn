/**
 * 快速排序算法
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] array = { 1, 212, 45, 7, 6, 9, 98, 43, 123, 440, 76, 10, 55, 102, 67 };
        QuickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void QuickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int base = arr[left];
        while (i != j) {
            while (base < arr[j] && i < j) {
                j--;
            }
            while (base > arr[i] && i < j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        base = arr[i];
        QuickSort(arr, left, i - 1);
        QuickSort(arr, j + 1, right);
    }
}
