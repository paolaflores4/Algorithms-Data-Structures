import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package monitoringsystem;*/

/**
 *
 * @author paola.flores_snhu
 */
public class MonitoringSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\nPlease select an option"); //Previous: "\nPlease select an option to monitor:"
            System.out.println("\tOption 1: Monitor Animals"); //Added "Monitor"
            System.out.println("\tOption 2: Monitor Habitats"); //Added "Monitor"
            System.out.println("\tOption 3: Veterinary"); //Added "VETERINARY" option
            System.out.println("\tOption 4: Exit");
            System.out.print("Enter option ");
            int userInput = 0;
            
            Scanner scnr = new Scanner(System.in);
            userInput = scnr.nextInt();
            System.out.println("");
            int write = 0;
            String animalName = "";
            String animalData = ""; //Added String
            String habitatName = "";
            BufferedReader bufferedReader;
            List<String> list = new ArrayList<>();
            String lineRead = "";
            switch (userInput) {
                case 1:
                    System.out.println("List of Animals ");
                    /*calls from animals file*/
                    bufferedReader = new BufferedReader(new FileReader("animals.txt"));
                    lineRead = "";
                    while ((lineRead = bufferedReader.readLine()) != null) {
                        list.add(lineRead);
                    }
                    bufferedReader.close();
                    /* A for loop that goes through the list*/
                    for (String line : list) {
                        if (line.toLowerCase().contains("Details on".toLowerCase())) {
                            /*Increase the write variable that tracks the index of the list*/
                            write += 1;
                            System.out.println("\t(" + write + ") " + line);
                        }
                    }
                    /*Allow user to input an animal's name for searching */
                    System.out.print("Enter your choice: ");
                    int animalChoice = scnr.nextInt();
                    System.out.println("");
                    /* Search for an animal in the list*/
                    for (String category : list.subList(write, list.size())) {
                        switch (animalChoice) {
                            case 1:
                                animalName = "Lion";
                                break;
                            case 2:
                                animalName = "Tiger";
                                break;
                            case 3:
                                animalName = "Bear";
                                break;
                            case 4:
                                animalName = "Giraffe";
                                break;
                            default:
                                System.out.println("\tWrong Choice!");
                                animalName = "";
                                break;

                        }
                        if (animalName.isEmpty()) {
                            break;
                        }
                        if (category.toLowerCase().contains(animalName.toLowerCase())) {
                            write = list.indexOf(category);
                            for (int i = write; i < write + 5; i++) {
                                /*Displays alert message if file contains ****** */
                                if (list.get(i).contains("*****")) {
                                    JOptionPane.showMessageDialog(new JFrame(),
                                            list.get(i).substring(list.get(i).lastIndexOf('*') + 1, list.get(i).length()), "ALERT!!!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                } 
                                else {
                                    System.out.println("\t" + list.get(i));
                                }
                            }

                        }
                    }
                    break;
                case 2:
                    System.out.println("List of Habitats ");
                    /*calls from habitats file */
                    bufferedReader = new BufferedReader(new FileReader("habitat.txt"));
                    lineRead = "";
                    while ((lineRead = bufferedReader.readLine()) != null) {
                        list.add(lineRead);
                    }
                    bufferedReader.close();
                    /* A for loop that goes thorugh the list*/
                    for (String line : list) {
                        if (line.toLowerCase().contains("Details on".toLowerCase())) {
                            write += 1;
                            System.out.println("\t(" + write + ") " + line);
                        }
                    }

                    System.out.print("Enter your choice: ");
                    int habitatChoice = scnr.nextInt();
                    System.out.println(""); 
                    for (String res : list.subList(write, list.size())) {
                        switch (habitatChoice) {
                            case 1:
                                habitatName = "Penguin";
                                break;
                            case 2:
                                habitatName = "Bird";
                                break;
                            case 3:
                                habitatName = "Aquarium";
                                break;
                            default:
                                System.out.println("\tWrong Choice!!!");
                                habitatName = "";
                                break;

                        }
                        if (habitatName.isEmpty()) {
                            break;
                        }
                        /*Check if the line contains a habitat name*/
                        if (res.toLowerCase().contains(habitatName.toLowerCase())) {
                            write = list.indexOf(res);
                            for (int i = write; i < write + 4; i++) {
                                /*Check if the line to be printed contains "****" */
                                if (list.get(i).contains("*****")) {
                                    /*Alert Box*/
                                    JOptionPane.showMessageDialog(new JFrame(),
                                            list.get(i).substring(list.get(i).lastIndexOf('*') + 1, list.get(i).length()), "ALERT!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                                else {
                                    System.out.println("\t" + list.get(i));
                                }
                            }
                        }
                    }
                    break;
                    //Include a new case for VETERINARY option
                    case 3: 
                    System.out.println("List of Animals To Check"); 
                    /*calls from animals file*/
                    bufferedReader = new BufferedReader(new FileReader("animals.txt"));
                    lineRead = "";
                    while ((lineRead = bufferedReader.readLine()) != null) {
                        list.add(lineRead);
                    }
                    bufferedReader.close();
                    /* A for loop that goes through the list*/
                    for (String line : list) {
                        if (line.toLowerCase().contains("Details on".toLowerCase())) {
                            /*Increase the write variable that tracks the index of the list*/
                            write += 1;
                            System.out.println("\t(" + write + ") " + line);
                        }
                    }
                    /*Allow user to input an animal's name for searching */
                    System.out.print("Enter your choice: ");
                    animalChoice = scnr.nextInt();
                    System.out.println("");
                    /* Search for an animal in the list*/
                    for (String category : list.subList(write, list.size())) {
                        switch (animalChoice) {
                            case 1:
                                animalName = "Lion";
                                animalData = "Type: Mammal; Gender: Male; Last Check Up: Feb 02, 2021; Next Check Up: Apr 1 2021"; //Added data
                                break;
                            case 2:
                                animalName = "Tiger";
                                animalData = "Type: Mammal; Gender: Female; Last Check Up: Mar 03, 2021; Next Check Up: Apr 1 2021"; //Added data
                                break;
                            case 3:
                                animalName = "Bear";
                                animalData = "Type: Mammal; Gender: Male; Last Check Up: Mar 15, 2021; Next Check Up: Apr 1 2021"; //Added data
                                break;
                            case 4:
                                animalName = "Giraffe";
                                animalData = "Type: Mammal; Gender: Female; Last Check Up: Mar 15, 2021; Next Check Up: Apr 1 2021"; //Added data
                                break;
                            default:
                                System.out.println("\tWrong Choice!");
                                animalName = "";
                                break;

                        }
                        if (animalName.isEmpty()) {
                            break;
                        }
                        if (category.toLowerCase().contains(animalName.toLowerCase())) {
                            write = list.indexOf(category);
                            for (int i = write; i < write + 5; i++) {
                                /*Displays alert message if file contains ****** */
                                if (list.get(i).contains("*****")) {
                                    JOptionPane.showMessageDialog(new JFrame(),
                                            list.get(i).substring(list.get(i).lastIndexOf('*') + 1, list.get(i).length()), "ALERT!!!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                } 
                                else {
                                    System.out.println("\t" + list.get(i));
                                }
                            }

                        }
                    }
                    break;
                case 4:
                    scnr.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!"
                            + "\nTerminating the Program");
                    System.exit(0);
                    break;
            }
        }
    } 
}
