/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Hewlett-Packard
 */
public class KasirModel implements Perhitungan {
   
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/kasir";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connection;
    Statement statement;
    
    public KasirModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }

    @Override
    public int average(int qty, int price, int disc) {
        return ((qty*price)-((qty*price*disc)/100));
    }
    
    public int getKasirdata(){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `transactions`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            return totalData;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public void insertKasir(String id, String nama_barang, String nama_kasir, String qty, String priceperqty, String discount){
        try {
            int quantity, priceper, dis, score;
           quantity = Integer.parseInt(qty);
            priceper = Integer.parseInt(priceperqty);
            dis = Integer.parseInt(discount);
            
           
            if(quantity < 0.0){
                throw new Exception("out");
            }
            if(priceper < 0.0){
                throw new Exception("out");
            }
            if(  dis < 0.0){
                throw new Exception("out");
            }
            score = average(quantity, priceper,dis);
          
       


            
            statement = connection.createStatement();
            statement.executeUpdate("insert into `transactions` (`id_trans`, `nama_barang`, `nama_kasir`, `qty`, `price_per_qty`, `discount`, `price_total`) " + 
                        " values  ('" + id + "','" + nama_barang + "','" + nama_kasir + "'," + quantity + "," + priceper +","+ dis +","+ score +")");
            
            JOptionPane.showMessageDialog(null, "Register Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("out")){
                JOptionPane.showMessageDialog(null, "Out of Bound");
            }else{
                JOptionPane.showMessageDialog(null, "Register Failed");
            }     
        }
    }
    
    public String[][] tampilKasir(){
        try{
            int totalData = 0;
            
            String data[][] = new String[getKasirdata()][7];
            
            String query = "SELECT * FROM `transactions`"; 
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[totalData][0] = resultSet.getString("id_trans");
                data[totalData][1] = resultSet.getString("nama_barang");                
                data[totalData][2] = resultSet.getString("nama_kasir");
                data[totalData][3] = resultSet.getString("qty");
                data[totalData][4] = resultSet.getString("price_per_qty");
                data[totalData][5] = resultSet.getString("discount");
                data[totalData][6] = resultSet.getString("price_total");
              
                totalData++;
            }
            statement.close();
            return data;
               
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
    
    public void updateKasir(String id, String nama_barang, String nama_kasir, String qty, String priceperqty, String discount){
        try {
            int quantity, priceper, disc, score;
           quantity = Integer.parseInt(qty);
            priceper = Integer.parseInt(priceperqty);
            disc = Integer.parseInt(discount);
            
           
            if(quantity < 0.0){
                throw new Exception("out");
            }
            if(priceper < 0.0){
                throw new Exception("out");
            }
            if(  disc < 0.0){
                throw new Exception("out");
            }
            score = average(quantity, priceper,  disc);
            
            String query = "UPDATE `transactions` "
                    + "SET "
                    + "`nama_barang`='" + nama_barang + "',"
                    + "`nama_kasir`='" + nama_kasir + "',"
                    + "`qty`=" + quantity + ","
                    + "`price_per_qty`=" + priceper + ","
                    + "`discount`=" +disc+ ","
                    + "`price_total`="+score
                    + " WHERE id_trans='" + id + "'";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("out")){
                JOptionPane.showMessageDialog(null, "Out of Bound");
            }else{
                JOptionPane.showMessageDialog(null, "Update Failed");
            }     
        }
    }
    
    public void deleteKasir (String id) {
        try{
            String query = "DELETE FROM transactions WHERE id_trans = '"+id+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Delete Success");
            
        }catch(SQLException e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
    
    
}
