package CaCoffee;

public class BlackCat extends Cat{
    public BlackCat() {
        this.c_Price=350.00;
    }
    @Override
    public String toString() {
        return "黑猫 名字：" +
                c_Name  +
                " ,  年龄：" + c_Age+"岁" ;
    }
}
