/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.integracao.feam.modelo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marcio Barross
 */
public class FeamMetodosPadrao {
    
     public String getDataAtual(String dateFormat)
    {
        SimpleDateFormat formatter= new SimpleDateFormat(dateFormat);
        Date date = new Date(System.currentTimeMillis());
        String dataAtual = formatter.format(date);                       
        return dataAtual;
    }                 
}
