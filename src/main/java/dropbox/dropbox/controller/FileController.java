package dropbox.dropbox.controller;

import com.mongodb.util.JSON;
import dropbox.dropbox.model.*;
import dropbox.dropbox.service.FileService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class FileController {
    @Autowired
    private FileService fileService;
    private static String dir = System.getProperty("user.dir");
    private static String USER_FOLDER = dir+"/UserData/";

    ResponseModel model=new ResponseModel();

    @RequestMapping(path = "/getImg",method = RequestMethod.GET)
    public ResponseEntity<?> listFiles( HttpSession session) throws JSONException {
        if(session==null)
        {
            System.out.print("session timout: "+session.getAttribute("sessionuser"));
            return new ResponseEntity(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
        }
        else
        {
            System.out.print("session in: "+session.getAttribute("sessionuser"));

            File[] files=fileService.findFiles((String)session.getAttribute("sessionuser"));
            model.setResArray(files);
            return new ResponseEntity(model,HttpStatus.CREATED);
        }
    }

    @RequestMapping(path = "/upload",method = RequestMethod.POST)
    public ResponseEntity<files> uploadFiles(@RequestParam("mypic") MultipartFile file,
                                             @RequestParam("username") String name,
                                             HttpSession session) throws JSONException, IOException {
        System.out.print("upload called: "+ session.getAttribute("sessionuser"));

        if(session==null)
        {
            System.out.print("session timout: "+session);
            return new ResponseEntity(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
        }
        else
        {
            if (file.isEmpty()) {
                System.out.print("message: Please select a file to upload");
                return new ResponseEntity(new ArrayList<>(),HttpStatus.CREATED);
            }
            else
            {
                try {
                    // Get the file and save it somewhere
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(USER_FOLDER + session.getAttribute("sessionuser")+"/"+file.getOriginalFilename());
                    Files.write(path, bytes);

                    FileWriter writer = new FileWriter(USER_FOLDER+ session.getAttribute("sessionuser")+"/"+session.getAttribute("sessionuser")+".txt",true);
                    writer.write("File uploaded by The User"+" at : "+new Date().toString());
                    writer.write("\r\n");
                    writer.close();

                    System.out.print("message: You successfully uploaded '" + file.getOriginalFilename() + "'");

                } catch (IOException e) {
                    e.printStackTrace();
                }

                File[] files=fileService.findFiles((String)session.getAttribute("sessionuser"));//to be changed
                return new ResponseEntity(files,HttpStatus.CREATED);
            }
        }
    }


    @RequestMapping(path = "/createFolder",method = RequestMethod.POST)
    public ResponseEntity<files> createFolder(@RequestBody String name,
                                              HttpSession session) throws JSONException, IOException{
        System.out.println("Create folder called..");
        if(session==null)
        {
            System.out.println("Session doesn't exist");
            return new ResponseEntity(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
        }
        else
            {
            try {
                System.out.println("folder name to create: "+ name);
                File theDir = new File(USER_FOLDER+session.getAttribute("sessionuser")+"/"+name);
                theDir.mkdir();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            File[] files=fileService.findFiles((String) session.getAttribute("sessionuser"));
            return new ResponseEntity(files, HttpStatus.CREATED);
        }
    }

    @RequestMapping(path = "/createSharedFolder",method = RequestMethod.POST)
    public ResponseEntity<files> createSharedFolder(@RequestBody String data,
                                                    HttpSession session) throws JSONException, IOException {
        System.out.println("Create Shared Folder Called..");
        JSONObject json=new JSONObject(data);

        if(session == null) {
            System.out.println("Session doesn't exist");
            return new ResponseEntity(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
        }
        else {
            try {
                System.out.println("Shared Folder name to create: "+json.getString("sharedFolderName"));

                File theDir = new File(USER_FOLDER+session.getAttribute("sessionuser")+"/"+"Shared - "+json.getString("sharedFolderName"));
                theDir.mkdir();
                 String userEmails = json.getString("userlist");
                // Insert Folder name and admin into folders collection.
                folders _folder=new folders();
                _folder.setAdmin(""+session.getAttribute("sessionuser"));
                _folder.setFolderName(json.getString("sharedFolderName"));
                fileService.addFolder(_folder);


                String[] emails = userEmails.split(",");

                System.out.println("User lists to share the folder with: "+ emails);
                for(int i=0;i<emails.length;i++) {
                    //Insert Folder Details into the folderDetails Collection.
                      folderDetails _folderDetails = new folderDetails();
                    _folderDetails.setFolderName(""+json.getString("sharedFolderName"));
                    _folderDetails.setGroupMember(emails[i]);
                    fileService.addFolderDetails(_folderDetails);

                    File crDir = new File(USER_FOLDER+emails[i]+"/"+"Shared - "+json.getString("sharedFolderName"));
                    crDir.mkdir();
                }

            }
            catch(Exception e) {
                e.printStackTrace();
            }
            File[] files = fileService.findFiles((String) session.getAttribute("sessionuser"));
            return new ResponseEntity(files, HttpStatus.CREATED);
        }
    }
}

