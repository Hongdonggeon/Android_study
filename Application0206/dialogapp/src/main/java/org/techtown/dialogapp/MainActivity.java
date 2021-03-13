package org.techtown.dialogapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private void showDialog1() {
        // 다이얼로그를 만들기 위한 Builder 클래스의 객체를 생성하고
        // 다이얼로그가 가질 정보(데이터)들을 설정한다.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setIcon(R.drawable.ic_baseline_warning_80); // 아이콘 설정
        builder.setTitle("안내 메세지"); // 타이틀 설정
        builder.setMessage("종료하시겠습니까?"); // 메세지 설정
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "종료 버튼 클릭", Toast.LENGTH_SHORT);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "취소 버튼 클릭", Toast.LENGTH_SHORT);
            }
        });
        builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "중단 버튼 클릭", Toast.LENGTH_SHORT);
            }
        });

        builder.setCancelable(true);
        // builder 객체를 통해서 AlertDialog 객체를 생성한다.
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showDialog2() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_warning_80)
                .setTitle("안내 메세지")
                .setMessage("종료하시겠습니까?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setCancelable(true)
                .create() //Builder가 가지는 메서드 (위에 전부다)
                .show(); // AlertDialog에 있는 메서드
    }

    private void showItemDialog() {
        String items[] = getResources().getStringArray(R.array.options);
        private void showItemDialog () {
            new AlertDialog.Builder(this)
                    .setTitle("선택")
                    .setItems(options, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, items[which] + "is selected.", Toast.LENGTH_SHORT).show();
                        }
                    }).create().show();
        }
        private void showMultiItemDialog() {
            boolean selected [] = new boolean[options.length];
            new AlertDialog.Builder(this)
                    .setTitle("다중 선택")
                    .setMultiChoiceItems(options, selected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("APPLY", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "적용", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .create().show();
        }
        private void showSingleDialog() {
            new AlertDialog.Builder(this)
                    .setTitle("단일 선택")
                    .setSingleChoiceItems(options, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, options[which]+"is selected", Toast.LENGTH_SHORT).show();
                        }
                    }).setPositiveButton(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            })
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        options = getResources().getStringArray(R.array.options);
        showMultiItemDialog();
    }
}