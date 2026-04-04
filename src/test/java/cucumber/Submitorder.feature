
@tag1
Feature: purchase the order from ekart website

Background:
Given I landed on ecommerce page



@Regression
Scenario Outline: Positive test of submitting a order
Given Loggedin with username <name> and password <password>
When I add the product <cartList> to cart
And checkout <cartList> and submit the order
And payment done via credit card with details of <cvv>,<name1>,<coupoun1>
Then verify the confirmation "Thankyou for the order." is dispayed

Examples:
         |          name          | password | 			cartList          |  cvv |   name1       |coupoun1 |
         | arjunvkakade@gmail.com | Arjun@123| ADIDAS ORIGINAL,ZARA COAT 3| 366  |Arjun v kakade |rahulshettyacademy|
      