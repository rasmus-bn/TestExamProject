package dk.projectsbygroup7.testproject.paymentservice;

import cucumber.api.java.Before;
import dk.projectsbygroup7.testproject.pojos.CreditCardInfo;
import dk.projectsbygroup7.testproject.services.TimeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//@RunWith(Parameterized.class)
public class CreditCardValidatorTest {

//    private CreditCardInfo card;
//    private boolean expected;

//    public CreditCardValidatorTest(
//        String cardNumber,
//        String expirationMonth,
//        String expirationYear,
//        String cvv,
//        boolean expected) {
//
//        this.card = new CreditCardInfo(
//                cardNumber,
//                expirationMonth,
//                expirationYear,
//                cvv);
//        this.expected = expected;
//    }

//    @Parameterized.Parameters
    public static Collection parameters () {
        return Arrays.asList(new Object[][]{
                { "123322233232", "2", "2019", "222", true },
                { "123322233232", "2", "2019", "222", true },
                { "123322233232", "2", "2019", "222", true },
        });
    }

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