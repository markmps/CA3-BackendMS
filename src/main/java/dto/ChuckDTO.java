package dto;

import entities.ChuckJoke;

public class ChuckDTO {
    
    private String value;
    private String url = "https://api.chucknorris.io/jokes/random";
    private ChuckJoke chuckj;

    public ChuckDTO(ChuckJoke chuckj) {
        this.value = chuckj.getValue();
        this.url = chuckj.getUrl();
    }

    public ChuckDTO() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChuckJoke getCj() {
        return chuckj;
    }

    public void setCj(ChuckJoke cj) {
        this.chuckj = chuckj;
    }
}