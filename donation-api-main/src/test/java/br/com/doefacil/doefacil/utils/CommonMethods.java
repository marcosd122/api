package br.com.doefacil.doefacil.utils;

import br.com.doefacil.doefacil.pojo.Ong;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.core.IsEqual;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CommonMethods {

    public void deleteAllOngsFromServer() {
        given()
                .log().all().
        when()
                .delete(BASE_URL_PATH + PATH_DEFAULT + DELETE_ALL_ONG)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body(new IsEqual<>(DELETE_ALL_MESSAGE));
    }

    public ValidatableResponse GetAllOngs() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL_PATH + PATH_DEFAULT + SEARCH_ALL_ONG)
                .then();
    }

    public ValidatableResponse RegisterOng(Ong ongForRegister) {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(ongForRegister)
                .when()
                .post(BASE_URL_PATH + PATH_DEFAULT + REGISTER_ONG)
                .then();
    }

    public ValidatableResponse UpdateOng(Ong ongForUpdate){
        String GET_ID_UPDATED_ONG = "/" + ongForUpdate.get_id();
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(ongForUpdate)
                .when()
                .put(BASE_URL_PATH + PATH_DEFAULT + UPDATE_ONG + GET_ID_UPDATED_ONG)
                .then();
    }

    //PATH
    private static final String BASE_URL_PATH = "http://localhost:8080/";
    private static final String PATH_DEFAULT = "api/ong/";
    private static final String SEARCH_ALL_ONG = "list";
    private static final String SEARCH_ONG_BY_ID = "details";
    private static final String REGISTER_ONG = "register";
    private static final String UPDATE_ONG = "update";
    private static final String DELETE_ALL_ONG = "delete/all";
    private static final String DELETE_ONG_BY_ID = "delete";

    //RESPONSE
    private static final String DELETE_ALL_MESSAGE = "Todas as Ongs foram deletadas";


}
