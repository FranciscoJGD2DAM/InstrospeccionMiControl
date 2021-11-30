/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrospeccionmicontrol;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import miscontroles.MiControl;

/**
 *
 * @author usuario
 */
public class InstrospeccionMiControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MiControl micontrol = new MiControl();
       System.out.println("la clase a la que pertene micontrol es: " + micontrol.getClass());
       
       Class c1 = micontrol.getClass();
       
       muestraLosCampos(c1);
       muestraLosConstructores(c1);
       muestraLosMetodos(c1);
    }

    private static void muestraLosConstructores(Class c1) {
        Constructor[] constructores = c1.getDeclaredConstructors();
        System.out.println("Los constructores de la clase son: ");
        for (Constructor c: constructores){
            String nombre = c.getName();
            System.out.println(" "+ Modifier.toString(c.getModifiers()));
            Class[] tipoParams = c.getParameterTypes();
            
            for(int i = 0; i <tipoParams.length; i++){
                if(i>0) System.out.print(", ");
                System.out.print(tipoParams[i].getName());               
            }
            System.out.println(")");
        }
        
    }

    private static void muestraLosMetodos(Class c1) {
        Method[] metodos = c1.getDeclaredMethods();
        System.out.println("Los metodos de la clase son: ");
        for(Method m: metodos){
            String nombre = m.getName();
            System.out.println(" "+ Modifier.toString(m.getModifiers()));
            Class[] tipoParams = m.getParameterTypes();
            
            for(int i = 0; i <tipoParams.length; i++){
                if(i>0) System.out.print(", ");
                System.out.print(tipoParams[i].getName());               
            }
            System.out.println(")");
        }
    }

    private static void muestraLosCampos(Class c1) {
        Field[] atributos = c1.getDeclaredFields();
        System.out.println("Los atributos de la clase son: ");
        for(Field f : atributos){
            System.out.println(Modifier.toString(f.getModifiers())+ "  "+ f.getType() + "  "+ f.getName());
        }
    }
    
}
