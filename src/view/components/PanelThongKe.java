package view.components;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import config.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PanelThongKe extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelThongKe() {
		setLayout(new GridLayout(2, 2)); // 2 hàng, 2 cột
		add(createBookByCategoryPanel()); // Màu xanh dương
		add(createBookByPublisherPanel()); // Màu đỏ, xanh lá
		add(createBookByAuthorPanel()); // Màu cam
		add(createTotalValueByCategoryPanel()); // Màu tím
	}

	// Biểu đồ cột: Số lượng sách theo thể loại (màu xanh dương)
	private ChartPanel createBookByCategoryPanel() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT tl.Tentheloai, COUNT(s.Masach) as SoLuong " +
								"FROM tblTheLoai tl LEFT JOIN tblSach s ON tl.Matheloai = s.Matheloai " +
								"GROUP BY tl.Tentheloai " +
								"ORDER BY tl.Tentheloai")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dataset.addValue(rs.getInt("SoLuong"), "Số lượng", rs.getString("Tentheloai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JFreeChart chart = ChartFactory.createBarChart("Số lượng sách theo thể loại", "Thể loại", "Số lượng", dataset);
		chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.BLUE); // Màu xanh dương
		return new ChartPanel(chart);
	}

	// Biểu đồ tròn: Số lượng sách theo NXB (màu đỏ, xanh lá)
	private ChartPanel createBookByPublisherPanel() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT nxb.TenNXB, COUNT(s.Masach) as SoLuong " +
								"FROM tblNXB nxb LEFT JOIN tblSach s ON nxb.MaNXB = s.MaNXB " +
								"GROUP BY nxb.TenNXB")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dataset.setValue(rs.getString("TenNXB"), rs.getInt("SoLuong"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JFreeChart chart = ChartFactory.createPieChart("Số lượng sách theo NXB", dataset);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setSectionPaint("NXB Chính trị Quốc gia Sự thật", Color.RED); // Màu đỏ
		plot.setSectionPaint("NXB Kim Đồng", Color.GREEN); // Màu xanh lá
		return new ChartPanel(chart);
	}

	// Biểu đồ cột: Số lượng sách theo tác giả (màu cam)
	private ChartPanel createBookByAuthorPanel() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT tg.Tentacgia, COUNT(s.Masach) as SoLuong " +
								"FROM tblTacGia tg LEFT JOIN tblSach s ON tg.Matacgia = s.Matacgia " +
								"GROUP BY tg.Tentacgia")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dataset.addValue(rs.getInt("SoLuong"), "Số lượng", rs.getString("Tentacgia"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JFreeChart chart = ChartFactory.createBarChart("Số lượng sách theo tác giả", "Tác giả", "Số lượng", dataset);
		chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.ORANGE); // Màu cam
		return new ChartPanel(chart);
	}

	// Biểu đồ cột: Tổng giá trị sách theo thể loại (màu tím)
	private ChartPanel createTotalValueByCategoryPanel() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT tl.Tentheloai, SUM(s.Giasach * s.Soluong) as TongGiaTri " +
								"FROM tblTheLoai tl LEFT JOIN tblSach s ON tl.Matheloai = s.Matheloai " +
								"GROUP BY tl.Tentheloai")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dataset.addValue(rs.getDouble("TongGiaTri"), "Tổng giá trị", rs.getString("Tentheloai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JFreeChart chart = ChartFactory.createBarChart("Tổng giá trị sách theo thể loại", "Thể loại",
				"Tổng giá trị (VND)", dataset);
		chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.MAGENTA); // Màu tím
		return new ChartPanel(chart);
	}
}