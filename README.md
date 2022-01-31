# Sandbox - pictureservice-hbc

A sandbox for handling images with Spring Boot and Javascript

### Notes:
This is not a showcase for any particular skill, more just a simpple testing grounds where I  can test functionality.
Mainly meant for REST api with Spring Boot, Postgresql and JavaScript for handling images

### About imgages and posgres:
@Lob annotations does not work with postgresql, the variable should be used as following way: "@Type(type = "org.hibernate.type.BinaryType")".
