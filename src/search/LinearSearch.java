package search;

public class LinearSearch {

    public void search(int[] arr, int value){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == value){
                System.out.println("value " + arr[i] + " found at index " + i);
                return;
            }
        }
        System.out.println("value " + value+ " not found");
    }

    public int indexOf(int[] arr, int value){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 2, 10, 15, 20};
        LinearSearch ls = new LinearSearch();
        ls.search(arr, 15);
        ls.search(arr, 35);
        System.out.println(ls.indexOf(arr, 15));
        System.out.println(ls.indexOf(arr, 35));
    }
}
