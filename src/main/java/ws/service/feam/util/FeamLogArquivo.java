package ws.service.feam.util;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Jean Valle 
 * @author Marcio
 */
public class FeamLogArquivo {
    
    private String nomeClasse;


    public FeamLogArquivo(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public FeamLogArquivo() {
    }

    static{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
     
    public Logger start() throws IOException, SQLException {
                
        final Logger log = Logger.getLogger(nomeClasse);
        
        Properties props = new Properties();
        props.setProperty("log4j.rootLogger", "INFO, stdout, file");
        props.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        props.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        props.setProperty("log4j.appender.stdout.Target", "System.out");
        props.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        props.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
        props.setProperty("log4j.appender.file", "org.apache.log4j.FileAppender");
        props.setProperty("log4j.appender.file.File", "Z:\\SIGRA\\Log\\LogRobo_${current.date.time}.log");

        props.setProperty("log4j.appender.file.Append", "true");
        props.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
        props.setProperty("log4j.appender.file.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");                        
        PropertyConfigurator.configure(props);  
        
        return log;
    }

    public String getNomeClasse() {
        return this.nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }
}