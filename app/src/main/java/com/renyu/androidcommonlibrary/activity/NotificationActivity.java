package com.renyu.androidcommonlibrary.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.renyu.androidcommonlibrary.R;
import com.renyu.androidcommonlibrary.RemoteInputReceiver;
import com.renyu.commonlibrary.baseact.BaseActivity;
import com.renyu.commonlibrary.commonutils.NotificationUtils;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by renyu on 2018/1/29.
 */

public class NotificationActivity extends BaseActivity {

    @BindView(R.id.tv_hello)
    TextView tv_hello;
    @BindView(R.id.tv_channel1)
    TextView tv_channel1;
    @BindView(R.id.tv_channel2)
    TextView tv_channel2;
    @BindView(R.id.tv_send_messagestyle)
    TextView tv_send_messagestyle;
    @BindView(R.id.tv_update_messagestyle)
    TextView tv_update_messagestyle;
    @BindView(R.id.tv_send_messagestyle8)
    TextView tv_send_messagestyle8;
    @BindView(R.id.tv_send_remoteinput)
    TextView tv_send_remoteinput;

    NotificationManager manager=null;

    NotificationCompat.MessagingStyle style;

    @Override
    public void initParams() {
        manager=(NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
            NotificationChannel channel = new NotificationChannel("channel3", "channelName3", NotificationManager.IMPORTANCE_HIGH);
            // 开启指示灯，如果设备有的话。
            channel.enableLights(true);
            // 设置指示灯颜色
            channel.setLightColor(ContextCompat.getColor(this, com.renyu.commonlibrary.R.color.colorPrimary));
            // 是否在久按桌面图标时显示此渠道的通知
            channel.setShowBadge(true);
            // 设置是否应在锁定屏幕上显示此频道的通知
            channel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PRIVATE);
            // 设置绕过免打扰模式
            channel.setBypassDnd(true);
            manager.createNotificationChannel(channel);
        }

