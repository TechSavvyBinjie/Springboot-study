package springbootweb.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Slf4j
@Controller
@CrossOrigin
public class SseController {

    @RequestMapping(value = "/server/info", method = {RequestMethod.GET}, produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter pushMsg() throws IOException {
        final SseEmitter emitter = new SseEmitter(0L);
        log.info("emitter push message .......");
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        emitter.send(list.toString(), MediaType.TEXT_EVENT_STREAM);
        return emitter;
    }

    @RequestMapping(value = "/server/data", method = {RequestMethod.GET}, produces = "text/event-stream;charset=UTF-8")
    public ResponseBodyEmitter push() throws InterruptedException, IOException {
        final SseEmitter emitter = new SseEmitter(0L);
        Thread.sleep(1000);
        double money = Math.random() * 10;
        DecimalFormat df = new DecimalFormat(".00");
        String param = df.format(money);
        emitter.send("白菜价格行情:" + param + "元" + "\n\n", MediaType.TEXT_EVENT_STREAM);
        return emitter;
    }
}