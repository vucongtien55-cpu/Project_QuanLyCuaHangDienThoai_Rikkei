package dao.impl;

import dao.IProductDAO;
import model.Product;
import utils.DBUtil;

import java.sql.*;
import java.util.*;

public class ProductDAOImpl implements IProductDAO {

    public void insert(Product p) {
        String sql="INSERT INTO product(name,brand,price,stock) VALUES(?,?,?,?)";

        try(Connection c=DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){

            ps.setString(1,p.getName());
            ps.setString(2,p.getBrand());
            ps.setDouble(3,p.getPrice());
            ps.setInt(4,p.getStock());

            ps.executeUpdate();
            System.out.println("Them thanh cong!");

        }catch(Exception e){e.printStackTrace();}
    }

    public List<Product> findAll() {
        List<Product> list=new ArrayList<>();
        String sql="SELECT * FROM product";

        try(Connection c=DBUtil.getConnection();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery(sql)){

            while(rs.next()){
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }

        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    public Product findById(int id){
        String sql="SELECT * FROM product WHERE id=?";

        try(Connection c=DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
            }

        }catch(Exception e){e.printStackTrace();}
        return null;
    }

    public void update(Product p){
        String sql="UPDATE product SET name=?,brand=?,price=?,stock=? WHERE id=?";

        try(Connection c=DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){

            ps.setString(1,p.getName());
            ps.setString(2,p.getBrand());
            ps.setDouble(3,p.getPrice());
            ps.setInt(4,p.getStock());
            ps.setInt(5,p.getId());

            ps.executeUpdate();
            System.out.println("Cap nhat thanh cong!");

        }catch(Exception e){e.printStackTrace();}
    }

    public void delete(int id){
        String sql="DELETE FROM product WHERE id=?";

        try(Connection c=DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){

            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Xoa thanh cong!");

        }catch(Exception e){e.printStackTrace();}
    }
}