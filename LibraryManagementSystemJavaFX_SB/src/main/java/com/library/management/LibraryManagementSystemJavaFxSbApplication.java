package com.library.management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class LibraryManagementSystemJavaFxSbApplication extends Application implements CommandLineRunner {

	@Override
	public void run(String... args) {

	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemJavaFxSbApplication.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LibraryManagementSystemJavaFX libraryApp = new LibraryManagementSystemJavaFX();
		libraryApp.start(primaryStage);

	}

}
