package com.gcu.apartmentx.business;

public interface AuthenticationInterface {
    public String authenticate(String username, String password);
    public void init();
    public void destroy();
}
