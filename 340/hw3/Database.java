import java.util.Set;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

public class Database implements Set<String>
{
    public static void main(String[] args) 
    {
        Database db = new Database();
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

    private ArrayList<String> data;
    
    public Database()
    {
        super();
        this.data = new ArrayList<String>();
    }

    @Override
    public int size() 
    {
        return data.size();
    }

    @Override
    public boolean isEmpty() 
    {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) 
    {
        return data.contains(o);
    }

    @Override
    public Iterator<String> iterator() 
    {
        return data.iterator();
    }

    @Override
    public Object[] toArray() 
    {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) 
    {
        return data.toArray(a);
    }

    @Override
    public boolean add(String e) 
    {
        if (data.contains(e)) 
        {
            return false;
        }
        return data.add(e);
    }

    @Override
    public boolean remove(Object o) 
    {
        return data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) 
    {
        return data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) 
    {
        return data.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) 
    {
        return data.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) 
    {
        return data.removeAll(c);
    }

    @Override
    public void clear() 
    {
        data.clear();
    }
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < data.size(); i++) 
            {
            sb.append(data.get(i));
            if(i < data.size() - 1) 
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

