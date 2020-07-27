/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.vallegrande.Model.Sevice;

import java.util.Calendar;

/**
 *
 * @author josue
 */
public class Validation { 
    
    public static java.sql.Date sqlDate(java.util.Date fecha) {
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        return sqlDate;
    }

    public static java.util.Date utilDate(java.sql.Date fecha) {
        java.util.Date utilDate = new java.util.Date(fecha.getTime());
        return utilDate;
    }
    
    public static int calcular(Calendar fechaNac) {
        Calendar fechaActual = Calendar.getInstance();
 
        // Cálculo de las diferencias.
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
 
        if(months < 0 // Aún no es el mes de su cumpleaños
           || (months==0 && days < 0)) { // o es el mes pero no ha llegado el día.
            years--;
        }
        return years;
    }
    
}
