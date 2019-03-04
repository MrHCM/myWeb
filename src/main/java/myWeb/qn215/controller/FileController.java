package myWeb.qn215.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import myWeb.qn215.config.PathConfig;

@Controller
public class FileController {

	@RequestMapping("/sss")
	public String File() {
		
		return "File";
}
	
	@PostMapping("/file")
    public String files(@RequestParam("file") MultipartFile myfile) throws IOException {
		

    	InputStream in=myfile.getInputStream();
    	/*File file=new File("D:\\eclipse-workspace\\myWeb\\src\\main\\webapp\\static\\images");*/
    	OutputStream out=new FileOutputStream(PathConfig.getRealPath("/static/images/")+myfile.getResource().getFilename());
    	System.out.println(PathConfig.getRealPath("/static/images/"));
    	byte[] b=new byte[10240];
    	int len;
    	while ((len=in.read(b))!=-1) {
    		out.write(b, 0, len);
		}
    	
    	out.flush();
    	out.close();
    	
		return "ok";
    	
    }
	
	  @RequestMapping("/down")
	    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{
	        //模拟文件，myfile.txt为需要下载的文件
	        String fileName = request.getSession().getServletContext().getRealPath("/static/images")+"/IMG_0317.jpg";
	        //获取输入流
	        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
	        //假如以中文名下载的话
	        String filename = "IMG_0317.jpg";
	        //转码，免得文件名中文乱码
	        filename = URLEncoder.encode(filename,"UTF-8");
	        //设置文件下载头
	        response.addHeader("Content-Disposition", "attachment;filename=" + filename);  
	        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
	        response.setContentType("multipart/form-data"); 
	        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
	        int len = 0;
	        while((len = bis.read()) != -1){
	            out.write(len);
	            out.flush();
	        }
	        out.close();
	    }


}
