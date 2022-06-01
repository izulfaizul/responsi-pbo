/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hewlett-Packard
 */
public class KasirView extends JFrame{
    
    JLabel lId = new JLabel("ID Transaksi");
    JLabel lnama_barang = new JLabel("Nama barang");
    JLabel lNama_kasir = new JLabel("Nama Kasir");
    JLabel lQty = new JLabel("Quantity");
    JLabel lPrice_per_qty = new JLabel("Price per Quantity");
    JLabel lDiscount = new JLabel("Discount");
 
    
    public JTextField tfId = new JTextField();
    public JTextField tfNama_barang = new JTextField();
    public JTextField tfNama_kasir = new JTextField();
    public JTextField tfQty = new JTextField();
    public JTextField tfPrice_per_qty = new JTextField();
    public JTextField tfDiscount = new JTextField();
  
    
    public JButton btnAdd = new JButton("Add");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object[] columnName = {"ID", "Nama Barang", "Nama kasir", "Quantity", "Price per Quantity", "Discount", "Price Total"};

    public KasirView() {
        dtm = new DefaultTableModel(columnName, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        
        setTitle("Transaksi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,500);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lId);
        lId.setBounds(510, 20, 90, 20);
        add(tfId);
        tfId.setBounds(510, 40, 120, 20);
        
        add(lnama_barang);
        lnama_barang.setBounds(510, 60, 90, 20);
        add(tfNama_barang);
        tfNama_barang.setBounds(510, 80, 120, 20);
        
        add(lNama_kasir);
        lNama_kasir.setBounds(510, 100, 90, 20);
        add(tfNama_kasir);
        tfNama_kasir.setBounds(510, 120, 120, 20);
        
        add(lQty);
        lQty.setBounds(510, 140, 90, 20);
        add(tfQty);
        tfQty.setBounds(510, 160, 120, 20);
        
         add(lPrice_per_qty);
        lPrice_per_qty.setBounds(510, 180, 90, 20);
        add(tfPrice_per_qty);
        tfPrice_per_qty.setBounds(510, 200, 120, 20);
        
         add(lDiscount);
        lDiscount.setBounds(510, 220, 90, 20);
        add(tfDiscount);
        tfDiscount.setBounds(510, 240, 120, 20);
        
     
        
        
        
        add(btnAdd);
        btnAdd.setBounds(510, 310, 90, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(510, 340, 90, 20);
        
        add(btnDelete);
        btnDelete.setBounds(510, 370, 90, 20);
        
        add(btnReset);
        btnReset.setBounds(510, 400, 90, 20);
    }
    
    public String getId(){
        return tfId.getText();
    }
    
    public String getNamabarang(){
        return tfNama_barang.getText();
    }
    
    public String getNama_kasir(){
        return tfNama_kasir.getText();
    }
    
    public String getQty(){
        return tfQty.getText();
    }
    public String getPriceperqty(){
        return tfPrice_per_qty.getText();
    }
    public String getDiscount(){
        return tfDiscount.getText();
    }
   
    
    public void setId(){
        tfId.setText("");
    }
    
    public void setNamabarang(){
        tfNama_barang.setText("");
    }
    
    public void setNamakasir(){
        tfNama_kasir.setText("");
    }
    
    public void setQty(){
        tfQty.setText("");
    }
    public void setPrice_per_qty(){
        tfPrice_per_qty.setText("");
    }
    
    public void setDiscount(){
        tfDiscount.setText("");
    }
    
   
    
    
    
}
