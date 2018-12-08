/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cours
 */
public class Projet {
    
    
    
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws FileNotFoundException {

	File stations;
        stations = new File("stations.txt");
        
        File connections;
        connections = new File("connections.txt");
        	
	try {
            
            //lecture du fichier texte & stockage du nom des stations dans un ArrayList
            Scanner scanner = new Scanner(stations);
            ArrayList<String> listeDesStations = new ArrayList<>();
                    
            while (scanner.hasNext() /* && !scanner.nextLine.contains("#") */){
                String ligne = scanner.nextLine();
                if (!ligne.contains("%") && !listeDesStations.contains(ligne)) {
                    listeDesStations.add(ligne);
                }    
                        
            }

            System.out.println(listeDesStations);
            scanner.close();
            
            // lecture des connections et comptage des stations voisines
            // ne marche pas!!
            Scanner sc = new Scanner(connections);
            ArrayList<Integer> compteurDesVoisines = new ArrayList<>();
            
            for(int i=0; i<listeDesStations.size(); i++) {
                int compteur;
                compteur = 0;
                String nomDeLaStation = listeDesStations.get(i);

                for(int j=0; j<connections.length(); j++)
                    while (sc.hasNext()) {
                        String line = sc.nextLine();
                        if (line.contains(nomDeLaStation)) {
                            compteur = compteur + 1;
                        }    
                    }
                sc.nextLine();
                compteurDesVoisines.add(compteur);
                }

            
               
            
            System.out.println(compteurDesVoisines);
	}		
	catch (FileNotFoundException e){
            System.out.println(e.toString());
        }
        
    }
    
}
