package com.srainbow.leisureten.util;

import com.srainbow.leisureten.data.ImgWithAuthor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SRainbow on 2017/4/9.
 */

public class HtmlParserWithJSoup {
    private volatile static HtmlParserWithJSoup instance = null;

    private HtmlParserWithJSoup(){}

    public static HtmlParserWithJSoup getInstance(){
        if(instance == null){
            synchronized (HtmlParserWithJSoup.class){
                if(instance == null){
                    instance = new HtmlParserWithJSoup();
                }
            }
        }
        return instance;
    }

    public List<String> parserHtmlForTags(){
        List<String> urlList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(Constant.Address_PICJUMBO).get();
            Element tags = doc.select("div.footer_tags").first().select("div.container").first();
            Elements tag = tags.select("a");
            for(Element ele : tag){
                urlList.add(ele.attr("href"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return urlList;
    }

    public List<ImgWithAuthor> parserHtmlForImgWithAuthor() {
        List<ImgWithAuthor> imgWithAuthorList = new ArrayList<>();
        if (parserHtmlForTags().size() > 0) {
            try {
                Document doc = Jsoup.connect(parserHtmlForTags().get(0)).get();
                Element content = doc.select("div.container").select("div.sticky_wrap")
                        .select("div.content").first();
                Elements items = content.select("div.item_wrap");
                for (Element ele : items) {
                    String imgUrl = ele.getElementsByClass("img_wrap").select("a").select("img").attr("src");
                    String author = ele.select("p").select("a").text();
                    imgWithAuthorList.add(new ImgWithAuthor(imgUrl, author));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return imgWithAuthorList;
    }
}
