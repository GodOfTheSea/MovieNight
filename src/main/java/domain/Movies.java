package domain;


public class Movies {

    private String Type;
    private String Name;
    private String Genre;
    private String Ldate;
    private String Wdate;
    private String Duration;
    private String Storyline;
    private String Stars;
    private String Director;
    private int Seasons;
    private int Episodes;
    private int Note;
    private int Favorite;
    private long id;

    //CONSTRUCTOR
    public Movies(String type, String name, String genre, String ldate, String wdate, String duration, String storyline, String stars, String director, int seasons, int episodes, int note, int favorite){
        this.Type=type;
        this.Name=name;
        this.Genre=genre;
        this.Ldate=ldate;
        this.Wdate=wdate;
        this.Duration=duration;
        this.Storyline=storyline;
        this.Stars=stars;
        this.Director=director;
        this.Seasons=seasons;
        this.Episodes=episodes;
        this.Note=note;
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

    public String getStars(){
        return this.Stars;
    }
    public void setStars(String stars){
        this.Stars=stars;
    }

    public String getDirector(){
        return this.Director;
    }
    public void setDirector(String director){
        this.Director=director;
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

    public int getNote(){
        return this.Note;
    }
    public void setNote (int note){
        this.Note=note;
    }

    public int getFavorite(){
        return this.Favorite;
    }
    public void setFavorite(int favorite){
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
        return Type + Name + Genre + Ldate + Wdate + Duration + Storyline + Stars + Director + Seasons + Episodes + Note + Favorite;
    }
}

