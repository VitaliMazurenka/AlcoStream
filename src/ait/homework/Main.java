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
                .sorted((a, b) -> Double.compare(b.getPrice(), a.getPrice())) // implements Comparable класс Alcohol!
                //.sorted()          // с естественным порядком сортировки , Comparable<Alcohol>
                .distinct()
                .limit(3)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(top);

        // Получите самый дешевый товар
        // version 1
        Alcohol cheapest = list.stream()
                .sorted()
                .findFirst()
                //     .orElseThrow(NoSuchElementException::new);  // в случае если элемента нет !
                .orElseGet(() -> null);
        //     .orElseGet(()->new Alcohol("Beer", 6.2, 3.40));
        System.out.println(cheapest);
        //if(cheapest!=null){
        //    cheapest.getTitle();
        // }
        // version 2
        Alcohol cheapest2 = list.stream()
                .min((a, b) -> Double.compare(a.getPrice(), b.getPrice()))
                .orElseGet(() -> null);
        System.out.println(cheapest2);

        //Создайте Set из исходного листа.

        Set<Alcohol> alcoholSet = list.stream()
                // промежуточные операции, если нет то лучше заменить на конструктор HashSet
                .collect(Collectors.toSet());
        System.out.println(alcoholSet);

        //Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениями будут цены.
        Map<String, Double> pricesByNames = list.stream()
                .distinct()
                .collect(Collectors.toMap(Alcohol::getTitle, Alcohol::getPrice));
        System.out.println(pricesByNames);

        //Создайте Map из исходного листа, в котором ключами будут - названия товаров, а значениям будет крепость.
        Map<String, Double> strengthesByNames = list.stream()
                .distinct()
                .collect(Collectors.toMap(Alcohol::getTitle, Alcohol::getStrength,(a,b) ->a)); // при наличи 2 объектов возьмет первый

        System.out.println(strengthesByNames);

    }
}
