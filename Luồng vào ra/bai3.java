import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bai3 {

    public int nhap() throws IOException {
        InputStreamReader ISR=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ISR);
        String s=br.readLine();
        return Integer.parseInt(s);
    }
    public void xulimang(int[] s) {
        //b. Tính tổng các số dương lẻ mảng a
        int sum=0;
        for(int i=0;i<s.length;i++) {
            if(s[i]%2==1 && s[i]>=0) {
                sum+=s[i];
            }
        }
        System.out.println("Tong cac so duong le la: "+sum);
        //c. Nhập phần tử k, tìm xem k có xuất hiện trong mảng đã cho hay không?
        //Nếu có chỉ ra phần tử ở vị trí đầu tiên
        bai3 b31=new bai3();
        int k=0;
        int find=-1;
        try {
            do {
                System.out.print("Moi nhap so can tim: ");
                k=b31.nhap();
            } while(k<=0);
            for(int i=0;i<s.length;i++) {
                if(s[i]==k) {
                    find=i;
                    break;
                }
            }
            System.out.println("Vi tri dau tien cua so "+k+" la: "+find);
        }

        catch(Exception e) {
            System.out.println(e);
        }

        //d.  Sắp sếp mảng a theo thứ tự tăng dần.
        Arrays.sort(s);
        System.out.print("Chuoi so theo thu tu la: ");
        for(int i=0;i<s.length;i++) {
            System.out.printf("%d, ", s[i]);
        }
        System.out.println();
        //e. Chèn phần tử p vào mảng a sao cho mảng a vẫn đảm bảo tăng dần và xuất
        //lại mảng a.

        int k1=0;

        try {
            do {
                System.out.print("Moi nhap so can them: ");
                k1=b31.nhap();
            } while(k1<=0);
            int[] s1=new int[s.length+1];
            for(int i=0;i<s.length;i++) {
                s1[i]=s[i];
            }
            s1[s.length]=k1;
            Arrays.sort(s1);
            System.out.print("Chuoi so theo thu tu la: ");
            for(int i=0;i<s1.length;i++) {
                System.out.printf("%d, ", s1[i]);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=0;
        int[] s;
        bai3 b3=new bai3();
        try {
            do {
                System.out.print("Moi nhap n: ");
                n=b3.nhap();
            } while(n<=0);
            s=new int[n];
            System.out.println("Nhap chuoi so: ");
            for(int i=0;i<n;i++) {
                s[i]=b3.nhap();
            }
            b3.xulimang(s);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
