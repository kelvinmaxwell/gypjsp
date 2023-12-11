package com.example.gymtestapp2.dao;

import com.example.gymtestapp2.dao.BatchesDao;
import com.example.gymtestapp2.dao.BatchesUserDao;
import com.example.gymtestapp2.dao.userDAO;
import com.example.gymtestapp2.model.BatchUsers;
import com.example.gymtestapp2.model.Batches;
import com.example.gymtestapp2.model.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private com.example.gymtestapp2.dao.userDAO userDAO = new userDAO();
	    
	    private BatchesDao batchesDao=new BatchesDao();
	    private BatchesUserDao batchesuserdao=new BatchesUserDao(0,null,null);
	    public ControlServlet()
		{
			
		}
		private String currentUser;
	    private HttpSession session=null;
	
	    
	    public void init()
	    {
	    	userDAO = new userDAO();
	    	currentUser= "";
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
	    
	    try {
        	switch(action) {  
        	case "/login":
        		login(request,response);
        		break;
        	case "/register":
        		register(request, response);
        		break;
        	case "/newBatch":
        		newBatch(request, response);
        		break;
        	case "/listBatches":
        		listBatches(request, response);
        		break;
        		
        	case "/editBatch":
        		editBatch(request, response);
        		break;
        	
        	case "/openeditBatch":
        		openeditBatch(request, response);
        		break;
        		
        	case "/deleteBatch":
        		deleteBatch(request, response);
        		break;
        	case "/batchesUserList":
        		batchesUserList(request, response);
        		break;
        	case "/deleteBatchUser":
        		deleteBatchUser(request, response);
        		break;
        		
        	case "/addUserBatch":
        		addUserBatch(request, response);
        		break;
        		
        	case "/submitBatchUser":
        		submitBatchUser(request, response);
        		break;
        	case "/root":
        		rootPage(request,response, "");
        		break;
        	
        	case "/logout":
        		logout(request,response);
        		break;
        	case "/list": 
                 System.out.println("The action is: list");
                 listUser(request, response);           	
                 break;
        	
	    
     
    	
    	
    	}
	    	
        	
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
	    
 

	    
	    
	    
	    
	    private void listBatches(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("started list batches: 00000000000000000000000000000000000");

	     
	        List<Batches> listbatches = batchesDao.listAllBatches();
	        request.setAttribute("listBatches", listbatches);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("batchesList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listQuote finished: 111111111111111111111111111111111111");}
	    
	    private void openeditBatch(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	    	  System.out.println("opening supplier started: 00000000000000000000000000000000000");

	     
	        String id = request.getParameter("id");
	    	 String name=request.getParameter("name");
	      
	        request.setAttribute("id", id);
	        request.setAttribute("name", name);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("editBatch.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("opening supplier decision finished: 111111111111111111111111111111111111");}
	    
	    
	    
 private void editBatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	System.out.print(request.getParameter("id"));
	        
	        int batchId = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("batchname");
			
			
//	       
//	        
     
			 batchesDao.updateBatch(name,batchId);
			 System.out.print(name);
		     listBatches(request,response);
	    }
 
 private void deleteBatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
 	
     
     int batchId = Integer.parseInt(request.getParameter("id"));
		
     

   
     batchesDao.deleteBatch(batchId);
     
     listBatches(request,response);
     
 }
 
 
 private void batchesUserList(HttpServletRequest request, HttpServletResponse response)
         throws SQLException, IOException, ServletException {
     System.out.println("started list batchesUsers: 00000000000000000000000000000000000");

  
     List<BatchesUserDao> listbatchesusers = batchesuserdao.listAllUserBatches();
     request.setAttribute("listBatchesUsers", listbatchesusers);       
     RequestDispatcher dispatcher = request.getRequestDispatcher("UserBatchList.jsp");       
     dispatcher.forward(request, response);
  
     System.out.println("listuserbatches finished: 111111111111111111111111111111111111");}
 
 
 
 private void deleteBatchUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
 	
     
     int batchUserId = Integer.parseInt(request.getParameter("id"));
		
     

   
     batchesuserdao.deleteBatchUser(batchUserId);
     
     batchesUserList(request,response);
     
 }
 

 private void addUserBatch(HttpServletRequest request, HttpServletResponse response)
         throws SQLException, IOException, ServletException {
     System.out.println("started list batchesUsers: 00000000000000000000000000000000000");

  
     List<Batches> listbatches = batchesDao.listAllBatches();
     request.setAttribute("listBatches", listbatches);     
     List<user> listUser = userDAO.listAllUsers();
     request.setAttribute("listUser", listUser);         
     RequestDispatcher dispatcher = request.getRequestDispatcher("AddUserBatch.jsp");       
     dispatcher.forward(request, response);
  
     System.out.println("add user finished: 111111111111111111111111111111111111");}
 
 
 
 private void submitBatchUser(HttpServletRequest request, HttpServletResponse response)
         throws SQLException, IOException, ServletException {
 	
 	
 	 String userselect = request.getParameter("userSelect");
 	 String batchselect=request.getParameter("batchSelect");
 	batchesuserdao.insert(new BatchUsers(0,Integer.parseInt(userselect),Integer.parseInt(batchselect)));
 	
 	 batchesUserList(request,response);
 	 
 }
 
 
	    
        	
	  
	        
	        
	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<user> listUser = userDAO.listAllUsers();
	        request.setAttribute("listUser", listUser);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("UserList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listPeople finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPage(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root view");
			request.setAttribute("listUser", userDAO.listAllUsers());
	    	request.getRequestDispatcher("UserList.jsp").forward(request, response);
	    }
	   
	    
	    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	 String email = request.getParameter("email");
	    	 String password = request.getParameter("password");
	    	 
	    	 if (email.equals("root") && password.equals("pass1234")) {
				 System.out.println("Login Successful! Redirecting to root");
				 session = request.getSession();
				 session.setAttribute("username", email);
				 rootPage(request, response, "");
	    	 }
	    	 else if(userDAO.isValid(email, password)) 
	    	 {
			 	 
			 	 currentUser = email;
			 	listUser(request,response);
				 
			 			 			 			 
	    	 }
	    	 else {
	    		 request.setAttribute("loginStr","Login Failed: Please check your credentials.");
	    		 request.getRequestDispatcher("login.jsp").forward(request, response);
	    	 }
	    }
	    
	    private void newBatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	String name = request.getParameter("name");
	   	 	
	    	 Batches batches = new Batches(name);
	    	 BatchesDao batchesdao=new BatchesDao();
	    	 batchesdao.insert(batches);
	   	 		response.sendRedirect("listBatches");
	    	
	    	
	    }
	           
	    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	
	    	String email = request.getParameter("email");
	   	 	String firstName = request.getParameter("firstName");
	   	 	String lastName = request.getParameter("lastName");
	   	 	String password = request.getParameter("password");
	   	 	String birthday = request.getParameter("birthday");
	   	 	String adress_street_num = request.getParameter("adress_street_num"); 
	   	 	String adress_street = request.getParameter("adress_street"); 
	   	 	String adress_city = request.getParameter("adress_city"); 
	   	 	String adress_state = request.getParameter("adress_state"); 
	   	 	String adress_zip_code = request.getParameter("adress_zip_code"); 	   	 	
	   	 	String confirm = request.getParameter("confirmation");
	   	 	
	   	 	if (password.equals(confirm)) {
	   	 		if (!userDAO.checkEmail(email)) {
		   	 		System.out.println("Registration Successful! Added to database");
		            user users = new user(email,firstName, lastName, password, birthday, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, 1000,0);
		   	 		userDAO.insert(users);
		   	 		response.sendRedirect("login.jsp");
	   	 		}
		   	 	else {
		   	 		System.out.println("Username taken, please enter new username");
		    		 request.setAttribute("errorOne","Registration failed: Username taken, please enter a new username.");
		    		 request.getRequestDispatcher("register.jsp").forward(request, response);
		   	 	}
	   	 	}
	   	 	else {
	   	 		System.out.println("Password and Password Confirmation do not match");
	   		 request.setAttribute("errorTwo","Registration failed: Password and Password Confirmation do not match.");
	   		 request.getRequestDispatcher("register.jsp").forward(request, response);
	   	 	}
	    }    
	    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    	currentUser = "";
        		response.sendRedirect("login.jsp");
        	}
	
	    

	     
        
	    
	    
	    
	    
	    
}
	        
	        
	    
	        
	        
	        
	    