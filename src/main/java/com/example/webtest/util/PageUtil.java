package com.example.webtest.util;

public class PageUtil {
	
	public static String getPageContent(String url,int pageCurrent,int pageSize,int pageCount){
		if (pageCount == 0) {
			return "";
		}
		String urlNew = url.replace("{pageSize}", pageSize+"");

		String first = urlNew.replace("{pageCurrent}", 1+"");
		String prev = urlNew.replace("{pageCurrent}", (pageCurrent - 1)+"");
		String next = urlNew.replace("{pageCurrent}", (pageCurrent + 1)+"");
		String last = urlNew.replace("{pageCurrent}", pageCount+"");

		StringBuilder html = new StringBuilder();
		String str1 = "<li class=\"footable-page-arrow"+(pageCurrent<=1?" disabled":"")+"\"><a href=\""+(pageCurrent<=1?"#":first)+"\">«</a></li>";
		html.append(str1);
		String str2 = "<li class=\"footable-page-arrow"+(pageCurrent<=1?" disabled":"")+"\"><a href=\""+(pageCurrent<=1?"#":prev)+"\">‹</a></li>";
		html.append(str2);
		for(int i = 0 ;i < pageCount; i++){
			String urlItem = urlNew.replace("{pageCurrent}", (i+1)+"");
			String str3 = "<li class=\"footable-page"+(((i+1) == pageCurrent)?" active":"")+"\"><a href=\""+urlItem+"\">"+(i+1)+"</a></li>";
			html.append(str3);
		}
		String str4 = "<li class=\"footable-page-arrow"+(pageCurrent==pageCount?" disabled":"")+"\"><a href=\""+(pageCurrent==pageCount?"#":next)+"\">›</a></li>";
		html.append(str4);
		String str5 = "<li class=\"footable-page-arrow"+(pageCurrent==pageCount?" disabled":"")+"\"><a href=\""+(pageCurrent==pageCount?"#":last)+"\">»</a></li>";
		html.append(str5);

		return html.toString().replaceAll("null", "");
	}
	
}