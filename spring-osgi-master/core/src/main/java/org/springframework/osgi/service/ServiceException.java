/*
 * Copyright 2006-2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.osgi.service;

import org.springframework.osgi.OsgiException;

/**
 * OSGi service specific exception.
 * 
 * @author Costin Leau
 * 
 */
public class ServiceException extends OsgiException {

	private static final long serialVersionUID = 8290043693193600721L;


	/**
	 * Constructs a new <code>ServiceException</code> instance.
	 * 
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Constructs a new <code>ServiceException</code> instance.
	 * 
	 * @param message exception detailed message
	 * @param cause exception cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new <code>ServiceException</code> instance.
	 * 
	 * @param message exception detailed message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Constructs a new <code>ServiceException</code> instance.
	 * 
	 * @param cause exception cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
