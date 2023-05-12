
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai2
{
    public int nhap() throws IOException {
        InputStreamReader ISR=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ISR);
        String s=br.readLine();
        return Integer.parseInt(s);
    }

    public void xuliso(int m) {
        //a.  Tính tổng các chữ số của số nguyên dương m
        int m1=m;
        int s=0;
        int s1=0;
        while(m1>0) {
            s+=m1%10;
            s1=s1*10+m1%10;
            m1/=10;
        }
        System.out.println("Tong cac chu so cua "+m+" la: "+s);
        //b.  In ra số đảo ngược của m
        System.out.println("So dao nguoc cua "+m+" la: "+s1);
        //c. Kiểm tra số m có thuộc dãy Fibonaci không? ( 1 1 2 3 5 8 ….)
        int fibo1=1,fibo2=1,fibo=1;
        while(fibo<m) {
            fibo=fibo1+fibo2;
            fibo1=fibo2;
            fibo2=fibo;
        }
        if(fibo==m) {
            System.out.println("So "+m+" thuoc day Fibonaci");
        }
        else {
            System.out.println("So "+m+" khong thuoc day Fibonaci");
        }
        //d.  Kiểm tra đảo ngược của m có phải là số đối xứng không?
        if(m==s1) {
            System.out.println("So "+m+" la so doi xung");
        }
        else {
            System.out.println("So "+m+" khong la so doi xung");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int m=0;
        bai2 b2=new bai2();
        try {
            do {
                System.out.print("Nhap so: ");
                m=b2.nhap();
            } while(m<=0);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        b2.xuliso(m);
    }

}
