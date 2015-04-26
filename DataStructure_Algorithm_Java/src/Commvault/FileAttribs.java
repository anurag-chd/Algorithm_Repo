package Commvault;

class FileAttribs implements Comparable<FileAttribs>{
	String fileName;
	long size;
	String lastModifiedTime;
	
	public FileAttribs(String fileName, long size, String lastModifiedTime){
		this.fileName = fileName;
		this.size = size;
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
		
	public String toString(){
		return this.fileName+","+this.size+","+this.lastModifiedTime;
	}

	@Override
	public int compareTo(FileAttribs arg0) {
		if(this.size > arg0.size)
			return -1;
		else if(this.size < arg0.size) 
			return 1;
		else 
			return 0;
	}
		
		
	
	
}