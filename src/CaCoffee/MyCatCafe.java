package CaCoffee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MyCatCafe implements CatCafe{
    public MyCatCafe() {
        this.cost=0.0;
    }

    @Override
    public void buyCat() {
        System.out.println("请选择猫的品种：1、橘猫  2、黑猫");
        Scanner sc=new Scanner(System.in);
        int select=sc.nextInt();
        if(select==1)
        {
            if(this.balance<200)
            {
                throw new InsufficientBalanceException("余额不足");
            }
            else {
                OrangeCat o = new OrangeCat();
                System.out.println("要买几岁的猫：");
                o.c_Age = sc.nextInt();
                System.out.println("请选择想要的体型：1、肥 2、不肥");
                int is = sc.nextInt();
                o.c_IsFat = is == 1;
                System.out.println("请给这只猫起名：");
                o.c_Name = sc.next();
                this.C_arr.add(o);
                this.balance-=200.0;
                this.cost+=200.0;
                System.out.println("购买成功！");
            }
        }
        else
        {
            if(this.balance<350)
            {
                throw new CatNotFoundException("无猫可rua");
            }
            else {
                BlackCat b=new BlackCat();
                System.out.println("要买几岁的猫：");
                b.c_Age = sc.nextInt();
                System.out.println("请给这只猫起名：");
                b.c_Name = sc.next();
                this.C_arr.add(b);
                this.cost+=350.0;
                this.balance-=350.0;
                System.out.println("购买成功");
            }
        }
    }

    @Override
    public void getCustomer() {
            Scanner sc=new Scanner(System.in);
            Customer C=new Customer();
            System.out.println("请输入到店时间：");
            System.out.println("年：");
            int year=sc.nextInt();
            System.out.println("月：");
            int month=sc.nextInt();
            System.out.println("日：");
            int day=sc.nextInt();
            C.Time=LocalDate.of(year,month,day);
            if(LocalDate.now().isEqual(C.Time)) {
                if(this.C_arr.size()==0) {
                    throw new CatNotFoundException("抱歉，今日店内无猫可rua,请去购买猫猫");
                }
                else{
            System.out.println("请输入顾客的姓名：");
            C.m_Name=sc.next();
            System.out.println("请输入今天要rua的次数：");
            C.m_Frequency=sc.nextInt();
            this.balance+=15.0*C.m_Frequency;
            System.out.println("他今天rua的猫为：");
            Random r=new Random();
            for(int i=0;i<C.m_Frequency;i++) {
                int numb = r.nextInt(this.C_arr.size());
                Cat c = this.C_arr.get(numb);
                System.out.println(c.toString());
                }
                    this.M_arr.add(C);
                    System.out.println("欢迎下次光临！");
            }
            }
            else {
                System.out.println("请输入顾客的姓名：");
                C.m_Name=sc.next();
                System.out.println("请输入顾客之前rua的次数：");
                C.m_Frequency=sc.nextInt();
                this.M_arr.add(C);
                System.out.println("欢迎下次光临");
            }
    }

    @Override
    public void close() {
        double sum=0;
        int total=0;
        for (Customer customer : this.M_arr) {
            if(LocalDate.now().isEqual(customer.Time))
            {
                total++;
            }
        }
        if(total==0)
        {
            System.out.println("今天没有顾客来QAQ");
        }
        else {
            System.out.println("今天来的顾客有：");
            for (Customer customer : this.M_arr) {
                if(LocalDate.now().isEqual(customer.Time))
                {
                    System.out.println(customer);
                    sum += customer.m_Frequency * 15.0;
                }
            }
        }
        System.out.println("今天的利润为："+(sum-this.cost));
        System.out.println("希望明天赚到更多的money");
    }
    double cost;
    double balance;
    ArrayList<Cat> C_arr= new ArrayList<>();
    ArrayList<Customer> M_arr= new ArrayList<>();
}
