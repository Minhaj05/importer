package com.spring26.section2.group15.importer.tabassum;

public class CarDetails {
    private String model;
    private String engineNo;
    private String chassisNo;
    private String condition;

    public CarDetails(String model, String engineNo, String chassisNo, String condition) {
        this.model = model;
        this.engineNo = engineNo;
        this.chassisNo = chassisNo;
        this.condition = condition;
    }

    public String getModel() {
        return model;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public String getCondition() {
        return condition;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "model='" + model + '\'' +
                ", engineNo='" + engineNo + '\'' +
                ", chassisNo='" + chassisNo + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
