__CHỨC NĂNG XÓA KÝ TỰ - BACKSPACE__

- lập trình chức năng xóa lùi 1 ký tự tương tự như khi click phím BackSpace
- giao diện
	- 1 EditText
	- 1 Button
___

__FILE RESOURCE STRING.XML__

- mở file ``string.xml`` từ directory ``res/string.xml`` trong Android Studio view Android
- định nghĩa thêm nội dung cho EditText (hint) và Button (text) như sau
- __string.xml__
```xml
<resources>
    <string name="app_name">Backspace System Function</string>
    <string name="editText_hint">Input</string>
    <string name="button_clear_one_name">CLEAR ONE</string>
</resources>
```

___

__FILE ACTIVITY_MAIN.XML__

- trong file ``activity_main.xml`` ta định nghĩa và thiết kế cho các View (EditText và Button) như sau
- __activity_main.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:padding="5dp"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/edt_input"
        android:inputType="number"
        android:gravity="start"
        android:hint="@string/editText_hint"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:layout_alignParentEnd="true"
        android:id="@+id/btn_clear_one"
        android:text="@string/button_clear_one_name"
        android:layout_below="@+id/edt_input"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</RelativeLayout>
```

___

__FILE MAIN ACTIVITY__

- khai báo các thành phần của view EditText và Button
- liên kết các thành phần đã khai báo với ``id`` của các view ở Layout
- bắt sự kiện cho thành phần Button và code chức năng backspace cho Button này khi có sự click của user
- __MainActivity.java__
```java
public class MainActivity extends AppCompatActivity {
    EditText edtInput;
    Button btnClearOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edt_input);
        btnClearOne = findViewById(R.id.btn_clear_one);

        btnClearOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtInput, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
            }
        });
    }
}
```

___

__RESULT__

- với chức năng tương tự như phím BackSpace, tại vị trí con trỏ trong EditText ta có thể xóa lùi lần lượt từng ký tự từ phải sang trái, đồng thời vị trí con trỏ cũng sẽ lùi từ phải sang trái sau mỗi lần xóa 1 ký tự, dù cho ta chọn vị trí con trỏ đứng sau bất kỳ ký tự nào chăng nữa thì nó vẫn không reset vị trí về đầu hay cuối của chuỗi ký tự trong field của EditText

