package com.liu;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.domain.FileImage;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload{
//	private String filePath="C:\\Users\\Shinelon\\workspace\\SSHblog\\WebContent\\pageimage";
	private String filePath="F:\\www1\\34812a72c1a33a6a58d4ad194d6ac129-0b44449e5dd85319015df08c253807b5\\webapps\\ROOT\\file\\pageimage";
//	@Value("#{prop.filePath}")
	public void setFilePath(String filePath)
	{
		System.out.println(filePath);
		this.filePath=filePath;
	}
	private String getFileExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	private String newFileName(String fileName){
		String ext=getFileExt(fileName);
		return UUID.randomUUID().toString()+"."+ext;
	}
	public String uploadFile(FileImage fileImage){
		String pic=newFileName(fileImage.getFileName());
		System.out.println("filePath:"+filePath);
		try
		{
			FileUtil.copyFile(fileImage.getFile(), new File(filePath,pic));
			return pic;
		} catch (Exception e) {  
            throw new RuntimeException(e);  
        } finally {  
            fileImage.getFile().delete();  
        }  
	}
	private String bankImagePath="E:\\wenjian\\bankImages1";
	 public String[] getBankImage() {
	        String[] list  = new File(bankImagePath).list(new FilenameFilter() {

	            //测试指定文件是否应该包含在某一文件列表中
	            @Override
	            public boolean accept(File dir, String name) {
	                System.out.println("dir:" + dir + ",name:" + name);             
	                //通过后缀名来实现文件的过滤效果
	                //返回真就放到list中，返回假就过滤掉
	                return name.endsWith(".gif");
	            }
	        });
	        return list;
	    }
}
