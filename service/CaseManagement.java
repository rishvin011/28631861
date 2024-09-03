package com.cts.service;// this is the class written to manage the cases table.

import com.cts.main.Main;
import com.cts.utill.DBConnection;
import com.cts.dao.CaseDAO;
import com.cts.exception.InvalidChoiceException;

import java.util.Scanner;

public class CaseManagement {

    public static void choice() throws InvalidChoiceException {
        int choice;
        CaseDAO caseDoa = new CaseDAO();

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Create new cases");
        System.out.println("2. View case details");
        System.out.println("3. Update case information");
        System.out.println("4. Close case");
        System.out.println("5. Exit");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                caseDoa.uploadCase();
                break;
            case 2:
                caseDoa.viewCase();
                break;
            case 3:
                caseDoa.updateCase();
                break;
            case 4:
                caseDoa.deleteCase();
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
