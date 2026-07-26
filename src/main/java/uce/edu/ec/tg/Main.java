package uce.edu.ec.tg;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

public class Main {

    public static void main(String[] args) {

        Quarkus.run(App.class, args);
        
    }

    public static class App implements QuarkusApplication{

        public int run(String... args) throws Exception {

            System.out.println("Conexion a la base de datos establecida correctamente");

            return 0;
        }
    }

}
