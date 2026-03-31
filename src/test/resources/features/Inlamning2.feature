Feature: Support Account Application Form Test

  Scenario Outline: Verify submit form with a successful application
    Given I am using the "<browser>" browser
    Given I have navigated to application form
    Then I have navigated to application form
    When I fill in the form with
     |Birth Date| First Name | Last Name   | Email Address        | Confirm Email         | Password  | Confirm Password | Terms and Conditions | Over 18 | Code of Ethics | Confirm and Join |
     | <bd>     |<fn>        | <ln>        | <ea>                 | <ce>                  | <pw>      | <cp>             | <tc>                 | <age>   | <coe>          | <cj>             |

    Then I have registered a supporter account.

    Examples:
      | browser | bd         |fn        | ln      | ea                 | ce                  | pw      | cp       | tc   | age   | coe   | cj  |
      | Chrome  | 08/03/1978 | Henric   | Wiktor  | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | yes  | yes   | yes   | yes |
      | Edge    | 08/03/1978 | Henric   | Wiktor  | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | yes  | yes   | yes   | yes |
      | Firefox | 08/03/1978 | Henric   | Wiktor  | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | yes  | yes   | yes   | yes |

  Scenario Outline: Verify submit form error messages
    Given I am using the "<browser>" browser
    Given I have navigated to application form
    When I fill in the form with
      |Birth Date| First Name | Last Name   | Email Address        | Confirm Email         | Password  | Confirm Password | Terms and Conditions | Over 18 | Code of Ethics | Confirm and Join |
      | <bd>     |<fn>        | <ln>        | <ea>                 | <ce>                  | <pw>      | <cp>             | <tc>                 | <age>   | <coe>          | <cj>             |

    Then I should see error message "<error>"

    Examples:
     | browser | bd          | fn       | ln        | ea                 | ce                  | pw      | cp       | tc   | age   | coe  | cj  | error |
     | Chrome  | 08/03/1978  | Henric   |           | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | yes  |  yes  | yes  | yes | Last Name is required  |
     | Chrome  | 08/03/1978  | Henric   | Wiktor    | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp1 | yes  |  yes  | yes  | yes | Password did not match |
     | Chrome  | 08/03/1978  | Henric   | Wiktor    | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | no   |  yes  | yes  | yes | You must confirm that you have read, understood and agree to the Code of Ethics and Conduct |
     | Edge    | 08/03/1978  | Henric   |           | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | yes  |  yes  | yes  | yes | Last Name is required  |
     | Edge    | 08/03/1978  | Henric   | Wiktor    | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp1 | yes  |  yes  | yes  | yes | Password did not match |
     | Edge    | 08/03/1978  | Henric   | Wiktor    | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | no   |  yes  | yes  | yes | You must confirm that you have read, understood and agree to the Code of Ethics and Conduct |
     | Firefox | 08/03/1978  | Henric   |           | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | yes  |  yes  | yes  | yes | Last Name is required  |
     | Firefox | 08/03/1978  | Henric   | Wiktor    | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp1 | yes  |  yes  | yes  | yes | Password did not match |
     | Firefox | 08/03/1978  | Henric   | Wiktor    | phumpeti@gmail.com | phumpeti@gmail.com  | hejhopp | hejhopp  | no   |  yes  | yes  | yes | You must confirm that you have read, understood and agree to the Code of Ethics and Conduct |