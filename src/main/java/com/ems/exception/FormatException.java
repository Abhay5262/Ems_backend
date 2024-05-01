package com.ems.exception;


public class FormatException {
	private String exceptionMessage;
		private String exceptionCode;
		public String getExceptionMessage() {
			return exceptionMessage;
		}
		public void setExceptionMessage(String exceptionMessage) {
			this.exceptionMessage = exceptionMessage;
		}
		public String getExceptionCode() {
			return exceptionCode;
		}
		public void setExceptionCode(String exceptionCode) {
			this.exceptionCode = exceptionCode;
		}
		public FormatException(String exceptionMessage, String exceptionCode) {
			super();
			this.exceptionMessage = exceptionMessage;
			this.exceptionCode = exceptionCode;
		}
		public FormatException() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
