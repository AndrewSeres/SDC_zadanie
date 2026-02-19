package com.andrej;

import com.andrej.service.ExcelReaderService;
import com.andrej.validators.PrimeNumberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;


public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }

        String filePath = args[0];
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            logger.error("The file '{}' does not exist or is not a valid file.", filePath);
            System.exit(1);
        }


        ExcelReaderService reader = new ExcelReaderService();
        PrimeNumberValidator validator = new PrimeNumberValidator();

        try {
            List<Long> numbers = reader.readNumbers(file);

            for (Long n : numbers) {
                if (validator.isValidPrime(n)) {
                    logger.info("{}", n);
                }
            }
        } catch (Exception e) {
            logger.error("An unexpected error occurred during procesing: ", e);
            System.exit(1);
        }
    }
}