package ws.service.feam.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class FeamMetodosPadrao {
        
    public String getDataAtual(String dateFormat)
    {
        SimpleDateFormat formatter= new SimpleDateFormat(dateFormat);
        Date date = new Date(System.currentTimeMillis());
        String dataAtual = formatter.format(date);                       
        return dataAtual;
    }          
     
    public void MensagemInformativa(String mensagem)
    {
        JOptionPane.showMessageDialog(null,
        ""+mensagem+"",
        "Informativo",
        JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void MensagemErro (String mensagem)
    {
        JOptionPane.showMessageDialog(null,
        ""+mensagem+"",
        "Erro!",
        JOptionPane.ERROR_MESSAGE);
    }    
    
    public void MensagemErroSQl(String mensagem, String erro, int codigo)
    {
        erro = erro.replace(".",":");       
        String [] textoSeparado = erro.split(":");                  
        String erro_final="";

        for(int i=0;i<textoSeparado.length; i++)
        {
            switch (i) {
                case 0:
                case 1:
                case 2:
                    erro_final= erro_final+"";
                    break;
                case 6:
                    erro_final=erro_final+textoSeparado[i];
                    break;
                default:
                    erro_final=erro_final+textoSeparado[i]+"\n";   
                    break;
            }
                     
        }
               
        JOptionPane.showMessageDialog(null,
        ""+mensagem+"\n\n Código do Erro: "+codigo+"\n Descrição do erro: "+erro,
        "Erro!",
        JOptionPane.ERROR_MESSAGE);
    }
    
    public void MensagemAlerta(String mensagem)
    {
        JOptionPane.showMessageDialog(null,
        ""+mensagem+"",
        "Atenção!",
        JOptionPane.WARNING_MESSAGE);
    }     
    
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
