package com.web.practice.webapi;

import com.web.practice.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 窗口切换
 */
public class WindowSwitchTest {
    WebDriver driver;

    @Test
    public void testSwitchWindow() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //设置全局等待30秒
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //获得元素对象（搜索输入框）
        WebElement input = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/input"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,input);
        //清空默认文本
        input.clear();
        //在百度输入框中输入Refa
        input.sendKeys("selenium-浏览器元素操作");
        Thread.sleep(2000);
        //获得元素对象即可用按钮
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/button"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,button);
        //点击搜索按钮
        button.click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(200,1500)");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"s-dom-c5170c81\"]/div/div/div/div[1]/div/a/em"));
        Utils.hightlightElement(driver,element);
        element.click();
        //获取当前窗口句柄组合
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            //获得当前窗口title属性
            String title = driver.getTitle();
            //如果当前窗口title属性是selenium-浏览器元素操作，跳出遍历
            if (title.contains("selenium-浏览器元素操作")) {
                break;
            }
        }
        //输出新窗口页面标题
        System.out.println(driver.getTitle());
    }

}
