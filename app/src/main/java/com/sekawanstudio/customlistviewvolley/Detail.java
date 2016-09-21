package com.sekawanstudio.customlistviewvolley;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by tjatoer on 05/09/16.
 */
public class Detail extends AppCompatActivity {
    public NetworkImageView imageView;
    public TextView textViewName;
    public TextView textViewRank;
    public TextView textViewRealName;
    public TextView textViewCreatedBy;
    public TextView textViewFirstAppearance;
    public TextView  textViewPowers;
    List<SuperHeroes> superHeroes;
    private ImageLoader imageLoader;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        imageView = (NetworkImageView) findViewById(R.id.imageViewHero);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewRank= (TextView) findViewById(R.id.textViewRank);
        textViewRealName= (TextView) findViewById(R.id.textViewRealName);
        textViewCreatedBy= (TextView) findViewById(R.id.textViewCreatedBy);
        textViewFirstAppearance= (TextView) findViewById(R.id.textViewFirstAppearance);
        textViewPowers= (TextView) findViewById(R.id.textViewPowers);

        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        String rank = b.getString("rank");
        String realname = b.getString("realname");
        String createby = b.getString("create by");
        String firstapp = b.getString("first appearance");
        String image = b.getString("image");

        imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(image, ImageLoader.getImageListener(imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        imageView.setImageUrl(image, imageLoader);
        textViewName.setText(name);
        textViewRank.setText(rank);
        textViewRealName.setText(realname);
        textViewCreatedBy.setText(createby);
        textViewFirstAppearance.setText(firstapp);





    }
}
