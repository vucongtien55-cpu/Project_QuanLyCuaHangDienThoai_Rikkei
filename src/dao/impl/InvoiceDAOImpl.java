package dao.impl;

import dao.IInvoiceDAO;
import model.InvoiceDetail;
import utils.DBUtil;
import java.sql.*;
import java.util.List;

public class InvoiceDAOImpl implements IInvoiceDAO {
    @Override
    public void create(int customerId, List<InvoiceDetail> list) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            double total = list.stream().mapToDouble(d -> d.getQuantity() * d.getPrice()).sum();


            String sql1 = "INSERT INTO invoice(customer_id, total_amount) VALUES(?, ?)";
            PreparedStatement ps1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(1, customerId);
            ps1.setDouble(2, total);
            ps1.executeUpdate();

            ResultSet rs = ps1.getGeneratedKeys();
            int invoiceId = 0;
            if (rs.next()) {
                invoiceId = rs.getInt(1);
            }

            String sql2 = "INSERT INTO invoice_details(invoice_id, product_id, quantity, unit_price) VALUES(?,?,?,?)";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            for (InvoiceDetail d : list) {
                ps2.setInt(1, invoiceId);
                ps2.setInt(2, d.getProductId());
                ps2.setInt(3, d.getQuantity());
                ps2.setDouble(4, d.getPrice());
                ps2.addBatch();
            }
            ps2.executeBatch();

            conn.commit();
        } catch (Exception e) {
            if (conn != null) try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
        } finally {
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}