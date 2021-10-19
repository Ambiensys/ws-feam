/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.integracao.feam.modelo.utils;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Marcio Barros
 */
public class FeamManutencaoArquivo {
        
    public String renomeiaArquivo(String diretorioTemp, String nomeTemp, String nomeNovo) throws IOException {               
        
        //Nomes do arquivo        
        String arquivoTemp = diretorioTemp + nomeTemp;
        String arquivoNovo = diretorioTemp + nomeNovo;
                        
        //Verificador de exis�ncia do arquivo
        boolean aFileExists = true;

        File f = new File(arquivoTemp); //Cria descritor do arquivo a.txt
        if(!f.exists()) { //Se arquivo a.txt n�o existir
                f = new File(arquivoNovo); //Trocar pelo descritor do arquivo b.txt
                if(!f.exists()) { //Se n�o existir nem o arquivo b.txt                        
                        try {
                                f.createNewFile(); //Cria o arquivo b.txt (que ser� renomeado para a.txt)
                        } catch (IOException e) {} //Trate esta exce��o como preferir.
                }
                aFileExists = false; //Marcar que arquivo a.txt n�o existe.
        }

        //A��o de renomear arquivo baseado em quem � v�lido.
        f.renameTo(aFileExists ? new File(arquivoNovo) : new File(arquivoTemp));
        return nomeNovo;    
    }
}    

