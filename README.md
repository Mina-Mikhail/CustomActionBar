# Custom Action Bar

This project is an simple custom action bar, the action bar consists of left button for navigation drawer menu, application title, and options menu.


* Demo: 
![img_20170708_160134](https://user-images.githubusercontent.com/17712116/27985961-c6dd2926-63f6-11e7-80ec-cdb12610722f.png "Action Bar Demo")

## Usage:
It's preety simple to use it in your project,

1. Create your custom bar layout file:
```xml
<LinearLayout
    android:layout_height="match_parent"
    android:layout_width="match_parent"
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal">

    <ImageView
        android:layout_width="28dp"
        android:layout_height="28dp"
        android:src="@drawable/menu"
        android:id="@+id/menuBTN"
        android:layout_gravity="start|center_vertical"
        android:contentDescription="@string/left_menu_button"
        />

    <TextView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="@string/custom_action_bar"
        android:textAppearance="?android:attr/textAppearanceMedium"
        android:textStyle="bold"
        android:padding="10dp"
        android:layout_weight="1"
        android:textColor="@color/white"
        android:layout_marginLeft="5dp"
        android:layout_marginStart="5dp"
        android:layout_gravity="center_vertical"
        />

</LinearLayout>
```

2. Just implement `setUpActionBar()` function in your activity and call it in `onCreate()`:
```java
private void setUpActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        // the custom action bar layout file
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        // the color of the action bar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        // make action bar support options menu
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // to access any view in the action bar
        View view = getSupportActionBar().getCustomView();

        ImageView menu_BTN= (ImageView)view.findViewById(R.id.menuBTN);
        menu_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Navigation btn", Toast.LENGTH_SHORT).show();
            }
        });
}
    
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // to setup Action Bar
    setUpActionBar();
}
```
3. Add custom style for the action bar to your style.xml file:
```xml
<style name="CustomTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- the color of the option menu overflow icon (three vertical dots) -->
        <item name="android:textColorSecondary">@color/white</item>
        <!-- to remove shadow of action bar for devices before Lollipop  -->
        <item name="android:windowContentOverlay">@null</item>
        <!-- to change color of status bar  -->
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
</style>
```
4. Apply the new style as a theme for your activity in AndroidManifest.xml file:
```xml
<activity
        android:name=".MainActivity"
        android:label="@string/app_name"
        android:theme="@style/CustomTheme">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
</activity>
```


==================

developed to make programming easy.

by Mina Mikhail (mano_samir@outlook.com) (https://www.linkedin.com/in/minasamirgerges)
