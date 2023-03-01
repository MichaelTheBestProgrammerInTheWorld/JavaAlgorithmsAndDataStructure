package sort;

public class BubbleSort {

    //instructor's algorithm
    public void sort(int[] arr) {
        int n = arr.length - 1;
        boolean isSwapped;
        for (int i = 0; i < n; i++) {
            isSwapped = false;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    //my algorithm
    public void sort2(int[] arr) {
        int n = arr.length;
        boolean isSwapped = true;
        while (isSwapped) {

            isSwapped = false;

            for (int j = 1; j < n; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwapped = true;
                }
            }

        }
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 2, 9, 10};
        BubbleSort bs = new BubbleSort();
        bs.printArray(arr);
        //bs.sort(arr);
        bs.sort2(arr);
        bs.printArray(arr);

        int[] arr2 = new int[]{5, 1, 2, 9, 10, 3, 7, 47, 8, 15, 35, 29, 18, 55};
        bs.printArray(arr2);
        //bs.sort(arr);
        bs.sort2(arr2);
        bs.printArray(arr2);
    }
}
