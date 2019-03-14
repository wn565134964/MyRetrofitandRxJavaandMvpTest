package com.example.ning.myretrofitandrxjavaandmvptest.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils.Bean;
import com.example.ning.myretrofitandrxjavaandmvptest.Presenter.myPresenter;
import com.example.ning.myretrofitandrxjavaandmvptest.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button myBtn;
    private TextView myText;
    private String Url = "http://www.qubaobei.com";
    myPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        myBtn = (Button) findViewById(R.id.myBtn);
        myText = (TextView) findViewById(R.id.myText);
        myBtn.setOnClickListener(this);
        presenter = new myPresenter(this, Url);
        presenter.create();
        presenter.attachView(mView);
    }
    private myView mView = new myView() {
        @Override
        public void success(Bean bean) {
            myText.setText(bean.getData().get(0).getTitle());
        }

        @Override
        public void onError(String s) {
            Log.e("错误信息",s);
        }
    };
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myBtn:
                    presenter.getYMDX_Info();
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }
}
