package hiber.model;


import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String model;
    int series;


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }


    public int getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}