import Entidades.Chef;
import Entidades.Despensa;
import Entidades.Ingrediente;
import Entidades.Utensilio;
import Servicios.DespensaService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Despensa despensa = new Despensa();
        Chef chef = new Chef("Francisco Mallmann", 0, despensa);

        List<Ingrediente> ingredientes = Arrays.asList(
                new Ingrediente("Arroz",5000),
                new Ingrediente("Leche",2000),
                new Ingrediente("Canela",10),
                new Ingrediente("Azucar",500),
                new Ingrediente("Huevo",12),
                new Ingrediente("Agua",10000),
                new Ingrediente("Ternera",8),
                new Ingrediente("Papa",3)
        );

        ingredientes.forEach(despensa::addElemento);

        List<Utensilio> utensilios = Arrays.asList(
                new Utensilio("Olla",0),
                new Utensilio("Olla",1),
                new Utensilio("Cuchara",500),
                new Utensilio("Bandeja",500),
                new Utensilio("Cuchillo",500),
                new Utensilio("Tenedor",500)
        );

        utensilios.forEach(despensa::addUtensilio);

        Map<String, Integer> recetas = new HashMap<>();
        recetas.put("\nArroz con Leche:", 1);
        recetas.put("\nHuevo Duro:", 2);
        recetas.put("\nTernera al Horno:", 3);
        recetas.put("\nNada:", 4);

        recetas.forEach((nombre, numero) -> {
            System.out.println(nombre);
            chef.prepararReceta(numero);
        });

        DespensaService.renovarUtensilios(despensa);

        System.out.println("\nArroz con Leche:");
        chef.prepararReceta(1);
    }
}