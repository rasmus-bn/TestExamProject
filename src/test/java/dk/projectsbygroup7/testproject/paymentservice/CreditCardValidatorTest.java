package dk.projectsbygroup7.testproject.paymentservice;

import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import dk.projectsbygroup7.testproject.services.TimeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreditCardValidatorTest {

    @Mock
    private TimeService time;

    @InjectMocks
    private CreditCardValidator cardValidator;

    @BeforeEach
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/CreditCardValidatorTest.csv")
    void checkCardFormat(
            String cardNumber,
            String expirationMonth,
            String expirationYear,
            String cvv,
            boolean expected) {

        CreditCardInfo cardInfo = new CreditCardInfo(
                cardNumber,
                expirationMonth,
                expirationYear,
                cvv);

        Mockito.when(time.getCurrentYear()).thenReturn(2019);
        Mockito.when(time.getCurrentMonth()).thenReturn(2);
        boolean actual = cardValidator.checkCardFormat(cardInfo);
        assertThat(actual, equalTo(expected));
    }
}