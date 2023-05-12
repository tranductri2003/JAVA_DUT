public class Thread1
{
    public static void main(String[] args)
    {
        Thongbao1 dt1 = new Thongbao1();
        dt1.start();
        Thongbao2 dt2 = new Thongbao2();
        dt2.start();
    }

}
class Thongbao1 extends  Thread
{
    public void run()
    {
        for(int i=1;i<=3000;i++)
        {
            System.out.println("Hello");
        }
    }
}


class Thongbao2 extends Thread
{
    public void run()
    {
        for (int i=1;i<=3000;i++)
        {
            System.out.println("Xin chao");
        }
    }
}
