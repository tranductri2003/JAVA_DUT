import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bai1
{
    public void xuLiChuoi (String s)
    {
        //1. Dao nguoc chuoi
        String strDao="";
        for ( int i=s.length()-1;i>=0;i--)
        {
            strDao+=s.charAt(i);
        }
        System.out.println("Chuoi dao so voi chuoi da cho la: "+strDao);

        //2. Duoi chuoi sang chu hoa
        String strHoa="";
        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                strHoa+=Character.toString(s.charAt(i)-32);
            }
            else
            {
                strHoa+=s.charAt(i);
            }
        }
        System.out.println("Chuoi in Hoa so voi chuoi da cho la: "+strHoa);

        //3. Doi chuoi da cho sang chu thuong
        String strThuong="";
        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i)>='A' && s.charAt(i)<='Z')
            {
                strThuong+=Character.toString(s.charAt(i)+32);
            }
            else
            {
                strThuong+=s.charAt(i);
            }
        }
        System.out.println("Chuoi in Thuong so voi chuoi da cho la: "+strThuong);

        //4. Doi chuoi da cho tu hoa sang thuong, thuong sang hoa
        String strHoaThuong="";
        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i)>='A' && s.charAt(i)<='Z')
            {
                strHoaThuong+=Character.toString(s.charAt(i)+32);
            }
            else if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                strHoaThuong+=Character.toString(s.charAt(i)-32);
            }
            else
            {
                strHoaThuong+=s.charAt(i);
            }
        }
        System.out.println("Chuoi in vua hoa vua thuong so voi chuoi da cho la: "+strHoaThuong);

        //5. Dem so tu co trong chuoi da cho
        // Tách các từ trong chuỗi bằng khoảng trắng hoặc dấu câu
        String[] words = s.split("\\s+|\\p{Punct}");

        // Đếm số từ đã tách được
        int soTu = words.length;

        System.out.println("Chuỗi: " + s);
        System.out.println("Số từ trong chuỗi: " + soTu);
        System.out.println("Các từ trong chuỗi:");
        for (String word : words) {
            System.out.println(word);
        }

    }
    public static void main(String [] args)
    {
        bai1 bt1 = new bai1();
        String s="";
        try
        {
            System.out.print("Nhap chuoi: ");
            InputStreamReader ISR = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ISR);
            s= br.readLine();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
        bt1.xuLiChuoi(s);

        //6. Dua bang tan so xuat hien cua cac tu
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i=0; i<s.length();i++)
        {
            if (frequency.get(s.charAt(i)) == null)
            {
                frequency.put(s.charAt(i),1);
            }
            else
            {
                frequency.put(s.charAt(i),frequency.get((s.charAt(i)))+1);
            }
        }
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Chữ: " + key + ", Số lần xuất hiện: " + value);
        }
    }

}