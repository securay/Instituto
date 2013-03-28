package com.instituto;

import com.instituto.controladores.ControladorAlumno;
import com.instituto.entidades.Alumno;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{

    public App() {
        ApplicationContext context = new ClassPathXmlApplicationContext("contexto/Spring.xml");
        String beans[]= context.getBeanDefinitionNames();
        for (String b : beans) {
            System.out.println(b);
        }
        ControladorAlumno ca= context.getBean(ControladorAlumno.class);
        List<Alumno> als= ca.listarAlumnos();
        for (Alumno a : als) {
            System.out.println(a.getIdAlumno() + ": " + a.getNombres() + " " + a.getApellidoPaterno() +
                    " " + a.getApellidoMaterno());
        }
    }
    
    public static void main( String[] args )
    {
        new App();
    }
}
