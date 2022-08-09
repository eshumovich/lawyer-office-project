package oop;

import oop.characteristic.Client;
import oop.characteristic.Lawyer;
import oop.characteristic.Staff;
import oop.inheritance.Human;
import oop.inheritance.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LawyerOfficeUtils {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOfficeUtils.class);

    public static void getBetterLawyer(LawyerOffice lawyerOffice) {
        Staff staff = lawyerOffice.getStaff();
        Lawyer[] lawyers = staff.getLawyer();
        for (Lawyer lawyer: lawyers) {
            if (lawyer.getRating() > 9) {
                LOGGER.info(lawyer.getName() + " with rating " + lawyer.getRating() + " is chosen");
            }
        }
    }

    public static void showEducation(Human... humans) {
        for (Human human : humans) {
            human.enterUniversity();
        }
    }

    public static void print(Printable...objects) {
        for(Printable object : objects) {
            object.print();
        }
    }

    public static void contactLawyer(Client client, Lawyer... lawyers) {
        while (client.isMoneyRemained()) {
            for(Lawyer lawyer : lawyers) {
                lawyer.provideDefendence(client);
            }
        }
    }
}
