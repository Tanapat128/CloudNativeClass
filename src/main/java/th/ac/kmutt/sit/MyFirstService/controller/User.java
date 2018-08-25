package th.ac.kmutt.sit.MyFirstService.controller;
public class User {
    int id;
    String username;

    public User(int id,String username) {
        this.id = id;
        this.username = username;
    }

    public int getId(){
        return this.id;
     }

     public String getUsername(){
        return this.username;
     }
}
