package com.web.practice.webapi;

import com.web.practice.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * iframe切换处理
 */
public class IframeTest {
    WebDriver driver;


    @Test(description = "使用iframe标签位置切换",priority = 1)
    public void testSwitchIframe1() {
        driver = Utils.browserOpened();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //点击反馈
        WebElement feedback = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[7]/ul/li[2]"));
        Utils.hightlightElement(driver,feedback);
        feedback.click();
        //用iframe标签的位置切换，本页面就一个iframe框，故此写0，表示第一个标签
        driver.switchTo().frame(0);
        //找到问题描述
        WebElement input = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div/form/div[2]/div/div/div/textarea"));
        Utils.hightlightElement(driver,input);
        //输入寻吧
        input.sendKeys("寻吧");
    }


    @Test(description = "使用元素对象进行iframe切换",priority = 2)
    public void testSwitchIframe2() {
        driver = Utils.browserOpened();
        //打开今日头条
//        driver.get("https://www.toutiao.com/");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //点击反馈
        WebElement feedback = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[7]/ul/li[2]"));
        Utils.hightlightElement(driver,feedback);
        feedback.click();
        //获得iframe元素对象
        WebElement iframe = driver.findElement(By.id("summon-web-iframe"));
        //使用元素对象进行iframe切换
        driver.switchTo().frame(iframe);
        //找到问题描述
        WebElement input = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div/form/div[2]/div/div/div/textarea"));
        Utils.hightlightElement(driver,input);
        //输入寻吧
        input.sendKeys("寻吧");
    }


    @Test(description = "使用id属性进行iframe切换",priority = 3)
    public void testSwitchIframe3() {
        driver = Utils.browserOpened();
        //打开今日头条
//        driver.get("https://www.toutiao.com/");
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //点击反馈
        WebElement feedback = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[7]/ul/li[2]"));
        Utils.hightlightElement(driver,feedback);
        feedback.click();
        //使用id属性进行iframe切换
        driver.switchTo().frame("summon-web-iframe");
        //找到问题描述
        WebElement input = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div/form/div[2]/div/div/div/textarea"));
        Utils.hightlightElement(driver,input);
        //输入寻吧
        input.sendKeys("寻吧");
    }

}
