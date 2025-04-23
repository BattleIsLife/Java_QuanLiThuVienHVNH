package GUI_Class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Database_Class.Nhanvien_DB;
import Model.Nhanvien;

public class Login_Events {
    private Login_GUI gui;
    public Login_Events(Login_GUI gui)
    {
        this.gui = gui;
        addEventListener();
    }

    private void addEventListener()
    {
        gui.btnDangnhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDangnhap_Click();
            }
        });

        gui.btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnThoat_Click();
            }
        });
    }

    private void btnDangnhap_Click()
    {
        String maNV = gui.txtManhanvien.getText().trim();
        Nhanvien nhanvienLogin = Nhanvien_DB.getInstance().selectById(maNV);
        if(nhanvienLogin == null)
        {
            JOptionPane.showMessageDialog(gui, "Sai mã nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!nhanvienLogin.getMatKhau().equals(gui.txtMatkhau.getText().trim())) {
            JOptionPane.showMessageDialog(gui, "Sai mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(gui, "Đăng nhập thành công", "Thông báo", JOptionPane.OK_OPTION);

        gui.dispose();
        new MainMenu_GUI(nhanvienLogin);
    }

    private void btnThoat_Click()
    {
        if (JOptionPane.showConfirmDialog(gui, "Bạn có muốn thoát chương trình?", "Thoát chương trình", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
