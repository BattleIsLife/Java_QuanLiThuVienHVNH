package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Nhanvien;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import view.components.*;

public class MainApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	public static CardLayout cardLayout;
	public Nhanvien loginUser;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public MainApplication(Nhanvien nv) {
		this.loginUser = nv;
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
		contentPanel.add(new PanelNhanVien(nv), "nhanvien");
		contentPanel.add(new PanelPhieuMuonTra(nv), "phieumuontra");
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
