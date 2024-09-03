package com.cts.dao;

import com.cts.exception.InvalidChoiceException;
import com.cts.model.Document;
import com.cts.utill.DBConnection;
import com.cts.service.DocumentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DocumentDAO {

   DBConnection databaseConnections = new DBConnection();
    Document Document = new Document();

    public void uploadDocument() throws InvalidChoiceException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter document title: ");
        Document.setTitle(sc.nextLine());
        System.out.println("Enter description: ");
        Document.setDes(sc.nextLine());
        System.out.println("Enter Path: ");
        Document.setPath(sc.nextLine());
        System.out.println("Enter date(YYYY-MM-DD): ");
        Document.setDate(sc.nextLine());
        String query = "insert into documents(Title,Description,File_Path,Upload_Date) values(?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
           
            pst.setString(1,Document.getTitle());
            pst.setString(2,Document.getDes());
            pst.setString(3,Document.getPath());
            pst.setString(4, Document.getDate());
            int rows = pst.executeUpdate();
            System.out.println(rows+" rows affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        DocumentManagement.choice();
    }
  
    public void viewDocument() throws InvalidChoiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Title: ");
        Document.setTitle(sc.nextLine());
        String query = "select * from documents where Title = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, Document.getTitle());
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1)+"  ");
            System.out.println(rs.getString(2)+"  ");
            System.out.println(rs.getString(3)+"  ");
            System.out.println(rs.getString(4)+"  ");
            System.out.println(rs.getDate(5)+"  ");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        DocumentManagement.choice();
    }
   
    public void updateDocument() throws InvalidChoiceException{
        String prevName;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter updated document title: ");
        Document.setTitle(sc.nextLine());
        System.out.println("Enter updated description: ");
        Document.setDes(sc.nextLine());
        System.out.println("Enter updated Path: ");
        Document.setPath(sc.nextLine());
        System.out.println("Enter updated date(YYYY-MM-DD): ");
        Document.setDate(sc.nextLine());
        System.out.println("Enter Previous Title: ");
        prevName = sc.nextLine();
        String query = "Update documents set Title = ? , Description = ? , File_Path = ? , Upload_Date = ? where Title = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, Document.getTitle());
            pst.setString(2, Document.getDes());
            pst.setString(3, Document.getPath());
            pst.setString(4, Document.getDate());
            pst.setString(5,prevName);
            int rows = pst.executeUpdate();
            System.out.println(rows+" Rows Affected");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        DocumentManagement.choice();
    }
    
    public void deleteDocument() throws InvalidChoiceException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Title: ");
        Document.setTitle(sc.nextLine());
        String query = "delete from documents where Title = ?";
        try {
            Connection con = DriverManager.getConnection(databaseConnections.getUrl(), databaseConnections.getUserName(), databaseConnections.getPassword());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,Document.getTitle());
            int rows = pst.executeUpdate();
            System.out.println(rows+" Deleted");
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
        DocumentManagement.choice();
    }
  
}
