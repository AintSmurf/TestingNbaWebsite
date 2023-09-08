package Utils;


import locators.StatsLocators;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.PlayerInfo;
import pages.TeamInfo;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Helpers {

    public static <T, K> HashMap<T, K> buildHashmap(List<T> l1, List<K> l2) {
        HashMap<T, K> map = new HashMap<>();
        for (int i = 0; i < l1.size() - 1; i++) {
            map.put(l1.get(i), l2.get(i));
        }
        return map;
    }

    public static void changeSeason(WebDriver driver, String season) {
        ClickOnHeader(driver," ",20,30);
        WebElement seasons = null;
        seasons = waitsHelpers.waitTillVisible(driver,20,StatsLocators.SELECTSEASONS);
        Select select = new Select(seasons);
        select.selectByValue(season);
    }

    public static void ClickOnHeader(WebDriver driver, String text, int timeout, int ret) {
        List<WebElement> columns = new ArrayList<>();
        int maxRetries = ret;
        int retries = 0;
        while (columns.size() < 28 && retries < maxRetries) {
            try {
                WebElement table = waitsHelpers.waitTillVisible(driver, timeout, StatsLocators.HEADERS);
                columns = table.findElements(By.tagName("th"));
                retries++;
            } catch (StaleElementReferenceException e) {
                System.out.printf("StaleElementReferenceException occurred: Retry %d of %d%n", retries + 1, maxRetries);
                retries++;
            } catch (Exception e) {
                System.out.printf("An error occurred: Retry %d of %d%n", retries + 1, maxRetries);
                retries++;
            }
        }
        if (columns.size() < 28) {
            throw new RuntimeException("Failed to find the required number of columns after retries.");
        }
        try {
            List<String> options = columns.stream().map(WebElement::getText).filter(t -> !t.isEmpty()).toList();
            List<String> attributes = columns.stream()
                    .map(element -> element.getAttribute("field"))
                    .toList();
            HashMap<String, String> map = Helpers.buildHashmap(options, attributes);
            if (options.contains(text)) {
                String temp = map.get(text);
                waitsHelpers.waitTillClickable(driver, timeout, By.xpath(String.format("//th[@field='%s']", temp)));
            } else {
                System.out.println("didn't find the required header.");
            }
        }
        catch (Exception StaleElementReferenceException){
            System.out.printf("StaleElementReferenceException occurred\ncoulndt find %s\n",text);
            ClickOnHeader(driver,text,timeout,maxRetries);
        }
    }

    public static <T> List<T> getTableData(WebDriver driver, Class<T> targetType) {
        List<WebElement> tableContent = driver.findElements(StatsLocators.TABLEBODYCONTENT);
        List<T> dataList = new ArrayList<>();
        T dataItem;
        try {
            if (targetType.equals(PlayerInfo.class)) {
                for (WebElement row : tableContent) {
                    List<WebElement> columns = row.findElements(By.tagName("td"));

                    String nameColumn = columns.get(1).getText();
                    String team = columns.get(2).getText();
                    int age = Integer.parseInt(columns.get(3).getText());
                    int gamesPlayed = Integer.parseInt(columns.get(4).getText());
                    int wins = Integer.parseInt(columns.get(5).getText());
                    int loses = Integer.parseInt(columns.get(6).getText());
                    double minutesPlayed = Double.parseDouble(columns.get(7).getText());

                    String[] nameParts = nameColumn.split(" ");
                    StringBuilder name = new StringBuilder();

                    for (int i = 0; i < nameParts.length; i++) {
                        name.append(nameParts[i]).append(" ");
                    }
                    name.deleteCharAt(name.length() - 1);

                    dataItem = (T) new PlayerInfo(name.toString(), team, age, gamesPlayed, wins, loses, minutesPlayed);
                    dataList.add(dataItem);
                }

            } else if (targetType.equals(TeamInfo.class)) {
                for (WebElement row : tableContent) {
                    List<WebElement> columns = row.findElements(By.tagName("td"));

                    String team = columns.get(1).getText();
                    int gamesPlayed = Integer.parseInt(columns.get(2).getText());
                    int wins = Integer.parseInt(columns.get(3).getText());
                    int loses = Integer.parseInt(columns.get(4).getText());
                    double minutesPlayed = Double.parseDouble(columns.get(6).getText());

                    dataItem = (T) new TeamInfo(team, gamesPlayed, wins, loses, minutesPlayed);
                    dataList.add(dataItem);
                }

            } else {
                throw new IllegalArgumentException("Unsupported targetType: " + targetType.getName());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}



