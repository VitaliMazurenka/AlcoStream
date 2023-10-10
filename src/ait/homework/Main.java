package ait.homework;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Alcohol> list = List.of(
                new Alcohol("Whiskey", 43.5, 54.90),
                new Alcohol("Beer", 6.2, 3.40),
                new Alcohol("Vodka", 40.0, 10.50),
                new Alcohol("Rum", 38.5, 24.70),
                new Alcohol("Wine", 13.5, 7.20),
                new Alcohol("Whiskey", 43.5, 54.90)
        );
        // Получите LinkedList из топ 3 самых дорогих товаров.
        LinkedList<Alcohol> top = list.stream()
                .filter(p -> p.getPrice() > 20)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(top);

        // Получите самый дешевый товар


        //Создайте Set из исходного листа.

        Set<Alcohol> alcoholSet = new HashSet<>(list);
        System.out.println(alcoholSet);

        //Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениями будут цены.
        Map<Alcohol, Double> alcoholMap = list.stream()
                .distinct()
                .collect(Collectors.toMap(Function.identity(),// Function.identity ключ , само слово
                        Alcohol::getPrice));
        System.out.println(alcoholMap);

        //Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениям будет крепость.
        Map<Alcohol, Double> strongAlcoholMap = list.stream()
                .distinct()
                .collect(Collectors.toMap(Function.identity(), Alcohol::getStrength));
        System.out.println(strongAlcoholMap);

    }
}
