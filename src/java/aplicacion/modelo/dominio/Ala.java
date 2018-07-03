/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Estrada
 */
public class Ala {
    
    public static void main(String[] args) {
        Character letra = 'A';
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= 5; j++) {
                String a= String.valueOf(letra);
                lista.add(a+j);
            }
            letra++;
        }
            
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
    }
    
}
