

## Room Optimization App

**Startup Instructions** 

 - Clone de project into your computer
 - Make sure you have [maven](https://maven.apache.org/download.cgi) installed in your computer
 - On console in the project file type: `mvn spring-boot:run` and `mvn test` to run tests
 The application should run locally in your 8080 port.
 
 
 
 **API Instructions**
 POST method `/room/optimize-rooms`
 This method needs a JSON body

     {
      "potentialGuests": [
        0
      ],
      "roomAvailableEconomy": 0,
      "roomAvailablePremium": 0
    }
**potentialGuests** an array of Integer, **roomAvailableEconomy** and **roomAvailablePremium** an Integer as the activity requeries.

Expect a response of:

      {  "amountPaidEconomy":  0,  "amountPaidPremium":  0,  "usageEconomy":  0,  "usagePremium":  0  }

You can also access the API on the SWAGGER UI `/swagger-ui.html`

This API is live in a heroku app so you can try the https://laio-booking.herokuapp.com/room/optimize-rooms to test the API or the [Swagger UI](https://laio-booking.herokuapp.com/swagger-ui.html)


		
