package domain;


import java.util.Date;

public class Film {

    private long id;
    private String title;
    private String description;
    private String runtime;
    private Date release_date;

    public Film (String title, String description, String runtime, Date release_date){
        this.title = title;
        this.description = description;
        this.runtime = runtime;
        this.release_date = release_date;
    }

    public void setId(long id){
        this.id=id;
    }
    @Override
    public String toString(){
        return id + " " + title + " " + description + " " + runtime + " " + release_date;
    }
}
