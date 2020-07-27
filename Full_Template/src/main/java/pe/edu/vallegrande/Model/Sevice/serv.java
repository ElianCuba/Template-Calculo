package pe.edu.vallegrande.Model.Sevice;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class serv {

    public static void mensajeInfo(String title, String content) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, content));
    }

    public static void mensajeWarn(String title, String content) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, content));
    }

    public static void mensajeError(String title, String content) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, content));
    }

    public static void mensajeFatal(String title, String content) {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title, content));
    }

    public static void mensajeFatal() {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "¡Error del Sistema!", "Vuelva a intentarlo en unos minutos."));
    }

    public static void ReporteGenerado() {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Reporte Descargado!", "Se descargó correctamente el Reporte."));
    }

    /*
    *Obtener fechar para enviar a la DB
     */
    public static java.sql.Date sqlDate(java.util.Date fecha) {
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        return sqlDate;
    }

    public static java.util.Date utilDate(java.sql.Date fecha) {
        java.util.Date utilDate = new java.util.Date(fecha.getTime());
        return utilDate;
    }
    
    public static java.sql.Date Util2Sql(java.util.Date fecha) {
        java.sql.Date sqlDate;
        if (fecha == null) {
            sqlDate = null;
        }else{
            sqlDate = new java.sql.Date(fecha.getTime());
        }
        return sqlDate;
    }

    public static java.util.Date Sql2Util(java.sql.Date fecha) {
        java.util.Date utilDate;
        if (fecha == null) {
            utilDate = null;
        }else{
            utilDate = new java.util.Date(fecha.getTime());
        }
        return utilDate;
    }
}
