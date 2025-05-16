package view.components;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelSach extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtNgiDng;

	/**
	 * Create the panel.
	 */
	public PanelSach() {
		setLayout(null);
		
		txtNgiDng = new JTextField();
		txtNgiDng.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgiDng.setText("Sách");
		txtNgiDng.setBounds(228, 164, 237, 62);
		add(txtNgiDng);
		txtNgiDng.setColumns(10);

	}
}
