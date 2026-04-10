package com.spring26.section2.group15.importer.tabassum;

public class update_import_status {
    private int id;
    private String source;
    private String status;

    public update_import_status(int id, String source, String status) {
        this.id = id;
        this.source = source;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "update_import_status{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
