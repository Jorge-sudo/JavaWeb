package com;

import javax.ejb.Stateless;

@Stateless
public class NewSessionBean implements NewSessionBeanRemote {

    @Override
    public int sumar(int a, int b) {
        System.out.println("Ejecutando metodo sumar");
        return a+b;
    }
    
}
