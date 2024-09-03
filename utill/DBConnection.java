package com.cts.utill;

public class DBConnection {


    private final String url = "jdbc:mysql://localhost:3306/lawFirmDB";
    private final String userName = "root";
    private final String password = "Richu@011";
    public String getUrl() {
        return url;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
}
