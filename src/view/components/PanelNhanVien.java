package view.components;

import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import model.Nhanvien;

import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

public class PanelNhanVien extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private Nhanvien nv;
	public PanelNhanVien(Nhanvien nv) {
		this.nv = nv;
		FlatLightLaf.setup();
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ca làm", null, panel_2, null);
		
		JPanel panel = new view.NhanVienForm(nv);
		tabbedPane.addTab("Danh sách nhân viên", null, panel, null);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
}
