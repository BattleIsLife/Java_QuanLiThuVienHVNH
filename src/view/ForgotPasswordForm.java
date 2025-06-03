package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import service.NhanVienService;
import model.Nhanvien;

public class ForgotPasswordForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtOTP;
    private JTextField txtNewPassword;
    private NhanVienService nhanVienService;
    private String generatedOTP;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ForgotPasswordForm frame = new ForgotPasswordForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ForgotPasswordForm() {
        nhanVienService = new NhanVienService();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Forgot Password");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setBounds(150, 20, 200, 30);
        contentPane.add(lblTitle);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblEmail.setBounds(50, 60, 100, 25);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 60, 200, 25);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPhone.setBounds(50, 100, 100, 25);
        contentPane.add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(150, 100, 200, 25);
        contentPane.add(txtPhone);
        txtPhone.setColumns(10);

        JButton btnSendOTP = new JButton("Send OTP");
        btnSendOTP.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnSendOTP.setBounds(150, 140, 100, 30);
        btnSendOTP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String phone = txtPhone.getText();
                Nhanvien user = nhanVienService.findByEmail(email);
                if (user != null && user.getSDT().equals(phone)) {
                    generatedOTP = generateOTP();
                    // Simulate sending OTP (in a real app, use an SMS API like Twilio)
                    JOptionPane.showMessageDialog(null, "OTP sent to " + phone + ": " + generatedOTP);
                    txtOTP.setEnabled(true);
                    txtNewPassword.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid email or phone number!");
                }
            }
        });
        contentPane.add(btnSendOTP);

        JLabel lblOTP = new JLabel("Enter OTP");
        lblOTP.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblOTP.setBounds(50, 180, 100, 25);
        contentPane.add(lblOTP);

        txtOTP = new JTextField();
        txtOTP.setBounds(150, 180, 200, 25);
        txtOTP.setEnabled(false);
        contentPane.add(txtOTP);
        txtOTP.setColumns(10);

        JLabel lblNewPassword = new JLabel("New Password");
        lblNewPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNewPassword.setBounds(50, 220, 100, 25);
        contentPane.add(lblNewPassword);

        txtNewPassword = new JTextField();
        txtNewPassword.setBounds(150, 220, 200, 25);
        txtNewPassword.setEnabled(false);
        contentPane.add(txtNewPassword);
        txtNewPassword.setColumns(10);

        JButton btnResetPassword = new JButton("Reset Password");
        btnResetPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnResetPassword.setBounds(150, 260, 150, 30);
        btnResetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredOTP = txtOTP.getText();
                String newPassword = txtNewPassword.getText();
                String email = txtEmail.getText();
                if (enteredOTP.equals(generatedOTP)) {
                    boolean updated = nhanVienService.updatePassword(email, newPassword);
                    if (updated) {
                        JOptionPane.showMessageDialog(null, "Password reset successfully!");
                        dispose();
                        LoginForm login = new LoginForm();
                        login.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update password!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid OTP!");
                }
            }
        });
        contentPane.add(btnResetPassword);

        JButton btnBack = new JButton("Back to Login");
        btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnBack.setBounds(150, 300, 150, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm login = new LoginForm();
                login.setVisible(true);
            }
        });
        contentPane.add(btnBack);
    }

    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // 6-digit OTP
        return String.valueOf(otp);
    }
}