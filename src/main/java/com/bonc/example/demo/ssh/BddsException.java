package com.bonc.example.demo.ssh;

/**
 * bdcs通用异常
 * @author wangdonghao
 * @date 2018年12月6日 下午2:48:35
 * @version v1.0
 */
public class BddsException extends RuntimeException{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6625058751331428556L;
	
	public BddsException(){
		
	}
	
	public BddsException(String message){
		super(message);
	}

	public BddsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BddsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BddsException(Throwable cause) {
		super(cause);
	}
	
	
}
