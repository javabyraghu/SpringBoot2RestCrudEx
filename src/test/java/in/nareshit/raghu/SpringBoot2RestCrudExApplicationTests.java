package in.nareshit.raghu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
public class SpringBoot2RestCrudExApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("TEST SAVE OPERATION")
	@Order(1)
	public void testSaveProduct() throws Exception {
		//1. Create Dummy Request 
		MockHttpServletRequestBuilder request =
				MockMvcRequestBuilders
				.post("/apis/product/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"prodCode\": \"PEN\",\"prodCost\":200.0,\"prodVendor\": \"NIT\"}");

		//2. execute and read result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. read response
		MockHttpServletResponse response = result.getResponse();

		//4. Assert response
		assertEquals(201, response.getStatus());
		if(!response.getContentAsString().contains("created")) {
			fail("Product Not Saved!");
		}

	}

	@Test
	@DisplayName("TEST GET ALL OPERATION")
	@Order(2)
	public void testGetAllProducts() throws Exception {
		//1. Create mocked Request 
		MockHttpServletRequestBuilder request = 
				MockMvcRequestBuilders.get("/apis/product/all");

		//2. execute and read result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. read response
		MockHttpServletResponse response = result.getResponse();

		//4. Assert response
		assertEquals(200, response.getStatus());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}

	@Test
	@DisplayName("FROM DELETE ONE TEST")
	@Order(3)
	public void testDeleteOneProduct() throws Exception {
		//1. Create mocked Request 
		MockHttpServletRequestBuilder request = 
				MockMvcRequestBuilders.delete("/apis/product/remove/1");

		//2. execute and read result
		MvcResult result = mockMvc.perform(request).andReturn();

		//3. read response
		MockHttpServletResponse response = result.getResponse();

		//4. Assert response
		assertEquals(200, response.getStatus());
		if(!response.getContentAsString().contains("Product removed")) {
			fail("Unable to Delete Product");
		}
	}



}
