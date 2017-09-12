package ru.mail.park.lecture2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (ViewGroup) findViewById(R.id.container);

        final Button inflaterBtn = (Button) findViewById(R.id.btn_inflater);
        inflaterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                useInflater();
            }
        });

        final Button progBtn = (Button) findViewById(R.id.btn_programmatically);
        progBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                doProgrammatically();
            }
        });
    }

    private void useInflater() {
        container.removeAllViews();

        final LayoutInflater inflater = LayoutInflater.from(this);
        final View view = inflater.inflate(R.layout.test, container, false);
        container.addView(view);
    }

    private void doProgrammatically() {
        container.removeAllViews();

        final LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        final ImageView cat1 = new ImageView(this);
        cat1.setImageResource(R.drawable.ic_cat3);
        cat1.setLayoutParams(createCatParams());
        layout.addView(cat1);

        final ImageView cat2 = new ImageView(this);
        cat2.setImageResource(R.drawable.ic_cat1);
        cat2.setLayoutParams(createCatParams());
        layout.addView(cat2);

        container.addView(layout);
    }

    private static ViewGroup.LayoutParams createCatParams() {
        return new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
    }
}
