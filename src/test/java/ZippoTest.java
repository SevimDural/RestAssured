
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZippoTest {
    @Test
    public void test() {
        given()
                // hazirlik islemlerini yapiyoruz
                .when()
                // link ve aksiyon islmeleri
                .then()

        // test ve extrackt islemleri

        ;

    }

    @Test
    public void statusCodeTest() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()  // log().all diyince tum respons u verecek. body diyince sadece body kkismindakileri
                .statusCode(200)

        ;
    }

    @Test
    public void contentTypeTest() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
        ;

    }

    @Test
    public void logAllTest() {
        given()
                .log().all()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()

        ;

    }

    @Test
    public void checkStateInResponseBody() {
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body()
                //.body("country", equalTo("United States"))  // body.country==United States

                //.body("places[0].state", equalTo("California")) // altaki ile ayni
                //.statusCode(200)
                .body("places.'state'", hasItem("California"));



        ;

    }


}
