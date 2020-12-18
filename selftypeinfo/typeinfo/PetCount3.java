// typeinfo/PetCount3.java
// (c)2020 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Using isInstance()

import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public class PetCount3 {
    static class Counter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(
//self-note: fun1
        /*      LiteralPetCreator.ALL_TYPES.stream()
        .map(lpc -> Pair.make(lpc, 0))
        .collect(Collectors.toMap(Pair::key, Pair::value))*/


//self-note: fun2
//            listToMap(LiteralPetCreator.ALL_TYPES,  newList()   )

//self-note: fun3
                    /*listToMap(LiteralPetCreator.ALL_TYPES,
                            Stream.generate(() -> 0)
                                    .limit(LiteralPetCreator.ALL_TYPES.size())
                                    .collect(Collectors.toList()))*/
//self-note: fun4
//                    LiteralPetCreator.ALL_TYPES.stream().collect(Collectors.toMap(x->x, x->0))

//self-note: fun5
                    LiteralPetCreator.ALL_TYPES.stream().collect(Collectors.toMap(Function.identity(), x->0))


            );
        }

        private static List<Integer> newList() {
            List<Integer> l = new ArrayList<>();
            int len = LiteralPetCreator.ALL_TYPES.size();
            for (int i = 0; i < len; i++) {
                l.add(0);
            }
            return l;
        }

        public void count(Pet pet) {
            // Class.isInstance() eliminates instanceofs:
            entrySet().stream()
                    .filter(pair -> pair.getKey().isInstance(pet))
                    .forEach(pair ->
                            put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s",
                            pair.getKey().getSimpleName(),
                            pair.getValue()))
                    .collect(Collectors.joining(", "));
            return "{" + result + "}";
        }
    }

    public static void main(String[] args) {
        Counter petCount = new Counter();
        Consumer<Pet> count = petCount::count;
        Consumer<Pet> petConsumer = p -> System.err.print(p.getClass().getSimpleName() + " ");
        Pets.stream()
                .limit(20)
                .peek(count)
                .forEach(petConsumer);//self-note: 这两个consumer可互换位置

        System.err.println("\n" + petCount);
    }


    public static <K, V> Map<K, V> listToMap(List<K> keys, List<V> values) {
        return keys.stream().collect(
                Collectors.toMap(
                        key -> key,
                        key -> values.get(keys.indexOf(key))
                )
        );
    }





}
/* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat
EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse
Pug Mouse Cymric
{Rat=2, Pug=3, Mutt=3, Mouse=2, Cat=9, Dog=6, Cymric=5,
EgyptianMau=2, Rodent=5, Hamster=1, Manx=7, Pet=20}
*/


/**
 *
 * {EgyptianMau=2, Pug=3, Rat=2, Cymric=5, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
 * {EgyptianMau=2, Pug=3, Rat=2, Cymric=5, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
 * {EgyptianMau=2, Pug=3, Rat=2, Cymric=5, Mouse=2, Cat=9, Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
 *
 */
