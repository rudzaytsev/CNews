package integration.cnews;



import cnews.controllers.NewsController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration("/test-servlet-context.xml")
@ActiveProfiles("test")
public class CNewsControllerTest {

  @Autowired
  private WebApplicationContext wac;


  private MockMvc mockMvc;

  @Before
  public void setup() {
    //mockMvc = MockMvcBuilders.standaloneSetup(NewsController.class).dispatchOptions(true).build();
    mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void testStartPage() throws Exception {
    mockMvc.perform(get("/").accept("text/html")).andDo(print()).andExpect(status().isOk());

  }
}
