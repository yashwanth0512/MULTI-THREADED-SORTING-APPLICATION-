package multithread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
 
public class QuickSortMutliThreading extends RecursiveTask<Integer> {
 
    int start, end;
    int[] arr;
 

    private int partition(int start, int end, int[] arr)  {
 
        int i = start, j = end;

        int pivote = new Random().nextInt(j - i) + i;
 
        int t = arr[j];
        arr[j] = arr[pivote];
        arr[pivote] = t;
        j--;
 
        while (i <= j) {
 
            if (arr[i] <= arr[end]) { 
            	i++;
                continue;
            }
 
            if (arr[j] >= arr[end]) {
                j--;
                continue;
            }
 
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            j--;
            i++;
        }
 
        t = arr[j + 1];
        arr[j + 1] = arr[end];
        arr[end] = t;
        return j + 1;
    }
 

    public QuickSortMutliThreading(int start, int end, int[] arr)
    {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
 
    @Override
    protected Integer compute()
    {
        // Base case
        if (start >= end)
            return null;
 
        // Find partition
        int p = partition(start, end, arr);
 
        // Divide array
        QuickSortMutliThreading left
            = new QuickSortMutliThreading(start, p - 1, arr);
 
        QuickSortMutliThreading right  = new QuickSortMutliThreading(p + 1, end, arr);
 
        left.fork();
        right.compute();
        left.join();
 
        return null;
    }
 
    public static void main(String args[]) {
        int n = 7;
        int[] arr = { 2, 1, 9, 5, 3, 8, 4 };
 
        ForkJoinPool pool = ForkJoinPool.commonPool();
 
        pool.invoke(new QuickSortMutliThreading(0, n - 1, arr));
 
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}