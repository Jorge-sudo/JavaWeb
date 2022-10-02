package mx.com._1_HolaSpring.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args) {
        
        String password = "123";
        System.out.println("password: "+ password);
        System.out.println("Password encriptado: " + encriptarPassword(password));
    }
    
    public static String  encriptarPassword (String password){
        //Este objeto de SPRING es que nos permite encriptar nuestro password se recomienda usar este metodo 
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password); //$2a$10$l99Vr/JofwkAUlrkr1dDueg6G/eiEqiLuradIuxs9Nx.oUf0qdSqm
        
    }
}
