package dao.impl;

import dao.IAdminDAO;
import model.Admin;
import utils.DBUtil;

import java.sql.*;

public class AdminDAOImpl implements IAdminDAO {

    public Admin login(String username, String password){
        String sql="SELECT * FROM admin WHERE username=? AND password=?";

        try(Connection c=DBUtil.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Admin(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }

        }catch(Exception e){e.printStackTrace();}

        return null;
    }
}