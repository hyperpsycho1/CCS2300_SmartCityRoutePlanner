
import java.util.*;

public class DataSorter {

    static Scanner sc = new Scanner(System.in);
    static int[] originalArray = null;

    // =========================
    // MAIN MENU
    // =========================
    public static void start() {
        while (true) {
            System.out.println("\n===== DATA SORTER MODULE =====");
            System.out.println("1. Enter Numbers Manually");
            System.out.println("2. Generate Random Numbers");
            System.out.println("3. Run Sorting Algorithms");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    enterNumbers();
                    break;
                case 2:
                    generateRandom();
                    break;
                case 3:
                    runSorting();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // =========================
    // ENTER NUMBERS
    // =========================
    private static void enterNumbers() {
        System.out.print("How many numbers? ");
        int n = sc.nextInt();

        originalArray = new int[n];

        System.out.println("Enter numbers:");
        for (int i = 0; i < n; i++) {
            originalArray[i] = sc.nextInt();
        }
    }

    // =========================
    // RANDOM NUMBERS
    // =========================
    private static void generateRandom() {
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        originalArray = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            originalArray[i] = r.nextInt(1000);
        }

        System.out.println("Random numbers generated.");
    }

    // =========================
    // RUN ALL SORTS
    // =========================
    private static void runSorting() {
        if (originalArray == null) {
            System.out.println("Please enter or generate numbers first!");
            return;
        }

        int[] bubbleArray = originalArray.clone();
        int[] mergeArray = originalArray.clone();
        int[] quickArray = originalArray.clone();

        long start, end;

        // Bubble
        start = System.nanoTime();
        bubbleSort(bubbleArray);
        end = System.nanoTime();
        long bubbleTime = end - start;

        // Merge
        start = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        end = System.nanoTime();
        long mergeTime = end - start;

        // Quick
        start = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        end = System.nanoTime();
        long quickTime = end - start;

        // Output
        System.out.println("\n===== SORTED OUTPUT =====");
        System.out.println("Bubble Sort:");
        printArray(bubbleArray);
        System.out.println("Merge Sort:");
        printArray(mergeArray);
        System.out.println("Quick Sort:");
        printArray(quickArray);

        // Comparison table
        System.out.println("\n===== PERFORMANCE COMPARISON =====");
        System.out.printf("%-12s %-12s %-12s%n", "Algorithm", "Time (ns)", "Time (ms)");
        System.out.printf("%-12s %-12d %-12.6f%n", "Bubble", bubbleTime, bubbleTime / 1_000_000.0);
        System.out.printf("%-12s %-12d %-12.6f%n", "Merge", mergeTime, mergeTime / 1_000_000.0);
        System.out.printf("%-12s %-12d %-12.6f%n", "Quick", quickTime, quickTime / 1_000_000.0);

        // Fastest
        long min = Math.min(bubbleTime, Math.min(mergeTime, quickTime));
        if (min == bubbleTime) {
            System.out.println("Fastest: Bubble Sort");
        } else if (min == mergeTime) {
            System.out.println("Fastest: Merge Sort");
        } else {
            System.out.println("Fastest: Quick Sort");
        }
    }

    // =========================
    // BUBBLE SORT
    // =========================
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // =========================
    // MERGE SORT
    // =========================
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // =========================
    // QUICK SORT
    // =========================
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // =========================
    // PRINT ARRAY
    // =========================
    private static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
