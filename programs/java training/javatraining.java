import java.util.*;
public class javatraining {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int a= sc.nextInt();
        //int b= sc.nextInt();
        //int s=a+b;
        int res= smallmultiple(a);
        System.out.println(res)
;        sc.close();
        
    
    }
    public static int smallmultiple(int num)
    {
       for(int i =1;i<10;i++)
       {
        if((i*num)%2==0 && (i*num)*num==0)
        {
            return (i*num);
        }
       }
       return 0;
    }
}
