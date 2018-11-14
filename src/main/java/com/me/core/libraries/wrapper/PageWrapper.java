/*
 * Copyright 2008-2017 the original author or authors.
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
package com.me.core.libraries.wrapper;

import java.util.Collections;
import java.util.function.Function;
import org.springframework.data.domain.Pageable;

/**
 * A page is a sublist of a list of objects. It allows gain information about the position of it in the containing
 * entire list.
 *
 * @param <T> as class input
 * @author Oliver Gierke
 */
public interface PageWrapper<T> extends SliceWrapper<T> {

	/**
	 * Creates a new empty {@link PageWrapper}.
	 *
	 * @return Class
	 * @since 2.0
	 */
	static <T> PageWrapper<T> empty() {
		return empty(Pageable.unpaged());
	}

	/**
	 * Creates a new empty {@link PageWrapper} for the given {@link Pageable}.
	 *
	 * @param pageable must not be {@literal null}.
	 * @return Class
	 * @since 2.0
	 */
	static <T> PageWrapper<T> empty(Pageable pageable) {
		return new PageImplWrapper(Collections.emptyList(), pageable, 0);
	}

	/**
	 * Returns the number of total pages.
	 *
	 * @return the number of total pages
	 */
	int getTotalPages();

	/**
	 * Returns the total amount of elements.
	 *
	 * @return the total amount of elements
	 */
	long getTotalElements();

	/**
	 * Returns a new {@link PageWrapper} with the content of the current one mapped by the given {@link Function}.
	 *
	 * @param converter must not be {@literal null}.
	 * @return a new {@link PageWrapper} with the content of the current one mapped by the given {@link Function}.
	 * @since 1.10
	 */
	<U> PageWrapper<U> map(Function<? super T, ? extends U> converter);
}
