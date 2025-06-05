package view.components;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import model.Nhanvien;
import view.ChiTietPhieuMuonForm;
import view.PhieuMuonForm;
import java.awt.Rectangle;
import java.awt.BorderLayout;

public class PanelPhieuMuonTra extends JPanel {
	private static final long serialVersionUID = 1L;
	Nhanvien nv;

	public PanelPhieuMuonTra(Nhanvien nv) {
		this.nv = nv;
		FlatLightLaf.setup();
		setBounds(new Rectangle(0, 0, 1000, 599));
		setLayout(new BorderLayout(0, 0));
		if(!utilities.PermissionUtil.isAllowedToViewAsNhanvien(nv, this))
        {
            return;
        }
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		JPanel phieumuon = new PhieuMuonForm(nv);
		tabbedPane.addTab("Phiếu mượn", null, phieumuon, null);
		phieumuon.setLayout(null);

		JPanel ctm = new ChiTietPhieuMuonForm(nv);
		tabbedPane.addTab("Chi tiết phiếu mượn", null, ctm, null);
		ctm.setLayout(null);

		SwingUtilities.updateComponentTreeUI(this);
	}
}