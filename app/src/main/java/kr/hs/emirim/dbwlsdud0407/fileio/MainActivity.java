package kr.hs.emirim.hanbee990508.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button butOut,butIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut=(Button)findViewById(R.id.but_output);
        butIn=(Button)findViewById(R.id.but_input);
        butOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try{
                    FileOutputStream out=openFileOutput("1017minn.text", Context.MODE_WORLD_WRITEABLE);
                    String message="미림정보과학고 학생들이 제일 예쁘다";
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        });
        butIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try{
                    FileInputStream in=openFileInput("1017minn.txt");
                    byte[]readMassge=new byte[200];
                    in.read(readMassge);
                    Toast.makeText(getApplicationContext(),new String(readMassge),Toast.LENGTH_LONG).show();
                    in.close();
                }catch(FileNotFoundException e){
                    Toast.makeText(getApplicationContext(),"파일이 존재하지 않는다.",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        });
    }
}