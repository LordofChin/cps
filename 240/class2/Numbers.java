import java.util.Scanner;

public class Numbers
{
    private int[] numbers;
    private int size;

    public Numbers(int size)
    {
        this.size = size;
        this.numbers = new int[size];
    }

    public void print() 
    {   
        System.out.print("{ ");
        for(int n : this.numbers)
        {
            System.out.print(n + " ");
        }
        System.out.println ("}");
    }

    public void fillPrompt()
    {   
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.size; i++)
        {
            System.out.printf("Enter element at index %d: ", i);
            this.numbers[i] = sc.nextInt();
        }
        sc.close();
    }

    public boolean checkFor(int element) 
    {
        for(int i = 0; i < this.size; i++)
        {
            if (this.numbers[i] == element) return true;
        }
        return false;
    }
}