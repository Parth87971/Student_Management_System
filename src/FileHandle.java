import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class FileHandle {
    void write(ArrayList<students>list)throws Exception
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Std.DAT"));
        oos.writeObject(list);
        oos.close();

    }
    ArrayList<students> read()throws Exception
    {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Std.DAT"));
        ArrayList<students> list = (ArrayList<students>) ois.readObject();
        ois.close();
        return list;
    }
    void search() throws Exception {
        Scanner sc = new Scanner(System.in);

        int id;
        while (true) {
            try {
                System.out.println("Enter ID to search : ");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid ID!");
            }
        }

        ArrayList<students> list = read();

        boolean found = false;

        for (students s : list) {
            if (s.studentid == id) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found");
        }
    }
    void sort()throws Exception{
        ArrayList<students>list=read();
        students s;
        if(list.isEmpty())
        {
            System.out.println("No data found");
        }

        Collections.sort(list, (a, b) -> Double.compare(b.marks, a.marks));
        write(list);
        display();

    }
    void textfile()throws Exception{
        ArrayList<students>List=read();

        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\LENOVO\\IdeaProjects\\Student Management System\\Students.txt"));

        bw.write(String.format("%-5s %-15s %-10s %-10s", "ID", "Name", "RollNo", "Marks"));
        bw.newLine();


        for(students s : List) {
            bw.write(String.format("%-5d %-15s %-10d %-10.2f",
                    s.studentid, s.name, s.Roll_no, s.marks));
            bw.newLine();
        }

        bw.close();
        System.out.println("Data Exported");
    }
    void addStudent() throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<students> list;

        try {
            list = read();
        } catch (Exception e) {
            list = new ArrayList<>();
        }

        int id;
        while (true) {
            try {
                System.out.println("Enter student ID :");
                id = sc.nextInt();

                boolean exists = false;
                for (students s : list) {
                    if (s.studentid == id) {
                        System.out.println("ID Already Exists");
                        exists = true;
                        break;
                    }
                }
                if (!exists) break;

            } catch (Exception e) {
                System.out.println("Invalid ID! Enter a number.");
            }
        }

        String name;
        while (true) {
            System.out.println("Enter Name :");
            name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty");
            } else {
                break;
            }
        }

        int rollno;
        while (true) {
            try {
                System.out.println("Enter Roll no :");
                rollno = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid roll number!");
            }
        }

        double marks;
        while (true) {
            try {
                System.out.println("Enter marks :");
                marks = Double.parseDouble(sc.nextLine());

                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid marks!");
            }
        }

        list.add(new students(id, name, rollno, marks));
        write(list);
        System.out.println("Student added");
    }
    void display()throws Exception{
            ArrayList<students>list = read();

            if(list.isEmpty())
            {
                System.out.println("No data found");
            }

                System.out.printf("%-5s %-15s %-10s %-10s\n", "ID", "Name", "RollNo", "Marks");


                for(students s : list) {
                    System.out.printf("%-5d %-15s %-10d %-10.2f\n",
                            s.studentid, s.name, s.Roll_no, s.marks);
            }
    }
    void update() throws Exception {
        Scanner sc = new Scanner(System.in);

        int id;
        while (true) {
            try {
                System.out.println("Enter which ID to update :");
                id = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid ID!");
            }
        }

        ArrayList<students> list = read();
        boolean found = false;

        for (students s : list) {
            if (s.studentid == id) {

                System.out.println("Enter new name :");
                s.name = sc.nextLine();

                while (true) {
                    try {
                        System.out.println("Enter new marks :");
                        double m = sc.nextDouble();

                        if (m < 0 || m > 100) {
                            System.out.println("Marks must be 0-100");
                        } else {
                            s.marks = m;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid marks!");
                    }
                }

                found = true;
                break;
            }
        }

        if (found) {
            write(list);
            System.out.println("List updated");
        } else {
            System.out.println("student not found");
        }
    }
    void delete() throws Exception {
        Scanner sc = new Scanner(System.in);

        int id;
        while (true) {
            try {
                System.out.println("Enter student id :");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid ID!");
            }
        }

        ArrayList<students> list = read();

        boolean removed = false;

        Iterator<students> it = list.iterator();

        while (it.hasNext()) {
            students s = it.next();
            if (s.studentid == id) {
                it.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            write(list);
            System.out.println("Data deleted");
        } else {
            System.out.println("Not found");
        }
    }
    void count()throws Exception
    {
        ArrayList<students>list=read();
        System.out.println("Total students :"+list.size());
    }
    void Topper()throws Exception
    {
        ArrayList<students>list=read();
        if(list.isEmpty())
        {
            System.out.println("No records");
        }
        students top = list.get(0);
        for(students s:list)
        {
            if(s.marks>top.marks)
            {
                top=s;
            }

        }
        System.out.println("Topper :"+"\n"+top);
    }
}
