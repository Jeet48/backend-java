package com.hrc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.pojo.pojo_class;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see Httpre_stervlet#Httpre_stervlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Httpre_stervlet#doGet(Httpre_stervletRequest request, Httpre_stervletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see Httpre_stervlet#doPost(Httpre_stervletRequest request, Httpre_stervletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try {
			Connection conn=Create_Connection.cc();
			pojo_class run=new Gson().fromJson(request.getReader(),pojo_class.class);
			String query="INSERT INTO winter_internship (business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pre_st=conn.prepareStatement(query);
			
			pre_st.setString(1,run.getBusiness_code());
			pre_st.setInt(2,Integer.parseInt(run.getCust_number()));
			pre_st.setDate(3,Date.valueOf(run.getClear_date()));
			pre_st.setString(4,run.getBuisness_year());
			pre_st.setString(5,run.getDoc_id());
			pre_st.setDate(6,Date.valueOf(run.getPosting_date()));
			pre_st.setDate(7,Date.valueOf(run.getDocument_create_date()));
			pre_st.setDate(8,Date.valueOf(run.getDue_in_date()));
			pre_st.setString(9,run.getInvoice_currency());
			pre_st.setString(10,run.getDocument_type());
			pre_st.setInt(11,Integer.parseInt(run.getPosting_id()));
			pre_st.setDouble(12,Double.parseDouble(run.getTotal_open_amount()));
			pre_st.setDate(13,Date.valueOf(run.getBaseline_create_date()));
			pre_st.setString(14,run.getCust_payment_terms());
			pre_st.setInt(15,Integer.parseInt(run.getInvoice_id()));
			
			pre_st.execute();
			
			response.setContentType("application/json");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
	}

