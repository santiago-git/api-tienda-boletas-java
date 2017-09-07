package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin //permite peticiones desde cualquier origen
@SpringBootApplication
@ComponentScan
@ComponentScan({"web", "controller"})
public class Main {

    public static void main(String[] args) {

//         Conector con = new Conector();
//         Connection miCon = con.conectar();
//         System.out.println(miCon);
//         con.desconectar(miCon);
        SpringApplication.run(Main.class, args);
    }
}
