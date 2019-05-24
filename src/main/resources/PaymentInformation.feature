Feature: Student want to pay course fee

 Scenario: Payment card has sufficent funds
    Given Student chose the course for payment
    And Enter card number
    And Chose the "card type"
    And Enter account holder name
    And Enter expeire date
    And Enter cvc number
    Then payment transfer successfully

