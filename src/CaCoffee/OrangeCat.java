package CaCoffee;

public class OrangeCat extends Cat{
    public boolean c_IsFat;

    public OrangeCat() {
        this.c_Price=200.00;
    }

    @Override
    public String toString() {
        return "橘猫 名字：" +
                 c_Name  +
                " ,  年龄：" + c_Age +"岁"+
                " ,  体型：" + ((c_IsFat)?"肥":"不肥");
    }
}
