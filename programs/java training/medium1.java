import java.util.*;
public class medium1{
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    String s=sc.nextLine();
    String res="",ans="";
    int n=s.length(),i=0;
    while(i<n)
    {
        char ch=s.charAt(i);
        if(ch >= 'a' && ch <= 'z')
        {
            res+=ch;
        }
        else{
            for(int j=1;j<=(ch-'0');j++)
            {
                for(int k=0;k<res.length();k++)
                {
                    for(int l=1;l<=(ch-'0');l++)
                    {
                        ans+=res.charAt(k);
                    }
                }
            }
            res="";
        }
        i=i+1;
    }
    System.out.println(ans);
}
}
