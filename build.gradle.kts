import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id ("org.flywaydb.flyway") version "6.2.2"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("plugin.jpa") version "1.6.10"
}

group = "com.example."
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.flywaydb:flyway-core")

	implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")
	implementation("com.fasterxml.jackson.core:jackson-core:2.11.2")
	implementation("com.fasterxml.jackson.core:jackson-annotations:2.11.2")

	//testImplementation ("com.github.springtestdbunit:spring-test-dbunit")
	//testImplementation ("org.dbunit:dbunit")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//DBサーバ作成
tasks.register("runup", Exec::class) {
	commandLine("docker-compose", "up", "-d")
}

//DBサーバ作成
tasks.register("rundown", Exec::class) {
	commandLine("docker-compose", "down")
}

//DB作成
tasks.register("createDb", Exec::class) {
	//TODO 可変にしたい
	commandLine("docker", "exec", "-i", "mssql", "/opt/mssql-tools/bin/sqlcmd", "-U", "sa", "-P", "passWord567", "-Q", "CREATE DATABASE test")
}

//Flyway接続先
flyway {
	url = "jdbc:sqlserver://localhost:1433;databaseName=test;loginTimeout=30;socketTimeout=30000"
	user = "sa"
	password = "passWord567"
}
