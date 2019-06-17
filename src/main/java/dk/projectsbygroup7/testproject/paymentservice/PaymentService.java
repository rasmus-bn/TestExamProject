package dk.projectsbygroup7.testproject.paymentservice;

import dk.projectsbygroup7.testproject.paymentservice.validators.CreditCardValidator;
import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    CreditCardValidator cardValidator;

    public boolean performPayment(CreditCardInfo cardInfo) {
        return cardValidator.checkCardFormat(cardInfo);
    }
}
