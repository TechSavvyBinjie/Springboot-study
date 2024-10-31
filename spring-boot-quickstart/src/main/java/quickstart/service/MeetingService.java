package quickstart.service;

import org.springframework.stereotype.Service;
import quickstart.entity.Meeting;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {
private final List<Meeting> meetings=new ArrayList<>();
public boolean isRoomAvailable(Meeting newMeeting){
    return meetings.stream().noneMatch(existingMeeting->existingMeeting.isOverlapping(newMeeting));
}
public void addMeeting(Meeting meeting){
    meetings.add(meeting);
}
}
