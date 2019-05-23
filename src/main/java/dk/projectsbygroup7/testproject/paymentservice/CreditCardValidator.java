package dk.projectsbygroup7.testproject.paymentservice;

import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import org.springframework.stereotype.Service;

@Service
public class CreditCardValidator {

    public boolean checkCardFormat(CreditCardInfo cardInfo){
        String cardNo = cardInfo.getCardNumber().replaceAll("\\s", "");
        if (cardNo.length() < 13 || cardNo.length() > 19) return false;
        if (!cardNo.matches("[0-9]+")) return false;


        return true;
    }
}
