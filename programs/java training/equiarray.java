import java.util.*;
public class equiarray{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int[] arr1= new int[3];
        int[] arr2=new int[3];
        for(int i=0;i<3;i++)
        {
             arr1[i]=sc.nextInt();
        }
        for(int i=0;i<3;i++)
        {
             arr2[i]=sc.nextInt();
        }
        int flag=0;
        
        for(int i=0;i<3;i++)
        {
             flag=1;
            if(arr1[i]==arr2[i])
            {
                continue;
            }
            int[] hash= new int[10];
            int nu1=arr1[i];
            int nu2=arr2[i];
            int digi1,digi2;
            while(nu1>0 && nu2>0)
            {
                digi1=nu1%10;
                hash[digi1]++;
                digi2=nu2%10;
                hash[digi2]++;
                nu1=nu1/10;
                nu2=nu2/10;
            }
            int j=0;
            while(j<10)
            {
                if(hash[j]==2|| hash[j]==0)
                {
                    j=j+1;
                }
                else
                {
                    flag=0;
                    break;
                }
                
            }
        }
        if(flag==1)
        {
            System.out.println("equi array");
        }
        else
        {
            System.out.println("no equi array");
        }
        sc.close();
    }
}
