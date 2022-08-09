package oop;

import oop.characteristic.Client;
import oop.characteristic.Service;
import oop.characteristic.Staff;
import oop.inheritance.Organization;
import oop.inheritance.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class LawyerOffice extends Organization implements Printable {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOffice.class);

    private Address address;
    private Staff staff;
    private Service[] services;
    private Client[] clients;

    public LawyerOffice(String name, LocalDate dateOfFoundation, Address address, Staff staff, Client[] clients, Service[] services) {
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

    public int countClients(Client[] clients) {
        int counter = 0;
        for (Client client : clients) {
            LOGGER.info("Client: " + client.getName() + " " + client.getClientCase() );
            counter++;
        }
        return counter;
    }

    public void showServices(Service[] services) {
        for(Service service : services) {
            LOGGER.info("Show service: " + service.getDescriptionOfService());
        }
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

    public Service[] getServices() {
        return services;
    }

    public void setServices(Service[] services) {
        this.services = services;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
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
                ", services=" + Arrays.toString(services) +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LawyerOffice that = (LawyerOffice) o;
        return Objects.equals(address, that.address) && Objects.equals(staff, that.staff) && Arrays.equals(services, that.services) && Arrays.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(address, staff);
        result = 31 * result + Arrays.hashCode(services);
        result = 31 * result + Arrays.hashCode(clients);
        return result;
    }
}
