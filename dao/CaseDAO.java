package com.cts.dao;

import com.cts.exception.InvalidChoiceException;
import com.cts.model.Case;
import com.cts.utill.DBConnection;
import com.cts.service.CaseManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CaseDAO {

    Case Case = new Case();
    DBConnection databaseConnections = new DBConnection();

    public void uploadCase() throws InvalidChoiceException{

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Client Id: ");
        Case.setClientId(sc.nextInt());
        System.out.println("Enter Case Number: ");
        Case.setCaseNum(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter description: ");
        Case.setDes(sc.nextLine());
        System.out.println("Enter Case Status: ");
        Case.setStatus(sc.nextLine());
        System.out.println("Enter Case Open Date(YYYY-MM-DD): ");
        Case.setOpenDate(sc.nextLine());
        System.out.println("Enter Case Close Date(YYYY-MM-DD): ");
        Case.setCloseDate(sc.nextLine());
        String query = "insert into cases(Client_id,Case_num,Description,Status,Open_date,Close_date) values(?,?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,Case.getClientId());
            pst.setInt(2,Case.getCaseNum());
            pst.setString(3,Case.getDes());
            pst.setString(4,Case.getStatus());
            pst.setString(5,Case.getOpenDate());
            pst.setString(6,Case.getCloseDate());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        CaseManagement.choice();
    }

    //this function is written to view particular data.

    public void viewCase() throws InvalidChoiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Case Number: ");
        Case.setCaseNum(sc.nextInt());
        String query = "select * from cases where Case_num = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,Case.getCaseNum());
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1)+"  ");
            System.out.println(rs.getInt(2)+"  ");
            System.out.println(rs.getInt(3)+"  ");
            System.out.println(rs.getString(4)+"  ");
            System.out.println(rs.getString(5)+"  ");
            System.out.println(rs.getString(6)+"  ");
            System.out.println(rs.getString(7)+"  ");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        CaseManagement.choice();
    }

    //this function is written to update the table.
    public void updateCase() throws InvalidChoiceException{
        int caseId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter updated Client ID: ");
        Case.setClientId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Updated Case Number: ");
        Case.setCaseNum(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Updated Description: ");
        Case.setDes(sc.nextLine());
        System.out.println("Enter Updated Status: ");
        Case.setStatus(sc.nextLine());
        System.out.println("Enter Updated Open Date(YYYY-MM-DD): ");
        Case.setOpenDate(sc.nextLine());
        System.out.println("Enter Updated Close Date(YYYY-MM-DD): ");
        Case.setCloseDate(sc.nextLine());
        System.out.println("Enter the Case Id that has to be updated: ");
        caseId = sc.nextInt();
        String query = "Update cases set Client_id = ? , Case_num = ? , Description = ? , Status = ? , Open_date= ? , Close_date = ? where Case_id = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,Case.getClientId());
            pst.setInt(2,Case.getCaseNum());
            pst.setString(3,Case.getDes());
            pst.setString(4,Case.getStatus());
            pst.setString(5,Case.getOpenDate());
            pst.setString(6,Case.getCloseDate());
            pst.setInt(7,caseId);
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        CaseManagement.choice();

    }
    //we can delete certain rows using this function.
    public void deleteCase() throws InvalidChoiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter case number: ");
        Case.setCaseNum(sc.nextInt());
        String query = "delete from cases where Case_num = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,Case.getCaseNum());
            int rows = pst.executeUpdate();
            System.out.println(rows+" Deleted");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        CaseManagement.choice();
    }
   
    
}
