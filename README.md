# jag-bcsc-auth-service
BCSC Auth service (eCRC microservice) by Ministry of Justice

Technical Overview
---------------------
| Layer   | Technology |
| ------- | ------------ |
| Service | Java, SpringFramework |
| Application Server | Spring Boot / Tomcat |
| Runtime | Pathfinder OpenShift |

## Installation:
### Local Environment:
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

#### Prerequisites

Possibly STS4 (Used to create this initial code base).

Note: Clone the repo then import as a 'Maven' project into STS4.

#### Environmental variables for running the eCRC-API locally

The following Windows environmental variables must be set either as Windows environmental variables or as STS4 Spring Boot App variables.

| Variable                                           |                Example Value |
| -------------------------------------------------- | ---------------------------: |
| BCSC_OAUTH_BASIC_PASSWORD                          |                     password |
| BCSC_OAUTH_BASIC_USERNAME                          |                         user |
| BCSC_OAUTH_IDP                                     |                      IDP url |
| BCSC_OAUTH_JWT_AUTH_ROLE                           |                   Authorized |
| BCSC_OAUTH_JWT_HEADER                              |               Authorization2 |
| BCSC_OAUTH_JWT_PREFIX                              |                       Bearer |
| BCSC_OAUTH_JWT_SECRET                              |                Authorization |
| BCSC_OAUTH_SERVER_PORT                             |              SOMETHINGSECRET |
| BCSC_OAUTH_TOKEN_EXPIRY                            |                         3000 |
| BCSC_OAUTH_WELL_KNOWN                              |                      someUrl |
| BCSC_PER_SECRET_URN_CA_BC_GOV_JUSTICE_ECRC_DEV     |                   someSecret |
| BCSC_RETURN_URI_URN_CA_BC_GOV_JUSTICE_ECRC_DEV     |                      someUrl |
| BCSC_SCOPE_URN_CA_BC_GOV_JUSTICE_ECRC_DEV          |                  oAuth scope |
| BCSC_SECRET_URN_CA_BC_GOV_JUSTICE_ECRC_DEV         |               secret for urn |

#### Installing

```
mvn clean install
```

#### Run locally (Tomcat server)

```
mvn springboot:run
```

#### Set project version using maven

```
mvn versions:set -DartifactId=*  -DgroupId=*
```

Note: If using STS4, see the **Boot Dashboard** window instead of using the Maven command above.

#### Application Context Path

```
http://localhost:8083/oauth
```

#### Autodeploy

This application will autodeploy after every save. (Due to Spring Boot Devtools in the POM).

#### Docker

Do run api in Docker conatiner create .env file using .env.template.

Run command

```
docker-compose up --build -d
```

#### Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

### OpenShift:
The latest OpenShift deployment images are available under pqyiwk-tools project. 

To manually deploy the latest image to a target environment:
- Create the deployment configuration if not yet exists. 
- Run oc command. Following is an example.
```
oc rollout latest dc/bcsc-auth-service -n pqyiwk-dev
```

## Files in this repository
```
project
+-- src
|   +-- bcsc-auth
```

DevOps Process
-------------

### Jenkins
Jenkins pipeline is triggered by merge request in the repository.

### DEV builds
Dev builds are triggered by merge request in the repository.

## Promotion to TEST
Login to the OpenShift Web Console and navigate to the Tools project for the system.  Go to Builds->Pipelines.  Click  "Yes" on "Deploy to Test Approval" prompt.

## Promotion to PROD
Login to the OpenShift Web Console and navigate to the Tools project for the system.  Go to Builds->Pipelines.  Click  "Yes" on "Deploy to Prod Approval" prompt.

### Environments

| Environment | URL                                    | VPN Required? |
| ----------- | -------------------------------------- | ------------- |
| DEV         | https://bcsc-auth-service-pqyiwk-dev.pathfinder.gov.bc.ca  | No           |
| TEST        | https://bcsc-auth-service-pqyiwk-test.pathfinder.bcgov | Yes           |
| PROD        | https://bcsc-auth-service-pqyiwk-prod.pathfinder.bcgov      | Yes            |

## Access Control - IP Whitelisting
To allow client application to access this BCSC auth service, the IP address of the client application must be added to the route configuration. Use white space to separate multiple IP addresses. Here is an example:
```
...
annotations:
	haproxy.router.openshift.io/ip_whitelist: 142.34.208.209 142.29.196.27
...
```