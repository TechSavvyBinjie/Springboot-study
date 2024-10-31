package quickstart.controller;

import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quickstart.entity.Meeting;
import quickstart.service.MeetingService;

@RestController
@RequestMapping("/v2")
public class MeetingController {
    @Resource
    private MeetingService meetingService;
    @PostMapping("/check")
    public ResponseEntity<String> checkAvailability(@RequestBody Meeting meeting){
        if (meetingService.isRoomAvailable(meeting)){
            meetingService.addMeeting(meeting);
            return ResponseEntity.ok("会议可用，预定成功");
        }
        else return ResponseEntity.status(409).body("会议不可用");
    }
}
