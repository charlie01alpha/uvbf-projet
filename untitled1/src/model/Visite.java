// src/model/Visite.java
package model;

import java.util.Date;
import java.util.List;

public class Visite {
    private Date date;
    private Bien bien;
    private List<Client> clientsInteressés;

    public Visite(Date date, Bien bien, List<Client> clientsInteressés) {
        this.date = date;
        this.bien = bien;
        this.clientsInteressés = clientsInteressés;
    }

    @Override
    public String toString() {
        return "Visite{" +
                "date=" + date +
                ", bien=" + bien +
                ", clientsInteressés=" + clientsInteressés +
                '}';
    }
}
