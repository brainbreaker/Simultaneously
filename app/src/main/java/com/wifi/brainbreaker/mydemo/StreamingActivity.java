package com.wifi.brainbreaker.mydemo;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class StreamingActivity extends ActionBarActivity {

	private static final String TAG = "StreamingActivity";
	LocalFileStreamingServer mServer;
	LocalFileStreamingServer mServer1;
	LocalFileStreamingServer mServer2;
	LocalFileStreamingServer mServer3;
	LocalFileStreamingServer mServer4;
	LocalFileStreamingServer mServer5;
	LocalFileStreamingServer mServer6;
	LocalFileStreamingServer mServer7;
	LocalFileStreamingServer mServer8;
	LocalFileStreamingServer mServer9;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_streaming);
		/*
		 * Make sure you have correct file structure. For demo copy the jellies
		 * file onto ROOT of SD card. You can have your own file pointed instead
		 */
		WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
		String deviceIp = Formatter.formatIpAddress(wm.getConnectionInfo()
				.getIpAddress());

		mServer = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer.init(deviceIp, 8000);

		mServer1 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer1.init(deviceIp, 8001);

		mServer2 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer2.init(deviceIp, 8002);

		mServer3 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer3.init(deviceIp, 8003);

		mServer4 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer4.init(deviceIp, 8004);

		mServer5 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer5.init(deviceIp, 8005);

		mServer6 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer6.init(deviceIp, 8006);

		mServer7 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer7.init(deviceIp, 8007);

		mServer8 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer8.init(deviceIp, 8008);

		mServer9 = new LocalFileStreamingServer(new File(
				Environment.getExternalStorageDirectory() + "/Force.mp4"));
		mServer9.init(deviceIp, 8009);

//		//start UDP server
//		UDP_Server server = new UDP_Server();
//		server.runUdpServer(this, 8554);
//
//		//UDP Client erstellen
//		UDP_Client client = new UDP_Client();
//		client.Message = "Gotta fuck this UDP shit";
//		try {
//			client.NachrichtSenden(InetAddress.getByName(deviceIp), 8554);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.streaming, menu);
//		return true;
//	}

	public void stopStreaming(View v) {
		if (null != mServer)
			mServer.stop();
		((TextView) findViewById(R.id.status)).setText("");
	}

	public void startStreaming(View v) {
		if (null != mServer && !mServer.isRunning())
			mServer.start();
		((TextView) findViewById(R.id.status))
				.setText("Use the URL on your browser or any media player to stream this video:\n"
						+ mServer.getFileUrl());

		if (null != mServer1 && !mServer1.isRunning())
			mServer1.start();

		if (null != mServer2 && !mServer2.isRunning())
			mServer2.start();


		if (null != mServer3 && !mServer3.isRunning())
			mServer3.start();

		if (null != mServer4 && !mServer4.isRunning())
			mServer4.start();


		if (null != mServer5 && !mServer5.isRunning())
			mServer5.start();

		if (null != mServer6 && !mServer6.isRunning())
			mServer6.start();

		if (null != mServer7 && !mServer7.isRunning())
			mServer7.start();

		if (null != mServer8 && !mServer8.isRunning())
			mServer8.start();

		if (null != mServer9 && !mServer9.isRunning())
			mServer9.start();

	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}

	@Override
	protected void onDestroy() {
		if (null != mServer && mServer.isRunning()) {
			mServer.stop();
			mServer = null;
		}
		super.onDestroy();
	}
}
