package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Nhanvien;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import view.components.*;

public class MainApplication extends JFrame {

	private static final long serialVersionUID = 1L;
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
	
	Nhanvien nv;
	
	public MainApplication() {
		// this.nv = nv;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 636);
		getContentPane().setLayout(null);

		// Tạo CardLayout + Content Panel
		CardLayout cardLayout = new CardLayout();
		JPanel contentPanel = new JPanel(cardLayout);
		contentPanel.setBounds(240, 0, 1054, 599);
		getContentPane().add(contentPanel);

		// Add các panel con
		contentPanel.add(new PanelThongKe(), "thongke");
		contentPanel.add(new PanelSach(nv), "sach");
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
