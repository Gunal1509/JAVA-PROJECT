import java.util.*;
public class valid{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int day= sc.nextInt();
        int month=sc.nextInt();
        int year=sc.nextInt();
        if(year>=1000 && year<=9999)
        {
            if(month<=12)
            {
                if( month==7 || month==8 || month==10 ||month==12|| month==1)
                {
                          if(day<=31 && day>=1)
                          {
                            System.out.println("valid");
                          }
                          else
                          {
                            System.out.println("invalid");
                          }
                }
                else
                {
                        if(month==2)
                        {
                            if(year%400==0 || ((year%4==0)&&(year%100 !=0)))
                            {
                                if(day<=29 && day>=1)
                                {
                                    System.out.println("valid");
                                }
                                else
                                {
                                    System.out.println("invalid");
                                }
                            }
                            else
                            {
                                if(day<=28 && day>=1)
                                {
                                    System.out.println("valid");
                                }
                                else
                                {
                                    System.out.println("invalid");
                                }
                            }
                        }
                        else
                        {
                             if(day<=30 && day>=1)
                                {
                                    System.out.println("valid");
                                }
                                else
                                {
                                    System.out.println("invalid");
                        }
                    }
            }
        }
        else
        {
            System.out.println("invalid");
        }
    }
    else
    {
        System.out.println("invalid");
    }
    sc.close();
}
}