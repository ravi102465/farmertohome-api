package com.rsg.framertohomeapi.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rsg.framertohomeapi.models.UserDetail;
import com.rsg.framertohomeapi.repositories.UserRepository;

@RunWith(SpringRunner.class)
@AutoConfigureWebClient
@WebAppConfiguration
@WebMvcTest(UserDetailController.class)
class UserDetailControllerTest {

	@Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @MockBean
	private UserRepository userRepository;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    private  List<UserDetail> userDetails = new ArrayList<>();
    private UserDetail userDetail1 = new UserDetail();
    private UserDetail userDetail2 = new UserDetail();
	{
	
	
	userDetail1.setUserId(1);
	userDetail1.setFirstName("test");
	userDetail1.setEmail("xyz@gmail.com");
	
	
	userDetail2.setUserId(2);
	userDetail2.setFirstName("test2");
	userDetail2.setEmail("xyz@gmail.com2");
	
	userDetails.add(userDetail1);
	userDetails.add(userDetail2);}
	
	
    @Test
    public void whenGettingAllUsersAndNoData_thenSuccess() throws Exception{

    	System.out.println(userDetail1.getEmail());
        mockMvc.perform(get("/api/v1/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(0)));
    }
    
    @Test
    public void whenGettingAllUsersAndData_thenSuccess() throws Exception{

    	when(userRepository.findAll()).thenReturn(userDetails);
        mockMvc.perform(get("/api/v1/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].userId",is(1)))
            .andExpect(jsonPath("$[1].email",is("xyz@gmail.com2")));
        
    }

}
