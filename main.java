import java.util.Scanner;

public class main  {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== SMART CITY MANAGEMENT SYSTEM =====");
            System.out.println("1. Smart City Route Planner");
            System.out.println("2. Data Sorter");
            System.out.println("3. Performance Analyzer");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Module 1 starting...");
                    // Member 1 code call
                    // RoutePlannerModule.start();
                    break;

                case 2:
                    System.out.println("Module 2 starting...");
                    DataSorter.start();   //
                    break;

                case 3:
                    System.out.println("Module 3 starting...");
                    // Member 3 code call
                    // PerformanceModule.start();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

