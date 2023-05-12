public class Runnable1 
{
    public static void main(String[] args)
    {
        Thread t = new Thread (new Thongbao1());
        t.start();
        Thread t1 = new Thread(new Thongbao2());
        t1.start();
    }
}

class Thongbao1 implements Runnable
{
    public void run()
    {
        for (int i=1;i<=3000;i++)
        {
            System.out.println("Chao ban");
        }
    }
}

class Thongbao2 implements Runnable
{
    public void run()
    {
        for (int i=1;i<=3000;i++)
        {
            System.out.println("Hi");
        }
    }
}
