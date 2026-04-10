package com.spring26.section2.group15.importer.tabassum;

public class importOfficer {
    private int officerId;
    private String name;
    private String department;

    public importOfficer(int officerId, String name, String department) {
        this.officerId = officerId;
        this.name = name;
        this.department = department;
    }

    public int getOfficerId() {
        return officerId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setOfficerId(int officerId) {
        this.officerId = officerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "importOfficer{" +
                "officerId=" + officerId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
