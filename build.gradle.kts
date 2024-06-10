plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.dev"
version = "0.0.1-SNAPSHOT"
var springCloudVersion= "2022.0.4"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	//implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	//implementation("org.springframework.boot:spring-boot-starter-amqp")
	//implementation("org.springframework.boot:spring-boot-starter-web")
	
	implementation("org.springframework.boot:spring-boot-starter-rsocket")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	
	//implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
	//implementation("org.springframework.cloud:spring-cloud-stream-binder-rabbit")
	//implementation("org.springframework.kafka:spring-kafka")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.r2dbc:r2dbc-h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
dependencyManagement {
  imports {
    mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
  }
}

tasks.withType<Test> {
	useJUnitPlatform()
}
