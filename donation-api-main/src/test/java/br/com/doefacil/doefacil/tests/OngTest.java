package br.com.doefacil.doefacil.tests;

import br.com.doefacil.doefacil.pojo.Ong;
import br.com.doefacil.doefacil.utils.CommonMethods;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class OngTest extends CommonMethods {

	@AfterEach
	public void deleteAllOngsAfterTests(){
		_commonMethods.deleteAllOngsFromServer();
	}

	@Test
	@DisplayName("When search all ongs without save a ong, Then should return a empty list ")
	public void whenSearchAllOngsWithoutSaveOngItShouldReturnEmptyList() throws Exception{
		_commonMethods.deleteAllOngsFromServer();

		_commonMethods.GetAllOngs()
				.statusCode(HttpStatus.SC_OK)
				.body(equalTo(EMPTY_ONG_LIST));

	}
	@Test
	@DisplayName("When register a ong, Then ong should be saved with success ")
	public void whenRegisterOngItShouldBeSaveWithSuccess(){

		Ong registerOng = new Ong("001", "Ong Amigos","Avenida Brasil","ongamigos@gmail.com","81987658765","","Teste","www.ongamigos.com.br","81987658765","Caixa","1234","123456789");

		_commonMethods.RegisterOng(registerOng)
				.statusCode(HttpStatus.SC_CREATED)
				.body("_id",equalTo("001"))
				.body("ongName",equalTo("Ong Amigos"))
				.body("ongAddress",equalTo("Avenida Brasil"))
				.body("ongEmail",equalTo("ongamigos@gmail.com"))
				.body("ongPhone",equalTo("81987658765"))
				.body("ongImg",equalTo(""))
				.body("ongDescription",equalTo("Teste"))
				.body("ongSite",equalTo("www.ongamigos.com.br"))
				.body("ongPix",equalTo("81987658765"))
				.body("ongBankName",equalTo("Caixa"))
				.body("ongBankAgency",equalTo("1234"))
				.body("ongBankAccount",equalTo("123456789"));
	}

	@Test
	@DisplayName("When update a ong, then return updated ong with success")
	public void whenUpdateOngItShouldUpdatedWithSuccess(){

		Ong registerOng = new Ong("001", "Ong Amigos","Avenida Brasil","ongamigos@gmail.com","81987658765","","Teste","www.ongamigos.com.br","81987658765","Caixa","1234","123456789");

		_commonMethods.RegisterOng(registerOng);

		registerOng.setOngAddress("Avenida Brasil, numero 10");
		registerOng.setOngName("Ong Amigos 1");
		registerOng.setOngSite("www.ongamigos1.com.br");


		_commonMethods.UpdateOng(registerOng)
				.statusCode(HttpStatus.SC_OK)
				.body("_id",equalTo("001"))
				.body("ongName",equalTo("Ong Amigos 1"))
				.body("ongAddress",equalTo("Avenida Brasil, numero 10"))
				.body("ongEmail",equalTo("ongamigos@gmail.com"))
				.body("ongPhone",equalTo("81987658765"))
				.body("ongImg",equalTo(""))
				.body("ongDescription",equalTo("Teste"))
				.body("ongSite",equalTo("www.ongamigos1.com.br"))
				.body("ongPix",equalTo("81987658765"))
				.body("ongBankName",equalTo("Caixa"))
				.body("ongBankAgency",equalTo("1234"))
				.body("ongBankAccount",equalTo("123456789"));
	}

	CommonMethods _commonMethods = new CommonMethods();

	//RESPONSE
	private static final String EMPTY_ONG_LIST = "[]";



}
