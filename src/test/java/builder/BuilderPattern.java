package builder;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mashape.unirest.http.HttpResponse;


 class Unirest_tes  {
   private String url;
   private String url_post;
   private String name;
   private String email;
   private String gender;
   private String status;
   private String ch_name;
     @Test
     public void post_method() throws UnirestException {
         HttpResponse<JsonNode> response = Unirest.post(this.url_post)
                 .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")

                 .field("name", this.name)
                 .field("email",this.email)
                 .field("gender",this.gender)
                 .field("status",this.status)
                 .asJson();
         System.out.println(response.getBody());
         System.out.println(response.getStatus());

     }
     @Test
     public void get_method() throws UnirestException {
         HttpResponse<JsonNode> response1 = Unirest.get(this.url)
                 .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")


                 .asJson();
         System.out.println(response1.getStatus());
         System.out.println(response1.getBody());

     }
     @Test
     public void put_method() throws UnirestException {
         HttpResponse<JsonNode> response2 = Unirest.put(this.url)
                 .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")

                 .field("name",this.ch_name)
                 .asJson();
         System.out.println(response2.getStatus());


     }
     @Test
     public void delete_method() throws UnirestException {
         HttpResponse<JsonNode> response2 = Unirest.delete(this.url)
                 .header("Authorization", "Bearer 32c80880fe3786cc2f271303a83d13c186ffe28e512260b97fc4dd5c151ff64f")

                 .asJson();
         System.out.println(response2.getStatus());

     }

    private Unirest_tes(Unirest_tesBuilder builder){
        this.url=builder.url;
        this.url_post=builder.url_post;

    }
    public static class Unirest_tesBuilder {
        private String url;
        private String url_post;
        private String name;
        private String email;
        private String gender;
        private String status;
        private String ch_name;

        public Unirest_tesBuilder(String url,String url_post) {
            this.url=url;
            this.url_post=url_post;
        }
        public Unirest_tesBuilder set_post(String name,String email,String gender,String status){
            this.name=name;
            this.email=email;
            this.gender=gender;
            this.status=status;
            return this;
        }
        public Unirest_tesBuilder set_put(String ch_name){
            this.ch_name=ch_name;
            return this;
        }
        public Unirest_tes build(){
            return  new Unirest_tes(this);
        }
    }


}
public class BuilderPattern{
    public static void main(String[] args) throws UnirestException
    {

        Unirest_tes firstTest= new Unirest_tes.Unirest_tesBuilder(
                "https://gorest.co.in/public/v2/users/186",
                "https://gorest.co.in/public/v2/users").set_post("ratul","ratul@gmail.com","male","active")
                .set_put("rafi").build();
        firstTest.post_method();
        firstTest.get_method();
        firstTest.put_method();
        firstTest.delete_method();

    }
}
