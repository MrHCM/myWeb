package myWeb.qn215.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;




public class StringtoDateConver implements Converter<String, Date>{
		@Override
		public Date convert(String source) {
			String date="yyyy-MM-dd";
			if (source.contains("/")) {
				date="yyyy/MM/dd";
			}
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				return sf.parse(source);
			} catch (Exception e) {
				return null;
			}
			
		}

		

		

}
