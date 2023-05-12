import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bai1 extends JFrame implements ActionListener {
    private JLabel lblTitle, lblDonGia, lblSoLuong, lblGiamGia, lblThue;
    private JTextField txtDonGia, txtSoLuong, txtGiamGia, txtThue, txtTongTien;
    private JButton btnTongTien;

    public bai1(String s){
        super(s);
        GUI();
    }

    public void GUI(){
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setSize(600,350);

        lblTitle  = new JLabel("HÓA ĐƠN BÁN HÀNG");

        lblDonGia = new JLabel("ĐƠN GIÁ");
        lblSoLuong = new JLabel("SỐ LƯỢNG");
        lblGiamGia = new JLabel("GIẢM GIÁ");
        lblThue = new JLabel("THUẾ VAT");
        btnTongTien = new JButton("TỔNG TIỀN");

        txtDonGia = new JTextField(6);
        txtSoLuong = new JTextField(6);
        txtGiamGia = new JTextField(6);
        txtGiamGia.setEditable(false);
        txtThue = new JTextField(6);
        txtTongTien = new JTextField(6);
        txtTongTien.setEditable(false);

        lblTitle.setBounds(250,25,200,25);
        lblDonGia.setBounds(100,75,200,25);
        lblSoLuong.setBounds(100,125,200,25);
        lblGiamGia.setBounds(100,175,200,25);
        lblThue.setBounds(100,225,200,25);
        btnTongTien.setBounds(100,275,200,25);
        txtDonGia.setBounds(350,75,200,25);
        txtSoLuong.setBounds(350,125,200,25);
        txtGiamGia.setBounds(350,175,200,25);
        txtThue.setBounds(350,225,200,25);
        txtTongTien.setBounds(350,275,200,25);
        add(lblTitle);
        add(lblDonGia);
        add(lblSoLuong);
        add(lblGiamGia);
        add(lblThue);
        add(btnTongTien);
        add(txtDonGia);
        add(txtSoLuong);
        add(txtGiamGia);
        add(txtThue);
        add(txtTongTien);
        show();

        btnTongTien.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnTongTien){
            try{
                int DonGia = Integer.parseInt(txtDonGia.getText());
                int SoLuong = Integer.parseInt(txtSoLuong.getText());
                Double Thue = Double.parseDouble(txtThue.getText());
                Double GiamGia =0.0;

                if (5<=SoLuong && SoLuong<=9){
                    txtGiamGia.setText("5%");
                    GiamGia = 0.05;
                }
                else if (10<=SoLuong && SoLuong<=19){
                    txtGiamGia.setText("10%");
                    GiamGia = 0.10;
                }
                else if (20<=SoLuong && SoLuong<=39){
                    txtGiamGia.setText("20%");
                    GiamGia = 0.20;
                }
                else if (SoLuong>=40){
                    txtGiamGia.setText("30%");
                    GiamGia = 0.30;
                }
                else{
                    txtGiamGia.setText("0%");
                }
                Double TongTien = (DonGia*SoLuong)*(1-GiamGia)*(1+Thue/100);
                txtTongTien.setText(String.format("%.2f", TongTien));

            }catch (Exception p){
                JOptionPane.showMessageDialog(this, "THÔNG TIN NHẬP VÀO KHÔNG HỢP LỆ");
            }
        }
    }

    public static void main(String [] args){
        bai1 bai1 = new bai1("HOA DON BAN HANG");
    }
}
