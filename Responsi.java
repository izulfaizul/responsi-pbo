/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;
import controller.KasirController;
import model.KasirModel;
import view.KasirView;
import model.Perhitungan;

/**
 *
 * @author Hewlett-Packard
 */
public class Responsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       KasirView movieView = new KasirView();
        KasirModel movieModel = new KasirModel();
        KasirController movieController = new KasirController(movieModel, movieView);
    }
    
}
