import java.util.*;
public class subtractProduct{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int  num=sc.nextInt();
        int s=0;
        int p=1;
        int n=num;
        while(n>0)
        {
            int digi=n%10;
            s=s+digi;
            p=p*digi;
            n=n/10;

        }
        System.out.println(p-s+" ");
        sc.close();

    }
}