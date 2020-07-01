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
public class Detalle {

    private int IDDET;
    private int CODFAC;
    private int IDPROD;
    private int CANTDET;
    private double PRICTOTDET;

    public int getIDDET() {
        return IDDET;
    }

    public void setIDDET(int IDDET) {
        this.IDDET = IDDET;
    }

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

    public double getPRICTOTDET() {
        return PRICTOTDET;
    }

    public void setPRICTOTDET(double PRICTOTDET) {
        this.PRICTOTDET = PRICTOTDET;
    }
    
    
}
