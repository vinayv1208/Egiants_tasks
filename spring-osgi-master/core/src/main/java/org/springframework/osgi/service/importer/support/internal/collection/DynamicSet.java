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

package org.springframework.osgi.service.importer.support.internal.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Wrapper extension to {@link DynamicCollection} which prevents duplicates.
 * 
 * @see DynamicCollection
 * @see Set
 * @author Costin Leau
 * 
 */
public class DynamicSet<E> extends DynamicCollection<E> implements Set<E> {

	public DynamicSet() {
		super();
	}

	public DynamicSet(Collection<? extends E> c) {
		super(c);
	}

	public DynamicSet(int size) {
		super(size);
	}

	public boolean add(E o) {
		synchronized (storage) {
			if (storage.contains(o))
				return false;
			storage.add(o);
		}
		return true;
	}

	public boolean addAll(Collection<? extends E> c) {
		if (c == null)
			throw new NullPointerException();
		boolean result = false;
		synchronized (storage) {
			for (Iterator<? extends E> iter = c.iterator(); iter.hasNext();) {
				result |= add(iter.next());
			}
		}

		return result;
	}
}