import java.util.*;
public class rec{
    public static void main(String[] args)
{
    int res= fibo(6);
    System.out.println(res);
}
    public static int fibo(int num)
    {
      if(num==0)
      {
        return 0;
      }
      else if(num==1)
      {
        return 1;
      }
      else
      {
        return fibo(num-1)+fibo(num-2);
      }

    }
}