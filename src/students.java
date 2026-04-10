import java.io.Serializable;

class students implements Serializable
{
    int studentid;
    String name;
    int Roll_no;
    double marks;

    students(int id,String name,int roll,double marks)
    {
        studentid=id;
        this.name=name;
        this.Roll_no=roll;
        this.marks=marks;
    }

    public String toString()
    {
        return "ID : " + studentid + ", Name : " + name + ", Roll no : " + Roll_no + ", Marks : " + marks;
    }

}
