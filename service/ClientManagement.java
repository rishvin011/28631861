package com.cts.service;

import com.cts.dao.ClientDAO;
import com.cts.exception.InvalidChoiceException;
import com.cts.main.Main;
import java.util.Scanner;

public class ClientManagement {

    public static void choice() throws InvalidChoiceException {
        int choice;
        ClientDAO clientdoa =new ClientDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add new clients");
        System.out.println("2. View client details");
        System.out.println("3. Update client information");
        System.out.println("4. Delete client");
        System.out.println("5. Exit");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                clientdoa.addClient();
                break;
            case 2:
                clientdoa.viewDetails();
                break;
            case 3:
                clientdoa.updateClient();
                break;
            case 4:
                clientdoa.deleteClient();
                break;
            case 5:
                Main.start();
                break;
            default:
                System.out.println("Error");
                choice();
        }
    }
    //this is the function written to add new data.

}



