import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий размер рыбы.
 */
class Size {
    private double width;
    private double length;

    public Size(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}

/**
 * Абстрактный класс для всех рыб.
 */
abstract class Fish {
    private String species;
    private double weight;
    private Size size;

    public Fish(String species, double weight, Size size) {
        this.species = species;
        this.weight = weight;
        this.size = size;
    }

    public String getSpecies() {
        return species;
    }

    public double getWeight() {
        return weight;
    }

    public Size getSize() {
        return size;
    }

    public abstract boolean isPredator();

    @Override
    public String toString() {
        return String.format("Species: %s, Weight: %.2f g, Size: %.2f x %.2f",
                species, weight, size.getWidth(), size.getLength());
    }
}

/**
 * Класс, представляющий хищную рыбу.
 */
class PredatorFish extends Fish {
    public PredatorFish(String species, double weight, Size size) {
        super(species, weight, size);
    }

    @Override
    public boolean isPredator() {
        return true;
    }
}

/**
 * Класс, представляющий мирную рыбу.
 */
class PeacefulFish extends Fish {
    public PeacefulFish(String species, double weight, Size size) {
        super(species, weight, size);
    }

    @Override
    public boolean isPredator() {
        return false;
    }
}

public class main {
    public static void main(String[] args) {
        List<Fish> fishList = new ArrayList<>();

        // Создание экземпляров рыб
        fishList.add(new PredatorFish("Pike", 150, new Size(10, 30)));
        fishList.add(new PredatorFish("Trout", 200, new Size(12, 35)));
        fishList.add(new PeacefulFish("Goldfish", 50, new Size(5, 10)));
        fishList.add(new PeacefulFish("Guppy", 5, new Size(2, 4)));
        fishList.add(new PredatorFish("Catfish", 120, new Size(15, 40)));
        fishList.add(new PeacefulFish("Neon Tetra", 1, new Size(1, 2)));

        // Вывод информации о хищниках больше 100 г
        System.out.println("Predator fish weighing more than 100g:");
        for (Fish fish : fishList) {
            if (fish.isPredator() && fish.getWeight() > 100) {
                System.out.println(fish);
            }
        }

        // Вычисление самой длинной рыбы
        Fish longestFish = null;
        for (Fish fish : fishList) {
            if (longestFish == null || fish.getSize().getLength() > longestFish.getSize().getLength()) {
                longestFish = fish;
            }
        }

        if (longestFish != null) {
            System.out.println("The longest fish is: " + longestFish);
        }
    }
}
