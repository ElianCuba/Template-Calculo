/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Model;

import java.util.Date;

/**
 *
 * @author josue
 */
public class Factura {

    private int CODFAC;
    private int IDCLI;
    private Date FECHFAC;
    private int IDPAG;

    public int getCODFAC() {
        return CODFAC;
    }

    public void setCODFAC(int CODFAC) {
        this.CODFAC = CODFAC;
    }

    public int getIDCLI() {
        return IDCLI;
    }

    public void setIDCLI(int IDCLI) {
        this.IDCLI = IDCLI;
    }

    public Date getFECHFAC() {
        return FECHFAC;
    }

    public void setFECHFAC(Date FECHFAC) {
        this.FECHFAC = FECHFAC;
    }

    public int getIDPAG() {
        return IDPAG;
    }

    public void setIDPAG(int IDPAG) {
        this.IDPAG = IDPAG;
    }

}
