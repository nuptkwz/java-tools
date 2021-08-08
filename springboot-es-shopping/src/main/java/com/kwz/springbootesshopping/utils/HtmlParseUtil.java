package com.kwz.springbootesshopping.utils;

import com.kwz.springbootesshopping.module.Book;
import lombok.experimental.UtilityClass;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * Date 2020/8/8 20:31
 * Created by kwz
 */
@UtilityClass
public class HtmlParseUtil {
    private static String URL_TEMPLATE = "https://search.jd.com/Search?keyword=%s";

    public static void main(String[] args) throws IOException {
        List<Book> books = getJdBooks("vue");
        System.out.println(books);
    }

    public List<Book> getJdBooks(String keywords) throws IOException {
        //获取浏览器Document对象
        String url = String.format(URL_TEMPLATE, keywords);
        Document document = Jsoup.parse(new URL(url), 30000);
        Element goodsElement = document.getElementById("J_goodsList");
        //获取li标签
        Elements liElements = goodsElement.getElementsByTag("li");
        return liElements.stream().map(
                element -> {
                    //商品标题
                    String title = element.getElementsByClass("p-name").eq(0).text();
                    //图片url（image标签）
                    String pictureUrl = element.getElementsByTag("img").eq(0).attr("data-lazy-img");
                    //商品价格
                    String price = element.getElementsByClass("p-price").eq(0).text();
                    return new Book(title, price, pictureUrl);
                }
        ).collect(Collectors.toList());
    }
}
