* Configure the Spring Cloud Config Server with an `application.properties` or `application.yml` in `batch-job/src/main/resources` with the following properties configured:
    * `spring.datasource.driverClassName`
    * `spring.datasource.url`
    * `spring.datasource.username`
    * `spring.datasource.password`
    * `spring.datasource.schema` - this should point to the `schema-mysql.sql` in the same directory
    * `job.resource-path` - this should be the S3 bucket
    * `cloud.aws.credentials.accessKey`
    * `cloud.aws.credentials.secretKey`
    * `cloud.aws.region.static` - the region the S3 bucket exists in
    * `cloud.aws.region.auto` - this should be false unless you are running this on AWS
* Launch the Config server & eureka via `spring cloud configserver eureka`
* Build the project from the root via `./mvnw clean install`
* Launch Spring Cloud Data Flow (SCDF) via `java -jar bin/spring-cloud-dataflow-server-local-1.5.1.RELEASE.jar`
* Launch Spring Cloud Data Flow Shell via `java -jar bin/spring-cloud-dataflow-shell-1.5.1.RELEASE.jar`
* Register the app with SCDF in the shell via 'app register --name S3JDBC --type task --uri "maven://io.spring.cloud-native-batch:batch-job:0.0.1-SNAPSHOT"'
* Launch the UI from http://localhost:9393/dashboard
* Launch the task via the UI
* Verify results via the query `select * from cloud_native_batch.foo;` assuming your schema is called `cloud_native_batch`
