package domain;


public class Movies {

    private String Type;
    private String Name;
    private String Genre;
    private String Ldate;
    private String Wdate;
    private String Duration;
    private String Storyline;
    private String Actors;
    private String Producers;
    private int Seasons;
    private int Episodes;
    private int Reviews;
    private boolean Favorite;
    private long id;

    //CONSTRUCTOR
    public Movies(String type, String name, String genre, String ldate, String wdate, String duration,
                  String storyline, String actors, String producers, int seasons, int episodes, int reviews, boolean favorite){
        this.Type=type;
        this.Name=name;
        this.Genre=genre;
        this.Ldate=ldate;
        this.Wdate=wdate;
        this.Duration=duration;
        this.Storyline=storyline;
        this.Actors = actors;
        this.Producers = producers;
        this.Seasons=seasons;
        this.Episodes=episodes;
        this.Reviews = reviews;
        this.Favorite = favorite;
    }


    //GETTERS & SETTERS
    public String getType(){
        return this.Type;
    }
    public void setType(String type){
        this.Type=type;
    }

    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name=name;
    }

    public String getGenre(){
        return this.Genre;
    }
    public void setGenre(String genre){
        this.Genre=genre;
    }

    public String getLdate(){
        return this.Ldate;
    }
    public void setLdate(String ldate){
        this.Ldate=ldate;
    }

    public String getWdate(){
        return this.Wdate;
    }
    public void setWdate(String wdate){
        this.Wdate=wdate;
    }

    public String getDuration(){
        return this.Duration;
    }
    public void setDuration(String duration){
        this.Duration=duration;
    }

    public String getStoryline(){
        return this.Storyline;
    }
    public void setStoryline(String storyline){
        this.Storyline=storyline;
    }

    public String getActors(){
        return this.Actors;
    }
    public void setActors(String actors){
        this.Actors = actors;
    }

    public String getProducers(){
        return this.Producers;
    }
    public void setProducers(String producers){
        this.Producers = producers;
    }

    public int getSeasons(){
        return this.Seasons;
    }
    public void setSeasons(int seasons){
        this.Seasons=seasons;
    }

    public int getEpisodes(){
        return this.Episodes;
    }
    public void setEpisodes(int episodes){
        this.Episodes=episodes;
    }

    public int getReviews(){
        return this.Reviews;
    }
    public void setReviews(int reviews){
        this.Reviews = reviews;
    }

    public boolean getFavorite(){
        return this.Favorite;
    }
    public void setFavorite(boolean favorite){
        this.Favorite = favorite;
    }

    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id=id;
    }

    @Override
    public String toString(){
        return Type + Name + Genre + Ldate + Wdate + Duration + Storyline + Actors + Producers + Seasons + Episodes + Reviews + Favorite;
    }
}

