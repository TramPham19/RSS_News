package com.example.rss_news;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {
    // Main GUI - A NEWS application based on National Public Radio RSS material
    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;
    // hard-coding main NEWS categories (TODO: use a resource file)
    String[][] myUrlCaptionMenu = {
            {"https://vnexpress.net/rss/the-gioi.rss", "The gioi"},
            {"https://vnexpress.net/rss/thoi-su.rss", "Thoi su"},
            {"https://vnexpress.net/rss/kinh-doanh.rss", "Kinh doanh"},
            {"https://vnexpress.net/rss/startup.rss", "Startup"},
            {"https://vnexpress.net/rss/giai-tri.rss", "Giai tri"},
            {"https://vnexpress.net/rss/the-thao.rss", "The thao"},
            {"https://vnexpress.net/rss/phap-luat.rss", "Phap luat"}
    };
    String[][] myUrlCaptionMenu1 = {
            {"https://tuoitre.vn/rss/the-gioi.rss", "The gioi"},
            {"https://tuoitre.vn/rss/thoi-su.rss", "Thời sự"},
            {"https://tuoitre.vn/rss/kinh-doanh.rss", "Kinh doanh"},
            {"https://tuoitre.vn/rss/suc-khoe.rss", "Suc khoe"},
            {"https://tuoitre.vn/rss/giai-tri.rss", "Giai tri"},
            {"https://tuoitre.vn/rss/the-thao.rss", "The thao"},
            {"https://tuoitre.vn/rss/phap-luat.rss", "Phap luat"}
    };
    String[][] myUrlCaptionMenu2 = {
            {"https://thanhnien.vn/rss/the-gioi.rss", "The gioi"},
            {"https://thanhnien.vn/rss/van-hoa.rss", "Văn hóa"},
            {"https://thanhnien.vn/rss/doi-song.rss", "Đời sống"},
            {"https://thanhnien.vn/rss/tai-chinh-kinh-doanh.rss", "Tài chính - kinh doanh"},
            {"https://thanhnien.vn/rss/giai-tri.rss", "Giai tri"},
            {"https://thanhnien.vn/rss/cong-nghe.rss", "Công nghệ"},
            {"https://game.thanhnien.vn/rss/home.rss", "Game"}
    };
    String[][] myUrlCaptionMenu3 = {
            {"https://vietnamnet.vn/rss/the-gioi.rss", "The gioi"},
            {"https://vietnamnet.vn/rss/thoi-su-chinh-tri.rss", "Thời sự - chính trị"},
            {"https://vietnamnet.vn/rss/kinh-doanh.rss", "Kinh doanh"},
            {"https://vietnamnet.vn/rss/suc-khoe.rss", "Suc khoe"},
            {"https://vietnamnet.vn/vn/giai-tri/index.html", "Giai tri"},
            {"https://vietnamnet.vn/rss/the-thao.rss", "The thao"},
            {"https://vietnamnet.vn/rss/phap-luat.rss", "Phap luat"}
    };
    //define convenient URL and CAPTIONs arrays
    String[] myUrlCaption = new String[myUrlCaptionMenu.length];
    String[] myUrlAddress = new String[myUrlCaptionMenu.length];
    String[] myUrlCaption1 = new String[myUrlCaptionMenu1.length];
    String[] myUrlAddress1 = new String[myUrlCaptionMenu1.length];
    String[] myUrlCaption2 = new String[myUrlCaptionMenu2.length];
    String[] myUrlAddress2 = new String[myUrlCaptionMenu2.length];
    String[] myUrlCaption3 = new String[myUrlCaptionMenu3.length];
    String[] myUrlAddress3 = new String[myUrlCaptionMenu3.length];
    public static String niceDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy",


                Locale.US);
        return sdf.format(new Date()); //Monday Apr 7, 2014
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //====================
        Intent myCallerIntent = getIntent();
        Bundle myBundle = myCallerIntent.getExtras();
        int val1 = myBundle.getInt("val1");
        //===================
        if(val1 == 1)
        {
            for (int i = 0; i < myUrlAddress.length; i++) {
                myUrlAddress[i] = myUrlCaptionMenu[i][0];
                myUrlCaption[i] = myUrlCaptionMenu[i][1];
            }
            context = getApplicationContext();
            this.setTitle("Vnexpress Headline News\n" + niceDate());
    // user will tap on a ListView’s row to request category’s headlines
            myMainListView = (ListView) this.findViewById(R.id.myListView);
            myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
                    String urlAddress = myUrlAddress[_index], urlCaption = myUrlCaption1[_index];
    //create an Intent to talk to activity: ShowHeadlines
                    Intent callShowHeadlines = new Intent(MainActivity.this, ShowHeadlines.class);
    //prepare a Bundle and add the input arguments: url & caption
                    Bundle myData = new Bundle();
                    myData.putString("urlAddress", urlAddress);
                    myData.putString("urlCaption", urlCaption);
                    callShowHeadlines.putExtras(myData);
                    startActivity(callShowHeadlines);
                }
            });
    // fill up the Main-GUI’s ListView with main news categories
            adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption);
            myMainListView.setAdapter(adapterMainSubjects);
        }
        else if(val1 == 2){
            for (int i = 0; i < myUrlAddress1.length; i++) {
                myUrlAddress1[i] = myUrlCaptionMenu1[i][0];
                myUrlCaption1[i] = myUrlCaptionMenu1[i][1];
            }
            context = getApplicationContext();
            this.setTitle("Vnexpress Headline News\n" + niceDate());
            // user will tap on a ListView’s row to request category’s headlines
            myMainListView = (ListView) this.findViewById(R.id.myListView);
            myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
                    String urlAddress = myUrlAddress1[_index], urlCaption = myUrlCaption1[_index];
                    //create an Intent to talk to activity: ShowHeadlines
                    Intent callShowHeadlines = new Intent(MainActivity.this, ShowHeadlines.class);
                    //prepare a Bundle and add the input arguments: url & caption
                    Bundle myData = new Bundle();
                    myData.putString("urlAddress", urlAddress);
                    myData.putString("urlCaption", urlCaption);
                    callShowHeadlines.putExtras(myData);
                    startActivity(callShowHeadlines);
                }
            });
            // fill up the Main-GUI’s ListView with main news categories
            adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption1);
            myMainListView.setAdapter(adapterMainSubjects);
        }
        else if(val1 == 3){
            for (int i = 0; i < myUrlAddress2.length; i++) {
                myUrlAddress2[i] = myUrlCaptionMenu2[i][0];
                myUrlCaption2[i] = myUrlCaptionMenu2[i][1];
            }
            context = getApplicationContext();
            this.setTitle("Vnexpress Headline News\n" + niceDate());
            // user will tap on a ListView’s row to request category’s headlines
            myMainListView = (ListView) this.findViewById(R.id.myListView);
            myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
                    String urlAddress = myUrlAddress2[_index], urlCaption = myUrlCaption2[_index];
                    //create an Intent to talk to activity: ShowHeadlines
                    Intent callShowHeadlines = new Intent(MainActivity.this, ShowHeadlines.class);
                    //prepare a Bundle and add the input arguments: url & caption
                    Bundle myData = new Bundle();
                    myData.putString("urlAddress", urlAddress);
                    myData.putString("urlCaption", urlCaption);
                    callShowHeadlines.putExtras(myData);
                    startActivity(callShowHeadlines);
                }
            });
            // fill up the Main-GUI’s ListView with main news categories
            adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption2);
            myMainListView.setAdapter(adapterMainSubjects);
        }
        else{
            for (int i = 0; i < myUrlAddress3.length; i++) {
                myUrlAddress3[i] = myUrlCaptionMenu3[i][0];
                myUrlCaption3[i] = myUrlCaptionMenu3[i][1];
            }
            context = getApplicationContext();
            this.setTitle("Vnexpress Headline News\n" + niceDate());
            // user will tap on a ListView’s row to request category’s headlines
            myMainListView = (ListView) this.findViewById(R.id.myListView);
            myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
                    String urlAddress = myUrlAddress3[_index], urlCaption = myUrlCaption3[_index];
                    //create an Intent to talk to activity: ShowHeadlines
                    Intent callShowHeadlines = new Intent(MainActivity.this, ShowHeadlines.class);
                    //prepare a Bundle and add the input arguments: url & caption
                    Bundle myData = new Bundle();
                    myData.putString("urlAddress", urlAddress);
                    myData.putString("urlCaption", urlCaption);
                    callShowHeadlines.putExtras(myData);
                    startActivity(callShowHeadlines);
                }
            });
            // fill up the Main-GUI’s ListView with main news categories
            adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption3);
            myMainListView.setAdapter(adapterMainSubjects);
        }
    }//onCreate
} // MainActivity