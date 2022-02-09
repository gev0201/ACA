package models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonFormat(shape = JsonFormat.Shape.ARRAY)
//@JsonPropertyOrder({ "id", "name", "email", "gender", "status" })
public class UserJson {
    private int id;
    private String email;
    private String name;
    private String gender;
    private String status;

    public UserJson(){};

    //Use this for POST request
    public UserJson(String email, String name, String gender, String status){
        setEmail(email);
        setName(name);
        setGender(gender);
        setStatus(status);
    }

    //Use this for PUT request
    public UserJson(int id, String email, String name,  String gender, String status){
        setId(id);
        setEmail(email);
        setName(name);
        setGender(gender);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
