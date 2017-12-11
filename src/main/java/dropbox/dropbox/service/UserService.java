package dropbox.dropbox.service;

import dropbox.dropbox.model.ResponseModel;
import dropbox.dropbox.model.users;
import dropbox.dropbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.*;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private String dir = System.getProperty("user.dir");
    private String USER_FOLDER = dir+"/UserData/";

    BufferedWriter bw = null;
    FileWriter fw = null;

    ResponseModel model=new ResponseModel();

    public List<users> findUsers(){
        return userRepository.findAllByEmail("mohit@gmail.com");
    }

    public ResponseModel addUser(users users) throws IOException {
        if(checkUserExists(users.getEmail())) {
            model.setResult("User Exists");
            return model;
        }
        else
        {
            userRepository.save(users);
            model.setResult("User added");
            model.setStatus(201);

            /* creating user specific upload directory */

            File theDir = new File(USER_FOLDER+users.getEmail());
            theDir.mkdir();

            /* creating user specific log file */

            fw = new FileWriter(USER_FOLDER+users.getEmail()+"/"+users.getEmail()+".txt");
            bw = new BufferedWriter(fw);
            bw.write("");

            return model;
        }
    }

    public List<users> login(String email, String password) throws IOException {
        List<users> user= new ArrayList<>();
        System.out.print("emil:"+email);
         user= userRepository.findAllByEmail(email);
        if(BCrypt.checkpw(password,user.get(0).getPassword()))
        {
            FileWriter writer = new FileWriter(USER_FOLDER+email+"/"+email+".txt",true);
            writer.write("Logged in SuccessFully"+" on date: "+new Date().toString());
            writer.write("\r\n");
            writer.close();
            return user;
        }
        else {
            return new ArrayList<>();
        }
    }

    public boolean checkUserExists(String email)
    {
        boolean flag=false;
        List<users> users= userRepository.findAllByEmail(email);

        if(users.size()>=1)
        {
            flag=true;
        }
        else {
            flag = false;
        }
        return flag;
    }
}
