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

import java.util.Collection;

import org.osgi.service.blueprint.container.BlueprintContainer;
import org.osgi.service.blueprint.reflect.ComponentMetadata;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.osgi.blueprint.container.support.BlueprintEditorRegistrar;
import org.springframework.osgi.context.support.BundleContextAwareProcessor;
import org.springframework.osgi.context.support.PublicBlueprintDocumentLoader;
import org.springframework.osgi.mock.MockBundleContext;

import junit.framework.TestCase;

/**
 * @author Costin Leau
 */
public class TestLazyBeansTest extends TestCase {

	private static final String CONFIG = "lazy-beans.xml";

	private GenericApplicationContext context;
	private XmlBeanDefinitionReader reader;
	protected MockBundleContext bundleContext;
	private BlueprintContainer blueprintContainer;

	protected void setUp() throws Exception {
		bundleContext = new MockBundleContext();

		context = new GenericApplicationContext();
		context.setClassLoader(getClass().getClassLoader());
		context.getBeanFactory().addBeanPostProcessor(new BundleContextAwareProcessor(bundleContext));
		context.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {

			public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
				beanFactory.addPropertyEditorRegistrar(new BlueprintEditorRegistrar());
				beanFactory.registerSingleton("blueprintContainer",
						new SpringBlueprintContainer(context));
			}
		});

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

	public void testConvertersAvailable() throws Exception {
		System.out.println(blueprintContainer.getComponentIds());
		blueprintContainer.getComponentInstance("lazyCollection");
	}

	public void testBeanCount() throws Exception {
		Collection<ComponentMetadata> metadata = blueprintContainer.getMetadata(ComponentMetadata.class);
		System.out.println(metadata.size());
		for (ComponentMetadata componentMetadata : metadata) {
			System.out.println(componentMetadata.getId());
		}
	}
}