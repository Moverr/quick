package tests;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.k15t.pat.ApplicationBootstrap;
import com.k15t.pat.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;
    private String getRootUrl() {
        return "http://localhost:" + port;
    }


    @Test
    public void contextLoads() { 
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    @Test
    public void registerUser() throws Exception {

        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setName("abu");
        user.setNumber("070567778");
        user.setPassword("admin");
        user.setAddress("buziga");
        ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/users", user, User.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

}
