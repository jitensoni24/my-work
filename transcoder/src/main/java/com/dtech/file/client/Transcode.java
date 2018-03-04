package com.dtech.file.client;

import java.util.List;

import com.dtech.file.client.exception.TranscodeException;
import com.dtech.file.client.resource.TranscodeProgress;
import com.dtech.file.client.resource.TranscodeRequest;

public interface Transcode {

	String submitJob(TranscodeRequest requestDetails) throws TranscodeException;
	
	List<TranscodeProgress> checkTranscodeProgress(String jobId) throws TranscodeException;
}
