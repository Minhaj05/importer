package com.spring26.section2.group15.importer.Shafuath.model;

public class Access {

    private String user;
    private String role;

    public Access(String user, String role){
        this.user = user;
        this.role = role;
    }

    public String getUser(){ return user; }
    public String getRole(){ return role; }

    public void setUser(String user){ this.user = user; }
    public void setRole(String role){ this.role = role; }

    @Override
    public String toString(){
        return user + " - " + role;
    }
}
