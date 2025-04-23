package GUI_Class;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.Nhanvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class MainMenu_GUI extends frameTemplate{
    protected Nhanvien nhanvien;

    public MainMenu_GUI(Nhanvien nhanvien)
    {
        //Thêm thông tin nhân viên
        this.nhanvien = nhanvien;

        //Add main panel
        this.add(mainPanel());

        //Add event listener
        new MainMenu_Events(this);

        this.setVisible(true);
    }


    private JPanel mainPanel()
    {
        BorderLayout layout = new BorderLayout();
        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.lightGray);

        addMainMenu(panel);
        addMainLabel(panel);
        return panel;
    }


    //Thêm thanh menu ở trên
    private void addMainMenu(JPanel panel)
    {
        JMenuBar menuBar = new JMenuBar();
        panel.add(menuBar, BorderLayout.NORTH);
        addMenu(menuBar);
    }


    //Thêm label
    private void addMainLabel(JPanel panel)
    {
        ImageIcon bookIcon = new ImageIcon("src/picture/book_icon.png");
        // JLabel welcomeLabel = new JLabel("Chương trình quản lí thư viện HVNH");
        JLabel welcomeLabel = new JLabel("Chào mừng, " + nhanvien.getMaNhanVien());
        welcomeLabel.setForeground(Color.blue);
        welcomeLabel.setFont(new Font("serif", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        welcomeLabel.setIcon(bookIcon);
        welcomeLabel.setIconTextGap(5);
        welcomeLabel.setHorizontalTextPosition(JLabel.CENTER);
        welcomeLabel.setVerticalTextPosition(JLabel.BOTTOM);

        panel.add(welcomeLabel, BorderLayout.CENTER);
    }


    //Thêm các danh mục của menu
    private void addMenu(JMenuBar menuBar)
    {
        menuBar.add(menuThuVien);
        menuBar.add(menuNhanVien);
        menuBar.add(menuMuonTraSach);
        menuBar.add(menuThoat);
        menuBar.add(menuDangxuat);

        menuThuVien.setFont(font);
        menuNhanVien.setFont(font);
        menuMuonTraSach.setFont(font);
        menuThoat.setFont(font);
        menuDangxuat.setFont(font);

        addMenuItem();
    }


    //Thêm chi tiết từng danh mục
    private void addMenuItem()
    {
        //Danh muc thư viện
        menuThuVien.add(itemSach);
        menuThuVien.add(itemTheLoai);
        menuThuVien.add(itemTacGia);
        menuThuVien.add(itemNXB);

        itemSach.setFont(font);
        itemTheLoai.setFont(font);
        itemTacGia.setFont(font);
        itemNXB.setFont(font);

        //Danh mục nhân viên
        menuNhanVien.add(itemNhanVien);
        menuNhanVien.add(itemCaLam);

        itemNhanVien.setFont(font);
        itemCaLam.setFont(font);

        //Mượn, trả sách
        menuMuonTraSach.add(itemMuon);
        menuMuonTraSach.add(itemPhat);

        itemMuon.setFont(font);
        itemPhat.setFont(font);
    }


    //Global variables
    protected JMenu menuThuVien = new JMenu("Thư viện");
    protected JMenu menuNhanVien = new JMenu("Nhân viên");
    protected JMenu menuMuonTraSach = new JMenu("Mượn/trả sách");
    protected JMenu menuDangxuat = new JMenu("Đăng xuất");
    protected JMenu menuThoat = new JMenu("Thoát");

    protected JMenuItem itemSach = new JMenuItem("Sách");
    protected JMenuItem itemTheLoai = new JMenuItem("Thể loại");
    protected JMenuItem itemTacGia = new JMenuItem("Tác giả");
    protected JMenuItem itemNXB = new JMenuItem("Nhà xuất bản");

    protected JMenuItem itemNhanVien = new JMenuItem("Thông tin nhân viên");
    protected JMenuItem itemCaLam = new JMenuItem("Ca làm");

    protected JMenuItem itemMuon = new JMenuItem("Phiếu mượn");
    protected JMenuItem itemPhat = new JMenuItem("Phiếu phạt");

    //Font
    protected Font font = new Font("sans-serif", Font.PLAIN, 18);
    
}
