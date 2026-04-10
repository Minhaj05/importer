package com.spring26.section2.group15.importer.tabassum;

import java.time.LocalDate;

public class generate_report {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reportText;

    public generate_report(LocalDate fromDate, LocalDate toDate, String reportText) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reportText = reportText;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public String getReportText() {
        return reportText;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    @Override
    public String toString() {
        return "generate_report{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", reportText='" + reportText + '\'' +
                '}';
    }
}
