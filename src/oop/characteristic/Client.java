package oop.characteristic;

import oop.inheritance.Human;
import oop.inheritance.Billable;
import oop.inheritance.IIncreaseRating;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Objects;

public class Client<T extends IIncreaseRating> extends Human<T> implements Billable {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private ClientCase clientCase;
    private BigDecimal money;

    public Client(String name, ClientCase clientCase, BigDecimal money) {
        super(name);
        this.clientCase = clientCase;
        this.money = money;
    }

    @Override
    public void enterUniversity() {
        LOGGER.info(getName() + " passed the exam");
    }

    public void payLawyer(BigDecimal amount) {
        this.money = money.subtract(amount);
        LOGGER.info(getName() + " has remained: " + money + "$ after lawyers services");
    }

    public ClientCase getClientCase() {
        return clientCase;
    }

    public void setClientCase(ClientCase clientCase) {
        this.clientCase = clientCase;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean isMoneyRemained() {
        return money.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientCase=" + clientCase +
                ", money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return money == client.money && Objects.equals(clientCase, client.clientCase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientCase, money);
    }
}

