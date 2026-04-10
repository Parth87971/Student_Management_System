import java.io.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws Exception {
        FileHandle F1 = new FileHandle();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("      STUDENT MANAGEMENT SYSTEM       ");
            System.out.println("1.Add Student :");
            System.out.println("2.Display :");
            System.out.println("3.Search :");
            System.out.println("4.Total Count :");
            System.out.println("5.Delete ");
            System.out.println("6.Update ");
            System.out.println("7.Sort Students");
            System.out.println("8.Export data to text File");
            System.out.println("9.Topper ");
            System.out.println("Exit");

            System.out.println("Enter your choice :");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    F1.addStudent();
                    break;
                case 2 :
                    F1.display();
                    break;
                case 3:
                    F1.search();
                    break;
                case 4:
                    F1.count();
                    break;
                case 5 :
                    F1.delete();
                    break;
                case 6 :
                    F1.update();
                    break;
                case 7 :
                    F1.sort();
                    break;
                case 8:
                    F1.textfile();
                    break;
                case 9:
                    F1.Topper();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=10);





    }

}
