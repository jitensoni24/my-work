package com.dtech.file.client.resource;

import java.util.List;

import lombok.Data;

@Data
public class TranscodeRequest {

	private String inputUrl;
	private List<Output> outputs;
	
	public String getInputUrl() {
		return inputUrl;
	}
	public void setInputUrl(String inputUrl) {
		this.inputUrl = inputUrl;
	}
	public List<Output> getOutputs() {
		return outputs;
	}
	public void setOutputs(List<Output> outputs) {
		this.outputs = outputs;
	}
}

@Data
class Output {
	private String label;
	private String format;
	private String size;
	private Boolean test;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}
	
}