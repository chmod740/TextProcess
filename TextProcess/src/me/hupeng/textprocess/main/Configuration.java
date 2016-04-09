package me.hupeng.textprocess.main;

public class Configuration {
	
	private String fileInputName;
	private String fileOutputName;
	private String inputCharCode="UTF-8";
	private String outputCharCod="UTF-8";
	
	/**
	 * mode = 0 不去重
	 * mode = 1 去重
	 * */
	private Integer mood = 1;
	
	
	public Configuration(String fileInputName,String fileOutputName){
		this.fileInputName = fileInputName;
		this.fileOutputName = fileOutputName;
	}

	public Configuration(String fileInputName,String fileOutputName,Integer mood){
		this.fileInputName = fileInputName;
		this.fileOutputName = fileOutputName;
		this.mood = mood;
	}
	
	
	public String getFileInputName() {
		return fileInputName;
	}

	public void setFileInputName(String fileInputName) {
		this.fileInputName = fileInputName;
	}

	public String getFileOutputName() {
		return fileOutputName;
	}

	public void setFileOutputName(String fileOutputName) {
		this.fileOutputName = fileOutputName;
	}

	public Integer getMood() {
		return mood;
	}

	public void setMood(Integer mood) {
		this.mood = mood;
	}

	public String getInputCharCode() {
		return inputCharCode;
	}

	public void setInputCharCode(String inputCharCode) {
		this.inputCharCode = inputCharCode;
	}

	public String getOutputCharCod() {
		return outputCharCod;
	}

	public void setOutputCharCod(String outputCharCod) {
		this.outputCharCod = outputCharCod;
	}
	
	
	
}
