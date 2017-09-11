package com.liu;

import com.domain.FileImage;

public interface FileUpload {
	public abstract String uploadFile(FileImage fileImage);

	public abstract String[] getBankImage();
}
