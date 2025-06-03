package view;

import javax.swing.*;

import dao.NhanVienDAO;
import model.Nhanvien;
import model.PermissionLevel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RegisterForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel PanelLogin;
    private JTextField txtMaNhanVien;
    private JTextField txtTenNguoiDung;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RegisterForm frame = new RegisterForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public RegisterForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1102, 669);
        setTitle("Register Form");

        PanelLogin = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image img = ImageIO.read(new File("src/resource/picture/library.png"));
                    Image scaledImage = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                    g.drawImage(scaledImage, 0, 0, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        PanelLogin.setLayout(null);
        setContentPane(PanelLogin);

        // LEFT PANEL
        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(52, 119, 434, 467);
        panelLeft.setBorder(BorderFactory.createEtchedBorder());
        panelLeft.setLayout(null);
        PanelLogin.add(panelLeft);

        // Logo
        ImageIcon imageIcon = new ImageIcon("src/resource/picture/logo.png");
        JLabel label = new JLabel(imageIcon);
        label.setBounds(160, 10, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panelLeft.add(label);

        // Title
        JLabel lblGetStarted = new JLabel("Get started now");
        lblGetStarted.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblGetStarted.setBounds(38, 100, 300, 30);
        panelLeft.add(lblGetStarted);

        JLabel lblCreateAccount = new JLabel("Create an account");
        lblCreateAccount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblCreateAccount.setBounds(38, 130, 300, 30);
        panelLeft.add(lblCreateAccount);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(171, 171, 171));
        separator.setBounds(38, 165, 346, 2);
        panelLeft.add(separator);

        // Labels
        JLabel lblMaNV = new JLabel("Mã nhân viên");
        lblMaNV.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblMaNV.setBounds(38, 180, 200, 25);
        panelLeft.add(lblMaNV);

        txtMaNhanVien = new JTextField();
        txtMaNhanVien.setBounds(38, 210, 346, 27);
        panelLeft.add(txtMaNhanVien);

        JLabel lblTenND = new JLabel("Tên người dùng");
        lblTenND.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTenND.setBounds(38, 245, 200, 25);
        panelLeft.add(lblTenND);

        txtTenNguoiDung = new JTextField();
        txtTenNguoiDung.setBounds(38, 275, 346, 27);
        panelLeft.add(txtTenNguoiDung);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPassword.setBounds(38, 310, 200, 25);
        panelLeft.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(38, 340, 346, 27);
        panelLeft.add(txtPassword);

        // Register Button
        JButton btnRegister = new JButton("Register");
        btnRegister.setBackground(new Color(20, 250, 118));
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnRegister.setBounds(38, 385, 346, 34);
        panelLeft.add(btnRegister);

        // Already have account
        JLabel lblLoginPrompt = new JLabel("Already have an account?");
        lblLoginPrompt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblLoginPrompt.setBounds(97, 430, 141, 20);
        panelLeft.add(lblLoginPrompt);

        JLabel btnLogin = new JLabel("Login");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLogin.setBounds(233, 430, 74, 20);
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panelLeft.add(btnLogin);

        // Dummy Login click event (navigate to login screen - TO DO)
        btnLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);

                dispose();
            }
        });

        // Dummy Register Button
        btnRegister.addActionListener(e -> {
            String maNV = txtMaNhanVien.getText().trim();
            String tenNguoiDung = txtTenNguoiDung.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();

            if (maNV.isEmpty() || tenNguoiDung.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Cảnh báo",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                Nhanvien nv = new Nhanvien();
                nv.setMaNhanVien(maNV);
                nv.setTenNhanVien(tenNguoiDung);
                nv.setMatKhau(password);

                // Mặc định quyền hạn là NONE
                NhanVienDAO dao = new NhanVienDAO();

                if (dao.themNhanVien(nv)) {
                    JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    LoginForm loginForm = new LoginForm();
                    loginForm.setVisible(true);

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại hoặc lỗi hệ thống!", "Lỗi",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
}
