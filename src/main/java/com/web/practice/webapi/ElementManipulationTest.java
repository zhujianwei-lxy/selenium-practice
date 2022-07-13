package com.web.practice.webapi;

import com.web.practice.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


/**
 * 浏览器元素操作
 */
public class ElementManipulationTest {
    WebDriver driver;

    @Test(description = "click形式点击", priority = 1)
    public void testButton() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //获得元素对象即可用按钮
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/button"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,button);
        //判断按钮是否可以点击
        if (button.isEnabled()) {
            button.click();
        }
        //退出浏览器
        driver.quit();
    }


    @Test(description = "submit形式点击", priority = 2)
    public void testSubmit() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //点击反馈按钮
        WebElement feedback = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[7]/ul/li[2]"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,feedback);
        feedback.click();
        //切换iframe窗口
        driver.switchTo().frame("summon-web-iframe");
        //等待1秒
        Thread.sleep(1000);
        //点击提交按钮（该元素type="submit"）
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div/form/button"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,submit);
        //判断按钮是否可以点击
        boolean isDisplayed = submit.isDisplayed();
        if (isDisplayed) {
            //如可点击，则点击可用按钮
            submit.click();
        }
        //退出浏览器
        driver.quit();
    }

    @Test(description = "输入操作", priority = 3)
    public void testInput() throws Exception {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(2000);
        //获得元素对象（搜索输入框）
        WebElement input = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/input"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,input);
        //清空默认文本
        input.clear();
        //输入测试
        input.sendKeys("测试");
        //等待1秒（为了更清楚的看到效果）
        Thread.sleep(1000);
        //退出浏览器
        driver.quit();
    }

    @Test(description = "获取页面元素文本操作", priority = 4)
    public void testGetText() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(2000);
        //热搜第一个
        WebElement text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/div/div[1]/span"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,text);
        //输出热搜第一个文本
        System.out.println(text.getText());
        //退出浏览器
        driver.quit();
    }

    @Test(description = "获取页面元素标签名称操作", priority = 5)
    public void testGetTagName() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //热搜第一个
        WebElement text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/div/div[1]/span"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,text);
        //输出热搜元素标签
        System.out.println(text.getTagName());
        //退出浏览器
        driver.quit();
    }

    @Test(description = "获取页面元素属性值操作", priority = 6)
    public void testGetAttribute() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //获得热搜栏
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/div"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,button);
        //输出热搜栏的class属性值
        System.out.println(button.getAttribute("class"));
        //退出浏览器
        driver.quit();
    }

    @Test(description = "获取页面元素的尺寸操作", priority = 7)
    public void testGetSize() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //获取搜索按钮
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/button"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,button);
        //输出搜索按钮尺寸
        System.out.println(button.getSize());
        //退出浏览器
        driver.quit();
    }

    @Test(description = "获取页面元素的CSS样式操作", priority = 8)
    public void testGetCssValue() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //获取搜索按钮
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/button"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,button);
        //输出搜索按钮的css属性background值
        System.out.println(button.getCssValue("background"));
        //退出浏览器
        driver.quit();
    }

    @Test(description = "获取页面元素的坐标操作", priority = 10)
    public void testGetLocation() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //获取搜索按钮
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/button"));
        //高亮显示元素(方便看效果)
        Utils.hightlightElement(driver,button);
        //输出搜索按钮的坐标
        System.out.println(button.getLocation());
        //退出浏览器
        driver.quit();
    }

    @Test(description = "获取页面多个元素操作", priority = 11)
    public void testFindElements() throws InterruptedException {
        driver = Utils.getChromeDriver();
        //打开今日头条
        driver.get("https://www.toutiao.com/");
        Thread.sleep(3000);
        //定位所有超链接元素，即a标签个数，返回一个list集合
        List<WebElement> elements = driver.findElements(By.xpath("//a"));
        //打印首页中超链接的个数
        System.out.println(elements.size());
        //退出浏览器
        driver.quit();
    }
}
