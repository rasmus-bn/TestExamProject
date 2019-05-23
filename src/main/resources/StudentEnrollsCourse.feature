Feature: Student enrolls course

  Scenario: Student enters personal info
    Given a person is 18
    When the person tries to enroll to a course
    Then the system should "deny" the enrollment
