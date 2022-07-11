package com.web.practice.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import io.qameta.allure.Attachment;
import lombok.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

@Data
public class Utils {
    static JavascriptExecutor js;
    static WebDriver driver;

    /**
     * @return 浏览器驱动
     * @Description 获取chrome浏览器驱动
     */
    public static WebDriver getChromeDriver() {
        //设置驱动
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        //浏览器窗口最大化
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * @param webDriver     驱动
     * @param attributeName 属性名
     * @param element       元素位置
     * @param value         更改后的值
     * @Description 修改页面元素属性
     */
    public static void setAttribute(WebDriver webDriver, WebElement element, String attributeName, String value) {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
    }

    /**
     * @param webDriver     驱动
     * @param attributeName 属性名
     * @param element       元素位置
     * @Description 封装删除页面元素属性
     */
    public static void removeAttribute(WebDriver webDriver, WebElement element, String attributeName) {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].removeAttribute(arguments[1],arguments[2])", element, attributeName);
    }

    /**
     * @param element 元素
     * @Description 高亮显示元素
     */
    public static void hightlightElement(WebDriver driver,WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "background: yellow; border: 2px solid red;");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return 时间
     * @Description 获取当前时间
     */
    public static String timestamp() {
        DateTime date = DateUtil.date();
        return String.valueOf(date);
    }

    /**
     * @param driver 驱动
     * @Description 截图
     */
    @Attachment(value = "截图如下：",type = "image/png")
    public static byte[] creatFile(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}
