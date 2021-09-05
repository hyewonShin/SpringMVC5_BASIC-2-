package kr.co.hyewon.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hyewon.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")   //@WebServlet 매핑에서는 앞에  \ 를 붙이면 안된다!->에러남 ㅠ 
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("HomeController");
		
		//요청한 주소를 가져온다.
		String url = request.getRequestURI();
		//System.out.println(url);
		
		//View로 사용할 JSP
		String viewName = null;
		
		//요청한 주소 분기 (spring의 controller역할)
		if(url.contains("main.mvc")) {
			//System.out.println("main 요청");
			viewName = "main.jsp";
		}else if(url.contains("test1.mvc")) {
			//System.out.println("test1 요청");
			
			//파라미터 데이터 추출
			//파라미터는 초기 문자로 날아오기 때문에 int로 변환해줘야 한다.
			String str1 = request.getParameter("number1");
			String str2 = request.getParameter("number2");

			int number1 = Integer.parseInt(str1);
			int number2 = Integer.parseInt(str2);
			
			int result = number1 + number2;
			
			request.setAttribute("result", result);
			
			viewName = "test1.jsp";
		}else if(url.contains("test2.mvc")) {
			//System.out.println("test2 요청");
			//위와 다르게 모델에 해당하는 부분을 Test2Service라는 클래스러 따로 분리해서 호출함.
			
			// 모델 요청
			int result = Test2Service.minus(request);
			
			request.setAttribute("result", result);
			
			
			viewName = "test2.jsp";
		}
		
		//코드의 흐름이 해당 jsp 로 이동하게 됌.
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);
		
		//RequestDispatcher는 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나, 
		//특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스입니다.

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
