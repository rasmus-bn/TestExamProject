package dk.projectsbygroup7.testproject.paymentservice;

import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import dk.projectsbygroup7.testproject.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidator {

    @Autowired
    TimeService time;

    public boolean checkCardFormat(CreditCardInfo cardInfo){
        String cardNo = cardInfo.getCardNumber().replaceAll("\\s", "");
        if (!cardNo.matches("[0-9]{13,19}")) return false;

        String cvv = cardInfo.getCvv().replaceAll("\\s", "");
        if (!cvv.matches("[0-9]{3}")) return false;

        int expMonth;
        try {
            expMonth = Integer.parseInt(cardInfo.getExpirationMonth().replaceAll("\\s", ""));
        } catch (NumberFormatException e) {
            return false;
        }
        if (expMonth < 1 || expMonth > 12) return false;

        int expYear;
        try {
            expYear = Integer.parseInt(cardInfo.getExpirationYear().replaceAll("\\s", ""));
        } catch (NumberFormatException e) {
            return false;
        }

        int currentYear = time.getCurrentYear();
        int currentMonth = time.getCurrentMonth();
        if (expYear < currentYear) return false;
        if (expYear == currentYear && expMonth < currentMonth) return false;

        return true;
    }
}
