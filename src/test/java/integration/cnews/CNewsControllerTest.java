package integration.cnews;




import cnews.modals.User;

import cnews.security.SecurityConfig;
import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("/test-servlet-context.xml")
public class CNewsControllerTest {

  @Autowired
  private WebApplicationContext wac;

  @Autowired
  private Filter springSecurityFilterChain;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).
      apply(springSecurity()).
      addFilters(springSecurityFilterChain).build();
  }

  @Test
  public void testStartPage() throws Exception {
    mockMvc.perform(get("/").accept("text/html")).andExpect(status().isOk());
  }


  @Test
  public void successfulLogin() throws Exception {
    mockMvc.perform(
      post("/login").
      with(csrf()).param("login", "testuser").param("password", "12345")).
      andExpect(status().isOk()).
      andExpect(model().attribute("user", new User("testuser", "12345"))
    );
  }


  @Test
  public void unknownLogin() throws Exception {
    mockMvc.perform(post("/login").
      with(csrf()).
      param("login", "unknownuser").param("password","123")).
      andExpect(status().is(500)).
      andExpect(model().attribute("error", "Error. Incorrect login or password"));
  }


  @Test
  public void wrongPassword() throws Exception {
    mockMvc.perform(post("/login").
      with(csrf()).
      param("login", "testuser").param("password","wrongpasswd")).
      andExpect(status().is(500)).
      andExpect(model().attribute("error", "Error. Incorrect login or password"));
  }

  @Test
  public void invalidCsrfToken() throws Exception {
    mockMvc.perform(post("/login").with(csrf().useInvalidToken()).
      param("login", "testuser").param("password", "12345")).
      andExpect(status().isForbidden());
  }
}
