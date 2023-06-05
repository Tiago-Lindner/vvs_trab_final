package dev.ifrs.teste;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.*;

@QuarkusTest
public class TestQuarkus {

    @Test
    @DisplayName("Login test")
    public void testLogin() {
        given()
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
          .body("nome=Tiago&senha=123")
          .when() .post("/testeQ") .then()
             .statusCode(200)
             .body(is("Logado"));
    }

    @Test
    @DisplayName("Senha incorreta test")
    public void testLogin2() {
        given()
          .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
          .body("nome=Tiago&senha=444")
          .when() .post("/testeQ") .then()
             .statusCode(200)
             .body(is("Credenciais incorretas"));
    }
}
