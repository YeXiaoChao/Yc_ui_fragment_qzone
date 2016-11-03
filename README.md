<p>直接看栗子吧，效果基本实现，界面微调和弹窗的优化，去做的话会很耗时说，暂时就酱紫了。上传效果动态图太大了，直接手机截图的效果图如下：</p>
<p><img src="http://images.cnitblog.com/blog/359646/201502/121539393231870.jpg" alt="" /></p>
<p>&nbsp;</p>
<p>至于代码的实现主要就是自定义的菜单栏，和用 PopupWindow 实现弹窗了。仔细看代码很好懂的。</p>
<p>1.主界面布局代码如下：</p>
<div class="cnblogs_code" onclick="cnblogs_code_show('f24d4b80-37cc-4c70-82b8-3d9821b589a8')"><img id="code_img_closed_f24d4b80-37cc-4c70-82b8-3d9821b589a8" class="code_img_closed" src="http://images.cnblogs.com/OutliningIndicators/ContractedBlock.gif" alt="" /><img id="code_img_opened_f24d4b80-37cc-4c70-82b8-3d9821b589a8" class="code_img_opened" style="display: none;" onclick="cnblogs_code_hide('f24d4b80-37cc-4c70-82b8-3d9821b589a8',event)" src="http://images.cnblogs.com/OutliningIndicators/ExpandedBlockStart.gif" alt="" />
<div id="cnblogs_code_open_f24d4b80-37cc-4c70-82b8-3d9821b589a8" class="cnblogs_code_hide">
<pre><span style="color: #0000ff;">&lt;</span><span style="color: #800000;">RelativeLayout </span><span style="color: #ff0000;">xmlns:android</span><span style="color: #0000ff;">="http://schemas.android.com/apk/res/android"</span><span style="color: #ff0000;">
    xmlns:tools</span><span style="color: #0000ff;">="http://schemas.android.com/tools"</span><span style="color: #ff0000;">
    android:layout_width</span><span style="color: #0000ff;">="fill_parent"</span><span style="color: #ff0000;">
    android:layout_height</span><span style="color: #0000ff;">="fill_parent"</span> <span style="color: #0000ff;">&gt;</span>

    <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">FrameLayout
        </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/frame_content"</span><span style="color: #ff0000;">
        android:layout_width</span><span style="color: #0000ff;">="match_parent"</span><span style="color: #ff0000;">
        android:layout_height</span><span style="color: #0000ff;">="match_parent"</span><span style="color: #ff0000;">
        android:layout_above</span><span style="color: #0000ff;">="@+id/frameMenu"</span><span style="color: #ff0000;">
        android:layout_alignParentTop</span><span style="color: #0000ff;">="true"</span> <span style="color: #0000ff;">&gt;</span>
    <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">FrameLayout</span><span style="color: #0000ff;">&gt;</span>

    <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">FrameLayout
        </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/frameMenu"</span><span style="color: #ff0000;">
        android:layout_width</span><span style="color: #0000ff;">="match_parent"</span><span style="color: #ff0000;">
        android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
        android:layout_alignParentBottom</span><span style="color: #0000ff;">="true"</span> <span style="color: #0000ff;">&gt;</span>

        <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">LinearLayout
            </span><span style="color: #ff0000;">android:layout_width</span><span style="color: #0000ff;">="match_parent"</span><span style="color: #ff0000;">
            android:layout_height</span><span style="color: #0000ff;">="match_parent"</span><span style="color: #ff0000;">
            android:background</span><span style="color: #0000ff;">="@color/skin_tabbar_bg"</span><span style="color: #ff0000;">
            android:orientation</span><span style="color: #0000ff;">="horizontal"</span> <span style="color: #0000ff;">&gt;</span>

            <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 动态 </span><span style="color: #008000;">--&gt;</span>

            <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">FrameLayout
                </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/layout_at"</span><span style="color: #ff0000;">
                android:layout_width</span><span style="color: #0000ff;">="fill_parent"</span><span style="color: #ff0000;">
                android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                android:layout_weight</span><span style="color: #0000ff;">="1"</span> <span style="color: #0000ff;">&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">ImageView
                    </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/image_at"</span><span style="color: #ff0000;">
                    android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="top|center"</span><span style="color: #ff0000;">
                    android:src</span><span style="color: #0000ff;">="@drawable/skin_tabbar_icon_auth_select"</span> <span style="color: #0000ff;">/&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">TextView
                    </span><span style="color: #ff0000;">android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="bottom|center"</span><span style="color: #ff0000;">
                    android:text</span><span style="color: #0000ff;">="@string/skin_tabbar_icon_auth"</span><span style="color: #ff0000;">
                    android:textColor</span><span style="color: #0000ff;">="@android:color/black"</span><span style="color: #ff0000;">
                    android:textSize</span><span style="color: #0000ff;">="12sp"</span> <span style="color: #0000ff;">/&gt;</span>
            <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">FrameLayout</span><span style="color: #0000ff;">&gt;</span>

            <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 与我相关 </span><span style="color: #008000;">--&gt;</span>

            <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">FrameLayout
                </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/layout_auth"</span><span style="color: #ff0000;">
                android:layout_width</span><span style="color: #0000ff;">="fill_parent"</span><span style="color: #ff0000;">
                android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                android:layout_weight</span><span style="color: #0000ff;">="1"</span> <span style="color: #0000ff;">&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">ImageView
                    </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/image_auth"</span><span style="color: #ff0000;">
                    android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="top|center"</span><span style="color: #ff0000;">
                    android:src</span><span style="color: #0000ff;">="@drawable/skin_tabbar_icon_at_select"</span> <span style="color: #0000ff;">/&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">TextView
                    </span><span style="color: #ff0000;">android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="bottom|center"</span><span style="color: #ff0000;">
                    android:text</span><span style="color: #0000ff;">="@string/skin_tabbar_icon_at"</span><span style="color: #ff0000;">
                    android:textColor</span><span style="color: #0000ff;">="@android:color/black"</span><span style="color: #ff0000;">
                    android:textSize</span><span style="color: #0000ff;">="12sp"</span> <span style="color: #0000ff;">/&gt;</span>
            <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">FrameLayout</span><span style="color: #0000ff;">&gt;</span>

            <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 留白 </span><span style="color: #008000;">--&gt;</span>

            <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">FrameLayout
                </span><span style="color: #ff0000;">android:layout_width</span><span style="color: #0000ff;">="fill_parent"</span><span style="color: #ff0000;">
                android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                android:layout_weight</span><span style="color: #0000ff;">="1"</span> <span style="color: #0000ff;">&gt;</span>
            <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">FrameLayout</span><span style="color: #0000ff;">&gt;</span>

            <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 我的空间 </span><span style="color: #008000;">--&gt;</span>

            <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">FrameLayout
                </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/layout_space"</span><span style="color: #ff0000;">
                android:layout_width</span><span style="color: #0000ff;">="fill_parent"</span><span style="color: #ff0000;">
                android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                android:layout_weight</span><span style="color: #0000ff;">="1"</span> <span style="color: #0000ff;">&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">ImageView
                    </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/image_space"</span><span style="color: #ff0000;">
                    android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="top|center"</span><span style="color: #ff0000;">
                    android:src</span><span style="color: #0000ff;">="@drawable/skin_tabbar_icon_space_select"</span> <span style="color: #0000ff;">/&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">TextView
                    </span><span style="color: #ff0000;">android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="bottom|center"</span><span style="color: #ff0000;">
                    android:text</span><span style="color: #0000ff;">="@string/skin_tabbar_icon_space"</span><span style="color: #ff0000;">
                    android:textColor</span><span style="color: #0000ff;">="@android:color/black"</span><span style="color: #ff0000;">
                    android:textSize</span><span style="color: #0000ff;">="12sp"</span> <span style="color: #0000ff;">/&gt;</span>
            <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">FrameLayout</span><span style="color: #0000ff;">&gt;</span>

            <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 玩吧 </span><span style="color: #008000;">--&gt;</span>

            <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">FrameLayout
                </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/layout_more"</span><span style="color: #ff0000;">
                android:layout_width</span><span style="color: #0000ff;">="fill_parent"</span><span style="color: #ff0000;">
                android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                android:layout_weight</span><span style="color: #0000ff;">="1"</span> <span style="color: #0000ff;">&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">ImageView
                    </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/image_more"</span><span style="color: #ff0000;">
                    android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="top|center"</span><span style="color: #ff0000;">
                    android:src</span><span style="color: #0000ff;">="@drawable/skin_tabbar_icon_more_select"</span> <span style="color: #0000ff;">/&gt;</span>

                <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">TextView
                    </span><span style="color: #ff0000;">android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
                    android:layout_gravity</span><span style="color: #0000ff;">="bottom|center"</span><span style="color: #ff0000;">
                    android:text</span><span style="color: #0000ff;">="@string/skin_tabbar_icon_more"</span><span style="color: #ff0000;">
                    android:textColor</span><span style="color: #0000ff;">="@android:color/black"</span><span style="color: #ff0000;">
                    android:textSize</span><span style="color: #0000ff;">="12sp"</span> <span style="color: #0000ff;">/&gt;</span>
            <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">FrameLayout</span><span style="color: #0000ff;">&gt;</span>
        <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">LinearLayout</span><span style="color: #0000ff;">&gt;</span>

        <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">LinearLayout
            </span><span style="color: #ff0000;">android:layout_width</span><span style="color: #0000ff;">="match_parent"</span><span style="color: #ff0000;">
            android:layout_height</span><span style="color: #0000ff;">="1px"</span><span style="color: #ff0000;">
            android:background</span><span style="color: #0000ff;">="@android:color/black"</span> <span style="color: #0000ff;">&gt;</span>
        <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">LinearLayout</span><span style="color: #0000ff;">&gt;</span>
    <span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">FrameLayout</span><span style="color: #0000ff;">&gt;</span>

    <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 中间按钮背景 </span><span style="color: #008000;">--&gt;</span>

    <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">ImageView
        </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/toggle_btn"</span><span style="color: #ff0000;">
        android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
        android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
        android:layout_alignParentBottom</span><span style="color: #0000ff;">="true"</span><span style="color: #ff0000;">
        android:layout_alignTop</span><span style="color: #0000ff;">="@+id/frameMenu"</span><span style="color: #ff0000;">
        android:layout_centerInParent</span><span style="color: #0000ff;">="true"</span><span style="color: #ff0000;">
        android:src</span><span style="color: #0000ff;">="@drawable/skin_tabbar_btn"</span> <span style="color: #0000ff;">/&gt;</span>

    <span style="color: #008000;">&lt;!--</span><span style="color: #008000;"> 中间按钮 </span><span style="color: #008000;">--&gt;</span>

    <span style="color: #0000ff;">&lt;</span><span style="color: #800000;">ImageView
        </span><span style="color: #ff0000;">android:id</span><span style="color: #0000ff;">="@+id/plus_btn"</span><span style="color: #ff0000;">
        android:layout_width</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
        android:layout_height</span><span style="color: #0000ff;">="wrap_content"</span><span style="color: #ff0000;">
        android:layout_alignParentBottom</span><span style="color: #0000ff;">="true"</span><span style="color: #ff0000;">
        android:layout_alignTop</span><span style="color: #0000ff;">="@+id/frameMenu"</span><span style="color: #ff0000;">
        android:layout_centerInParent</span><span style="color: #0000ff;">="true"</span><span style="color: #ff0000;">
        android:src</span><span style="color: #0000ff;">="@drawable/skin_tabbar_icon_select"</span> <span style="color: #0000ff;">/&gt;</span>

