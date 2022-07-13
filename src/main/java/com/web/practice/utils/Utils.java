package com.web.practice.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import io.qameta.allure.Attachment;
import lombok.Data;
import org.ietf.jgss.Oid;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Data
public class Utils {
    static JavascriptExecutor js;

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


    /**
     * @Description 获取已经打开的浏览器方法
     */
    public static WebDriver browserOpened(){
        /**
         * mac电脑：
         * 步骤一：在终端运行下面命令会自动打开一个新的chrome窗口
         * 终端命令：sudo /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --remote-debugging-port=9222
         */
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //增加浏览器参数配置本地127.0.0.1 端口：9222
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    @Test(description = "对上述封装方法进行测试")
    public void demo(){
        WebDriver driver = browserOpened();
        //这步骤已经操作了，浏览器也处于这步骤，可以注释
//        driver.get("https://www.toutiao.com/");
        //在已打开的浏览器操作方便调试自己的代码
        WebElement input = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/input"));
        hightlightElement(driver,input);
        input.sendKeys("软件测试");
    }

}
