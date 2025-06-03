package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.formdev.flatlaf.FlatLightLaf;

import dao.NhaXuatBanDAO;
import dao.SachDAO;
import dao.TacGiaDAO;
import dao.TheLoaiDAO;
import model.Nhanvien;
import model.Nhaxuatban;
import model.Sach;
import model.Tacgia;
import model.Theloai;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class SachForm extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// Nhanvien nv = new Nhanvien();
	// nv.setQuyenHan(PermissionLevel.ADMIN);
	// new SachForm(nv);
	// }

	/**
	 * Create the frame.
	 */

	private Nhanvien nhanvien;

	public SachForm(Nhanvien nhanvien) {
		setBounds(new Rectangle(0, 0, 100, 599));
		this.nhanvien = nhanvien;
		FlatLightLaf.setup();
		setLayout(null);

		JLabel lblMSch = new JLabel("Mã sách");
		lblMSch.setBounds(19, 14, 71, 23);
		lblMSch.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblMSch);

		txtMaSach = new JTextField();
		txtMaSach.setBounds(172, 10, 332, 31);
		txtMaSach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(txtMaSach);
		txtMaSach.setColumns(10);

		JLabel lblnh = new JLabel("Ảnh");
		lblnh.setBounds(750, 18, 33, 23);
		lblnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblnh);

		JScrollPane scrollPaneAnh = new JScrollPane();
		scrollPaneAnh.setBounds(835, 14, 199, 184);
		scrollPaneAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneAnh.setPreferredSize(new Dimension(103, 22));
		this.add(scrollPaneAnh);
		lblPictureHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (lblPictureHere.getIcon() == null)
					return;
				JFrame frame = new JFrame();
				frame.setTitle(txtAnh.getText());
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JLabel lbl = new JLabel(lblPictureHere.getIcon());
				JScrollPane pane = new JScrollPane(lbl);
				pane.setSize(new Dimension(300, 300));

				frame.getContentPane().add(pane);
				frame.setMinimumSize(pane.getSize());
				frame.pack();
				frame.setLocationRelativeTo(scrollPaneAnh);
				frame.setVisible(true);

			}
		});
		lblPictureHere.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPictureHere.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPaneAnh.setViewportView(lblPictureHere);

		lblPictureHere.setBorder(null);

		JLabel lblTnSch = new JLabel("Tên sách");
		lblTnSch.setBounds(19, 57, 101, 23);
		lblTnSch.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblTnSch);

		txtTensach = new JTextField();
		txtTensach.setBounds(172, 53, 332, 31);
		txtTensach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(txtTensach);
		txtTensach.setColumns(10);

		JLabel lblGiSch = new JLabel("Giá sách");
		lblGiSch.setBounds(19, 100, 71, 23);
		lblGiSch.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblGiSch);

		txtGiasach = new JTextField();
		txtGiasach.setBounds(172, 96, 332, 31);
		txtGiasach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		txtGiasach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0' && c <= '9') || c == '\b'))
					e.consume();
			}
		});
		this.add(txtGiasach);
		txtGiasach.setColumns(10);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(19, 142, 101, 23);
		lblSLng.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblSLng);
		spnSoluong.setBounds(172, 139, 80, 31);

		spnSoluong.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spnSoluong.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(spnSoluong);

		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setBounds(19, 184, 62, 23);
		lblGhiCh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblGhiCh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 182, 338, 86);
		scrollPane.setPreferredSize(new Dimension(78, 50));
		this.add(scrollPane);
		txtGhichu.setWrapStyleWord(true);
		txtGhichu.setLineWrap(true);

		txtGhichu.setMinimumSize(new Dimension(78, 20));
		scrollPane.setViewportView(txtGhichu);
		txtGhichu.setColumns(20);
		txtGhichu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));

		JLabel lblngDnnh = new JLabel("Đường dẫn ảnh");
		lblngDnnh.setBounds(19, 284, 145, 23);
		lblngDnnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblngDnnh);

		txtAnh = new JTextField();
		txtAnh.setBounds(172, 280, 338, 31);
		txtAnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(txtAnh);
		txtAnh.setColumns(10);

		JButton btnAnh = new JButton("Mở ảnh");
		btnAnh.setBounds(715, 69, 101, 31);
		btnAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnh_Click();
			}
		});
		btnAnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(btnAnh);

		JLabel lblMTcGi = new JLabel("Mã tác giả");
		lblMTcGi.setBounds(723, 257, 93, 23);
		lblMTcGi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblMTcGi);
		cboTacgia.setBounds(835, 253, 199, 31);
		cboTacgia.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(cboTacgia);

		JLabel lblMThLoi = new JLabel("Mã thể loại");
		lblMThLoi.setBounds(723, 218, 93, 23);
		lblMThLoi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblMThLoi);
		cboTheloai.setBounds(835, 214, 199, 31);
		cboTheloai.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(cboTheloai);

		JLabel lblMNxb = new JLabel("Mã NXB");
		lblMNxb.setBounds(723, 300, 93, 23);
		lblMNxb.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(lblMNxb);
		cboNXB.setBounds(835, 296, 199, 31);
		cboNXB.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		this.add(cboNXB);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(19, 331, 702, 207);
		this.add(scrollPane_1);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_Click();
			}
		});
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		scrollPane_1.setViewportView(table);
		table.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));

		JPanel panel = new JPanel();
		panel.setBounds(750, 350, 284, 184);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		this.add(panel);

		btnThem.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem_Click();
			}
		});
		panel.add(btnThem);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua_Click();
			}
		});

		btnSua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnSua);

		btnXoa.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa_Click();
			}
		});
		panel.add(btnXoa);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLuu_Click();
			}
		});

		btnLuu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnLuu);

		btnBoqua.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		btnBoqua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBoqua_Click();
			}
		});
		panel.add(btnBoqua);
		btnTimkiem.setToolTipText("Tìm kiếm theo tên sách, tác giả, nhà xuất bản, thể loại");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTimkiem_Click();
			}
		});

		btnTimkiem.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnTimkiem);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValue();
				LoadTableData();
			}
		});

		btnReset.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		panel.add(btnReset);

		FormLoad();

		SwingUtilities.updateComponentTreeUI(this);
	}

	private JTextField txtMaSach;
	private JTextField txtTensach;
	private JTextField txtGiasach;
	private JTextField txtAnh;

	private JTable table;
	private DefaultTableModel model;

	private JTextArea txtGhichu = new JTextArea();

	private JSpinner spnSoluong = new JSpinner();

	private JLabel lblPictureHere = new JLabel("");

	private JComboBox<String> cboTacgia = new JComboBox<String>();
	private JComboBox<String> cboNXB = new JComboBox<String>();
	private JComboBox<String> cboTheloai = new JComboBox<String>();

	JButton btnThem = new JButton("Thêm");
	JButton btnSua = new JButton("Sửa");
	JButton btnXoa = new JButton("Xóa");
	JButton btnLuu = new JButton("Lưu");
	JButton btnBoqua = new JButton("Bỏ qua");
	JButton btnTimkiem = new JButton("Tìm kiếm");
	JButton btnReset = new JButton("Tải lại dữ liệu");

	private void FormLoad() {
		String[] colHead = { "Mã sách", "Tên sách", "Mã thể loại", "Mã tác giả", "Mã NXB", "Giá sách", "Số lượng" };
		model = new DefaultTableModel(null, colHead);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
		utilities.ComboBoxUtil.Combobox_GetValue(cboTheloai, "SELECT * FROM tblTheLoai", "Tentheloai");
		utilities.ComboBoxUtil.Combobox_GetValue(cboNXB, "SELECT * FROM tblNXB", "TenNXB");
		utilities.ComboBoxUtil.Combobox_GetValue(cboTacgia, "SELECT * FROM tblTacGia", "TenTacGia");

		ResetValue();
		LoadTableData();

	}

	private void ResetValue() {
		txtMaSach.setText("");
		txtTensach.setText("");
		txtGiasach.setText("");
		spnSoluong.setValue(0);
		txtGhichu.setText("");
		lblPictureHere.setIcon(null);
		txtAnh.setText("");
		cboTacgia.setSelectedIndex(-1);
		cboNXB.setSelectedIndex(-1);
		cboTheloai.setSelectedIndex(-1);

		txtMaSach.setEditable(false);

		btnThem.setEnabled(true);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		btnLuu.setEnabled(false);
		btnBoqua.setEnabled(false);
		btnTimkiem.setEnabled(true);
		btnReset.setEnabled(true);
	}

	private void LoadTableData() {
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		SachDAO dao = new SachDAO();
		List<Sach> list = dao.getAll();

		for (Sach s : list) {
			Object[] row = { s.getMaSach(), s.getTenSach(), s.getMaTheLoai(), s.getMaTacGia(), s.getMaNXB(),
					s.getGiaSach(), s.getSoLuong() };
			model.addRow(row);
		}

	}

	private void table_Click() {
		if (!btnThem.isEnabled()) {
			JOptionPane.showMessageDialog(this, "Bạn đang ở chế độ thêm mới", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0) {
			String masach = model.getValueAt(selectedRow, 0).toString();
			String ten = model.getValueAt(selectedRow, 1).toString();
			String matl = model.getValueAt(selectedRow, 2).toString();
			String matg = model.getValueAt(selectedRow, 3).toString();
			String manxb = model.getValueAt(selectedRow, 4).toString();
			String gia = model.getValueAt(selectedRow, 5).toString();
			String sl = model.getValueAt(selectedRow, 6).toString();

			txtMaSach.setText(masach);
			txtTensach.setText(ten);
			spnSoluong.setValue(Integer.valueOf(sl));
			txtGiasach.setText(gia);

			TheLoaiDAO tldao = new TheLoaiDAO();
			Theloai tl = tldao.selectById(matl);
			cboTheloai.setSelectedItem(tl.getTenTheLoai());

			TacGiaDAO tgdao = new TacGiaDAO();
			Tacgia tg = tgdao.selectById(matg);
			cboTacgia.setSelectedItem(tg.getTenTacGia());

			NhaXuatBanDAO nxbdao = new NhaXuatBanDAO();
			Nhaxuatban nxb = nxbdao.selectById(manxb);
			cboNXB.setSelectedItem(nxb.getTenNXB());

			SachDAO sachdao = new SachDAO();
			Sach s = sachdao.selectById(masach);

			txtGhichu.setText(s.getGhiChu());
			txtAnh.setText(s.getAnh());
			try {
				ImageIcon img = new ImageIcon(s.getAnh());
				lblPictureHere.setIcon(img);
				lblPictureHere.setText("");
			} catch (Exception e) {

			}
			btnBoqua.setEnabled(true);
		}
	}

	private void btnThem_Click() {
		if (!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		ResetValue();
		btnThem.setEnabled(false);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnBoqua.setEnabled(true);
		btnLuu.setEnabled(true);
		txtMaSach.setEditable(true);
	}

	private void btnBoqua_Click() {
		ResetValue();
	}

	private void btnAnh_Click() {
		if (!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn ảnh");
		int response = fileChooser.showOpenDialog(this);
		if (response == fileChooser.APPROVE_OPTION) {
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			try {
				lblPictureHere.setIcon(new ImageIcon(file.getAbsolutePath()));
				lblPictureHere.setText("");
				txtAnh.setText(file.getAbsolutePath());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Ảnh không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void btnLuu_Click() {
		String masach = txtMaSach.getText().trim();
		String tensach = txtTensach.getText().trim();
		String anh = txtAnh.getText().trim();
		String ghichu = txtGhichu.getText().trim();

		if (masach.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập mã sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (tensach.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tên sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (txtGiasach.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập giá", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (cboTheloai.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa chọn thể loại sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (cboTacgia.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa chọn tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (cboNXB.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa chọn nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (anh.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa chọn ảnh", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (ghichu.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập ghi chú", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		SachDAO dao = new SachDAO();
		Sach key = dao.selectById(masach);
		if (key != null) {
			JOptionPane.showMessageDialog(this, "Trùng mã sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String tentl = cboTheloai.getSelectedItem().toString();
		String tentg = cboTacgia.getSelectedItem().toString();
		String tennxb = cboNXB.getSelectedItem().toString();
		float gia = Float.valueOf(txtGiasach.getText().trim());
		int sl = Integer.valueOf(spnSoluong.getValue().toString());

		TheLoaiDAO tldao = new TheLoaiDAO();
		Theloai tl = tldao.selectByName(tentl);

		TacGiaDAO tgdao = new TacGiaDAO();
		Tacgia tg = tgdao.selectByName(tentg);

		NhaXuatBanDAO nxbdao = new NhaXuatBanDAO();
		Nhaxuatban nxb = nxbdao.selectByName(tennxb);

		Sach sach = new Sach(masach, tensach, tl.getMaTheLoai(), tg.getMaTacGia(), nxb.getMaNXB(), gia, sl, anh,
				ghichu);
		dao.them(sach);
		ResetValue();
		LoadTableData();
	}

	private void btnSua_Click() {
		if (!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		if (model.getColumnCount() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String masach = txtMaSach.getText().trim();
		String tensach = txtTensach.getText().trim();
		String anh = txtAnh.getText().trim();
		String ghichu = txtGhichu.getText().trim();

		if (model.getColumnCount() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (masach.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (tensach.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập tên sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (txtGiasach.getText().trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập giá", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (cboTheloai.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa chọn thể loại sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (cboTacgia.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa chọn tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (cboNXB.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa chọn nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (anh.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa chọn ảnh", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (ghichu.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập ghi chú", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String tentl = cboTheloai.getSelectedItem().toString();
		String tentg = cboTacgia.getSelectedItem().toString();
		String tennxb = cboNXB.getSelectedItem().toString();
		float gia = Float.valueOf(txtGiasach.getText().trim());
		int sl = Integer.valueOf(spnSoluong.getValue().toString());

		SachDAO dao = new SachDAO();

		TheLoaiDAO tldao = new TheLoaiDAO();
		Theloai tl = tldao.selectByName(tentl);

		TacGiaDAO tgdao = new TacGiaDAO();
		Tacgia tg = tgdao.selectByName(tentg);

		NhaXuatBanDAO nxbdao = new NhaXuatBanDAO();
		Nhaxuatban nxb = nxbdao.selectByName(tennxb);

		Sach sach = new Sach(masach, tensach, tl.getMaTheLoai(), tg.getMaTacGia(), nxb.getMaNXB(), gia, sl, anh,
				ghichu);
		dao.sua(sach);
		ResetValue();
		LoadTableData();
	}

	private void btnXoa_Click() {
		if (!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		if (model.getColumnCount() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String masach = txtMaSach.getText().trim();

		if (masach.length() == 0) {
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa", "Xóa", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			SachDAO dao = new SachDAO();
			dao.xoa(masach);
			ResetValue();
			LoadTableData();
		}
	}

	private void btnTimkiem_Click() {
		String masach = txtMaSach.getText().trim();
		String tensach = txtTensach.getText().trim();
		if (tensach.length() == 0 && cboTheloai.getSelectedIndex() == -1 && cboTacgia.getSelectedIndex() == -1
				&& cboNXB.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "Chưa nhập đủ điều kiện tìm kiếm", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String sql = "SELECT * FROM tblSach WHERE 1=1 ";

		if (tensach.length() != 0)
			sql += "AND Tensach LIKE N'%" + tensach + "%' ";
		if (cboTheloai.getSelectedItem() != null) {
			TheLoaiDAO tldao = new TheLoaiDAO();
			Theloai tl = tldao.selectByName(cboTheloai.getSelectedItem().toString());
			sql += "AND Matheloai LIKE '%" + tl.getMaTheLoai() + "%' ";
		}
		if (cboTacgia.getSelectedItem() != null) {
			TacGiaDAO tgdao = new TacGiaDAO();
			Tacgia tg = tgdao.selectByName(cboTacgia.getSelectedItem().toString());
			sql += "AND Matacgia LIKE '%" + tg.getMaTacGia() + "%' ";
		}
		if (cboNXB.getSelectedItem() != null) {
			NhaXuatBanDAO tldao = new NhaXuatBanDAO();
			Nhaxuatban nxb = tldao.selectByName(cboNXB.getSelectedItem().toString());
			sql += "AND MaNXB LIKE '%" + nxb.getMaNXB() + "%' ";
		}

		SachDAO dao = new SachDAO();

		List<Sach> list = dao.getAll(sql);

		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		for (Sach s : list) {
			Object[] row = { s.getMaSach(), s.getTenSach(), s.getMaTheLoai(), s.getMaTacGia(), s.getMaNXB(),
					s.getGiaSach(), s.getSoLuong() };
			model.addRow(row);
		}

		JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " dòng thỏa mãn điều kiện tìm kiếm",
				"Thông báo", JOptionPane.PLAIN_MESSAGE);
	}
}
