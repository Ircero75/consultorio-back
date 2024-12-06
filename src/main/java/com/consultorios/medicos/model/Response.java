package com.consultorios.medicos.model;

import java.io.Serializable;



import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Response<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long uuid;
	
	private Integer StatusCode;
	
	private String message;
	
	private  transient T  info;
	
	public Response() {
		
	}
	
	public Response(Long uuid, Integer StatusCode, String message) {
		super();
		this.uuid = uuid;
		this.StatusCode = StatusCode;
		this.message = message;
	}

	public Response(Long uuid, Integer StatusCode, String message, T info) {
		super();
		this.uuid = uuid;
		this.StatusCode = StatusCode;
		this.message = message;
		this.info = info;
	}

}
