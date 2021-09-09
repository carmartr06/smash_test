package com.smash.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CellPhoneApp implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CellPhoneApp.class);

    public static void main (String[] args){
        SpringApplication.run(CellPhoneApp.class, args);
    }


    @Override
    public void run (String... args) throws Exception{
        log.info("Importing data {}", Arrays.toString(args));
    }
}
