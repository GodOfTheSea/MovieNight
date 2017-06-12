package domain;


public class MyExceptions extends Throwable {

    private String error;

    //CONSTRUCTOR
    public MyExceptions(){
    }
    public MyExceptions(String text){
        this.error = text;
    }



    public String getError(){
        return error;
    }
    public void setError(String error){
        this.error=error;
    }

//    public void checkError(String email, String pass){
//
//    }
}
