package com.cts.dao;

import com.cts.exception.InvalidChoiceException;
import com.cts.model.Client;
import com.cts.service.ClientManagement;
import com.cts.utill.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class ClientDAO {

    DBConnection databaseConnections = new DBConnection();
    Client Client = new Client();


    public void addClient() throws InvalidChoiceException{

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        Client.setClientId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter client name: ");
        Client.setName(sc.nextLine());
        System.out.println("Enter client Number: ");
        Client.setNum(sc.nextLine());
        System.out.println("Enter Email Id: ");
        Client.setEmail(sc.nextLine());
        System.out.println("Enter Address: ");
        Client.setAddress(sc.nextLine());
        String query = "insert into clients values(?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,Client.getClientId());
            pst.setString(2,Client.getName());
            pst.setString(3,Client.getNum());
            pst.setString(4, Client.getEmail());
            pst.setString(5,Client.getAddress());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        ClientManagement.choice();
    }
    //this function is written to view particular data.
    public void viewDetails() throws InvalidChoiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        Client.setName(sc.nextLine());
        String query = "select * from clients where Name = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,Client.getName());
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1)+"  ");
            System.out.println(rs.getString(2)+"  ");
            System.out.println(rs.getString(3)+"  ");
            System.out.println(rs.getString(4)+"  ");
            System.out.println(rs.getString(5)+"  ");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        ClientManagement.choice();
    }
    //this function is written to update the table.
    public void updateClient() throws InvalidChoiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        Client.setClientId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Updated client name: ");
        Client.setName(sc.nextLine());
        System.out.println("Enter Updated client Number: ");
        Client.setNum(sc.nextLine());
        System.out.println("Enter Updated Email Id: ");
        Client.setEmail(sc.nextLine());
        System.out.println("Enter Updated Address: ");
        Client.setAddress(sc.nextLine());
        String query = "Update clients set Name = ? , Contact = ? , Email = ? , Address = ? where Client_id = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,Client.getName());
            pst.setString(2,Client.getNum());
            pst.setString(3,Client.getEmail());
            pst.setString(4,Client.getAddress());
            pst.setInt(5,Client.getClientId());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        ClientManagement.choice();

    }
    //we can delete certain rows using this function.
    public void deleteClient() throws InvalidChoiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client Name: ");
        Client.setName(sc.nextLine());
        String query = "delete from clients where Name = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,Client.getName());
            int rows = pst.executeUpdate();
            System.out.println(rows+" Deleted");
            con.close();
        }
        catch (SQLIntegrityConstraintViolationException e){
            System.out.println("There are cases that are not closed for this client in cases table. Please close them to delete this client.");

        }
        catch (Exception e){

            System.out.println(e);
        }
        ClientManagement.choice();
    }
  
}
