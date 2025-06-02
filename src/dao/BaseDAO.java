package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;

public abstract class BaseDAO<T> {

    protected Connection getConnection() throws SQLException {
        return DBConnection.getConnection(); // Sử dụng phương thức từ JDBC_Util để kết nối DB
    }

    // Các phương thức chung mà mọi DAO có thể sử dụng
    public int insert(String sql, Object... params) {
        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            setParams(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(String sql, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            setParams(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String sql, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            setParams(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public T selectById(String sql, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            setParams(ps, params);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T findByCredentials(String sql, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            setParams(ps, params);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs); // Phương thức ánh xạ kết quả từ ResultSet vào đối tượng
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> getAll(String sql, Object... params) {
        List<T> results = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            setParams(ps, params);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(mapRow(rs)); // Ánh xạ từng bản ghi vào đối tượng
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    // Phương thức này cần được cài đặt trong các lớp con để ánh xạ dữ liệu từ
    // ResultSet vào đối tượng
    protected abstract T mapRow(ResultSet rs) throws SQLException;

    private void setParams(PreparedStatement ps, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
    }
}