package ws.service.feam.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import ws.service.feam.util.FeamLogArquivo;
import ws.service.feam.util.FeamMetodosPadrao;


public class FeamConectaBanco 
{
    FeamLogArquivo logArquivo = new FeamLogArquivo(FeamConectaBanco.class.getName());
    FeamMetodosPadrao metodos = new FeamMetodosPadrao();
    
    // Variveis Obrigatorias para conexão com o Banco de Dados
    public  Statement stm; //statement é responsável por preparar e realizar pesquisas no banco de dados
    public  ResultSet rs; // responsável por armazenar o resultado de uma pesquisa passada para o Statement
    private String driver  = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //Responsável por identificar serviço do Banco de Dados
    private String caminho = "jdbc:sqlserver://10.222.0.138:1433;databaseName=SIGRAPRD"; // Responsável por Setar o Local do Banco de Dados
    private String usuario = "sigraweb"; //Usuário para acesso do banco
    private String senha   = "8Ph#%kZD"; //senha pré definida na instalação
    public  Connection conn; //Responsável por realizar a conexão com o Banco de Dados 
    
        
    public String ambiente = caminho;
    
    //Métodos de Conexão
    
    public void conexao() throws IOException, SQLException //esse método é responsável por realizar a conexão com o banco de dados
    {
        Logger log = logArquivo.start();
        
        try //Tentativa Inicial
        {
            System.setProperty("jdbc.Drivers",driver); //Seta a Propriedade do Driver de Conexão
            conn = DriverManager.getConnection(caminho, usuario, senha); //Realiza a Conexão com o Banco de Dados
            conn.setAutoCommit(true);            
        }   
        
        catch (SQLException ex) // Caso de Errado (exceção)
        {
            log.info("ERROR! Problema de conexao com o banco de dados : " + ex.getMessage());//Imprime uma caixa de mensagem (se for False);
            metodos.MensagemErro("ERROR! Problema de conexao com o banco de dados : " + ex.getMessage());
        }
    }
    
    public void desconecta() throws IOException, SQLException // Metodo Para Fechar a Conexão com o Banco de Dados
    {
        Logger log = logArquivo.start();
        
        try 
        {
            conn.close(); //Fecha a Conexão com Banco
        } 
        
        catch (SQLException ex) 
        {
            log.info("ERROR! Erro ao fechar conexao com o banco de dados : " + ex.getMessage()); //Exeção se der Errado
            metodos.MensagemErro("ERROR! Erro ao fechar conexao com o banco de dados : " + ex.getMessage());
        }
    }
    
    public void executaSQL(String sql) throws IOException, SQLException
    {
        Logger log = logArquivo.start();
        
        try 
        {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } 
        
        catch (SQLException ex) {
            log.info("ERROR! Erro ao executar comando SQL (Query): " + ex.getMessage()); 
            metodos.MensagemErro("ERROR! Erro ao executar comando SQL (Query): " + ex.getMessage()); 
        }
    }
    
    public void executaUpdate(String sql) throws IOException, SQLException
    {
        Logger log = logArquivo.start();
        
        try 
        {
            PreparedStatement updateSql = conn.prepareStatement(sql);            
            updateSql.executeUpdate();
        } 
        
        catch (SQLException ex) {
            log.info("ERROR! Erro ao executar comando SQL (Update): " + ex.getMessage()); 
            metodos.MensagemErro("ERROR! Erro ao executar comando SQL (Update): " + ex.getMessage()); 
        }
    }    
    
    public void commit() throws IOException, SQLException
    {
        Logger log = logArquivo.start();
        
        try 
        {
            conn.commit();            
        } 
        
        catch (SQLException ex) {
            log.info("ERROR! Erro ao executar comando SQL (Commit): " + ex.getMessage()); 
            metodos.MensagemErro("ERROR! Erro ao executar comando SQL (Commit): " + ex.getMessage()); 
        }
    }    
    
    public void rollback() throws IOException, SQLException
    {
        Logger log = logArquivo.start();
        
        try 
        {
            conn.rollback();            
        } 
        
        catch (SQLException ex) {
            log.info("ERROR! Erro ao executar comando SQL (Rollback): " + ex.getMessage()); 
            metodos.MensagemErro("ERROR! Erro ao executar comando SQL (Rollback): " + ex.getMessage()); 
        }
    }     
}