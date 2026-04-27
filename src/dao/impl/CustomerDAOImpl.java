package dao.impl;

import dao.ICustomerDAO;
import model.Customer;
import utils.DBUtil;

import java.sql.*;
import java.util.*;

public class CustomerDAOImpl implements ICustomerDAO {

    public void insert(Customer c){
        String sql="INSERT INTO customer(name,phone,email,address) VALUES(?,?,?,?)";

        try(Connection conn=DBUtil.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){

            ps.setString(1,c.getName());
            ps.setString(2,c.getPhone());
            ps.setString(3,c.getEmail());
            ps.setString(4,c.getAddress());

            ps.executeUpdate();
            System.out.println("Them KH thanh cong!");

        }catch(Exception e){e.printStackTrace();}
    }

    public List<Customer> findAll(){
        List<Customer> list=new ArrayList<>();

        try(Connection conn=DBUtil.getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM customer")){

            while(rs.next()){
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                ));
            }

        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    public void delete(int id){
        try(Connection conn=DBUtil.getConnection();
            PreparedStatement ps=conn.prepareStatement("DELETE FROM customer WHERE id=?")){

            ps.setInt(1,id);
            ps.executeUpdate();

        }catch(Exception e){e.printStackTrace();}
    }
}