package dataStructure;



public class ArrayUtil {

    public void printArray(int[] array){
        int n = array.length;
        for (int i=0; i<n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo(){
        int[] myArray = new int[5];
        printArray(myArray);
        myArray[0] = 5;
        myArray[1] = 10;
        myArray[2] = 15;
        myArray[3] = 20;
        myArray[4] = 25;
        printArray(myArray);
        myArray[2] = 50;
        printArray(myArray);
        System.out.println("length is " + myArray.length);
        System.out.println("last element is " + myArray[myArray.length - 1]);
        int[] arr2 = {1, 2, 3, 4, 5};
        printArray(arr2);
    }

    public int[] removeEven(int[] array){

        int oddCount = 0;
        for (int i=0; i<array.length; i++){
            if (array[i]%2 != 0){
                oddCount++;
            }
        }
        int[] result = new int[oddCount];
        int index = 0;
        for (int i=0; i<array.length; i++){
            if (array[i]%2 != 0){
                result[index] = array[i];
                index++;
            }
        }
        return result;
    }

    public int[] removeOdd(int[] array){

        int evenCount = 0;
        for (int i=0; i<array.length; i++){
            if (array[i]%2 == 0){
                evenCount++;
            }
        }
        int[] result = new int[evenCount];
        int index = 0;
        for (int i=0; i<array.length; i++){
            if (array[i]%2 == 0){
                result[index] = array[i];
                index++;
            }
        }
        return result;
    }

    public int[] reverseArray(int[] numbers, int start, int end){
        while (start < end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
        return numbers;
    }

    public int findMinimum(int[] numbers){
        int minimum = numbers[0];
        for (int i=1; i< numbers.length; i++){
            if (numbers[i] < minimum){
                minimum = numbers[i];
            }
        }
        return minimum;
    }

    public int findMaximum(int[] numbers){
        int maximum = numbers[0];
        for (int i=1; i< numbers.length; i++){
            if (numbers[i] > maximum){
                maximum = numbers[i];
            }
        }
        return maximum;
    }

    public int myFindSecondMaximum(int[] numbers){
        int maximum = numbers[0];
        int position = 0;
        for (int i=1; i< numbers.length; i++){
            if (numbers[i] > maximum){
                maximum = numbers[i];
                position = i;
            }
        }
        numbers[position] = 0;
        int secondMaximum = numbers[0];
        for (int i=1; i< numbers.length; i++){
            if (numbers[i] > secondMaximum && numbers[i] != maximum){
                secondMaximum = numbers[i];
            }
        }
        return secondMaximum;
    }

    public int findSecondMaximum(int[] numbers){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i=0; i<numbers.length; i++){
            if (numbers[i] > max){
                secondMax = max;
                max = numbers[i];
            } else if (numbers[i] > secondMax && numbers[i] != max){
                secondMax = numbers[i];
            }
        }
        return secondMax;
    }

    public int[] myShiftZerosToEnd(int[] numbers){
        int[] result = new int[numbers.length];
        int position = 0;
        for (int val : numbers){
            if (val != 0){
                result[position] = val;
                position++;
            }
        }
        return result;
    }

    public int[] shiftZerosToEnd(int[] numbers, int n){
        int j = 0;
        for (int i=0; i < n; i++){
            if (numbers[i] != 0 && numbers[j] == 0){
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
            if (numbers[j] != 0){
                j++;
            }
        }
        return numbers;
    }

    public int[] resize(int[] numbers, int capacity){
        int[] temp = new int[capacity];
        for (int i=0; i< numbers.length; i++){
            temp[i] = numbers[i];
        }
        return temp;
    }

    //we will use mathematical formula that needs to start from no. 1
    public int findMissingNumber(int[] numbers){
        int n = numbers.length + 1;
        int sum = n * (n+1) / 2;
        for (int num : numbers){
            sum -= num;
        }
        return sum;
    }

    //problem in video 89
    public int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        int pointer = 0;
        for (int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                if (arr[i] < arr[j]){
                    result[pointer] = arr[j];
                    pointer++;
                    break;
                } else if (j == arr.length-1){
                    result[pointer] = -1;
                    pointer++;
                }
            }
        }
        result[pointer] = -1;
        return result;
    }

    public static void main(String[] args) {

        ArrayUtil arrayUtil = new ArrayUtil();
        arrayUtil.arrayDemo();
        System.out.println("mod = " + 0%2);
        int[] arr = {1, 2, 5, 5, 3, 4, 5};
        arrayUtil.printArray(arrayUtil.removeEven(arr));
        arrayUtil.printArray(arrayUtil.removeOdd(arr));
        arrayUtil.printArray(arrayUtil.reverseArray(arr, 0, arr.length-1));
        System.out.println("minimum is " + arrayUtil.findMinimum(arr));
        System.out.println("maximum is " + arrayUtil.findMaximum(arr));
        System.out.println("my second maximum is " + arrayUtil.myFindSecondMaximum(arr));
        System.out.println("second maximum is " + arrayUtil.findSecondMaximum(arr));
        int[] arr2 = {1, 0, 0, 3, 0 , 9, 0, 0, 5, 8};
        arrayUtil.printArray(arr2);
        arrayUtil.printArray(arrayUtil.myShiftZerosToEnd(arr2));
        arrayUtil.printArray(arrayUtil.shiftZerosToEnd(arr2, arr2.length));
        arr = arrayUtil.resize(arr, arr.length*2);
        arr[7] = 20;
        arr[8] = 30;
        arr[9] = 50;
        arrayUtil.printArray(arr);
        int[] arr3 = {1, 4, 3, 6 , 9, 7, 2, 8};
        System.out.println("missing number is " + arrayUtil.findMissingNumber(arr3));

        int[] arr4 = {4, 7, 3, 4, 8, 1};
        int[] result = arrayUtil.nextGreaterElement(arr4);
        for (int i : result){
            System.out.print(i + " / ");
        }
        System.out.println();
    }
}
