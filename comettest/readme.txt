1、编译项目时可将catalina.jar引入，发布时将lib下面的catalina.jar删除，否则报错
	HTTP Status 500 - java.lang.ClassCastException: org.apache.catalina.util.DefaultAnnotationProcessor cannot be cast to 	org.apache.AnnotationProcessor
	type Exception report

	message java.lang.ClassCastException: org.apache.catalina.util.DefaultAnnotationProcessor cannot be cast to 	org.apache.AnnotationProcessor

	description The server encountered an internal error that prevented it from fulfilling this request.

	exception

	org.apache.jasper.JasperException: java.lang.ClassCastException: org.apache.catalina.util.DefaultAnnotationProcessor cannot be 	cast to org.apache.AnnotationProcessor
		org.apache.jasper.servlet.JspServletWrapper.handleJspException(JspServletWrapper.java:538)
		org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:370)
		org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:313)
		org.apache.jasper.servlet.JspServlet.service(JspServlet.java:260)
		javax.servlet.http.HttpServlet.service(HttpServlet.java:717)
	root cause

	java.lang.ClassCastException: org.apache.catalina.util.DefaultAnnotationProcessor cannot be cast to org.apache.AnnotationProcessor
		org.apache.jsp.index_jsp._jspInit(index_jsp.java:23)
		org.apache.jasper.runtime.HttpJspBase.init(HttpJspBase.java:52)
		org.apache.jasper.servlet.JspServletWrapper.getServlet(JspServletWrapper.java:164)
		org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:340)
		org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:313)
		org.apache.jasper.servlet.JspServlet.service(JspServlet.java:260)
		javax.servlet.http.HttpServlet.service(HttpServlet.java:717)
	note The full stack trace of the root cause is available in the Apache Tomcat/6.0.36 logs.

	Apache Tomcat/6.0.36

2、直接将此项目放入tomcat服务器下访问index.jsp