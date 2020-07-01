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
public class Cliente {

    private int IDCLI;
    private String NOMCLI;
    private String APEPATCLI;
    private String APEMATCLI;
    private Date FECNACCLI;
    private String DIRCLI;
    private Number TELFCLI;
    private String EMAILCLI;

    public int getIDCLI() {
        return IDCLI;
    }

    public void setIDCLI(int IDCLI) {
        this.IDCLI = IDCLI;
    }

    public String getNOMCLI() {
        return NOMCLI;
    }

    public void setNOMCLI(String NOMCLI) {
        this.NOMCLI = NOMCLI;
    }

    public String getAPEPATCLI() {
        return APEPATCLI;
    }

    public void setAPEPATCLI(String APEPATCLI) {
        this.APEPATCLI = APEPATCLI;
    }

    public String getAPEMATCLI() {
        return APEMATCLI;
    }

    public void setAPEMATCLI(String APEMATCLI) {
        this.APEMATCLI = APEMATCLI;
    }

    public Date getFECNACCLI() {
        return FECNACCLI;
    }

    public void setFECNACCLI(Date FECNACCLI) {
        this.FECNACCLI = FECNACCLI;
    }

    public String getDIRCLI() {
        return DIRCLI;
    }

    public void setDIRCLI(String DIRCLI) {
        this.DIRCLI = DIRCLI;
    }

    public Number getTELFCLI() {
        return TELFCLI;
    }

    public void setTELFCLI(Number TELFCLI) {
        this.TELFCLI = TELFCLI;
    }

    
    public String getEMAILCLI() {
        return EMAILCLI;
    }

    public void setEMAILCLI(String EMAILCLI) {
        this.EMAILCLI = EMAILCLI;
    }
    
    
}
