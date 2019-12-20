# stabbr: twitter but sharp

This is a web application being designed by:

[Vaidehi Paranjape (Tech Lead)](https://github.com/vaidehi4321)

[Kendra Ng](https://github.com/kendrang)

[John Tokhi](https://github.com/tokhij)

[Kane Kopetski](https://github.com/KaneKopetski)

To get started:
1. Clone the project
2. Run the application using your preferred IDE or by running this terminal command from the project root: ./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=cloud;-DDB_URL=jdbc:postgresql://localhost:5432/group3blog;-DDB_UN=postgres;-DDB_PW=password"
  2a. The application is configured to launch locally with an in-mem H2 DB and on PCF with a PostgreSQL DB. The profile is selected for you. To configure DB password and URL, see documentation
3. Launch Postman
4. Register and login
7. You may now using any of the actuator, post, or comment endpoints defined in the documentation.

[Documentation found here.](https://app.swaggerhub.com/apis-docs/Zipcode-Wilmington/BlogDoc/0.1)

#Deployment Steps:
Note: You will need PCF CLI. Get it [here](https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry/install-the-cf-cli) if you do not have it.
1. Clone to the repo
2. Navigate to the project root directory using your terminal
3. Get a clean build using this command: ./mvnw clean package
4. After the build completes, push it to PCF using this command: cf push --no-start
5. If the push is successful, start the service using cf start zcw-group3blogproject


