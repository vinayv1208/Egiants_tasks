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
package org.springframework.osgi.blueprint.container;

import junit.framework.TestCase;

import org.osgi.service.blueprint.container.BlueprintContainer;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.osgi.context.support.BundleContextAwareProcessor;
import org.springframework.osgi.context.support.PublicBlueprintDocumentLoader;
import org.springframework.osgi.mock.MockBundleContext;

/**
 * @author Costin Leau
 */
public class GenericsTest extends TestCase {

	private static final String CONFIG = "generics-config.xml";

	private GenericApplicationContext context;
	private XmlBeanDefinitionReader reader;
	protected MockBundleContext bundleContext;
	private BlueprintContainer blueprintContainer;

	protected void setUp() throws Exception {
		bundleContext = new MockBundleContext();

		context = new GenericApplicationContext();
		context.setClassLoader(getClass().getClassLoader());
		context.getBeanFactory().addBeanPostProcessor(new BundleContextAwareProcessor(bundleContext));
		SpringBlueprintConverterService converterService =
				new SpringBlueprintConverterService(null, context.getBeanFactory());
		converterService.add(new GenericConverter());
		context.getBeanFactory().setConversionService(converterService);

		reader = new XmlBeanDefinitionReader(context);
		reader.setDocumentLoader(new PublicBlueprintDocumentLoader());
		reader.loadBeanDefinitions(new ClassPathResource(CONFIG, getClass()));
		context.refresh();

		blueprintContainer = new SpringBlueprintContainer(context);
	}

	protected void tearDown() throws Exception {
		context.close();
		context = null;
	}

	public void testRawClassInjection() throws Exception {
		GenerifiedBean bean = new GenerifiedBean();
		bean.setBooleanHolder(new GenericHolder("xyz"));
	}

	public void testBeans() throws Exception {
		System.out.println(blueprintContainer.getComponentIds());
	}
}