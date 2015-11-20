package fr.mosica.javaBasicTraining;

import fr.mosica.javaBasicTraining.own.OwmClient;
import fr.mosica.javaBasicTraining.own.WeatherResult;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author florent
 */
public class WeatherApp {

    /**
     * Méthode principale du programme
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Code postal de la ville recherchée : ");

        String codePostal;

        Scanner scanIn = new Scanner(System.in);
        codePostal = scanIn.nextLine();
        scanIn.close();
        
        
        try {
            OwmClient owmClient = new OwmClient(new URL("http://api.openweathermap.org/data/2.5/weather?zip="+codePostal+",fr&appid=8c05dfed7d5d0d8ba3a2bc70b83b227f"));
            
            WeatherResult w = owmClient.getWeather();
            String tpl = MessageTemplateReader.read();
            
            System.out.println(
                tpl
                    .replace("{city}", w.getName())
                    .replace("{temp}", String.valueOf(w.getMain().getTemp()) )
                    .replace("{wind}", String.valueOf(w.getWind().getSpeed()))
                    .replace("{cp}", codePostal)
            );
        } catch (MalformedURLException ex) {
            System.err.println("Oups une erreur : "+ex.getMessage());
        }
        
        System.out.println(codePostal);
    }
}
