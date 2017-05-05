package com.hxqh.abb.common;


//import com.sun.java_cup.internal.internal_error;

public class ApplicationException extends RuntimeException//
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2006100526128933584L;
	/**
	 * 未知错误
	 */
	public static final int UNKNOWD_ERROR = 1;  
	/**
	 * 存储过程业务逻辑错误
	 */
	public static final int BusinessPROC_ERROR = 2;
	/**
	 * 存储过程数据库未知错误
	 */
	public static final int DataBasePROC_ERROR = 3;
	/**
	 * 非法用户
	 */
	 public static final int InvalidUser_ERROR=4;
	
	/**
	 * 服务层业务自定义异常
	 */
	public static final int Service_ERROR = 5;
	
	/**
	 * 输入参数异常
	 */
	public static final int Param_ERROR = 6;
	
//	public static final int DUPLICATED_LOGIN_NAME = 2;
	
	private int errorType = UNKNOWD_ERROR;
	
	protected ApplicationException() {
	}

	public ApplicationException(int errorType, String errorMessage) {
		super(errorMessage);
		this.errorType = errorType;
	}
	
	public ApplicationException(int errorType, Exception message) {
		super(message);
		this.errorType = errorType;
		
	}
	
	public ApplicationException(String message) {
		super(message);
	}

	public int getErrorType()
	{
		return errorType;
	}

	public void setErrorType(int errorType)
	{
		this.errorType = errorType;
	}

}
