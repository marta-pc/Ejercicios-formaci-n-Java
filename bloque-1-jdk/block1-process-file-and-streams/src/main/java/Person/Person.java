package Person;

public class Person {

    private String name;
    private String town;
    private int age;

    /*Constructor para crear personas con parámetros obligatorios*/
    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    /*Constructor sin parámetros */
    public Person(){

    }

    /*Métodos get para consultar datos de una persona, los set es para modificarlos*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*Imprime la info de persona y sus atributos */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", age=" + age +
                '}';
    }


}
