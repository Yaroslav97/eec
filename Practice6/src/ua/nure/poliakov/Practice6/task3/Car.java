package ua.nure.poliakov.Practice6.task3;

public class Car {
    private String mark;

    public Car(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Car.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        Car other = (Car) obj;
        if ((this.mark == null) ? (other.mark != null) : !this.mark.equals(other.mark)) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 6 * hash + (this.mark != null ? this.mark.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                '}';
    }
}