package tests.apiTests;


import base.ApiBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class TestCRUDProducts extends ApiBase {

    String endpoint = "/api_testing/products/read.php";

    @Test
    public void getCategoryTest(){
        Response getCategories = getRequest(baseUrlLocal, null, null, endpoint);

    }


//    @Test
//    public void getProductTest(){
//        String endpoint = "/api_testing/product/read_one.php";
//        given().baseUri(baseUrl).queryParam("id", 2).
//                when().get(endpoint).
//                then().assertThat().log().body().statusCode(200).
//                body("price", is(equalTo("299.00")));
//    }
//
//    @Test
//    public void createProductTest(){
//        String endpoint = "/api_testing/product/create.php";
//        String requestBody = """
//                {"name" : "Ershik",
//                "description" : "Maqur ershik 2 amsakan shan msic",
//                "price": 10000,
//                "category_id": 4
//                }
//                """;
//       var response =  given().baseUri(baseUrl).body(requestBody).
//                when().post(endpoint).
//                then().log().body();
//    }
//
//    @Test
//    public void editProductTest(){
//        String endpoint = "/api_testing/product/update.php";
//        String requestBody = """
//                {"id": 27,
//                "name" : "NRBERSHIK --- ****",
//                "description" : "Maqur NBERSHIK"
//                }
//                """;
//        var response =  given().baseUri(baseUrl).body(requestBody).
//                when().put(endpoint).
//                then().log().body();
//    }
//
//    @Test
//    public void deleteProductTest(){
//        String endpoint = "/api_testing/product/delete.php";
//        String requestBody = """
//                {"id": 26
//                }
//                """;
//        var response =  given().baseUri(baseUrl).body(requestBody).
//                when().delete(endpoint).
//                then().log().body();
//    }
//
//    @Test
//    public void createSerializedProductTest(){
//        String endpoint = "/api_testing/product/create.php";
////        Product product = new Product(
////                "Ershik",
////                "Maqur ershik 2 amsakan shan msic",
////                1000,
////                3
////        );
////        var response =  given().baseUri(baseUrl).body(product).
////                when().post(endpoint).
////                then().log().body();
//
//    }

    @Test
    public void updateSerializedProductTest(){
        String endpoint = "/api_testing/product/update.php";
//        Product productUpdate = new Product(
//                26,
//                "Ershik - KOLBASA",
//                "Maqur ershik 2 amsakan shan msic",
//                1000,
//                3
//        );
//        var response =  given().baseUri(baseUrl).body(productUpdate).
//                when().put(endpoint).
//                then().log().body();

    }

    //GET product Deserialize
    @Test
    public void getSerializedProductTest(){
        String endpoint = "/api_testing/product/read_one.php";
//        Product productExpected = new Product(
//                28,
//                "Ershik",
//                "Maqur ershik 2 amsakan shan msic",
//                1000,
//                3,
//                "Active Wear - Unisex"
//        );
//        Product actualProduct =  given().baseUri(baseUrl).queryParam("id", 28).
//                when().get(endpoint).as(Product.class);
//        assertThat(actualProduct, samePropertyValuesAs(productExpected));

    }


}
