package oop;

import oop.characteristic.Client;
import oop.characteristic.ClientCase;
import oop.characteristic.Service;
import oop.characteristic.Staff;
import oop.inheritance.IIncreaseRating;
import oop.inheritance.Organization;
import oop.inheritance.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LawyerOffice extends Organization implements Printable {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOffice.class);

    private Address address;
    private Staff staff;
    private List<Service> services;
    private List<Client<? extends IIncreaseRating>> clients;
    private Map<String, Client<? extends IIncreaseRating>> schedule;

    public LawyerOffice(String name, LocalDate dateOfFoundation, Address address, Staff staff, List<Client<? extends IIncreaseRating>> clients, List<Service> services) {
        super(name, dateOfFoundation);
        this.address = address;
        this.staff = staff;
        this.clients = clients;
        this.services = services;
    }

    public LawyerOffice(String name, LocalDate dateOfFoundation) {
        super(name, dateOfFoundation);
    }

    @Override
    public void issueLicense() {
        LOGGER.info(getName() + " issue a license plus certificate for employees");
    }

    public void startCase() {
        LOGGER.info("Case waiting");
    }

    public void startCase(boolean lawyerAvailable) {
        LOGGER.info("Case waiting");
        if (lawyerAvailable) {
            LOGGER.info("Start case");
        }
    }

    public int countClients(List<Client<? extends IIncreaseRating>> clients) {
        int counter = 0;
        for (Client client : clients) {
            LOGGER.info("Client: " + client.getName() + " " + client.getClientCase() );
            counter++;
        }
        return counter;
    }

    public void showServices(List<Service> services) {
        for(Service service : services) {
            LOGGER.info("Show service: " + service.getDescriptionOfService());
        }
    }

    public void showSchedule(Map<String, Client<? extends IIncreaseRating>> schedule) {
        for (Map.Entry<String, Client<? extends IIncreaseRating>> entry : schedule.entrySet()) {
            LOGGER.info(entry.getKey() + "  :  " + entry.getValue());
        }
    }

    @Override
    public void print() {
        System.out.printf("%s is founded in %s. The address is: %s \n", getName(), getDateOfFoundation(), getAddress());
    }

    @Override
    public void read() {
    }

    @Override
    public String toString() {
        return "LawyerOffice{" +
                "address=" + address +
                ", staff=" + staff +
                ", services=" + services +
                ", clients=" + clients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawyerOffice that = (LawyerOffice) o;
        return Objects.equals(address, that.address) && Objects.equals(staff, that.staff) && Objects.equals(services, that.services) && Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, staff, services, clients);
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Client<? extends IIncreaseRating>> getClients() {
        return clients;
    }

    public void setClients(List<Client<? extends IIncreaseRating>> clients) {
        this.clients = clients;
    }

    public Map<String, Client<? extends IIncreaseRating>> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, Client<? extends IIncreaseRating>> schedule) {
        this.schedule = schedule;
    }
}
