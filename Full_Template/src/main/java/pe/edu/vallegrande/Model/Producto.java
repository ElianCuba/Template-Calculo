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
    private String DESCPPROD;
    private Double PRECPROD;
    private int STOCK;

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

    public String getDESCPPROD() {
        return DESCPPROD;
    }

    public void setDESCPPROD(String DESCPPROD) {
        this.DESCPPROD = DESCPPROD;
    }

    public Double getPRECPROD() {
        return PRECPROD;
    }

    public void setPRECPROD(Double PRECPROD) {
        this.PRECPROD = PRECPROD;
    }

    public int getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(int STOCK) {
        this.STOCK = STOCK;
    }

    

}
