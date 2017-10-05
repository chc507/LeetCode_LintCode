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
        mergeSort(0, length - 1, arr);
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

    private void mergeSort(int start, int end, int[] arr) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start,mid,arr);
            mergeSort(mid + 1,end,arr);
            merge(start, mid,end,arr);
        }
    }

    private void merge(int start, int mid, int end, int[] arr) {
        //find size of two arrays to be merged
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        //copy data to temp array
        for (int i = 0; i < n1; ++i){
            leftArr[i] = arr[start + i];
        }

        for (int j= 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < n2) {
            arr[j] = rightArr[j];
            j++;
            k++;
        }
    }


    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
