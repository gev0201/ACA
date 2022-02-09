package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class Utils {
    public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public String generateRandomString(int strLen) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = strLen;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static void main(String[] args) {
        String usernameAndPassword = "username:AA_123456";

        String base64Encoding = Base64.getEncoder().encodeToString(usernameAndPassword.getBytes());
        System.out.println("Encoded Username and password = " + base64Encoding);

        byte[] base64 = Base64.getDecoder().decode(base64Encoding);
        System.out.println("Decoded = " + new String(base64));

    }

}
