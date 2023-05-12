import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UCLNBCNN {
    public int nhapso() throws IOException
    {
        InputStreamReader luongvao = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(luongvao);
        String s = br.readLine();
        return Integer.parseInt(s);
    }

    int UCLN(int A, int B) {
        //Nếu A hoặc B = 0 thì UCLN = A+ B
        if (A == 0 || B == 0)
            return A + B;

        //Lặp cho tới khi A = B
        while(A != B) {
            //Lấy số lớn trừ số bé.
            if (A > B) {
                A -= B;
            }else{
                B -= A;
            }
        }

        // Trả về UCLB
        // Lúc này A = B nên return về A hay B đều giống nhau
        return A;
    }
    public static void main(String argx[])
    {
        int a=0,b=0;
        UCLNBCNN dt = new UCLNBCNN();
        try
        {
            do {
                System.out.print("Nhap a duong: ");
                a=dt.nhapso();

            }while (a<=0);
        }catch(Exception e){}

        try
        {
            do {
                System.out.print("Nhap b duong: ");
                b=dt.nhapso();

            }while (b<=0);
        }catch(Exception e){}

        int ucln = dt.UCLN(a,b);
        int bcnn = a*b/ucln;
        System.out.println("UCLN: "+ucln);
        System.out.println("BCNN: "+bcnn);
    }
}
