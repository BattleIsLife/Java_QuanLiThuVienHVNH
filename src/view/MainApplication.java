package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import view.components.*;
import view.components.custom.SearchText;
import javax.swing.JLabel;
import view.components.PanelCaiDat;

public class MainApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication frame = new MainApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1106, 636);
		getContentPane().setLayout(null);

		// Tạo CardLayout + Content Panel
		CardLayout cardLayout = new CardLayout();
		JPanel contentPanel = new JPanel(cardLayout);
		contentPanel.setBounds(240, 0, 852, 599);
		getContentPane().add(contentPanel);

		// Add các panel con
		contentPanel.add(new PanelThongKe(), "thongke");
		contentPanel.add(new PanelSach(), "sach");
		contentPanel.add(new PanelNguoiDung(), "nguoidung");
		contentPanel.add(new PanelNhanVien(), "nhanvien");
		contentPanel.add(new PanelPhieuMuonTra(), "phieumuontra");
		contentPanel.add(new PanelCaiDat(), "caidat");

		// Panel Navigation
		JPanel navigationWrapper = new JPanel();
		navigationWrapper.setBounds(0, 0, 242, 599);
		navigationWrapper.setLayout(new BorderLayout());
		getContentPane().add(navigationWrapper);

		Navigation tabar = new Navigation(cardLayout, contentPanel);
		navigationWrapper.add(tabar, BorderLayout.CENTER);

	}
}
