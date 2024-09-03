package com.cts.main;

import com.cts.service.CaseManagement;
import com.cts.service.ClientManagement;
import com.cts.service.DocumentManagement;
import com.cts.exception.InvalidChoiceException;



import java.util.Scanner;

public class Main {                                                       //Entry point of the project
   
    public static void main(String[] args) throws InvalidChoiceException {
    	try {
        start();
    }catch(InvalidChoiceException e) {
    	System.out.println(e.getMessage());
    	start();                                                          //to display menu and handle user interactions
    	}       
    }
    
    public static void start() throws InvalidChoiceException{
        int choice; 
        Scanner sc = new Scanner(System.in);
        System.out.println("Law Firm Document Management");
        System.out.println("1. Document Management");
        System.out.println("2. Client Management");
        System.out.println("3. Case Management");
        System.out.println("4. Close Application");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice){                                              //switch statement directs the program to the appropriate management class
          case 1:
              DocumentManagement.choice();
              break;
          case 2:
              ClientManagement.choice();
              break;
          case 3:
              CaseManagement.choice();
              break;
          case 4:
              System.out.println("Application Closed");
              break;
          default:
              throw new InvalidChoiceException("please enter valid option");
      }

    }
}


