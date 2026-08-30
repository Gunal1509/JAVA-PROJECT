import java.util.*;
public class recur2{
    public static void main(String[] args)
    {
        int num=10;
        odd(num);
    }
    public static void odd(int num)
    {
        if(num==0)
        {
            return;
        }
        System.out.print(num-1+" ");
        even(num-1);
         
    }
    public static void even(int num)
    {
        if(num==0)
        {
            return;
        }
         System.out.print(num+1+" ");
         odd(num-1);

    }
}