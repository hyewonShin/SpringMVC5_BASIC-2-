package kr.co.hyewon.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//XML설정의 web.xml과 같은 역할인 클래스이다.
//Class에서 implements WebApplicationInitializer 해줘서 사용한다.
/*
 * public class SpringConfigClass implements WebApplicationInitializer{
 * 
 * @Override public void onStartup(ServletContext servletContext) throws
 * ServletException { // TODO Auto-generated method stub
 * //System.out.println("onStartup");
 * 
 * //Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
 * AnnotationConfigWebApplicationContext servletAppContext = new
 * AnnotationConfigWebApplicationContext();
 * servletAppContext.register(ServletAppContext.class);
 * 
 * //요청 발생 시 요청을 처리하는 서블릿을 DispatcherServlet으로 설정해준다. DispatcherServlet
 * dispatcherServlet = new DispatcherServlet(servletAppContext);
 * ServletRegistration.Dynamic servlet =
 * servletContext.addServlet("dispatcher",dispatcherServlet);
 * 
 * //부가 설정 servlet.setLoadOnStartup(1); //가정 먼저 스타트 하겠다는 뜻.
 * servlet.addMapping("/");
 * 
 * // Bean을 정의하는 클래스를 지정한다(리스너 설정). AnnotationConfigWebApplicationContext
 * rootAppContext = new AnnotationConfigWebApplicationContext();
 * rootAppContext.register(RootAppContext.class);
 * 
 * ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
 * servletContext.addListener(listener);
 * 
 * // 파라미터 인코딩 설정 FilterRegistration.Dynamic filter =
 * servletContext.addFilter("encodingFilter",CharacterEncodingFilter.class);
 * filter.setInitParameter("encoding", "UTF-8");
 * filter.addMappingForServletNames(null, false, "dispatcher"); }
 * 
 * }
 */


// 위의 설정방법보다 간편하게 설정할 수 있지만, 고정적이라서 자율적으로 변경할 수 없다.
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	//DispatcherServlet에 매핑할 요청 주소를 셋팅한다.
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};  //모든 요청에 대해서 DispatecherServlet이 반응하도록 설정.
	}
	
	// Spring MVC 프로젝트 설정을 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletAppContext.class};
	}
	
	// 프로젝트에서 사용할 Bean들을 정의하기 위한 클래스를 지정한다.
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootAppContext.class};
	}
	
	//파라미터 인코딩 필터 설정
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
}
