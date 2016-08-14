package com.wifi.brainbreaker.mydemo;

import android.content.Intent;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.wifi.brainbreaker.mydemo.streaming.rtsp.RtspServer;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;


public class MainActivity extends AppCompatActivity {

//    final private static int VIDEO_SELECTED_RESULT_CODE = 1;
private RtspServer mRtspServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Click handler for the video selector button
     */

    /*private void selectVideoFile() {
        Intent mediaChooser = new Intent(Intent.ACTION_GET_CONTENT);
        mediaChooser.setType("video*//*");
        mediaChooser.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(mediaChooser, VIDEO_SELECTED_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        switch(requestCode){
            case VIDEO_SELECTED_RESULT_CODE:
                if (resultCode==RESULT_OK) {
                    Uri fileUri = returnIntent.getData();
                    String mimeType = getContentResolver().getType(fileUri);

                    if (mimeType != null && !mimeType.equals("video/mp4")) {
                        infoText.setText("The video selected is not an MP4 file");
                    } else {
                        setVideoFile(fileUri);
                    }
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, returnIntent);
    }

    private void setVideoFile(Uri fileUri) {
        FileDescriptor fd = getFD(fileUri);

        if (fd != null) {
            infoText.setVisibility(View.INVISIBLE);
            easyVideoPlayer.setVideoURI(fileUri);
            easyVideoPlayer.setVisibility(View.VISIBLE);
            easyVideoPlayer.start();
        } else {
            easyVideoPlayer.setVisibility(View.INVISIBLE);
            infoText.setVisibility(View.VISIBLE);
            infoText.setText("The format of the selected file could not be determined");
        }
    }

    private FileDescriptor getFD(Uri fileUri) {
        FileDescriptor fd;
        try {
            ParcelFileDescriptor pfd = getContentResolver().openFileDescriptor(fileUri, "r");
            if (pfd != null)
                fd = pfd.getFileDescriptor();
            else
                return null;
        } catch (FileNotFoundException e) {
            fd = null;
        }

        return fd;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_stream) {
            Intent intent = new Intent(MainActivity.this, StreamingActivity.class);
            this.startActivity(intent);
        }
        if(id == R.id.action_copy){
            Toast.makeText(this,"Text copied to clipboard",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}