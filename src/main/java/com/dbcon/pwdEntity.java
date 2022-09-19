package com.dbcon;

public class pwdEntity {
    private String account;
    private String password;

    public String getAccount(){return this.account;}

    public String getPassword(){return this.password;}

    public void setAccount(String account){this.account = account;}

    public void setPassword(String password){this.password = password;}

    public pwdEntity(String account,String password){
        this.account = account;
        this.password = password;

    }

}
