package rest;

import com.google.gson.Gson;
import dto.ChuckDTO;
import dto.CombinedJokesDTO;
import dto.DadDTO;
import entities.ChuckJoke;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

@Path("jokes")
public class JokeResource {

    @Context
    private UriInfo context;
    
    Gson gson = new Gson();

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        
        return "test";
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException {
        
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
        
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);
        
        CombinedJokesDTO comb = new CombinedJokesDTO(dadDTO, chuckDTO);
        
        String combinedJSON = gson.toJson(comb);
        return combinedJSON;
        
       }

   
}