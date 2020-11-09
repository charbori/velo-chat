package couhensoft.velochat.controller;

import couhensoft.velochat.service.VideoSampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/videoSample")
//request메서드만 사용
public class VideoSampleController {

    //private final File MP4_FILE = new File("C:\\Users\\binst\\Downloads\\sample.mp4");
    VideoSampleService videoSampleService;

    public VideoSampleController(VideoSampleService videoSampleService){
        this.videoSampleService = videoSampleService;
    }

    @GetMapping("/stream/{fileType}/{fileName}")
    public ResponseEntity<byte[]> staticVideo(@RequestHeader(value="Range", required=false) String httpRangeList,
                                              @PathVariable("fileType") String fileType,
                                              @PathVariable("fileName") String fileName) throws IOException {
        return videoSampleService.sendVideo(fileName, fileType, httpRangeList);
    }
}
