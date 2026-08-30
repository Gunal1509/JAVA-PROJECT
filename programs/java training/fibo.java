import java.util.*;
public class fibo{
    public static int fibonaci(int n)
    {
        if(n==0)
           return 0;
        else if(n==1)
            return 1;
        else
            return fibonaci(n-1)+fibonaci(n-2);
    }
    public static void main(String[] args)
    {
       int n;
       Scanner sc= new Scanner(System.in);
       n=sc.nextInt();
       int res= fibonaci(n);
       System.out.println(res);
    }
}