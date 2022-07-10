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
    WebDriver driver = Utils.getChromeDriver();

    /**
     * @Description 访问网站
     */
    @Test
    public void testOpen() throws InterruptedException {
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
    @Test
    public void testGoto() throws InterruptedException {
        //跳转到头条
        driver.navigate().to("https://www.toutiao.com/");
        Thread.sleep(3000);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 浏览器前进、后退操作
     */
    @Test
    public void testForwardBackward() throws Exception {
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
    @Test
    public void testRefresh() throws Exception {
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //刷新操作
        driver.navigate().refresh();
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 浏览器窗口操作
     */
    @Test
    public void testWindow(){
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
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 获取页面标题（title属性）
     * @throws Exception
     */
    @Test
    public void testGetTitle() throws Exception {
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //获取页面title属性
        String title = driver.getTitle();
        System.out.println(title);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 获取页面源代码信息
     * @throws Exception
     */
    @Test
    public void testGetPageSource() throws Exception {
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //获取页面源代码
        String pageSource = driver.getPageSource();
        //输出页面源代码
        System.out.println(pageSource);
        //退出浏览器
        driver.quit();
    }


    /**
     * @Description 获取当前页面URL地址
     * @throws Exception
     */
    @Test
    public void testGetCurrentUrl() throws Exception {
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //获取当前页面URL地址
        String currentUrl = driver.getCurrentUrl();
        //输出URL信息
        System.out.println(currentUrl);
        //退出浏览器
        driver.quit();
    }

    /**
     * @Description 关闭浏览器操作
     */
    @Test
    public void testClose() {
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        //退出并关闭标签页
        driver.quit();
        //仅关闭当前标签页
        //driver.close();
    }

}
