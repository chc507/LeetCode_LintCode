public class Sorting {
    public Sorting() {}
    //Implment quicksort with pivot on the first element
    public void myQuickSort(int[] arr) {
        //the last element
        int length = arr.length;
        quickSortMidPivot(0,length - 1, arr);
    }

    public void myMergeSort(int[] arr) {
        int length  = arr.length;
        int[] temp = new int[length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private void quickSortMidPivot(int start, int end, int[] arr) {
        int i = start;
        int j = end;
        int mid = i + (j - i)/ 2;
        int pivot = arr[mid];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j]  >  pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j, arr);
                i++;
                j--;
                }
        }

        if (start < j) {
            quickSortMidPivot(start,j, arr);
        }

        if (end > i) {
            quickSortMidPivot(i, end, arr);
        }
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int mid = (start + end) / 2;

        mergeSort(A, start, mid, temp);
        mergeSort(A, mid+1, end, temp);
        merge(A, start, mid, end, temp);
    }

    private void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid+1;
        int index = start;

        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }

        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }

    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
