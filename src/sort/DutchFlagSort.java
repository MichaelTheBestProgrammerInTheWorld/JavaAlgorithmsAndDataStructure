package sort;

public class DutchFlagSort {

    public void threeNumberSort(int[] arr){
        int i = 0;
        int j = 0;
        int k = arr.length-1;
        while (i<=k){
            if (arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 1){
                i++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);
                k--;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 0, 0, 1, 0, 2, 0, 1, 0, 2, 2, 0 };
        DutchFlagSort st = new DutchFlagSort();
        st.printArray(arr);
        st.threeNumberSort(arr);
        st.printArray(arr);
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
