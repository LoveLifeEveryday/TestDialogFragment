package com.xcynice.testdialogfragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

/**
 * @Author 许朋友爱玩
 * @Date 2020/7/20
 * @Github https://github.com/LoveLifeEveryday
 * @JueJin https://juejin.im/user/5e429bbc5188254967066d1b/posts
 * @Description NiceDialogFragment
 */


public class NiceDialogFragment extends DialogFragment implements View.OnClickListener {

    public OnDialogListener mListener;
    private View mRootView;


    public NiceDialogFragment(OnDialogListener listener) {
        setOnDialogListener(listener);
    }


    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //加这句话去掉自带的标题栏
        Objects.requireNonNull(getDialog()).requestWindowFeature(Window.FEATURE_NO_TITLE);
        mRootView = inflater.inflate(R.layout.fragment_nice_dialog, null);
        //从下到上的动画
        AnimationUtil.slideToUp(mRootView);
        return mRootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv1 = view.findViewById(R.id.tv1);
        TextView tv2 = view.findViewById(R.id.tv2);
        TextView tv3 = view.findViewById(R.id.tv3);
        TextView tv4 = view.findViewById(R.id.tv4);
        Button button = view.findViewById(R.id.btn_cancel);
        button.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = Objects.requireNonNull(getDialog()).getWindow();
        WindowManager.LayoutParams params = Objects.requireNonNull(window).getAttributes();
        //设置显示在底部
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        View decorView = window.getDecorView();
        decorView.setPadding(100, 100, 100, 0);
        decorView.setBackground(new ColorDrawable(Color.TRANSPARENT));
        //设置点击空白处关闭，也能启动从上到下的动画
        decorView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    slideDown();
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                mListener.onDialogClick("1");
                slideDown();
                break;
            case R.id.tv2:
                mListener.onDialogClick("2");
                slideDown();
                break;
            case R.id.tv3:
                mListener.onDialogClick("3");
                slideDown();
                break;
            case R.id.tv4:
                mListener.onDialogClick("4");
                slideDown();
                break;
            case R.id.btn_cancel:
                slideDown();
                break;
            default:
        }
    }

    private void slideDown() {
        AnimationUtil.slideToDown(mRootView, new AnimationUtil.AnimationEndListener() {
            @Override
            public void onFinish() {
                dismiss();
            }
        });
    }


    public interface OnDialogListener {
        /**
         * 回调返回选择的人数
         *
         * @param person 选择的人数
         */
        void onDialogClick(String person);
    }


    public void setOnDialogListener(OnDialogListener dialogListener) {
        this.mListener = dialogListener;
    }
}