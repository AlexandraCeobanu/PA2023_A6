public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String languages[] = {"C", "C++","C#","GO","Python", "Rust", "JavaScript", "PHP", "Swift","Java"};
        int n= (int) (Math.random() * 1_000_000);
        n=n*3;
        n=n+ Integer.parseInt("10101",16);
        n=n+ Integer.parseInt("FF",16);
        n=n*6;
        System.out.println(n);
        int sum=n;
        while(sum>9)
        {
            sum=0;
            while(n!=0)
            {
                sum=sum+n%10;
                n/=10;
            }
            n=sum;
        }
        System.out.println(sum);
        System.out.println("Willy-nilly, this semester I will learn"+" "+languages[sum]);
    }
}