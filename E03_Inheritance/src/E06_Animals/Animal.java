package E06_Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        } else {
            this.age = age;
        }
    }

    public void setGender(String gender) {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        } else {
            this.gender = gender;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append(getClass().getSimpleName()).append(System.lineSeparator());
        sb.append(String.format("%s %d %s",name,age,gender)).append(System.lineSeparator());
        sb.append(produceSound());
        return sb.toString();
    }
    public String produceSound(){
        return "";
    }
}
