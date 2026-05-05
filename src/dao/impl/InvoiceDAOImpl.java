package dao.impl;

import dao.IInvoiceDAO;
import model.InvoiceDetail;
import utils.DBUtil;
import java.sql.*;
import java.util.List;

public class InvoiceDAOImpl implements IInvoiceDAO {
    @Override
    public void create(int customerId, List<InvoiceDetail> list){
        Connection conn = null;

        try{
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);


            String sql = "INSERT INTO invoice(customer_id) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customerId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int invoiceId = 0;
            if(rs.next()){
                invoiceId = rs.getInt(1);
            }

            String detailSql = "INSERT INTO invoice_detail(invoice_id, product_id, quantity, unit_price) VALUES(?,?,?,?)";
            PreparedStatement psDetail = conn.prepareStatement(detailSql);

            for(InvoiceDetail i : list){
                psDetail.setInt(1, invoiceId);
                psDetail.setInt(2, i.getProductId());
                psDetail.setInt(3, i.getQuantity());
                psDetail.setDouble(4, i.getPrice());
                psDetail.executeUpdate();
            }

            conn.commit();
            System.out.println("Tao hoa don thanh cong!");

        }catch(Exception e){
            try{
                if(conn != null) conn.rollback();
            }catch(Exception ex){}
            System.out.println("Loi khi tao hoa don!");
            e.printStackTrace();

        }finally{
            try{
                if(conn != null) conn.close();
            }catch(Exception e){}
        }
    }
}