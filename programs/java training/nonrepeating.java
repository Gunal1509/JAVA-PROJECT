import java.util.*;
public class nonrepeating
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n1= sc.nextInt();
        int n2=sc.nextInt();
        int flag=0;
        for(int i=n1;i<=n2;i++)
        {
              int num=i;
              List<Integer> number = new ArrayList<>();
              while(num>0)
              {
                int digi=num%10;
                if(number.contains(digi)){
                    flag=0;
                    break;
                }
                else
                {
                    number.add(digi);

                }
                num=num/10;
                flag=1;
              }
              if(flag==1)
              {
                System.out.println(i);
              }

        }
        sc.close();
    }
}