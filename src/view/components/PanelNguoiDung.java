package view.components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Nhanvien;
import view.NguoiMuonForm;

public class PanelNguoiDung extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNgiDng;

	/**
	 * Create the panel.
	 */
	public PanelNguoiDung(Nhanvien nv) {
		new NguoiMuonForm(nv);
		// new NguoiMuonForm(nv);
		// setLayout(null);
		
		// txtNgiDng = new JTextField();
		// txtNgiDng.setHorizontalAlignment(SwingConstants.CENTER);
		// txtNgiDng.setText("Người dùng");
		// txtNgiDng.setBounds(228, 164, 237, 62);
		// add(txtNgiDng);
		// txtNgiDng.setColumns(10);

	}
}
