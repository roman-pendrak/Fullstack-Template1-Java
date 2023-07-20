# Fullstack-Template1-Java :man_technologist:
Modern Java/Spring full stack template using the latest technologies :zap:

# Install Java 17+, create database, clone, build, and run!
```bash
# build
$ mvn clean install

# run dev mode
$ spring-boot:run
```
---
# Auth0 Setup :lock:
Authentication is not enabled out of the box but configuration is simple.
Follow the steps below to enable OAuth using Spring Security and the free OAuth provider Auth0
---
*** Skip steps 1-3 if you already configured Auth0 using the Fullstack-Template1-React project ***
1. Sign up for FREE Auth0 account
2. Create Application
3. Note the information provided: 
   1. Name
   2. Domain
   3. Client ID
   4. Client Secret
4. Create API
5. Copy "Domain" from Application
6. Copy "API Audience/Identifier" from API
7. Paste copied values in application.properties for corresponding properties: 
   1. auth0.domain=
   2. auth0.audience=
8. Clear "disabledSecurity" from the "spring.profiles.active" value. Leave blank or replace with any other value
9. Uncomment the UNSECURE SecurityFilterChain method and comment in the SECURE method enabling OAuth. (SecurityConfig.java)
