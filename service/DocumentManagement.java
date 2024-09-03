package com.cts.service;// this is the class written to manage the documents table.

import com.cts.dao.DocumentDAO;
import com.cts.exception.InvalidChoiceException;
import com.cts.main.Main;

import java.util.Scanner;

public class DocumentManagement {

    public static void choice() throws InvalidChoiceException {
        int choice;
        DocumentDAO documentdoa = new DocumentDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Upload new documents");
        System.out.println("2. View document details");
        System.out.println("3. Update document details");
        System.out.println("4. Delete documents");
        System.out.println("5. Exit");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                documentdoa.uploadDocument();
                break;
            case 2:
                documentdoa.viewDocument();
                break;
            case 3:
                documentdoa.updateDocument();
                break;
            case 4:
                documentdoa.deleteDocument();
                break;
            case 5:
                Main.start();
                break;
            default:
                System.out.println("Error");
                choice();
        }
    }

}



