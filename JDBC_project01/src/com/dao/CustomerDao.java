package com.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class CustomerDao {

    // INSERT
    public void insertCustomer(int id, String name, String location, int mob_num)throws ClassNotFoundException, SQLException {

        Connection con = DBUtil.getConnection();
        String query = "INSERT INTO customer VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, location);
        ps.setInt(4, mob_num);

        int rows = ps.executeUpdate();

        System.out.println("No of rows inserted : " + rows);

        ps.close();
        con.close();
    }

    // UPDATE
    public void updateCustomer(int id, String name,String location, int mob_num)throws ClassNotFoundException, SQLException {

        Connection con = DBUtil.getConnection();
        String query ="UPDATE customer SET name=?, location=?, mob_num=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, name);
        ps.setString(2, location);
        ps.setInt(3, mob_num);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();
        System.out.println("No of rows updated : " + rows);

        ps.close();
        con.close();
    }

    // DELETE
    public void deleteCustomer(int id)throws ClassNotFoundException, SQLException {

        Connection con = DBUtil.getConnection();
        String query = "DELETE FROM customer WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        System.out.println("No of rows deleted : " + rows);

        ps.close();
        con.close();
    }
    
    // FETCH DATA
    public void fetchCustomer()throws ClassNotFoundException, SQLException {

        Connection con = DBUtil.getConnection();
        String query = "SELECT * FROM customer";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

       
        IO.println("ID\tNAME\tLOCATION\tMOBILE");
        IO.println("------------------------------------------------");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String location = rs.getString("location");
            int mob = rs.getInt("mob_num");

            IO.println(id + "\t" + name + "\t" + location + "\t" + mob);
        }

        rs.close();
        ps.close();
        con.close();
    }
    
}
