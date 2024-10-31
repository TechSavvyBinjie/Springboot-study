package quickstart.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting {
    private long id;
    private LocalDate data;

    private LocalTime StartTime;
    private LocalTime EndTime;
    public boolean isOverlapping(Meeting other){
        return this.data.equals(other.data)&&(this.StartTime.isBefore(other.EndTime))&&this.EndTime.isAfter(other.StartTime);
    }
}
