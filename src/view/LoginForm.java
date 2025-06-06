package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import model.Nhanvien;
import service.NhanVienService;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel PanelLogin;
    private JTextField txtMaNV;
    private JTextField txtPassword;
    private NhanVienService nhanVienService;

    // public static void main(String[] args) {
    //     EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             try {
    //                 LoginForm frame = new LoginForm();
    //                 frame.setVisible(true);
    //             } catch (Exception e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    // }

    public LoginForm() {
        nhanVienService = new NhanVienService();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1102, 669);
        this.setTitle("Đăng nhập");
        FlatLightLaf.setup();
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
        PanelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(PanelLogin);
        PanelLogin.setLayout(null);

        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(52, 119, 434, 467);
        panelLeft.setBorder(BorderFactory.createEtchedBorder());
        PanelLogin.add(panelLeft, new Integer(1));
        panelLeft.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("src/resource/picture/logo.png");
        JLabel label = new JLabel(imageIcon);
        label.setBounds(160, 10, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        panelLeft.add(label);

        JLabel lblNewLabel_1 = new JLabel("Welcome Back ");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblNewLabel_1.setBounds(38, 115, 196, 46);
        panelLeft.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Login to access your account");
        lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(38, 148, 336, 46);
        panelLeft.add(lblNewLabel_1_1);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(171, 171, 171));
        separator.setBounds(38, 204, 346, 2);
        panelLeft.add(separator);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(38, 204, 165, 46);
        panelLeft.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
        lblPassword.setBounds(38, 268, 165, 46);
        panelLeft.add(lblPassword);

        txtMaNV = new JTextField();
        txtMaNV.setBounds(38, 242, 346, 27);
        panelLeft.add(txtMaNV);
        txtMaNV.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(38, 303, 346, 27);
        panelLeft.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userid = txtMaNV.getText();
                String pass = txtPassword.getText();
                Nhanvien nv = nhanVienService.findByCredentials(userid, pass);
                if (nv != null) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    MainApplication main = new MainApplication(nv);
                    main.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng !!!");
                }
            }
        });
        btnLogin.setBackground(new Color(20, 250, 118));
        btnLogin.setForeground(new Color(0, 0, 0));
        btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnLogin.setBounds(38, 370, 346, 34);
        panelLeft.add(btnLogin);

        JLabel lblNewLabel_2 = new JLabel("Don't have an account?");
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(97, 426, 141, 34);
        panelLeft.add(lblNewLabel_2);

        JLabel btnRegister = new JLabel("Register");
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnRegister.setBounds(233, 437, 74, 13);
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    RegisterForm register = new RegisterForm();
                    register.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không mở được link");
                }
            }
        });
        panelLeft.add(btnRegister);

        JLabel btnForgotPassword = new JLabel("Forgot password?");
        btnForgotPassword.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnForgotPassword.setBounds(263, 340, 121, 20);
        btnForgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnForgotPassword.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    ForgotPasswordForm forgotForm = new ForgotPasswordForm();
                    forgotForm.setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Không mở được form quên mật khẩu");
                }
            }
        });
        panelLeft.add(btnForgotPassword);
        SwingUtilities.updateComponentTreeUI(this);
        this.setVisible(true);
    }
}