package com.spring26.section2.group15.importer.Shafuath.model;

public class admin_activity {

    private int id;
    private String user;
    private String action;
    private String time;
    private String status;

    public admin_activity(int id, String user, String action, String time, String status){
        this.id = id;
        this.user = user;
        this.action = action;
        this.time = time;
        this.status = status;
    }

    public int getId(){ return id; }
    public String getUser(){ return user; }
    public String getAction(){ return action; }
    public String getTime(){ return time; }
    public String getStatus(){ return status; }

    public void setId(int id){ this.id=id; }
    public void setUser(String user){ this.user=user; }
    public void setAction(String action){ this.action=action; }
    public void setTime(String time){ this.time=time; }
    public void setStatus(String status){ this.status=status; }

    @Override
    public String toString(){
        return user + " - " + action;
    }
}
