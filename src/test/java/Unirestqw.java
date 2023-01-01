import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;
import com.mashape.unirest.http.HttpResponse;


public class Unirestqw {
    @Test
    public void post_method() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post("https://gorest.co.in/public/v2/users")
                .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")

                .field("name", "farhan")
                .field("email", "nil26566@gmail.com")
                .field("gender","female")
                .field("status","active")
                .asJson();
        System.out.println(response.getBody());
        System.out.println(response.getStatus());

    }
    @Test
    public void get_method() throws UnirestException {
        HttpResponse<JsonNode> response1 = Unirest.get("https://gorest.co.in/public/v2/users/174")
                .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")


                .asJson();
        System.out.println(response1.getStatus());
        System.out.println(response1.getBody());

    }
    @Test
    public void put_method() throws UnirestException {
        HttpResponse<JsonNode> response2 = Unirest.put("https://gorest.co.in/public/v2/users/174")
                .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")

                .field("name","far")
                .asJson();
        System.out.println(response2.getStatus());

    }
    @Test
    public void delete_method() throws UnirestException {
        HttpResponse<JsonNode> response2 = Unirest.delete("https://gorest.co.in/public/v2/users/174")
                .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")

                .asJson();
        System.out.println(response2.getStatus());

    }


}
