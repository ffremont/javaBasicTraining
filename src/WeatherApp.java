
import java.util.Scanner;

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
        
        
        System.out.println(codePostal);
    }
}
