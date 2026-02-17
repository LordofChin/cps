import java.util.TreeSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class Database
{
    public static void main(String[] args) 
    {
        TreeSet<String> db = new TreeSet<String>();
        System.out.println("1. add\n2. remove\n3. search\n4. print\n5. Exit");
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    db.add(sc.next());
                    break;
                case 2:
                    db.remove(sc.next());
                    break;
                case 3:
                    if(db.contains(sc.next())) {
                        System.out.println("found");
                    } else {
                        System.out.println("not found");
                    }
                    break;
                case 4:
                    System.out.println(db.toString());
                    break;
                case 5:
                    System.out.println("goodbye");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
