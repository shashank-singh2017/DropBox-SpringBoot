package dropbox.dropbox.service;

import dropbox.dropbox.model.ResponseModel;
import dropbox.dropbox.model.activity;
import dropbox.dropbox.model.users;
import dropbox.dropbox.repository.ActivityRepository;
import dropbox.dropbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    private static String dir = System.getProperty("user.dir");
    private static String USER_FOLDER = dir+"/UserData/";
    String line = "";
    ResponseModel model=new ResponseModel();

    public List<activity> findActivities(String username) throws IOException {

        FileReader filerdr = new FileReader(USER_FOLDER+username+"/"+username+".txt");
        BufferedReader bfrrdr = new BufferedReader(filerdr);
        List<activity>  _activities = new ArrayList<>();

        while((line = bfrrdr.readLine()) != null) {
            activity _act = new activity();
            _act.setActivity(line);
            _activities.add(_act);
        }

 bfrrdr.close();


        return _activities;
    }



}
