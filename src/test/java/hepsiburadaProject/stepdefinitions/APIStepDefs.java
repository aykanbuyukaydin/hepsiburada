package hepsiburadaProject.stepdefinitions;

import hepsiburadaProject.pojos.BookingDatesPojo;
import hepsiburadaProject.pojos.BookingPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIStepDefs {
    Response response;

    @Then("Kullanici kisiyi okumak icin {string} endpointe gider")
    public void kullaniciKisiyiOkumakIcinEndpointeGider(String endpoint) {
        response = given()
                .accept("application/json")
                .when()
                .get(endpoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();

        System.out.println("-----------------------------------------------------------------------------------");
    }

    @And("Status kodunun {int} oldugunu kontrol eder")
    public void statusKodununOldugunuKontrolEder(int statusKod) {
        System.out.println(response.getStatusCode());
        if(response.getStatusCode()==statusKod) {
            response.then().assertThat().
                    statusCode(statusKod).
                    contentType(ContentType.JSON);
            System.out.println("Status Kod Basarili");
        }else {
            System.out.println("Status Kod Basarisiz");
        }
    }


    @Then("Kullanici kisi eklemek icin {string} endpointe gider")
    public void kullaniciKisiEklemekIcinEndpointeGider(String endpoint) {
        BookingDatesPojo bookingDates = new BookingDatesPojo("2020-09-09","2020-09-21");
        BookingPojo booking = new BookingPojo("Aykan","Buyukaydin",35000,true,bookingDates);
        System.out.println(booking);

        response = given().
                contentType(ContentType.JSON).
                body(booking).
                when().
                post(endpoint);

        response.prettyPrint();

        System.out.println("-----------------------------------------------------------------------------------");

    }
}


