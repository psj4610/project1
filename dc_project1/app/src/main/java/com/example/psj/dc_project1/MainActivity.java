package com.example.psj.dc_project1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedInstance;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void Create_Folder(){
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/SavedPDF";
        File dir = new File(path);
        if(!dir.exists())
            Log.e("FILE", "Directory not created");
            dir.mkdir();
    }
    //어플 권한 승인 여부 다이얼로그 출력.
    private void showPermissionDialog(){
        PermissionListener P_listener = new PermissionListener() {
            @Override
            //권한 승인 시 권한허용 메시지 출력 후 디렉토리 생성
            public void onPermissionGranted() {
                Toast.makeText(MainActivity.this,"저장공간 권한부여를 승인하셨습니다",Toast.LENGTH_LONG).show();
                Create_Folder();
            }
            //권한 미승인 시 권한 미허용 메시지 출력 후 앱 강제 종료
            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(MainActivity.this,"저장공간 권한부여를 거부하셨습니다",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        new TedPermission(this)
                .setPermissionListener(P_listener)
                .setRationaleMessage("이 앱을 사용하기 위해선 저장공간에 대한 권한부여를 승인해주셔야 합니다.")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE).check();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPermissionDialog();



        // 버튼 후원서 저장 환경설정 순서
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,donateActivity.class);
                // 또 다른 액티비티 실행
                startActivityForResult(intent, 0);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                // 또 다른 액티비티 실행
                startActivityForResult(intent, 0);
            }
        });

    }
}
