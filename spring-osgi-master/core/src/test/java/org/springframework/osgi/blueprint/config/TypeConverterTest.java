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

package org.springframework.osgi.blueprint.config;

import junit.framework.TestCase;

import org.osgi.framework.ServiceReference;
import org.osgi.service.blueprint.container.Converter;
import org.osgi.service.blueprint.container.ReifiedType;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.osgi.blueprint.TestComponent;
import org.springframework.osgi.blueprint.container.SpringBlueprintConverter;
import org.springframework.osgi.blueprint.container.support.BlueprintEditorRegistrar;
import org.springframework.osgi.service.importer.support.ServiceReferenceEditor;
import org.springframework.util.ObjectUtils;

/**
 * @author Costin Leau
 * 
 */
public class TypeConverterTest extends TestCase {

	private static final String CONFIG = "type-converters.xml";

	private GenericApplicationContext context;
	private XmlBeanDefinitionReader reader;

	protected void setUp() throws Exception {
		context = new GenericApplicationContext();
		context.setClassLoader(getClass().getClassLoader());
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

		beanFactory.registerCustomEditor(ServiceReference.class, ServiceReferenceEditor.class);
		beanFactory.addPropertyEditorRegistrar(new BlueprintEditorRegistrar());

		reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions(new ClassPathResource(CONFIG, getClass()));
		context.refresh();
	}

	protected void tearDown() throws Exception {
		context.close();
		context = null;
	}

	public void testNumberOfBeans() throws Exception {
		System.out.println("The beans declared are: " + ObjectUtils.nullSafeToString(context.getBeanDefinitionNames()));
		assertTrue("not enough beans found", context.getBeanDefinitionCount() >= 3);
	}

	public void testReferenceToConverter() throws Exception {
		TestComponent component = (TestComponent) context.getBean("conversion");
		Object prop = component.getPropB();
		assertTrue(prop instanceof ComponentHolder);
		assertEquals("rachmaninoff", ((ComponentHolder) prop).getProperty());
	}

	public void testNestedConverter() throws Exception {
		TestComponent component = (TestComponent) context.getBean("conversion");
		Object prop = component.getPropA();
		assertTrue(prop instanceof TestComponent);
		assertEquals("sergey", ((TestComponent) prop).getPropA());
	}

	public void testConversionService() throws Exception {
		SpringBlueprintConverter cs = new SpringBlueprintConverter(context.getBeanFactory());

		Object converted = cs.convert("1", new ReifiedType(Long.class));
		assertNotNull(converted);
		assertEquals(Long.valueOf("1"), converted);

		assertEquals(Boolean.TRUE, cs.convert("T", new ReifiedType(Boolean.class)));
	}

	public void testBooleanConversion() throws Exception {
		TestComponent comp = (TestComponent) context.getBean("booleanConversion");
		assertEquals(Boolean.TRUE, comp.getPropA());
	}

	public void testArrayConversion() throws Exception {
		TestComponent comp = (TestComponent) context.getBean("arrayConversion");
		assertTrue(comp.getPropA() instanceof RegionCode[]);
	}

	public void testReferenceDelegate() throws Exception {
		TestComponent comp = (TestComponent) context.getBean("serviceReference");
		assertNotNull(comp.getServiceReference());
	}

	public void testInvalidInjection1() throws Exception {
		try {
			TestComponent comp = (TestComponent) context.getBean("invalidInjection1");
			fail("expected exception");
		} catch (Exception ex) {
		}
	}

	public void testInvalidInjection2() throws Exception {
		try {
			TestComponent comp = (TestComponent) context.getBean("invalidInjection2");
			fail("expected exception");
		} catch (Exception ex) {
		}
	}
}