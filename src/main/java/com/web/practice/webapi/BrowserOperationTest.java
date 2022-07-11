package com.web.practice.webapi;

import com.web.practice.utils.Utils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * 浏览器操作
 */
public class BrowserOperationTest {
    WebDriver driver;

    /**
     * @Description 访问网站
     */
    @Test(priority = 1)
    public void testOpen() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开某个页面
        driver.get("https://www.toutiao.com/");
        //等待3秒
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 跳转网址
     */
    @Test(priority = 2)
    public void testGoto() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //跳转到头条
        driver.navigate().to("https://www.toutiao.com/");
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 浏览器前进、后退操作
     */
    @Test(priority = 3)
    public void testForwardBackward() throws Exception {
        driver = Utils.getChromeDriver();
        //打开百度
        driver.get("https://www.baidu.com/");
        //等待3秒
        Thread.sleep(3000);
        //打开今日头条
        driver.navigate().to("https://www.toutiao.com/");
        //等待3秒
        Thread.sleep(3000);
        //模拟浏览器后退操作
        driver.navigate().back();
        //等待3秒
        Thread.sleep(3000);
        //模拟浏览器前进操作
        driver.navigate().forward();
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 浏览器刷新操作
     * @throws Exception
     */
    @Test(priority = 4)
    public void testRefresh() throws Exception {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //刷新操作
        driver.navigate().refresh();
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 浏览器窗口操作
     */
    @Test(priority = 5)
    public void testWindow() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //浏览器窗口最小化
        driver.manage().window().minimize();
        //浏览器窗口最大化
        driver.manage().window().maximize();
        //设置窗口大小
        driver.manage().window().setSize(new Dimension(375,600));
        //设置窗口在什么位置打开显示
        driver.manage().window().setPosition(new Point(400,500));
        //全屏操作
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 获取页面标题（title属性）
     * @throws Exception
     */
    @Test(priority = 6)
    public void testGetTitle() throws Exception {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //获取页面title属性
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 获取页面源代码信息
     * @throws Exception
     */
    @Test(priority = 7)
    public void testGetPageSource() throws Exception {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //获取页面源代码
        String pageSource = driver.getPageSource();
        //输出页面源代码
        System.out.println(pageSource);
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }


    /**
     * @Description 获取当前页面URL地址
     * @throws Exception
     */
    @Test(priority = 8)
    public void testGetCurrentUrl() throws Exception {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //获取当前页面URL地址
        String currentUrl = driver.getCurrentUrl();
        //输出URL信息
        System.out.println(currentUrl);
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 关闭浏览器操作
     */
    @Test(priority = 9)
    public void testClose() {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //退出并关闭标签页
        driver.quit();
        //仅关闭当前标签页
        //driver.close();
    }

}
