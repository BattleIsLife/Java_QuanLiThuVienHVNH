package view.components;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import model.Nhanvien;

import view.NhaXuatBanForm;
import view.PhieuMuon;
import view.SachForm;
import view.TacGiaForm;
import view.TheLoaiForm;

import java.awt.Rectangle;

import java.awt.BorderLayout;

public class PanelPhieuMuonTra extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	Nhanvien nv;

	public PanelPhieuMuonTra(Nhanvien nv) {
		this.nv = nv;
		FlatLightLaf.setup();
		setBounds(new Rectangle(0, 0, 1000, 599));
		setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		JPanel phieumuon = new PhieuMuon(nv);
		tabbedPane.addTab("Phiếu mượn ", null, phieumuon, null);
		phieumuon.setLayout(null);

		JPanel traForm = new PhieuMuon(nv);

		tabbedPane.addTab("Chi tiết phiếu mượn", null, traForm, null);
		traForm.setLayout(null);

		SwingUtilities.updateComponentTreeUI(this);
	}

}
