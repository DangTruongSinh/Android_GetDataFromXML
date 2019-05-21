package com.truongsinh.luyentapgetdatafromxml;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AdapterItem.sukien{
    ArrayList<ItemRSS> arr =new ArrayList<ItemRSS>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      /*  arr.add(new Item(R.drawable.anh,"hinh 1"));
        arr.add(new Item(R.drawable.anh,"hinh 2"));
        arr.add(new Item(R.drawable.anh,"hinh 3"));
        arr.add(new Item(R.drawable.anh,"hinh 4"));
        arr.add(new Item(R.drawable.anh,"hinh 5"));
        arr.add(new Item(R.drawable.anh,"hinh 6"));
        arr.add(new Item(R.drawable.anh,"hinh 7"));
        arr.add(new Item(R.drawable.anh,"hinh 8"));*/


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo == null || !networkInfo.isConnected())
        {
            Toast.makeText(this, "Internet not connected", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String s ="https://vnexpress.net/rss/tin-moi-nhat.rss";
            new loadData().execute(s);
        }

    }
    class loadData extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openStream();
                XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
                xmlPullParser.setInput(inputStream,null);
                int event = xmlPullParser.getEventType();
                ItemRSS itemRSS =null;
                String chuoi = "";
                while (event!=XmlPullParser.END_DOCUMENT)
                {
                    String name = xmlPullParser.getName();
                    switch (event)
                    {
                        case XmlPullParser.START_TAG:
                            if(name.equals("item"))
                                 itemRSS = new ItemRSS();
                            break;
                        case XmlPullParser.TEXT:
                            chuoi = xmlPullParser.getText();
                            break;
                        case XmlPullParser.END_TAG:
                            if(name.equals("item"))
                                arr.add(itemRSS);
                            else if(name.equals("title") && itemRSS!=null)
                                itemRSS.setTieude(chuoi);
                            else if(name.equals("pubDate") && itemRSS!=null)
                                itemRSS.setNoidung(chuoi);
                            break;

                    }
                    event = xmlPullParser.next();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            AdapterRSS adapterItem = new AdapterRSS(arr);
            recyclerView.setAdapter(adapterItem);
        }
    }
    @Override
    public void phanhoisukien(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }
}
