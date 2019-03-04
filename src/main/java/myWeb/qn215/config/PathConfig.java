package myWeb.qn215.config;



public class PathConfig {
	//项目运行时路径
	private static  String project_path;
	//开关,防止二次变动
	private static boolean project_path_init=false;
	
	public void set(String path) {
			if (!project_path_init) {
				project_path_init=true;
				project_path=path;
				project_path=path.endsWith("/") ||path.endsWith("\\")?path:path+"/";
			}
	}
	
	public static String getRealPath(String path) {
		if (path.startsWith("/")) {//如果用户传入的路径是/开始
			path=path.substring(1);//去掉第一个字符
		}
		return project_path+path;
	}
	
}
