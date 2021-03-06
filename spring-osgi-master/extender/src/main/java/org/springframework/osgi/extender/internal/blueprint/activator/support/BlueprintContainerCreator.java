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

package org.springframework.osgi.extender.internal.blueprint.activator.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.springframework.osgi.context.DelegatedExecutionOsgiBundleApplicationContext;
import org.springframework.osgi.context.support.OsgiBundleXmlApplicationContext;
import org.springframework.osgi.extender.OsgiApplicationContextCreator;
import org.springframework.osgi.extender.support.ApplicationContextConfiguration;
import org.springframework.osgi.util.OsgiStringUtils;
import org.springframework.util.ObjectUtils;

/**
 * Blueprint specific context creator. Picks up the Blueprint locations instead of Spring DM's.
 * 
 * @author Costin Leau
 * 
 */
public class BlueprintContainerCreator implements OsgiApplicationContextCreator {

	/** logger */
	private static final Log log = LogFactory.getLog(BlueprintContainerCreator.class);

	public DelegatedExecutionOsgiBundleApplicationContext createApplicationContext(BundleContext bundleContext)
			throws Exception {
		Bundle bundle = bundleContext.getBundle();
		ApplicationContextConfiguration config = new BlueprintContainerConfig(bundle);
		String bundleName = OsgiStringUtils.nullSafeNameAndSymName(bundle);
		if (log.isTraceEnabled())
			log.trace("Created configuration " + config + " for bundle " + bundleName);

		// it's not a spring bundle, ignore it
		if (!config.isSpringPoweredBundle()) {
			if (log.isDebugEnabled())
				log.debug("No blueprint configuration found in bundle " + bundleName + "; ignoring it...");
			return null;
		}

		log.info("Discovered configurations " + ObjectUtils.nullSafeToString(config.getConfigurationLocations())
				+ " in bundle [" + bundleName + "]");

		DelegatedExecutionOsgiBundleApplicationContext sdoac =
				new OsgiBundleXmlApplicationContext(config.getConfigurationLocations());
		sdoac.setBundleContext(bundleContext);
		sdoac.setPublishContextAsService(config.isPublishContextAsService());

		return sdoac;
	}
}
