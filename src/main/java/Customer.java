import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Customer {
    private String name;
    private ArrayList<Rental> _rentals = new ArrayList();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Iterator<Rental> rentals = _rentals.iterator();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Iterator<Rental> rentals = _rentals.iterator();
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        // add footer lines
        result += "<P>Amount owed is <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "You earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }


    private double getTotalCharge() {
        double result = 0;
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();
            result += each.getCharge();
        }
        return result;
    }

    private double getTotalFrequentRenterPoints() {
        double result = 0;
        Iterator<Rental> rentals = _rentals.iterator();
        while (rentals.hasNext()) {
            Rental each = (Rental) rentals.next();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
