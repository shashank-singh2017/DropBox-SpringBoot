package dropbox.dropbox.controller;

import dropbox.dropbox.model.ResponseModel;
import dropbox.dropbox.model.users;
import dropbox.dropbox.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(method= RequestMethod.POST , value="/users")
    public ResponseEntity<List<users>> getAllUsers(){
    List<users> users=    userService.findUsers() ;
    System.out.print("size: "+users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.POST , value="/doLogin")
    public ResponseEntity<String> validateUser(@RequestBody String user,HttpSession session) throws JSONException, IOException {
        JSONObject jsonObject;
        jsonObject = new JSONObject(user);
        ResponseModel model=new ResponseModel();
        List<users> users=    userService.login(jsonObject.getString("username"),jsonObject.getString("password")) ;
        System.out.print("size: "+users.size());
        if(users.size()>0) {

            session.setAttribute("sessionuser",jsonObject.getString("username"));
            System.out.print("session check: "+ session.getAttribute("sessionuser"));
            model.setResult("valid Login");
            model.setStatus(201);
            return new ResponseEntity(model, HttpStatus.CREATED);
        }
        else
        {
            model.setResult("invalid Login");
            return new ResponseEntity(model, HttpStatus.OK);
        }
    }


    @RequestMapping(method= RequestMethod.POST , value="/logout")
    public ResponseEntity<Boolean> logout(HttpSession session) throws JSONException {
        System.out.print("session value: "+session.getAttribute("name"));
        session.invalidate();
        return new ResponseEntity<Boolean>(true,HttpStatus.OK);
    }
}

