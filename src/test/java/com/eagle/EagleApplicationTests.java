package com.eagle;

import com.eagle.model.StudentPD;
import com.eagle.model.StudentSD;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EagleApplicationTests {

	private static final String BASE_URL = "http://localhost:8090/rest/eagle";
	TestRestTemplate testRestTemplate = new TestRestTemplate();
	//POST
	@Test
	public void postStudentpdTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		StudentPD studentpd = new StudentPD("6","Tom","1/3/2007",10,"Mr.Doe","8847852987","doetom@gmail.com","O-");
		ResponseEntity<String> result = testRestTemplate.postForEntity(BASE_URL + "/addStudentpd" , studentpd, String.class);
		assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
		System.out.println(result);
	}
	//POST
	@Test
	public void postStudentsdTest() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		StudentSD studentsd = new StudentSD("4","6/8/2016","hjhj","white","05/10/2017","05/12/2017","jhjk","kjlkj","kjh","four","ijoi","lkji","05/11/2017","500");
		ResponseEntity<String> result = testRestTemplate.postForEntity(BASE_URL + "/addStudentsd" , studentsd, String.class);
		assertThat(result.getStatusCode(), equalTo(HttpStatus.CREATED));
		System.out.println(result);
	}
	//DELETE
	@Test
	public void deleteStudentpdTest() throws Exception {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<StudentPD> responseEntity = testRestTemplate.exchange(BASE_URL + "/deleteStudentpd/{id}",
				HttpMethod.DELETE, null, StudentPD.class, 3);

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.NO_CONTENT));
		assertThat(responseEntity.getBody(), nullValue());
		System.out.println(responseEntity);
	}
	@Test
	public void deleteStudentsdTest() throws Exception {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<StudentSD> responseEntity = testRestTemplate.exchange(BASE_URL + "/deleteStudentsd/{id}",
				HttpMethod.DELETE, null, StudentSD.class, 2);

		assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.NO_CONTENT));
		assertThat(responseEntity.getBody(), nullValue());
		System.out.println(responseEntity);
	}
	//GET
	@Test
	public void getByStudentpdIdTest() {

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		final StudentPD resource = testRestTemplate.getForObject(BASE_URL + "/getStudentpdbyID/{id}", StudentPD.class, "3");

		assertThat(resource, notNullValue());
		System.out.println(resource);
	}

	@Test
	public void getByStudentsdIdTest() {

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		final StudentSD resource = testRestTemplate.getForObject(BASE_URL + "/getStudentsdbyID/{id}", StudentSD.class, "1");

		assertThat(resource, notNullValue());
		System.out.println(resource);
	}

	//UPDATE
	@Test
	public void putStudentpdTest() {
		final HttpHeaders headers = new HttpHeaders();
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final StudentPD studentpd = new StudentPD("4","TESTUpdate","1/3/2005",13,"TESTPARENT","7788877888","test@gmail.com","A");
		final HttpEntity<StudentPD> requestUpdate = new HttpEntity<>(studentpd, headers);
		final ResponseEntity<StudentPD> response = testRestTemplate.exchange(BASE_URL + "/updateStudentpd?studentId=4", HttpMethod.PUT,
				requestUpdate, StudentPD.class);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	public void putStudentsdTest() {
		final HttpHeaders headers = new HttpHeaders();
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final StudentSD studentsd = new StudentSD("2","6/8/2016","hjhj","white","05/10/2017","05/12/2017","jhjk","kjlkj","kjh","four","ijoi","lkji","05/11/2017","500");
		final HttpEntity<StudentSD> requestUpdate = new HttpEntity<>(studentsd, headers);
		final ResponseEntity<StudentSD> response = testRestTemplate.exchange(BASE_URL + "/updateStudentsd?studentId=2", HttpMethod.PUT,
				requestUpdate, StudentSD.class);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	public void contextLoads() {
	}

}
