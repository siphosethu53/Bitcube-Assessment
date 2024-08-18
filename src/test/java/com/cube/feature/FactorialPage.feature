@FactorialCalculator
Feature: Calculate the factorial of a given number

    Background: landing page
        Given user is on the home page "https://qainterview.pythonanywhere.com/"

    @HappyPath
    Scenario Outline: happy path
        When user enter a positive whole number "<factorialNumber>"
        And user click on calculate button
        Then user close browser
        Examples:
            | factorialNumber |
            | 4               |

    @HyperlinksDefect
    Scenario Outline: Heyperlinks redict to incorrect error message page
        When user click on a "<hyperlink>" and is redirected to "<url>" and the incorrect "<message>" is displayed
        Then user close browser
        Examples:
            | hyperlink            | url                                                                                           | message                                                                 |
            | Terms and Conditions | https://qainterview.pythonanywhere.com/privacy                                                | This is the privacy document. We are not yet ready with it. Stay tuned! |
            | Privacy              | https://qainterview.pythonanywhere.com/privacy                                                | https://qainterview.pythonanywhere.com/terms                            | This is the terms and conditions document. We are not yet ready with it. Stay tuned! |
            | Qxf2 Services        | https://qxf2.com/?utm_source=qa-interview&utm_medium=click&utm_campaign=From%20QA%20Interview |                                                                         |


    @EdgecaseDefect
    Scenario Outline: Entering more than 4 digits that are greater than zero
        When user enter more than four "<digits>"
        Then application provide no results or any type of message
        And user close browser
        Examples:
            | digits |
            | 1111   |
            | 98764  |
