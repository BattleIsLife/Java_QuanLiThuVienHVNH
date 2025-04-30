package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
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
import java.awt.event.ActionEvent;

public class SachForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		Nhanvien nv = new Nhanvien();
//		nv.setQuyenHan(PermissionLevel.ADMIN);
//		new SachForm(nv);
//	}

	/**
	 * Create the frame.
	 */
	
	private Nhanvien nhanvien;
	
	public SachForm(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
		setTitle("Sách");
		FlatLightLaf.setup();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 1103, 838);
		this.setSize(1103, 838);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 274, 0, 289, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 106, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMSch = new JLabel("Mã sách");
		lblMSch.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMSch = new GridBagConstraints();
		gbc_lblMSch.insets = new Insets(10, 20, 10, 20);
		gbc_lblMSch.gridx = 0;
		gbc_lblMSch.gridy = 0;
		contentPane.add(lblMSch, gbc_lblMSch);
		
		txtMaSach = new JTextField();
		txtMaSach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_txtMaSach = new GridBagConstraints();
		gbc_txtMaSach.insets = new Insets(10, 20, 10, 20);
		gbc_txtMaSach.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaSach.gridx = 1;
		gbc_txtMaSach.gridy = 0;
		contentPane.add(txtMaSach, gbc_txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lblnh = new JLabel("Ảnh");
		lblnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblnh = new GridBagConstraints();
		gbc_lblnh.insets = new Insets(10, 20, 10, 20);
		gbc_lblnh.gridx = 2;
		gbc_lblnh.gridy = 0;
		contentPane.add(lblnh, gbc_lblnh);
		
		JScrollPane scrollPaneAnh = new JScrollPane();
		scrollPaneAnh.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneAnh.setPreferredSize(new Dimension(103, 22));
		GridBagConstraints gbc_scrollPaneAnh = new GridBagConstraints();
		gbc_scrollPaneAnh.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAnh.gridheight = 4;
		gbc_scrollPaneAnh.insets = new Insets(10, 20, 10, 20);
		gbc_scrollPaneAnh.gridx = 3;
		gbc_scrollPaneAnh.gridy = 0;
		contentPane.add(scrollPaneAnh, gbc_scrollPaneAnh);
		lblPictureHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblPictureHere.getIcon() == null)
					return;
				JFrame frame = new JFrame();
				frame.setTitle(txtAnh.getText());
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		lblTnSch.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTnSch = new GridBagConstraints();
		gbc_lblTnSch.insets = new Insets(10, 20, 10, 20);
		gbc_lblTnSch.gridx = 0;
		gbc_lblTnSch.gridy = 1;
		contentPane.add(lblTnSch, gbc_lblTnSch);
		
		txtTensach = new JTextField();
		txtTensach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_txtTensach = new GridBagConstraints();
		gbc_txtTensach.insets = new Insets(10, 20, 10, 20);
		gbc_txtTensach.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTensach.gridx = 1;
		gbc_txtTensach.gridy = 1;
		contentPane.add(txtTensach, gbc_txtTensach);
		txtTensach.setColumns(10);
		
		JLabel lblGiSch = new JLabel("Giá sách");
		lblGiSch.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblGiSch = new GridBagConstraints();
		gbc_lblGiSch.insets = new Insets(10, 20, 10, 20);
		gbc_lblGiSch.gridx = 0;
		gbc_lblGiSch.gridy = 2;
		contentPane.add(lblGiSch, gbc_lblGiSch);
		
		txtGiasach = new JTextField();
		txtGiasach.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_txtGiasach = new GridBagConstraints();
		gbc_txtGiasach.insets = new Insets(10, 20, 10, 20);
		gbc_txtGiasach.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiasach.gridx = 1;
		gbc_txtGiasach.gridy = 2;
		contentPane.add(txtGiasach, gbc_txtGiasach);
		txtGiasach.setColumns(10);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblSLng = new GridBagConstraints();
		gbc_lblSLng.insets = new Insets(10, 20, 10, 20);
		gbc_lblSLng.gridx = 0;
		gbc_lblSLng.gridy = 3;
		contentPane.add(lblSLng, gbc_lblSLng);
		
		
		spnSoluong.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spnSoluong.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_spnSoluong = new GridBagConstraints();
		gbc_spnSoluong.anchor = GridBagConstraints.WEST;
		gbc_spnSoluong.insets = new Insets(10, 20, 10, 20);
		gbc_spnSoluong.gridx = 1;
		gbc_spnSoluong.gridy = 3;
		contentPane.add(spnSoluong, gbc_spnSoluong);
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblGhiCh = new GridBagConstraints();
		gbc_lblGhiCh.anchor = GridBagConstraints.NORTH;
		gbc_lblGhiCh.insets = new Insets(10, 20, 10, 20);
		gbc_lblGhiCh.gridx = 0;
		gbc_lblGhiCh.gridy = 4;
		contentPane.add(lblGhiCh, gbc_lblGhiCh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(78, 50));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(10, 20, 10, 20);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		contentPane.add(scrollPane, gbc_scrollPane);
		txtGhichu.setWrapStyleWord(true);
		txtGhichu.setLineWrap(true);
		
		
		txtGhichu.setMinimumSize(new Dimension(78, 20));
		scrollPane.setViewportView(txtGhichu);
		txtGhichu.setColumns(20);
		txtGhichu.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		
		JLabel lblngDnnh = new JLabel("Đường dẫn ảnh");
		lblngDnnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblngDnnh = new GridBagConstraints();
		gbc_lblngDnnh.insets = new Insets(10, 20, 10, 20);
		gbc_lblngDnnh.gridx = 0;
		gbc_lblngDnnh.gridy = 5;
		contentPane.add(lblngDnnh, gbc_lblngDnnh);
		
		txtAnh = new JTextField();
		txtAnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_txtAnh = new GridBagConstraints();
		gbc_txtAnh.insets = new Insets(10, 20, 10, 20);
		gbc_txtAnh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnh.gridx = 1;
		gbc_txtAnh.gridy = 5;
		contentPane.add(txtAnh, gbc_txtAnh);
		txtAnh.setColumns(10);
		
		JButton btnAnh = new JButton("Mở ảnh");
		btnAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnh_Click();
			}
		});
		btnAnh.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_btnAnh = new GridBagConstraints();
		gbc_btnAnh.insets = new Insets(10, 20, 10, 20);
		gbc_btnAnh.gridx = 2;
		gbc_btnAnh.gridy = 5;
		contentPane.add(btnAnh, gbc_btnAnh);
		
		JLabel lblMTcGi = new JLabel("Mã tác giả");
		lblMTcGi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMTcGi = new GridBagConstraints();
		gbc_lblMTcGi.insets = new Insets(10, 20, 10, 20);
		gbc_lblMTcGi.gridx = 0;
		gbc_lblMTcGi.gridy = 6;
		contentPane.add(lblMTcGi, gbc_lblMTcGi);
		cboTacgia.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_cboTacgia = new GridBagConstraints();
		gbc_cboTacgia.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboTacgia.insets = new Insets(10, 20, 10, 20);
		gbc_cboTacgia.gridx = 1;
		gbc_cboTacgia.gridy = 6;
		contentPane.add(cboTacgia, gbc_cboTacgia);
		
		JLabel lblMThLoi = new JLabel("Mã thể loại");
		lblMThLoi.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMThLoi = new GridBagConstraints();
		gbc_lblMThLoi.insets = new Insets(10, 20, 10, 20);
		gbc_lblMThLoi.gridx = 2;
		gbc_lblMThLoi.gridy = 6;
		contentPane.add(lblMThLoi, gbc_lblMThLoi);
		cboTheloai.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_cboTheloai = new GridBagConstraints();
		gbc_cboTheloai.insets = new Insets(10, 20, 10, 20);
		gbc_cboTheloai.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboTheloai.gridx = 3;
		gbc_cboTheloai.gridy = 6;
		contentPane.add(cboTheloai, gbc_cboTheloai);
		
		JLabel lblMNxb = new JLabel("Mã NXB");
		lblMNxb.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMNxb = new GridBagConstraints();
		gbc_lblMNxb.insets = new Insets(10, 20, 10, 20);
		gbc_lblMNxb.gridx = 0;
		gbc_lblMNxb.gridy = 7;
		contentPane.add(lblMNxb, gbc_lblMNxb);
		cboNXB.setFont(new Font("Adwaita Sans", Font.PLAIN, 18));
		GridBagConstraints gbc_cboNXB = new GridBagConstraints();
		gbc_cboNXB.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboNXB.insets = new Insets(10, 20, 10, 20);
		gbc_cboNXB.gridx = 1;
		gbc_cboNXB.gridy = 7;
		contentPane.add(cboNXB, gbc_cboNXB);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.insets = new Insets(10, 20, 10, 20);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 8;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
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
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(20);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(10, 20, 10, 20);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
		contentPane.add(panel, gbc_panel);
		
		
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
		this.pack();
		this.setVisible(true);
		
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
	
	
	private void FormLoad()
	{
		String[] colHead = {"Mã sách", "Tên sách", "Mã thể loại", "Mã tác giả", "Mã NXB", "Giá sách", "Số lượng"};
		model = new DefaultTableModel(null, colHead);
		table.setModel(model);
		table.setDefaultEditor(Object.class, null);
		utilities.ComboBoxUtil.Combobox_GetValue(cboTheloai, "SELECT * FROM tblTheLoai", "Tentheloai");
		utilities.ComboBoxUtil.Combobox_GetValue(cboNXB, "SELECT * FROM tblNXB", "TenNXB");
		utilities.ComboBoxUtil.Combobox_GetValue(cboTacgia, "SELECT * FROM tblTacGia", "TenTacGia");
		
		ResetValue();
		LoadTableData();
		
	}
	
	private void ResetValue()
	{
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
	
	private void LoadTableData()
	{
		for(int i = model.getRowCount()-1; i>=0; i--)
		{
			model.removeRow(i);
		}
		
		SachDAO dao = new SachDAO();
		List<Sach> list = dao.getAll();
		
		for(Sach s : list)
		{
			Object[] row = {s.getMaSach(), s.getTenSach(), s.getMaTheLoai(), s.getMaTacGia(), s.getMaNXB(), s.getGiaSach(), s.getSoLuong()};
			model.addRow(row);
		}
		
	}
	
	private void table_Click()
	{
		if(!btnThem.isEnabled())
		{
			JOptionPane.showMessageDialog(this, "Bạn đang ở chế độ thêm mới", "Thông báo", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		int selectedRow = table.getSelectedRow();
		if(selectedRow >= 0)
		{
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
	
	private void btnThem_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		ResetValue();
		btnThem.setEnabled(false);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnBoqua.setEnabled(true);
		btnLuu.setEnabled(true);
		txtMaSach.setEditable(true);
	}
	
	private void btnBoqua_Click()
	{
		ResetValue();
	}
	
	private void btnAnh_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn ảnh");
		int response = fileChooser.showOpenDialog(this);
		if(response == fileChooser.APPROVE_OPTION)
		{
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
			try
			{
				lblPictureHere.setIcon(new ImageIcon(file.getAbsolutePath()));
				lblPictureHere.setText("");
				txtAnh.setText(file.getAbsolutePath());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Ảnh không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void btnLuu_Click()
	{
		String masach = txtMaSach.getText().trim();
		String tensach = txtTensach.getText().trim();
		String anh = txtAnh.getText().trim();
		String ghichu = txtGhichu.getText().trim();
		
		if(masach.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập mã sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(tensach.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập tên sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(txtGiasach.getText().trim().length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập giá", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(cboTheloai.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn thể loại sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(cboTacgia.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(cboNXB.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(anh.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn ảnh", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(ghichu.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập ghi chú", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		SachDAO dao = new SachDAO();
		Sach key = dao.selectById(masach);
		if(key != null)
		{
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
		
		Sach sach = new Sach(masach, tensach, tl.getMaTheLoai(), tg.getMaTacGia(), nxb.getMaNXB(), gia, sl, anh, ghichu);
		dao.them(sach);
		ResetValue();
		LoadTableData();
	}
	
	private void btnSua_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		if(model.getColumnCount() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String masach = txtMaSach.getText().trim();
		String tensach = txtTensach.getText().trim();
		String anh = txtAnh.getText().trim();
		String ghichu = txtGhichu.getText().trim();
		
		if(model.getColumnCount() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(masach.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để sửa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(tensach.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập tên sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(txtGiasach.getText().trim().length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập giá", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(cboTheloai.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn thể loại sách", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(cboTacgia.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn tác giả", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(cboNXB.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn nhà xuất bản", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(anh.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn ảnh", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(ghichu.length() == 0)
		{
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
		
		Sach sach = new Sach(masach, tensach, tl.getMaTheLoai(), tg.getMaTacGia(), nxb.getMaNXB(), gia, sl, anh, ghichu);
		dao.sua(sach);
		ResetValue();
		LoadTableData();
	}
	
	private void btnXoa_Click()
	{
		if(!utilities.PermissionUtil.isAllowedToModify(nhanvien, this))
			return;
		if(model.getColumnCount() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa có dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		String masach = txtMaSach.getText().trim();
		
		if(masach.length() == 0)
		{
			JOptionPane.showMessageDialog(this, "Chưa chọn dữ liệu để xóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa", "Xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
			SachDAO dao = new SachDAO();
			dao.xoa(masach);
			ResetValue();
			LoadTableData();
		}
	}
	
	private void btnTimkiem_Click()
	{
		String masach = txtMaSach.getText().trim();
		String tensach = txtTensach.getText().trim();
		if(tensach.length() == 0 && cboTheloai.getSelectedIndex() == -1 && cboTacgia.getSelectedIndex() == -1 && cboNXB.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(this, "Chưa nhập đủ điều kiện tìm kiếm", "Thông báo", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String sql = "SELECT * FROM tblSach WHERE 1=1 ";
		
		if(tensach.length() != 0)
			sql += "AND Tensach LIKE N'%" + tensach + "%' ";
		if(cboTheloai.getSelectedItem() != null)
		{
			TheLoaiDAO tldao = new TheLoaiDAO();
			Theloai tl = tldao.selectByName(cboTheloai.getSelectedItem().toString()); 
			sql += "AND Matheloai LIKE '%" + tl.getMaTheLoai() + "%' ";
		}
		if(cboTacgia.getSelectedItem() != null)
		{
			TacGiaDAO tgdao = new TacGiaDAO();
			Tacgia tg = tgdao.selectByName(cboTacgia.getSelectedItem().toString()); 
			sql += "AND Matacgia LIKE '%" + tg.getMaTacGia() + "%' ";
		}
		if(cboNXB.getSelectedItem() != null)
		{
			NhaXuatBanDAO tldao = new NhaXuatBanDAO();
			Nhaxuatban nxb = tldao.selectByName(cboNXB.getSelectedItem().toString()); 
			sql += "AND MaNXB LIKE '%" + nxb.getMaNXB() + "%' ";
		}
		
		SachDAO dao = new SachDAO();
		
		List<Sach> list = dao.getAll(sql);

		for(int i = model.getRowCount()-1; i>=0; i--)
		{
			model.removeRow(i);
		}
		
		for(Sach s : list)
		{
			Object[] row = {s.getMaSach(), s.getTenSach(), s.getMaTheLoai(), s.getMaTacGia(), s.getMaNXB(), s.getGiaSach(), s.getSoLuong()};
			model.addRow(row);
		}
		
		JOptionPane.showMessageDialog(this, "Có " + model.getRowCount() + " dòng thỏa mãn điều kiện tìm kiếm", "Thông báo", JOptionPane.PLAIN_MESSAGE);
	}
}
