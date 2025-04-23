package GUI_Class;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Nhanvien;

public class Login_GUI extends frameTemplate{
    public Nhanvien nhanvien;

    public Login_GUI()
    {
        this.setTitle("Đăng nhập");

        this.add(mainPanel());

        this.pack();
        this.setVisible(true);
        new Login_Events(this);
    }

    private JPanel mainPanel()
    {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 20, 10, 20);

        panel = new JPanel(layout);
        panel.setBackground(Color.lightGray);

        addUsernameInput(layout, constraints);
        addPasswordInput(layout, constraints);
        addButtons(layout, constraints);
        

        return panel;
    }


    //Nhập username
    private void addUsernameInput(GridBagLayout layout, GridBagConstraints constraints)
    {
        JLabel userLabel = new JLabel("Mã nhân viên");
        userLabel.setFont(font);
        constraints.gridx = 0; constraints.gridy = 0;
        panel.add(userLabel, constraints);

        txtManhanvien.setFont(font);
        txtManhanvien.setPreferredSize(txtDimension);
        constraints.gridx = 1; constraints.gridy = 0;
        panel.add(txtManhanvien, constraints);
    }


    //Nhập password
    private void addPasswordInput(GridBagLayout layout, GridBagConstraints constraints)
    {
        JLabel passwordLabel = new JLabel("Mật khẩu");
        passwordLabel.setFont(font);
        constraints.gridx = 0; constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        txtMatkhau.setFont(font);
        txtMatkhau.setPreferredSize(txtDimension);
        constraints.gridx = 1; constraints.gridy = 1;
        panel.add(txtMatkhau, constraints);
    }


    //Nút bấm
    private void addButtons(GridBagLayout layout, GridBagConstraints constraints)
    {
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        btnPanel.setBackground(Color.lightGray);
        constraints.gridwidth = 10;
        constraints.gridx = 0; constraints.gridy = 2;
        panel.add(btnPanel, constraints);

        btnPanel.add(btnDangnhap);
        btnPanel.add(btnThoat);

        buttonStyle(btnDangnhap);
        buttonStyle(btnThoat);
        
    }

    private void buttonStyle(JButton btn)
    {
        btn.setFont(font);
        btn.setPreferredSize(btnDimension);
        btn.setFocusable(false);
    }


    private JPanel panel;
    private Font font = new Font("sans-serif", Font.PLAIN, 18);
    private Dimension btnDimension = new Dimension(150, 30);
    private Dimension txtDimension = new Dimension(200, 25);

    protected JTextArea txtManhanvien = new JTextArea();
    protected JTextArea txtMatkhau = new JTextArea();

    protected JButton btnDangnhap = new JButton("Đăng nhập");
    protected JButton btnThoat = new JButton("Thoát");
}
