package com.lihui.share.service;

import java.io.IOException;
import java.io.InputStream;

public interface FileUploadService
{
	public void saveFile(String priName, String filePath, String docType);
	
	public void SaveFileFromInputStream(InputStream stream, String path, String filename) throws IOException;
}
