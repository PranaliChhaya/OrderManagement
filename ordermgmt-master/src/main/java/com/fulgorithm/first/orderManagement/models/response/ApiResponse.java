package com.fulgorithm.first.orderManagement.models.response;

public class ApiResponse {
	private Object data;
    private String message;
    private boolean error = true;

    public ApiResponse(Object data, String message){
        this.data = data;
        this.message = message;
    }

}
