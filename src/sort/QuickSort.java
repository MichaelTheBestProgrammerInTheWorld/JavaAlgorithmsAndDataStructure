package sort;

public class QuickSort {

    public void sort(int[] arr, int low, int high){
        if (low < high){    //base case
            int p = partition(arr, low, high);
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low;
        int j = low;
        while (i<=high){
            if (arr[i] <= pivot){
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        return j-1;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 2, 0, 1, 6, 3 };
        QuickSort qs = new QuickSort();
        qs.printArray(arr);
        qs.sort(arr, 0, arr.length-1);
        qs.printArray(arr);
    }

    private void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
