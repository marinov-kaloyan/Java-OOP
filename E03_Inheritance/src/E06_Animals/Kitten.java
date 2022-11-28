package E06_Animals;

public class Kitten extends Cat {
    public static final String KITTENS_GENDER ="Female";
    public Kitten(String name, int age) {
        super(name, age, KITTENS_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
