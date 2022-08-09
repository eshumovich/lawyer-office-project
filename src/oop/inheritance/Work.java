package oop.inheritance;

import java.math.BigDecimal;

public abstract class Work {

    private String severity;
    private BigDecimal price;

    public Work(String severity, BigDecimal price) {
        this.severity = severity;
        this.price = price;
    }

    public Work() {
    }

    public abstract void provideWork();

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
