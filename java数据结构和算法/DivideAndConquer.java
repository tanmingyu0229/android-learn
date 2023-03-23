public class DivideAndConquer {
    public static int sum(int[] arr) {
        return sumHelper(arr, 0, arr.length - 1);
    }
    private static int sumHelper(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = start + (end - start) / 2;
        int leftSum = sumHelper(arr, start, mid);
        int rightSum = sumHelper(arr, mid + 1, end);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
           int[] arr = {1, 2, 3, 4, 5};
        int sum = DivideAndConquer.sum(arr);
        System.out.println("The sum is " + sum);
    }

}

