import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MangSoNguyen {
    private int[]A = new int[100];
    private int m;
    private static int docso() throws IOException{
        InputStreamReader rd = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(rd);
        return Integer.parseInt(b.readLine());
    }

    private void Nhapmang() throws IOException
    {
        System.out.println("Nhap so phan tu: ");
        m = docso();
        for(int i=0; i<m;i++)
        {
            System.out.print("A["+i+"]  = ");
            A[i] = docso();
        }
        for (int i=0; i<m;i++)
        {
            System.out.print(A[i]);
        }
    }
    public static void main(String argx[]) throws IOException {
        MangSoNguyen t = new MangSoNguyen();
        t.Nhapmang();
    }

}
