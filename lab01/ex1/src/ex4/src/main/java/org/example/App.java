package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify an URL to a file.");
            return;
        }

        String fileUrl = args[0];
        UrlValidator urlValidator = new UrlValidator();

        if (!urlValidator.isValid(fileUrl)) {
            System.out.println("This is not a valid URL.");
            return;
        }

        try {
            // Get the file name from the URL
            String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);

            // Download the file and save it to the current working directory
            FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));

            System.out.println("File downloaded successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred during file download: " + e.getMessage());
        }
    }
}
