package com.example.nellya.firebasestudent;


public class Student {
    private String id;
    private String name;

   // public Student (){
       // this.id = "0";
        //this.name = "FOO";
    //}
    public Student (String id, String name){
        this.id = id;
        this.name = name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId (){ return id; }
    public String getName () { return name; }
}