<span style="color: #0000ff;">&lt;/</span><span style="color: #800000;">RelativeLayout</span><span style="color: #0000ff;">&gt;</span></pre>
</div>
<span class="cnblogs_code_collapse">activity_main.xml</span></div>
<p>2.弹窗布局，就是几个图标的显示，比较简单的，可以看代码</p>
<p>3.然后就是主界面逻辑代码了，菜单栏按钮事件控制页面的显示，可以图标的选中状态，已经弹窗的实现，代码如下：</p>
<div class="cnblogs_code" onclick="cnblogs_code_show('e2e5c8f9-c469-42e6-b05b-4d3fa4763685')"><img id="code_img_closed_e2e5c8f9-c469-42e6-b05b-4d3fa4763685" class="code_img_closed" src="http://images.cnblogs.com/OutliningIndicators/ContractedBlock.gif" alt="" /><img id="code_img_opened_e2e5c8f9-c469-42e6-b05b-4d3fa4763685" class="code_img_opened" style="display: none;" onclick="cnblogs_code_hide('e2e5c8f9-c469-42e6-b05b-4d3fa4763685',event)" src="http://images.cnblogs.com/OutliningIndicators/ExpandedBlockStart.gif" alt="" />
<div id="cnblogs_code_open_e2e5c8f9-c469-42e6-b05b-4d3fa4763685" class="cnblogs_code_hide">
<pre><span style="color: #0000ff;">package</span><span style="color: #000000;"> com.yanis.yc_ui_qzone;