        tv_hello.setOnClickListener(v -> {
            String channelId="Channel1";
            String channelName="channelName1";

            String channelId2="Channel2";
            String channelName2="channelName2";

            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
                {
                    NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
                    // 开启指示灯，如果设备有的话。
                    channel.enableLights(true);
                    // 设置指示灯颜色
                    channel.setLightColor(ContextCompat.getColor(getApplicationContext(), com.renyu.commonlibrary.R.color.colorPrimary));
                    // 是否在久按桌面图标时显示此渠道的通知
                    channel.setShowBadge(true);
                    // 设置是否应在锁定屏幕上显示此频道的通知
                    channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
                    // 设置绕过免打扰模式
                    channel.setBypassDnd(true);
                    NotificationUtils.getNotificationCenter(getApplicationContext()).createNotificationChannel(channel);

                    NotificationCompat.Builder builder = NotificationUtils.getNotificationCenter(getApplicationContext()).getSimpleBuilder("ticker", "channel1", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, channelId, new Intent());
                    NotificationUtils.getNotificationCenter(getApplicationContext()).getNotificationManager().notify(100, builder.build());
                }


                {
                    NotificationChannel channel = new NotificationChannel(channelId2, channelName2, NotificationManager.IMPORTANCE_DEFAULT);
                    // 开启指示灯，如果设备有的话。
                    channel.enableLights(true);
                    // 设置指示灯颜色
                    channel.setLightColor(ContextCompat.getColor(getApplicationContext(), com.renyu.commonlibrary.R.color.colorPrimary));
                    // 是否在久按桌面图标时显示此渠道的通知
                    channel.setShowBadge(true);
                    // 设置是否应在锁定屏幕上显示此频道的通知
                    channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
                    // 设置绕过免打扰模式
                    channel.setBypassDnd(true);
                    NotificationUtils.getNotificationCenter(getApplicationContext()).createNotificationChannel(channel);

                    NotificationCompat.Builder builder = NotificationUtils.getNotificationCenter(getApplicationContext()).getSimpleBuilderWithTimeout("ticker", "channel2", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, channelId2, 10, new Intent());
                    NotificationUtils.getNotificationCenter(getApplicationContext()).getNotificationManager().notify(101, builder.build());
                }
            }

            NotificationCompat.Builder builder3 = NotificationUtils.getNotificationCenter(getApplicationContext()).getSimpleBuilder("ticker", "channel3", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, channelId, new Intent());
            NotificationUtils.getNotificationCenter(getApplicationContext()).getNotificationManager().notify(107, builder3.build());

            NotificationCompat.Builder builder4 = NotificationUtils.getNotificationCenter(getApplicationContext()).getSimpleBuilderWithTimeout("ticker", "channel4", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, channelId2, 10, new Intent());
            NotificationUtils.getNotificationCenter(getApplicationContext()).getNotificationManager().notify(106, builder4.build());
        });

        tv_channel1.setOnClickListener(v -> {
            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
                NotificationUtils.getNotificationCenter(getApplicationContext()).deleteNotificationChannel("Channel1");
            }
        });

        tv_channel2.setOnClickListener(v -> {
            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
                NotificationUtils.getNotificationCenter(getApplicationContext()).deleteNotificationChannel("Channel2");
            }
        });

        tv_send_messagestyle.setOnClickListener(v -> {
            ArrayList<NotificationCompat.MessagingStyle.Message> messages = new ArrayList<>();
            NotificationCompat.MessagingStyle.Message message1 = new NotificationCompat.MessagingStyle.Message("1 "+System.currentTimeMillis(), System.currentTimeMillis(), "11");
            NotificationCompat.MessagingStyle.Message message2 = new NotificationCompat.MessagingStyle.Message("2 "+System.currentTimeMillis(), System.currentTimeMillis(), "22");
            NotificationCompat.MessagingStyle.Message message3 = new NotificationCompat.MessagingStyle.Message("3 "+System.currentTimeMillis(), System.currentTimeMillis(), "33");
            NotificationCompat.MessagingStyle.Message message4 = new NotificationCompat.MessagingStyle.Message("4 "+System.currentTimeMillis(), System.currentTimeMillis(), "44");
            NotificationCompat.MessagingStyle.Message message5 = new NotificationCompat.MessagingStyle.Message("5 "+System.currentTimeMillis(), System.currentTimeMillis(), "55");
            messages.add(message1);
            messages.add(message2);
            messages.add(message3);
            messages.add(message4);
            messages.add(message5);
            style = NotificationUtils.getNotificationCenter(getApplicationContext()).createMessagingStyleNotification("ticker", "channel1", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, "demo", "2 new messages wtih ", messages, new Intent(), 104);
        });

        tv_update_messagestyle.setOnClickListener(v -> {
            ArrayList<NotificationCompat.MessagingStyle.Message> messages = new ArrayList<>();
            NotificationCompat.MessagingStyle.Message message6 = new NotificationCompat.MessagingStyle.Message("6 "+System.currentTimeMillis(), System.currentTimeMillis(), "66");
            messages.add(message6);
            NotificationUtils.getNotificationCenter(getApplicationContext()).updateMessagingStyleNotification("ticker", "channel1", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, style, messages, new Intent(), 104);
        });

        tv_send_messagestyle8.setOnClickListener(v -> {
            if (Build.VERSION_CODES.O <= Build.VERSION.SDK_INT) {
                Notification.Builder builder = createNewNotificationMessagingStyle("ticker", "channel1", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, "channel3", new Intent());
                manager.notify(102, builder.build());
            }
        });

        tv_send_remoteinput.setOnClickListener(v -> {
            NotificationUtils.getNotificationCenter(getApplicationContext()).createRemoteInput("ticker", "channel1", "content", Color.RED, R.mipmap.ic_launcher, R.mipmap.ic_launcher, "channel3", new Intent(), 105,
                    "快速回复", RemoteInputReceiver.class, R.mipmap.ic_launcher, "请输入回复的内容");
        });
    }

    @Override
    public int initViews() {
        return R.layout.activity_notification;
    }

    @Override
    public void loadData() {

    }

    @Override
    public int setStatusBarColor() {
        return Color.BLACK;
    }

    @Override
    public int setStatusBarTranslucent() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getSimpleBuilder(String ticker, String title, String content, int color, int smallIcon, int largeIcon, String channelId, Intent intent) {
        Notification.Builder builder=new Notification.Builder(this, channelId);
        builder.setTicker(ticker);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setContentIntent(PendingIntent.getBroadcast(this, (int) SystemClock.uptimeMillis(), intent, PendingIntent.FLAG_UPDATE_CURRENT));
        builder.setColor(color);
        // 设置和启用通知的背景颜色（只能在用户必须一眼就能看到的持续任务的通知中使用此功能）
        builder.setColorized(true);
        builder.setSmallIcon(smallIcon);
        builder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(), largeIcon));
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_ALL);
        // 保持通知不被移除
        builder.setOngoing(false);
        return builder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder createNewNotificationMessagingStyle(String ticker, String title, String content, int color, int smallIcon, int largeIcon, String channelId, Intent intent) {
        Notification.Style style = new Notification.MessagingStyle("Me").setConversationTitle("Team lunch")

                .addHistoricMessage(new Notification.MessagingStyle.Message("Historic Message - not visible", 1, "Liang"));

        Notification.Builder builder = getSimpleBuilder(ticker, title, content, color, smallIcon, largeIcon, NotificationUtils.channelId, intent);
        builder.setStyle(style);
        return builder;
    }
}
