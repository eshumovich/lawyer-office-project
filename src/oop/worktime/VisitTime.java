package oop.worktime;

import java.time.LocalDateTime;

public class VisitTime {

    private int minutes;
    private int hours;
    private LocalDateTime visitDateTime;

    public VisitTime(int minutes, int hours, LocalDateTime visitDateTime) {
        this.minutes = minutes;
        this.hours = hours;
        this.visitDateTime = visitDateTime;
    }

    public VisitTime(int minutes, int hours) {
        this.minutes = minutes;
        this.hours = hours;
    }

    public int totalMinutes() {
        return minutes + hours * 60;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public LocalDateTime getVisitDateTime() {
        return visitDateTime;
    }

    public void setVisitDateTime(LocalDateTime visitDateTime) {
        this.visitDateTime = visitDateTime;
    }
}