</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.content.Context;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.graphics.drawable.BitmapDrawable;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.os.Bundle;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.support.v4.app.FragmentActivity;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.support.v4.app.FragmentTransaction;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.util.DisplayMetrics;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.view.LayoutInflater;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.view.MotionEvent;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.view.View;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.view.View.OnClickListener;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.view.View.OnTouchListener;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.widget.FrameLayout;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.widget.ImageView;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.widget.LinearLayout;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.widget.PopupWindow;
</span><span style="color: #0000ff;">import</span><span style="color: #000000;"> android.widget.PopupWindow.OnDismissListener;

</span><span style="color: #0000ff;">public</span> <span style="color: #0000ff;">class</span> MainActivity <span style="color: #0000ff;">extends</span> FragmentActivity <span style="color: #0000ff;">implements</span><span style="color: #000000;"> OnClickListener {
    </span><span style="color: #008000;">//</span><span style="color: #008000;"> 定义Fragment页面</span>
    <span style="color: #0000ff;">private</span><span style="color: #000000;"> FragmentAt fragmentAt;
    </span><span style="color: #0000ff;">private</span><span style="color: #000000;"> FragmentAuth fragmentAuth;
    </span><span style="color: #0000ff;">private</span><span style="color: #000000;"> FragmentSpace fragmentSpace;
    </span><span style="color: #0000ff;">private</span><span style="color: #000000;"> FragmentMore fragmentMore;
    </span><span style="color: #008000;">//</span><span style="color: #008000;"> 定义布局对象</span>
    <span style="color: #0000ff;">private</span><span style="color: #000000;"> FrameLayout atFl, authFl, spaceFl, moreFl;

    </span><span style="color: #008000;">//</span><span style="color: #008000;"> 定义图片组件对象</span>
    <span style="color: #0000ff;">private</span><span style="color: #000000;"> ImageView atIv, authIv, spaceIv, moreIv;

    </span><span style="color: #008000;">//</span><span style="color: #008000;"> 定义按钮图片组件</span>
    <span style="color: #0000ff;">private</span><span style="color: #000000;"> ImageView toggleImageView, plusImageView;

    </span><span style="color: #008000;">//</span><span style="color: #008000;"> 定义PopupWindow</span>
    <span style="color: #0000ff;">private</span><span style="color: #000000;"> PopupWindow popWindow;
    </span><span style="color: #008000;">//</span><span style="color: #008000;"> 获取手机屏幕分辨率的类</span>
    <span style="color: #0000ff;">private</span><span style="color: #000000;"> DisplayMetrics dm;

    @Override
    </span><span style="color: #0000ff;">protected</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> onCreate(Bundle savedInstanceState) {
        </span><span style="color: #0000ff;">super</span><span style="color: #000000;">.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 初始化默认为选中点击了&ldquo;动态&rdquo;按钮</span>
<span style="color: #000000;">        clickAtBtn();
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 初始化组件
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> initView() {
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 实例化布局对象</span>
        atFl =<span style="color: #000000;"> (FrameLayout) findViewById(R.id.layout_at);
        authFl </span>=<span style="color: #000000;"> (FrameLayout) findViewById(R.id.layout_auth);
        spaceFl </span>=<span style="color: #000000;"> (FrameLayout) findViewById(R.id.layout_space);
        moreFl </span>=<span style="color: #000000;"> (FrameLayout) findViewById(R.id.layout_more);

        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 实例化图片组件对象</span>
        atIv =<span style="color: #000000;"> (ImageView) findViewById(R.id.image_at);
        authIv </span>=<span style="color: #000000;"> (ImageView) findViewById(R.id.image_space);
        spaceIv </span>=<span style="color: #000000;"> (ImageView) findViewById(R.id.image_space);
        moreIv </span>=<span style="color: #000000;"> (ImageView) findViewById(R.id.image_more);

        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 实例化按钮图片组件</span>
        toggleImageView =<span style="color: #000000;"> (ImageView) findViewById(R.id.toggle_btn);
        plusImageView </span>=<span style="color: #000000;"> (ImageView) findViewById(R.id.plus_btn);

    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 初始化数据
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> initData() {
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 给布局对象设置监听</span>
        atFl.setOnClickListener(<span style="color: #0000ff;">this</span><span style="color: #000000;">);
        authFl.setOnClickListener(</span><span style="color: #0000ff;">this</span><span style="color: #000000;">);
        spaceFl.setOnClickListener(</span><span style="color: #0000ff;">this</span><span style="color: #000000;">);
        moreFl.setOnClickListener(</span><span style="color: #0000ff;">this</span><span style="color: #000000;">);

        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 给按钮图片设置监听</span>
        toggleImageView.setOnClickListener(<span style="color: #0000ff;">this</span><span style="color: #000000;">);
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 点击事件
     </span><span style="color: #008000;">*/</span><span style="color: #000000;">
    @Override
    </span><span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> onClick(View v) {
        </span><span style="color: #0000ff;">switch</span><span style="color: #000000;"> (v.getId()) {
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 点击动态按钮</span>
        <span style="color: #0000ff;">case</span><span style="color: #000000;"> R.id.layout_at:
            clickAtBtn();
            </span><span style="color: #0000ff;">break</span><span style="color: #000000;">;
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 点击与我相关按钮</span>
        <span style="color: #0000ff;">case</span><span style="color: #000000;"> R.id.layout_auth:
            clickAuthBtn();
            </span><span style="color: #0000ff;">break</span><span style="color: #000000;">;
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 点击我的空间按钮</span>
        <span style="color: #0000ff;">case</span><span style="color: #000000;"> R.id.layout_space:
            clickSpaceBtn();
            </span><span style="color: #0000ff;">break</span><span style="color: #000000;">;
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 点击更多按钮</span>
        <span style="color: #0000ff;">case</span><span style="color: #000000;"> R.id.layout_more:
            clickMoreBtn();
            </span><span style="color: #0000ff;">break</span><span style="color: #000000;">;
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 点击中间按钮</span>
        <span style="color: #0000ff;">case</span><span style="color: #000000;"> R.id.toggle_btn:
            clickToggleBtn();
            </span><span style="color: #0000ff;">break</span><span style="color: #000000;">;
        }
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 点击了&ldquo;动态&rdquo;按钮
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> clickAtBtn() {
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 实例化Fragment页面</span>
        fragmentAt = <span style="color: #0000ff;">new</span><span style="color: #000000;"> FragmentAt();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 得到Fragment事务管理器</span>
        FragmentTransaction fragmentTransaction = <span style="color: #0000ff;">this</span><span style="color: #000000;">
                .getSupportFragmentManager().beginTransaction();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 替换当前的页面</span>
<span style="color: #000000;">        fragmentTransaction.replace(R.id.frame_content, fragmentAt);
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 事务管理提交</span>
<span style="color: #000000;">        fragmentTransaction.commit();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 改变选中状态</span>
        atFl.setSelected(<span style="color: #0000ff;">true</span><span style="color: #000000;">);
        atIv.setSelected(</span><span style="color: #0000ff;">true</span><span style="color: #000000;">);

        authFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        authIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        spaceFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        spaceIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        moreFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        moreIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 点击了&ldquo;与我相关&rdquo;按钮
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> clickAuthBtn() {
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 实例化Fragment页面</span>
        fragmentAuth = <span style="color: #0000ff;">new</span><span style="color: #000000;"> FragmentAuth();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 得到Fragment事务管理器</span>
        FragmentTransaction fragmentTransaction = <span style="color: #0000ff;">this</span><span style="color: #000000;">
                .getSupportFragmentManager().beginTransaction();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 替换当前的页面</span>
<span style="color: #000000;">        fragmentTransaction.replace(R.id.frame_content, fragmentAuth);
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 事务管理提交</span>
<span style="color: #000000;">        fragmentTransaction.commit();

        atFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        atIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        authFl.setSelected(</span><span style="color: #0000ff;">true</span><span style="color: #000000;">);
        authIv.setSelected(</span><span style="color: #0000ff;">true</span><span style="color: #000000;">);

        spaceFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        spaceIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        moreFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        moreIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 点击了&ldquo;我的空间&rdquo;按钮
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> clickSpaceBtn() {
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 实例化Fragment页面</span>
        fragmentSpace = <span style="color: #0000ff;">new</span><span style="color: #000000;"> FragmentSpace();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 得到Fragment事务管理器</span>
        FragmentTransaction fragmentTransaction = <span style="color: #0000ff;">this</span><span style="color: #000000;">
                .getSupportFragmentManager().beginTransaction();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 替换当前的页面</span>
<span style="color: #000000;">        fragmentTransaction.replace(R.id.frame_content, fragmentSpace);
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 事务管理提交</span>
<span style="color: #000000;">        fragmentTransaction.commit();

        atFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        atIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        authFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        authIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        spaceFl.setSelected(</span><span style="color: #0000ff;">true</span><span style="color: #000000;">);
        spaceIv.setSelected(</span><span style="color: #0000ff;">true</span><span style="color: #000000;">);

        moreFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        moreIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 点击了&ldquo;更多&rdquo;按钮
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> clickMoreBtn() {
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 实例化Fragment页面</span>
        fragmentMore = <span style="color: #0000ff;">new</span><span style="color: #000000;"> FragmentMore();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 得到Fragment事务管理器</span>
        FragmentTransaction fragmentTransaction = <span style="color: #0000ff;">this</span><span style="color: #000000;">
                .getSupportFragmentManager().beginTransaction();
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 替换当前的页面</span>
<span style="color: #000000;">        fragmentTransaction.replace(R.id.frame_content, fragmentMore);
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 事务管理提交</span>
<span style="color: #000000;">        fragmentTransaction.commit();

        atFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        atIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        authFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        authIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        spaceFl.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
        spaceIv.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);

        moreFl.setSelected(</span><span style="color: #0000ff;">true</span><span style="color: #000000;">);
        moreIv.setSelected(</span><span style="color: #0000ff;">true</span><span style="color: #000000;">);
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 点击了中间按钮
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> clickToggleBtn() {
        showPopupWindow(toggleImageView);
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 改变按钮显示的图片为按下时的状态</span>
        plusImageView.setSelected(<span style="color: #0000ff;">true</span><span style="color: #000000;">);
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 改变显示的按钮图片为正常状态
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> changeButtonImage() {
        plusImageView.setSelected(</span><span style="color: #0000ff;">false</span><span style="color: #000000;">);
    }

    </span><span style="color: #008000;">/**</span><span style="color: #008000;">
     * 显示PopupWindow弹出菜单
     </span><span style="color: #008000;">*/</span>
    <span style="color: #0000ff;">private</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> showPopupWindow(View parent) {
        </span><span style="color: #0000ff;">if</span> (popWindow == <span style="color: #0000ff;">null</span><span style="color: #000000;">) {
            LayoutInflater layoutInflater </span>=<span style="color: #000000;"> (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view </span>= layoutInflater.inflate(R.layout.popwindow_layout, <span style="color: #0000ff;">null</span><span style="color: #000000;">);
            dm </span>= <span style="color: #0000ff;">new</span><span style="color: #000000;"> DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            </span><span style="color: #008000;">//</span><span style="color: #008000;"> 创建一个PopuWidow对象</span>
            popWindow = <span style="color: #0000ff;">new</span><span style="color: #000000;"> PopupWindow(view, dm.widthPixels, LinearLayout.LayoutParams.WRAP_CONTENT); 
        }
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 使其聚集 ，要想监听菜单里控件的事件就必须要调用此方法</span>
        popWindow.setFocusable(<span style="color: #0000ff;">true</span><span style="color: #000000;">);
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 设置允许在外点击消失</span>
        popWindow.setOutsideTouchable(<span style="color: #0000ff;">true</span><span style="color: #000000;">);
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 设置背景，这个是为了点击&ldquo;返回Back&rdquo;也能使其消失，并且并不会影响你的背景</span>
        popWindow.setBackgroundDrawable(<span style="color: #0000ff;">new</span><span style="color: #000000;"> BitmapDrawable());
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> PopupWindow的显示及位置设置
        </span><span style="color: #008000;">//</span><span style="color: #008000;"> popWindow.showAtLocation(parent, Gravity.FILL, 0, 0);</span>
        popWindow.showAsDropDown(parent, 0,0<span style="color: #000000;">);

        popWindow.setOnDismissListener(</span><span style="color: #0000ff;">new</span><span style="color: #000000;"> OnDismissListener() {
            @Override
            </span><span style="color: #0000ff;">public</span> <span style="color: #0000ff;">void</span><span style="color: #000000;"> onDismiss() {
                </span><span style="color: #008000;">//</span><span style="color: #008000;"> 改变显示的按钮图片为正常状态</span>
<span style="color: #000000;">                changeButtonImage();
            }
        });

        </span><span style="color: #008000;">//</span><span style="color: #008000;"> 监听触屏事件</span>
        popWindow.setTouchInterceptor(<span style="color: #0000ff;">new</span><span style="color: #000000;"> OnTouchListener() {
            </span><span style="color: #0000ff;">public</span> <span style="color: #0000ff;">boolean</span><span style="color: #000000;"> onTouch(View view, MotionEvent event) {
                </span><span style="color: #008000;">//</span><span style="color: #008000;"> 改变显示的按钮图片为正常状态</span>
<span style="color: #000000;">                changeButtonImage();
                popWindow.dismiss();
                </span><span style="color: #0000ff;">return</span> <span style="color: #0000ff;">false</span><span style="color: #000000;">;
            }
        });
    }
}</span></pre>
</div>
<span class="cnblogs_code_collapse">MainActivity</span></div>
<p>4.其他的请看源代码吧 o(&cap;_&cap;)o</p>
<p>&nbsp;</p>
