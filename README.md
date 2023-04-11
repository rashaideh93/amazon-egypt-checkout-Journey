# Amazon Automation Checkout Journey && Foodics APIs Tests
## Introduction
This project aims to automate a scenario on the Amazon Egypt e-commerce website using Selenium WebDriver with Java and TestNG testing framework.

### Requirements
To run this test suite, you will need the following software installed:

- Java Development Kit (JDK) 8 or later
- Selenium WebDriver 4.0 or later
- TestNG testing framework
- ChromeDriver or GeckoDriver (depending on the browser you will use for testing)
### Setup
- Clone or download the repository to your local machine.
- Install the necessary software listed in the Requirements section above.
- Open the project in your preferred Java Integrated Development Environment (IDE).
- Set up the project dependencies and build the project.
### Running the Tests
- Navigate to the project's test folder in your IDE.
- Run the test suite by running the TestNG test suite XML file or by running the test class.
- The tests will open a browser and navigate to the e-commerce website to perform the tests.
### Test Cases
#### The test suite covered the below cases :

1. Open Amazon Egypt and login
2. open “All” menu from the left side
3. click on “video games” then choose “all video games”
4. from the filter menu on the left side add filter “free shipping” & add the filter of condition “ new”
5. On the right side open the sort menu then sort by price: high to low
6. add all products below that its cost below 15k EGP, if no product below 15k EGP move to next page
7. make sure that all products is already added to carts
8. add address and choose cash as a payment method
9. make sure that the total amount of all items is correct with the shipping fees if exist

### Test Reports
TestNG generates test reports in HTML format. These reports can be found in the /test-output folder of the project after the tests have been run. The reports provide information about the tests that were run, including the test status, duration, and any error messages.

### Contributing
If you find any issues with the test suite or would like to contribute improvements, please open an issue or a pull request on the project's GitHub repository.# amazon-egypt-checkout-Journey
