import java.util.*;
 class classA{
    classA()
    {
        System.out.println("i am classA");
    }
}
class classB extends classA
{
    classB()
    {
        System.out.println("i am classB");
    }
}
class classC extends classB
{
    classC()
    {
        System.out.println("i am classC");
    }
}
 class classc_1 extends classC
{

    classc_1()
    {
         System.out.println("i am classc_1");
    }
}
 class classc_2 extends classC
{
    classc_2()
    {
         System.out.println("i am classc_2");
    }
}
public class lokesh{
    public static void main(String args[])
    {
        classC c= new classC();
        classc_2 c1= new classc_2();
    }
}
