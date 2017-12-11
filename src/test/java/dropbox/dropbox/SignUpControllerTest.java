package dropbox.dropbox;

import dropbox.dropbox.controller.LoginController;
import dropbox.dropbox.controller.SignUpController;
import dropbox.dropbox.model.ResponseModel;
import dropbox.dropbox.model.users;
import dropbox.dropbox.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SignUpController.class, secure = false)
public class SignUpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userservice;

    ResponseModel model=new ResponseModel(null,"User added",201);
    String exampleCourseJson = "{\"firstname\":\"abhineet\",\"lastname\":\"gupta\",\"email\":\"abhineet@gmail.com\",\"password\":\"123456\"}";
    @Test
    public  void addUserTest() throws Exception
    {
        Mockito.when(userservice.addUser(Mockito.any(users.class))).thenReturn(model);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:8080/users/doSignUp")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(exampleCourseJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }
}
