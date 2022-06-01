/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.KasirModel;
import view.KasirView;
/**
 *
 * @author Hewlett-Packard
 */
public class KasirController {
    KasirModel movieModel;
    KasirView movieView;
     Object header[] = {"ID", "Nama Barang", "Nama kasir", "Quantity", "Price per Quantity", "Discount", "Price Total"};
  


    public KasirController(KasirModel movieModel, KasirView movieView) {
        this.movieModel = movieModel;
        this.movieView = movieView;
        
        if (movieModel.getKasirdata()!=0) {
            String dataMovie[][] = movieModel.tampilKasir();
            movieView.table.setModel((new JTable(dataMovie, header)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        movieView.btnAdd.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = movieView.getId();
                String nama_barang = movieView.getNamabarang();
                String nama_kasir = movieView.getNama_kasir();
                String qty = movieView.getQty();
                String priceperqty = movieView.getPriceperqty();
                String discount = movieView.getDiscount();
               
                
                
                movieModel.insertKasir( id,  nama_barang,  nama_kasir,  qty,  priceperqty,  discount);
                String dataMovie[][] = movieModel.tampilKasir();
                movieView.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        movieView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                 String id = movieView.getId();
                String nama_barang = movieView.getNamabarang();
                String nama_kasir = movieView.getNama_kasir();
                String qty = movieView.getQty();
                String priceperqty = movieView.getPriceperqty();
                String discount = movieView.getDiscount();
          
                movieModel.updateKasir( id,  nama_barang,  nama_kasir,  qty,  priceperqty,  discount);
                String dataMovie[][] = movieModel.tampilKasir();
                movieView.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        movieView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String title = movieView.getId();
                
                movieModel.deleteKasir(title);
                String dataMovie[][] = movieModel.tampilKasir();
                movieView.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        movieView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                movieView.setId();
                movieView.setNamabarang();
                movieView.setNamakasir();
                movieView.setQty();
                movieView.getPriceperqty();
                movieView.getDiscount();
               
            }
        });
    }
}
