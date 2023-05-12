
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bai4 {
    public int nhap() throws IOException {
        InputStreamReader ISR=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ISR);
        String s=br.readLine();
        return Integer.parseInt(s);
    }
    public void xulimang(int[][] s) {
        //b. Tính tích các số bội 3 nằm trên dòng đầu tiên của ma trận a
        int tich=1;
        for(int i=0;i<s.length;i++) {
            for(int j=0;j<s[i].length;j++) {
                if(s[i][j]%3==0) tich*=s[i][j];
            }
        }
        System.out.println("Tich cac so boi 3 la: "+tich);
        //c. Tạo ra mảng một chiều X[i] là các giá trị lớn nhất trên dòng i của ma trận
        int[] X=new int[s.length];
        for(int i=0;i<s.length;i++) {
            int max=s[i][0];
            for(int j=1;j<s[i].length;j++) {
                if(s[i][j]>max) max=s[i][j];
            }
            X[i]=max;
        }
        System.out.print("Mang cac so lon nhat cua hang la: ");
        for(int i=0;i<s.length;i++) {
            System.out.printf("%d ,",X[i]);
        }
        System.out.println();
        //d. Xoá đi phần tử đầu tiên của mảng X[i], xuất lại mảng X[i]
        for(int i=1;i<s.length;i++) {
            X[i-1]=X[i];
        }
        System.out.print("Mang sau khi loai so dau tien la: ");
        for(int i=0;i<s.length-1;i++) {
            System.out.printf("%d ,",X[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=0,m=0;
        int[][] s;
        bai4 b4=new bai4();
        try {
            do {
                System.out.print("Moi nhap n: ");
                n=b4.nhap();
                System.out.print("Moi nhap m: ");
                m=b4.nhap();
            } while(n<=0 || m<=0);
            s=new int[n][m];
            System.out.println("Nhap chuoi so: ");
            for(int i=0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    s[i][j]=b4.nhap();
                }
            }
            b4.xulimang(s);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}
