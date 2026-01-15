class Main
{
    public static void main(String[] args)
    {
        Numbers nums = new Numbers(3);
        nums.fillPrompt();
        nums.print();
        System.out.println((nums.checkFor(3) ? "Found" : "Not Found"));
    }
}