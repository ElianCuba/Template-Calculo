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
public class Detalle_Factura {

    private int CODFAC;
    private int IDPROD;
    private int CANTDET;
    private double SUBTOTDET;
    public Producto IDPRODTD = new Producto();
    public Factura CODFACTD = new Factura();

    public int getCODFAC() {
        return CODFAC;
    }

    public void setCODFAC(int CODFAC) {
        this.CODFAC = CODFAC;
    }

    public int getIDPROD() {
        return IDPROD;
    }

    public void setIDPROD(int IDPROD) {
        this.IDPROD = IDPROD;
    }

    public int getCANTDET() {
        return CANTDET;
    }

    public void setCANTDET(int CANTDET) {
        this.CANTDET = CANTDET;
    }

    public double getSUBTOTDET() {
        return SUBTOTDET;
    }

    public void setSUBTOTDET(double SUBTOTDET) {
        this.SUBTOTDET = SUBTOTDET;
    }

    public Producto getIDPRODTD() {
        return IDPRODTD;
    }

    public void setIDPRODTD(Producto IDPRODTD) {
        this.IDPRODTD = IDPRODTD;
    }

    public Factura getCODFACTD() {
        return CODFACTD;
    }

    public void setCODFACTD(Factura CODFACTD) {
        this.CODFACTD = CODFACTD;
    }

}
