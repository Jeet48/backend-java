package com.hrc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pojo.pojo_class;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			Connection conn=Create_Connection.cc();
			pojo_class run=new Gson().fromJson(request.getReader(),pojo_class.class);
			String query="UPDATE winter_internship SET invoice_currency=?, cust_payment_terms=? WHERE sl_no=?";
			PreparedStatement pre_st=conn.prepareStatement(query);
			
			pre_st.setString(1, run.getInvoice_currency());
			pre_st.setString(2, run.getCust_payment_terms());
			pre_st.setString(3, run.getSl_no());
			
			pre_st.execute();
			response.setContentType("application/json");
		}
		catch(Exception e) {
			System.out.println(e);
		}
			
		}
	}

