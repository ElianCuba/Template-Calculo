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
public class ModoPago {
    private int IDPAG ;
    private String  NOMPAG;
    private String  DETALPAG ;

    
     public String getFULLNAMEP() {
        String valor = (NOMPAG + ", " + (DETALPAG).toUpperCase());
        return valor.toUpperCase().contains("null".toUpperCase()) ? "" : valor;
    }
    public int getIDPAG() {
        return IDPAG;
    }

    public void setIDPAG(int IDPAG) {
        this.IDPAG = IDPAG;
    }

    public String getNOMPAG() {
        return NOMPAG;
    }

    public void setNOMPAG(String NOMPAG) {
        this.NOMPAG = NOMPAG;
    }

    public String getDETALPAG() {
        return DETALPAG;
    }

    public void setDETALPAG(String DETALPAG) {
        this.DETALPAG = DETALPAG;
    }
    
}
