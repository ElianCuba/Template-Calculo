/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Model;

/**
 *
 * @author josue
 */
public class Producto {

    private int IDPROD;
    private String NOMPROD;
    private double PRICPROD;
    private int STOCK;
    private int IDCAT;

    public int getIDPROD() {
        return IDPROD;
    }

    public void setIDPROD(int IDPROD) {
        this.IDPROD = IDPROD;
    }

    public String getNOMPROD() {
        return NOMPROD;
    }

    public void setNOMPROD(String NOMPROD) {
        this.NOMPROD = NOMPROD;
    }

    public double getPRICPROD() {
        return PRICPROD;
    }

    public void setPRICPROD(double PRICPROD) {
        this.PRICPROD = PRICPROD;
    }

    public int getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(int STOCK) {
        this.STOCK = STOCK;
    }

    public int getIDCAT() {
        return IDCAT;
    }

    public void setIDCAT(int IDCAT) {
        this.IDCAT = IDCAT;
    }

}
