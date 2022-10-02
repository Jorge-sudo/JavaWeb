package com;

import javax.ejb.Remote;

@Remote
public interface NewSessionBeanRemote {
    public int sumar(int a, int b);
}
