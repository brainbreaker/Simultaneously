package com.wifi.brainbreaker.mydemo.spydroid.api;

import com.wifi.brainbreaker.mydemo.streaming.rtsp.RtspServer;

public class CustomRtspServer extends RtspServer {
	public CustomRtspServer() {
		super();
		// RTSP server disabled by default
		mEnabled = false;
	}
}

