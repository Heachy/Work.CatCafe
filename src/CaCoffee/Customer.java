package CaCoffee;

import java.time.LocalDate;

public class Customer {
    public String m_Name;
    public int m_Frequency;
    public LocalDate Time;
    @Override
    public String toString() {
        return
                "顾客的姓名: " + this.m_Name +
                ", rua猫的次数：" + this.m_Frequency +
                "次, 到店时间: " + Time;
    }
}
