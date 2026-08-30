import java.util.*;
public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    String s=sc.nextLine();
    String res=""
    String ans="";
    int n=s.length(),i=0;
    while(i<n)
    {
        char ch=s[i];
        if((int(ch-'0')>=97)&&(int(ch-'0')<=123))
        {
            res+=ch;
        }
        else{
            for(int j=1;j<=int(ch-'0');j++)
            {
                for(int k=0;k<res.length();k++)
                {
                    for(int l=1;l<=int(ch-'0');l++)
                    {
                        ans+=res[i];
                    }
                }
            }
            res="";
        }
        i=i+1;
    }
    System.out.println(ans);
}
