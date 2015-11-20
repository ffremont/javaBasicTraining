/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mosica.javaBasicTraining;

import fr.mosica.javaBasicTraining.own.TechnicalException;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author florent
 */
public abstract class MessageTemplateReader {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(MessageTemplateReader.class);
    
    /**
     * 
     * @return 
     */
    public static String read(){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("result.tpl");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String result = "";
 
	String line = null;
        try {
            while ((line = br.readLine()) != null) {
                result = result.concat(line).concat(System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
            throw new TechnicalException("Impossible de lire le template", ex);
        }finally{
            try {
                br.close();
            } catch (IOException ex) {
                LOG.warn("Fermeture du flux impossible", ex);
            }
            
        }
 
	return result;
    }
}
