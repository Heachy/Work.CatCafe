package CaCoffee;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        MyCatCafe myCatCafe=new MyCatCafe();
        myCatCafe.balance=2000.0;
        //开局两只猫，其余全靠买
        OrangeCat o=new OrangeCat();
        o.c_Age=3;
        o.c_Name="小橘";
        o.c_IsFat=true;
        myCatCafe.C_arr.add(o);
        BlackCat b=new BlackCat();
        b.c_Age=2;
        b.c_Name="小黑";
        myCatCafe.C_arr.add(b);
        while(true)
        {
            System.out.println("*************************************");
            System.out.println("**********—————————————————**********");
            System.out.println("*********|    我的猫咖馆     |*********");
            System.out.println("*********|                 |*********");
            System.out.println("*********|    1、购买猫猫    |*********");
            System.out.println("*********|                 |*********");
            System.out.println("*********|    2、招待顾客    |*********");
            System.out.println("*********|                 |*********");
            System.out.println("*********|    3、到点歇业    |*********");
            System.out.println("*********|                 |*********");
            System.out.println("**********—————————————————**********");
            System.out.println("*************************************");
            Scanner sc=new Scanner(System.in);
            int select=sc.nextInt();
            if(select==1)
            {
                try {
                    myCatCafe.buyCat();
                }catch (InsufficientBalanceException i)
                {
                    System.out.println(i.getMessage());
                }
            }
            else if(select==2)
            {
                try {
                    myCatCafe.getCustomer();
                }catch (CatNotFoundException c)
                {
                    System.out.println(c.getMessage());
                }
            }
            else
            {
                myCatCafe.close();
                break;
            }
            System.out.println("请输入1并按回车继续经营猫咖");
            char ch=sc.next().charAt(0);
        }
    }
}
