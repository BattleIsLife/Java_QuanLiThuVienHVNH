package view.components;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatLightLaf;

import model.Nhanvien;
import view.NhaXuatBanForm;
import view.SachForm;
import view.TacGiaForm;
import view.TheLoaiForm;

import java.awt.Rectangle;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class PanelSach extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	Nhanvien nv;
	
	public PanelSach(Nhanvien nv) {
		this.nv = nv;
		
		if(!utilities.PermissionUtil.isAllowedToViewAsNhanvien(nv, this))
		{
			return;
		}
		FlatLightLaf.setup();
		setBounds(new Rectangle(0, 0, 1000, 599));
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel sachForm = new SachForm(nv);
		tabbedPane.addTab("Quản lí sách", null, sachForm, null);
		sachForm.setLayout(null);
		
		JPanel tacGiaForm = new TacGiaForm(nv);
		
		tabbedPane.addTab("Quản lí tác giả", null, tacGiaForm, null);
		
		JPanel nxbForm = new NhaXuatBanForm(nv);
		tabbedPane.addTab("Quản lí NXB", null, nxbForm, null);
		
		JPanel tlForm = new TheLoaiForm(nv);
		tabbedPane.addTab("Quản lí thể loại", null, tlForm, null);
		
		SwingUtilities.updateComponentTreeUI(this);
	}
}