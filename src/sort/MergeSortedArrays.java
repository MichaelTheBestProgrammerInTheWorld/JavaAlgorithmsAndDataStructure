package sort;

public class MergeSortedArrays {

    public int[] merge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[] mergedArray = new int[n+m];
        int i = 0;  // index for arr1
        int j = 0;  //index for arr2
        int k = 0;  //index of mergedArray
        while (i<n && j<m){
            if (arr1[i] < arr2[j]){
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }
        // either arr1 got exhausted or arr2 got exhausted
        while (i < n) { // arr2 got exhausted
            mergedArray[k] = arr1[i]; // storing arr1 element into result
            i++;
            k++;
        }

        while (j < m) { // arr1 got exhausted
            mergedArray[k] = arr2[j]; // storing arr2 element into result
            j++;
            k++;
        }

        return mergedArray;
    }

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedArrays msa = new MergeSortedArrays();
        int[] arr1 = { 0, 1, 8, 10 };
        int[] arr2 = { 2, 4, 11, 15, 20 };
        msa.printArray(arr1);
        msa.printArray(arr2);

        int[] result = msa.merge(arr1, arr2);
        msa.printArray(result);
    }
}
