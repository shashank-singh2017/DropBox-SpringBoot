package dropbox.dropbox.controller;

import dropbox.dropbox.model.ResponseModel;
import dropbox.dropbox.model.activity;
import dropbox.dropbox.model.files;
import dropbox.dropbox.service.ActivityService;
import dropbox.dropbox.service.FileService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")

public class ActivityController {
    @Autowired
    private ActivityService activityService;
    ResponseModel model=new ResponseModel();

    @RequestMapping(path = "/fetchActivity",method = RequestMethod.GET)
    public ResponseEntity<activity> getActivity(HttpSession session) throws IOException {
        if(session.getAttribute("sessionuser")==null)
        {

            return new ResponseEntity(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
        }
        else
        {

            List<activity> activities= activityService.findActivities((String)session.getAttribute("sessionuser"));
            return new ResponseEntity(activities,HttpStatus.CREATED);
        }
    }
}