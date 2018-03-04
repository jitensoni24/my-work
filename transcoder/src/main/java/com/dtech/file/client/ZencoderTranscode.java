package com.dtech.file.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.brightcove.zencoder.client.ZencoderClient;
import com.brightcove.zencoder.client.request.ZencoderCreateJobRequest;
import com.brightcove.zencoder.client.request.ZencoderOutput;
import com.dtech.file.client.exception.TranscodeException;
import com.dtech.file.client.resource.TranscodeProgress;
import com.dtech.file.client.resource.TranscodeRequest;
import com.dtech.file.config.TranscodeClientConfig;

public class ZencoderTranscode implements Transcode {

	private ZencoderClient client;
	
	public ZencoderTranscode(TranscodeClientConfig config) {
		client.setApiKey(config.getKey());
		
		if( !StringUtils.isEmpty(config.getApiUrl()) ) {
			client.setApiUrl(config.getApiUrl());
		}
	}


	public String submitJob(TranscodeRequest requestDetails) throws TranscodeException {
		ZencoderCreateJobRequest job = new ZencoderCreateJobRequest();
		
		job.setInput(requestDetails.getInputUrl());
		
		List<ZencoderOutput> outputs = new ArrayList<ZencoderOutput>();

		return null;
	}

	public List<TranscodeProgress> checkTranscodeProgress(String jobId) throws TranscodeException {
		// TODO Auto-generated method stub
		return null;
	}
	
}