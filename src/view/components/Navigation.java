package view.components;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;

import view.components.custom.JButtonCustom;

public class Navigation extends JPanel {

	private static final long serialVersionUID = 1L;

	public Navigation(CardLayout cardLayout, JPanel contentPanel) {
		setLayout(null);
		
		JButton btnThongKe = new JButtonCustom("Thống kê");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThongKe.setBounds(15, 67, 209, 64);
		add(btnThongKe);
	
		JButton btnSach = new JButtonCustom("Sách");
		btnSach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSach.setBounds(15, 155, 209, 64);
		add(btnSach);
		
		JButton btnNguoiDung = new JButtonCustom("Người dùng");
		btnNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNguoiDung.setBounds(15, 229, 209, 64);
		add(btnNguoiDung);
		
		JButton btnNhanVien = new JButtonCustom("Nhân viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNhanVien.setBounds(15, 305, 209, 64);
		add(btnNhanVien);
		
		JButton btnPhieuMuonTra = new JButtonCustom("Phiếu mượn trả ");
		btnPhieuMuonTra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPhieuMuonTra.setBounds(15, 379, 209, 64);
		add(btnPhieuMuonTra);
		
		JButton btnCaiDat = new JButtonCustom("Cài đặt");
		btnCaiDat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCaiDat.setBounds(15, 453, 209, 64);
		add(btnCaiDat);

		// Button actions
		btnThongKe.addActionListener(e -> cardLayout.show(contentPanel, "thongke"));
		btnSach.addActionListener(e -> cardLayout.show(contentPanel, "sach"));
		btnNguoiDung.addActionListener(e -> cardLayout.show(contentPanel, "nguoidung"));
		btnNhanVien.addActionListener(e -> cardLayout.show(contentPanel, "nhanvien"));
		btnPhieuMuonTra.addActionListener(e -> cardLayout.show(contentPanel, "phieumuontra"));
		btnCaiDat.addActionListener(e -> cardLayout.show(contentPanel, "caidat"));
	}

	@Override
	protected void paintChildren(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
		g2.setPaint(g);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
		super.paintChildren(grphcs);
	}
}
