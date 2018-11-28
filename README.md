# cqrs-es-spring-axon
(CQRS+ES) with Spring &amp; Axon

---
#### Pre-condition 

Download from [Axoniq](https://axoniq.io) the latest version of **AxonDB** and put the _axondb-server.jar_ on _docker/axondb_

Build a docker image for AxonDB.

----

### Fix before run

Base of where docker is installed please fix hostname used for AxonDB and PostgreSQL connection.

Check those properties values into _application.properties_

`primary.datasource.url`

`axoniq.axondb.servers`

