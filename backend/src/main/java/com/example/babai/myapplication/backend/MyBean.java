package com.example.babai.myapplication.backend;

/** The object model for the data we are sending through endpoints */
class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    void setData(String data) {
        myData = data;
    }
}