package domain;

import java.sql.Date;


public class Persons {

        private String firstName;
        private String lastName;
        private String gender;
        private String datan;
        private String phone;
        private String email;
        private String password;
        private long id;



        //CONSTRUCTOR
        public Persons(String firstName, String lastName, String gender, String datan, String phone, String email, String password){
            this.firstName=firstName;
            this.lastName=lastName;
            this.gender=gender;
            this.datan=datan;
            this.phone=phone;
            this.email=email;
            this.password=password;
        }

        //CONSTRUCTOR VERIFICARE PAROLA
        public Persons (String email, String password) {
            this.email=email;
            this.password=password;
        }




        //GETTERS
        public String getFirstName(){
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }



        public String getGender(){
            return gender;
        }
        public String getEmail(){
            return email;
        }
        public String getDatan(){
            return datan;
        }

        public String getPhone() {
            return phone;
        }

        public long getId (){
            return id;
        }
        public String getPassword(){
            return password;
        }




        // SETTERS
        public void setFirstName(String firstName){
            this.firstName=firstName;
        }
        public void setLastName(String lastName){
            this.lastName=lastName;
        }
        public void setGender(String gender){
            this.gender=gender;
        }
        public void setEmail(String email) {
                this.email = email;
        }
        public void setDatan(String  datan){
            this.datan=datan;
        }
        public void setPhone(String phone){
            this.phone=phone;
        }
        public void setPassword(String password){

            this.password=password;
        }
        public void setId(long id) {
            this.id=id;
        }

        @Override
        public String toString(){
            return " Prenume: "+firstName+"  Nume: "+lastName+"  Gender: "+gender+"  Date of birth: "+datan+"  Phone number: "+phone+"  Email: "+email;
        }


    }


