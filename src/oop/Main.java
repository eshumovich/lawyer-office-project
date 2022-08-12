package oop;

import oop.characteristic.*;
import oop.exception.NameInvalidException;
import oop.inheritance.CompetitorLawyersOffice;
import oop.inheritance.Human;
import oop.worktime.VisitTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Main {

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Address address = new Address("Spain", "Madrid", 10);
        LOGGER.info(address.getCountry() + " " + address.getCity() + " " + address.getHouseNumber());

        Address address1 = new Address("Belarus", "Gomel", 12);
        Address address2 = new Address("Belarus", "Mogelev", 101);
        Address address3 = new Address("Belarus", "Brest", 148);
        Address address4 = new Address("Belarus", "Vitebsk", 101);
        Address address5 = new Address("Belarus", "Minsk", 3);

        Lawyer lawyer1 = new Lawyer("Rachel Green", address1, LocalDate.of(1990, 6, 2));
        lawyer1.setRating(9);
        Lawyer lawyer2 = new Lawyer("Monica Geller", address2, LocalDate.of(1986, 12, 8));
        lawyer2.setRating(8);
        Lawyer lawyer3 = new Lawyer("John", address3, LocalDate.of(1990, 11, 1));
        lawyer3.setRating(7);
        Lawyer lawyer4 = new Lawyer("Nikita", address4, LocalDate.of(2000, 3, 4));
        lawyer4.setRating(10);
        Lawyer lawyer5 = new Lawyer("Valentin", address4, LocalDate.of(2001, 2, 1));
        lawyer5.setRating(4);

        Lawyer[] lawyers = {lawyer1, lawyer2, lawyer3, lawyer4, lawyer5};

        Staff staff = new Staff(lawyers);
        staff.showAllLawyers(lawyers);

        LOGGER.info("Quantity of available lawyers: " + Lawyer.getQuantityLawyers());

        ClientCase divorce = new ClientCase("High", BigDecimal.valueOf(450), "Divorce process");
        LocalDate prevDate1 = LocalDate.of(2021, 5, 15);
        divorce.caseWaiting(prevDate1);
        ClientCase aliments = new ClientCase("Medium", BigDecimal.valueOf(370), "Aliments");
        LocalDate prevDate2 = LocalDate.of(2019, 8, 10);
        aliments.caseWaiting(prevDate2);

        Client client1 = new Client("Evgeny", divorce, BigDecimal.valueOf(1500));
        Client client2 = new Client("Valera", aliments, BigDecimal.valueOf(1350));

        LOGGER.info("----------------------------------");
        lawyer1.setSalary(BigDecimal.valueOf(150));
        lawyer1.isAvailable();

        Client[] clients = {client1, client2};

        VisitTime visit = new VisitTime(30, 2);
        LOGGER.info("Required time for the case: " + visit.totalMinutes() + " min");

        Service service1 = new Service(visit);
        Service service2 = new Service("ASAP", BigDecimal.valueOf(150), "bill the client for the case");
        Service service3 = new Service("ASAP", BigDecimal.valueOf(170), "Solve the case");

        Service[] services = {service1, service2, service3};

        LawyerOffice redClearing = new LawyerOffice("RedClearing",
                LocalDate.of(2002, 2, 1), address, staff, clients, services);

        LOGGER.info("----------------------------------");
        redClearing.startCase();
        redClearing.startCase(true);

        LOGGER.info("Quantity of clients: " + redClearing.countClients(clients));
        LOGGER.info(redClearing.getAddress());

        LOGGER.info("----------------------------------");
        redClearing.showServices(services);

        ZonedDateTime now = ZonedDateTime.now();
        LOGGER.info(now);

        LOGGER.info("----------------------------------");

        Address addressCourtHouse = new Address("Italy", "Rome", 100);
        CourtHouse courtHouse = new CourtHouse(addressCourtHouse);
        courtHouse.bookCourtHouse(LocalDateTime.of(2022, 12, 1, 7, 30));
        courtHouse.isOpen();
        courtHouse.startTrial();

        LOGGER.info(courtHouse.getAddress());

        LawyerOfficeUtils.getBetterLawyer(redClearing);

        LOGGER.info("----------------------------------");

        Address addressItaly = new Address("Italy", "Rome", 1);
        CompetitorLawyersOffice competitorLawyersOffice = new CompetitorLawyersOffice("BadLawyers", LocalDate.of(1975, 4, 5), addressItaly);
        competitorLawyersOffice.read();
        competitorLawyersOffice.stealInformation();
        redClearing.issueLicense();

        Human[] humans = {client1, client2, lawyer1, lawyer2, lawyer3};
        LawyerOfficeUtils.showEducation(humans);

        LOGGER.info("----------------------------------");
        LawyerOfficeUtils.print(redClearing, competitorLawyersOffice);

        LawyerOfficeUtils.contactLawyer(client1, lawyer1);

        try {
            redClearing.setName("RedClearing");
        } catch (NameInvalidException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            LOGGER.info("Name is set");
        }

        redClearing.setDateOfFoundation(LocalDate.of(2020, 5, 1));

        try (TextFile textFile = new TextFile()) {
            LOGGER.info("This is a idempotent");
        }

        Client client3 = new Client("Bruce", divorce, BigDecimal.valueOf(500));
    }
}



