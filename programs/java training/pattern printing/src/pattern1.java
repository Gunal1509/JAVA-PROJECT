import java.util.*;
public class pattern1 {
               public static void main(String[] args)
               {
                Scanner sc= new Scanner(System.in);
                int num=sc.nextInt();
                for(int i=1;i<=num;i++)
                {
                    if(i==num)
                    {
                        for(int j=1;j<=num;j++)
                        {
                            System.out.print(" * ");
                        }
                    }else
                    {
                          for(int j=1;j<=num;j++)
                        {
                            System.out.print("   ");
                        
                }
            }
            for(int k=1;k<=i;k++)
            {
                System.out.print(" * ");
            }
               System.out.println();

               }
}
}
