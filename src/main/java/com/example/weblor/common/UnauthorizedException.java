package com.example.weblor.common;

public class UnauthorizedException extends RuntimeException {
	 public UnauthorizedException(String message) {
			super(message);
		}

		public UnauthorizedException() {
			super("Unauthorized");
		}
}
