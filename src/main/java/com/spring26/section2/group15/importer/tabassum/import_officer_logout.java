package com.spring26.section2.group15.importer.tabassum;

public class import_officer_logout {
    private String message;
    private boolean confirm;

    public import_officer_logout(String message, boolean confirm) {
        this.message = message;
        this.confirm = confirm;
    }

    public String getMessage() {
        return message;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "import_officer_logout{" +
                "message='" + message + '\'' +
                ", confirm=" + confirm +
                '}';
    }
}
