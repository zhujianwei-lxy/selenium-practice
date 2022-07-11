package com.web.practice.webapi;

import com.web.practice.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * 等待方式
 */
public class WaitTest {
    WebDriver driver;

    @Test(description = "强制等待",priority = 1)
    public void testByThread() {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获得div块级元素
        WebElement element = driver.findElement(By.id("root"));
        //获取该元素css样式中background-color属性值
        String cssValue = element.getCssValue("background-color");
        //输出属性值
        System.out.println("cssValue: "+cssValue);
        //退出浏览器
        driver.quit();
    }

    @Test(description = "页面等待",priority = 2)
    public void testByPageLoad() {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //设置等待时间为3秒，如果3秒页面没有全部加载出来，就会报错，如果小于3秒就全部加载出来了，剩下的时间将不再等待，继续下一步操作
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        //退出浏览器
        driver.quit();
    }

    @Test(description = "隐式等待",priority = 3)
    public void testByImplicitlyWait() {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //设置等待时间为3秒，如果3秒元素没有加载出来，就会报错，如果小于3秒元素加载出来了，剩下的时间将不再等待，继续下一步操作
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        //获得div块级元素
        WebElement element = driver.findElement(By.id("root"));
        //获取该元素css样式中background-color属性值
        String cssValue = element.getCssValue("background-color");
        //输出属性值
        System.out.println("cssValue: "+cssValue);
        //退出浏览器
        driver.quit();
    }

    @Test(description = "显示等待方式一",priority = 4)
    public void testByShowWaiting1() {
        driver = Utils.getChromeDriver();
        ///打开今日头条
        driver.get("https://www.toutiao.com/");
        /**
         *等待时间为3秒，WebDriverWait默认每500ms就调用一次ExpectedCondition
         直到定位到该元素，如果3秒内div显示出来，则继续下一步，
         * 如果超过3秒没有显示出来，则until()会抛出org.openqa.selenium.TimeoutExceptionn异常
         */
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //元素是否存在，如果超过设置时间检测不到则抛出异常。
        wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                //重写方法
                return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div[1]/div/div/div/div[1]/div/ul/li[5]/div/div/a"));
            }
        });
        //获得div块级元素
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div[1]/div/div/div/div[1]/div/ul/li[5]/div/div/a"));
        //获取该元素css样式中background-color属性值
        String cssValue = element.getCssValue("background-color");
        //输出属性值
        System.out.println("cssValue: " + cssValue);
        //退出浏览器
        driver.quit();
    }

    @Test(description = "显示等待方式二",priority = 5)
    public void testByShowWaiting2() {
        driver = Utils.getChromeDriver();
        ///打开今日头条
        driver.get("https://www.toutiao.com/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[5]/div[1]/div/div/div/div[1]/div/ul/li[5]/div/div/a")));
        //获得div块级元素
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div[1]/div/div/div/div[1]/div/ul/li[5]/div/div/a"));
        //获取该元素css样式中background-color属性值
        String cssValue = element.getCssValue("background-color");
        //输出属性值
        System.out.println("cssValue: " + cssValue);
        //退出浏览器
        driver.quit();
    }
}
