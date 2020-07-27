/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Model;

import java.sql.Date;

/**
 *
 * @author josue
 */
public class Factura {

    private int CODFAC;
    private Date FECHFAC;
    private int IDCLI;
    private double TOTFAC;
    private double DESCFAC;
    private double IGV = 18;
    private double TOTPAGFAC;
    public Cliente IDCLIFAC = new Cliente();

    public int getCODFAC() {
        return CODFAC;
    }

    public void setCODFAC(int CODFAC) {
        this.CODFAC = CODFAC;
    }

    public Date getFECHFAC() {
        return FECHFAC;
    }

    public void setFECHFAC(Date FECHFAC) {
        this.FECHFAC = FECHFAC;
    }

    public int getIDCLI() {
        return IDCLI;
    }

    public void setIDCLI(int IDCLI) {
        this.IDCLI = IDCLI;
    }

    public double getTOTFAC() {
        return TOTFAC;
    }

    public void setTOTFAC(double TOTFAC) {
        this.TOTFAC = TOTFAC;
    }

    public double getDESCFAC() {
        return DESCFAC;
    }

    public void setDESCFAC(double DESCFAC) {
        this.DESCFAC = DESCFAC;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getTOTPAGFAC() {
        return TOTPAGFAC;
    }

    public void setTOTPAGFAC(double TOTPAGFAC) {
        this.TOTPAGFAC = TOTPAGFAC;
    }

    public Cliente getIDCLIFAC() {
        return IDCLIFAC;
    }

    public void setIDCLIFAC(Cliente IDCLIFAC) {
        this.IDCLIFAC = IDCLIFAC;
    }
    
    
}
