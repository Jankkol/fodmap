# Fodmap project concept

FODMAP is an acronym, derived from:

- Fermentable 
- Oligo-,
- Di-,
- Mono-saccharides 
- And 
- Polyols

In this project I will create web application with common knowledge about diet and products/ingridents and its importance for digestive system
healthy.The FODMAP concept is fairly new and very effective method helping with reducing IBS discomfort effects.

# Technology

I will trying to keep project to be updated as possible to newest and coolest technologies (especially in java world).

Actual stuff:

- Java 11
- Angular 6 (should be added soon)
- Spring Boot 2.0
- Spring HATEOAS
- Liquibase
- PostresSQL as supported db

# Plans:

- create ingredient model
- create fodmap model
- add data about fodmap (few ingredients at the begining)
- add Angular 6, create first views
- filter ingredients by fodmap
- support locals (data will be provided in polish and english)
- configurable deploy

# How to run application:

Requirements:
- gradle 4+
- Java 11
- installed PostgresDb (could be deployed on docker on even remote, I'd recommend Postgres official image from DockerHub)

After that, db properties has to be provided (here is example, could be changed to h2 as well):
**db.properties**
```
fodmap.db.driver=org.postgresql.Driver
fodmap.db.url=jdbc:postgresql://172.17.0.2:5432/postgres
fodmap.db.username=postgres
fodmap.db.password=1234
org.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
hibernate.jdbc.batch_size=20
```

and run gradle task:

```gradle bootRun```


