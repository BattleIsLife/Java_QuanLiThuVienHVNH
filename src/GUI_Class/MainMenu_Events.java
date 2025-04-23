package GUI_Class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class MainMenu_Events {
    private MainMenu_GUI ui;
    public MainMenu_Events(MainMenu_GUI ui)
    {
        this.ui = ui;
        addEventListener();
    }

    private void addEventListener()
    {
        ui.itemSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemSach_Click();
            }
        });

        ui.itemTacGia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemTacGia_Click();
            }
        });

        ui.menuThoat.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                menuThoat_Click();
            }
        });

        ui.menuDangxuat.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
               menuDangxuat_Click();
           } 
        });
    }

    private void itemSach_Click()
    {
        JOptionPane.showMessageDialog(ui, "Bạn vừa chọn sách", "Thông báo", JOptionPane.OK_OPTION);
    }

    private void itemTacGia_Click()
    {
        JOptionPane.showMessageDialog(ui, "Bạn vừa chọn tác giả", "Thông báo", JOptionPane.OK_OPTION);
    }

    private void menuThoat_Click()
    {
        if (JOptionPane.showConfirmDialog(ui, "Bạn có muốn thoát chương trình?", "Thoát chương trình", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void menuDangxuat_Click()
    {
        if (JOptionPane.showConfirmDialog(ui, "Bạn có muốn đăng xuất", "Đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            ui.dispose();
            new Login_GUI();
        }
    }
}
