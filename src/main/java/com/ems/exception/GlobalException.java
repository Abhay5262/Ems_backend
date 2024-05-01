package com.ems.exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;


@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<FormatException> emptyResultDataAccessException(NoSuchElementException ed){
		Date date=new Date();
		FormatException fException=new FormatException();
		fException.setExceptionCode("5000");
		fException.setExceptionMessage( "Record Not Exist");
		return new ResponseEntity<FormatException>(fException,HttpStatus.BAD_REQUEST);
	}	
	
	
	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<FormatException> expire(ExpiredJwtException jd){
		FormatException exception =new FormatException();
		exception.setExceptionCode("999");
		exception.setExceptionMessage("check Token ....!");
		return new ResponseEntity<FormatException>(exception, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<FormatException> expire(MultipartException jd){
		FormatException exception =new FormatException();
		exception.setExceptionCode("2000");
		exception.setExceptionMessage("Enter Valid Response");
		return new ResponseEntity<FormatException>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SignatureException.class)
	public ResponseEntity<FormatException> expire(SignatureException jd){
		FormatException exception =new FormatException();
		exception.setExceptionCode("2000");
		exception.setExceptionMessage("Enter Valid Token...!");
		return new ResponseEntity<FormatException>(exception, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MismatchedInputException.class)
	public ResponseEntity<FormatException> expire(MismatchedInputException jd){
		FormatException exception =new FormatException();
		exception.setExceptionCode("8000");
		exception.setExceptionMessage("Enter Valid Response");
		return new ResponseEntity<FormatException>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<FormatException> expire(EmptyResultDataAccessException jd){
		FormatException exception =new FormatException();
		exception.setExceptionCode("8000");
		exception.setExceptionMessage("Invalid Id ....!");
		return new ResponseEntity<FormatException>(exception, HttpStatus.BAD_REQUEST);
	}
}
