package sec.project.domain;

import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Signup extends AbstractPersistable<Long> {

    private String name;
    private String address;
    private  String creditCardNumber;
    @Id
    private Long id;

    public Signup() {
        super();
    }

    public Signup(String name, String address, String creditCardNumber) {
        this();
        this.name = name;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.id = new Random().nextLong();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
