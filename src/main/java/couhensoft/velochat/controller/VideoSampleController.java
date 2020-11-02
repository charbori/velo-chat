package couhensoft.velochat.controller;

import couhensoft.velochat.service.VideoSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
